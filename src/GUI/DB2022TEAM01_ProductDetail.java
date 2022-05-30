package GUI;

import DAO.DB2022TEAM01_LogInDAO;
import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import javax.xml.transform.Result;

public class DB2022TEAM01_ProductDetail {

	DB2022TEAM01_LogInDAO logInFunc = new DB2022TEAM01_LogInDAO();

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/DB2022Team01";
	static final String USER = "DB2022Team01";
	static final String PASS = "DB2022Team01";

	public Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection(DB_URL, USER, PASS);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return conn;
	}


	private PreparedStatement ps;
	private ResultSet rs;



	public DB2022TEAM01_ProductDetail() {
		JFrame frame = new JFrame("상품 상세"); 
        JPanel panel = new JPanel();
        JLabel label = new JLabel("상품 상세");
        JButton bt1 = new JButton("찜");
        JButton bt2 = new JButton("매수");
        
        Font font = new Font("맑은 고딕", Font.BOLD, 20);
        
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(font);
 
        
        String col[] = { "상품명", "아이돌 그룹", "멤버명", "카테고리" , "매도자 ID", "가격", "등록 날짜", "찜", "매수" };   

		/*
        Object values[][] = { { "샤넬 가현 포카", "드림캐쳐", "가현", "포토카드" , "a456737", "15000", "2020/04/19", "찜", "매수" }, 
        		{ "자연광 수민 포카", "스테이씨", "수민", "포토카드" , "a456737", "15000", "2020/04/19", "찜", "매수" } , 
        		{ "세은 쥬얼 포카", "스테이씨", "세은", "포토카드" , "a456737", "15000", "2020/04/19", "찜", "매수" } , 
        		{ "이달의 소녀 응원봉", "이달의 소녀", "???", "응원봉" , "a456737", "35000", "2020/04/19", "찜", "매수" } 
                 };
 */
		DefaultTableModel model = new DefaultTableModel(col, 0);


		Connection conn = getConnection();


		String SQL = "select * from DB2022_idol, DB2022_product where isSold = false and DB2022_idol.idol_id = DB2022_product.idol_id;";
		try{
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			int row = 1;
			while(rs.next()){
				Vector record = new Vector();
				row++;
				 // 샹품명
				record.add(rs.getString("name"));

				// 아이돌 그룹
				record.add(rs.getString("gp"));
				
				// 아이돌 이름
				record.add(rs.getString("member"));

				// 카테고리
				record.add(rs.getString("category"));

				// 판매자
				record.add(rs.getString("seller"));

				// 가격
				record.add(rs.getLong("price"));

				// 등록 날짜
				record.add(rs.getString("date"));
				model.addRow(record);
			}
		}catch (Exception e){
			e.printStackTrace();
		}



        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.getColumnModel().getColumn(7).setCellRenderer(new TableCell1());
        table.getColumnModel().getColumn(7).setCellEditor(new TableCell1());;
        
        table.getColumnModel().getColumn(8).setCellRenderer(new TableCell2());
        table.getColumnModel().getColumn(8).setCellEditor(new TableCell2());;
        
        table.setPreferredScrollableViewportSize(new Dimension (950, 650));
        table.setBackground(Color.pink); 
        
        JButton home = DB2022TEAM01_Main.make_home();
        home.setBounds(950, 5, 30, 30);
        panel.add(home);


        
        //홈버튼
        home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new DB2022TEAM01_Main();
			}
		});
      
        JScrollPane pane = new JScrollPane(table); 
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(pane, BorderLayout.CENTER);
        panel.add(label, BorderLayout.NORTH);
        frame.add(panel); 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);	//화면 중앙에 뜸
        frame.setVisible(true); 
	}	
}

class PopUp1 extends JFrame{
	public PopUp1() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame frame = new JFrame("찜 완료");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("위시리스트에 상품이 추가되었습니다", JLabel.CENTER);
		
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setFont(label.getFont().deriveFont(15.0f));

	    panel.setLayout(new BorderLayout(10, 10));
		panel.add(label);
		frame.add(panel);
		
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);	//화면 중앙에 뜸
		frame.setVisible(true);
		
	}
}

class PopUp2 extends JFrame{
	public PopUp2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame frame = new JFrame("매수 완료");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("상품 구입이 완료되었습니다", JLabel.CENTER);
		
		label.setHorizontalAlignment(JLabel.CENTER);
	    label.setFont(label.getFont().deriveFont(15.0f));

	    panel.setLayout(new BorderLayout(10, 10));
		panel.add(label);
		frame.add(panel);
		
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);	//화면 중앙에 뜸
		frame.setVisible(true);		
		
	}
}

//btn1(찜 버튼 셀에 추가)
class TableCell1 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	JButton btn1;
	
	public TableCell1() {
		btn1 = new JButton("찜");
		
		btn1.addActionListener(e -> {
			new PopUp1();
		});
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return btn1;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return btn1;
	}
	
}
//btn2(매수 버튼 셀에 추가)
class TableCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

	JButton btn2;
	
	public TableCell2() {
		btn2 = new JButton("매수");
		btn2.addActionListener(e -> {
			new PopUp2();			
		});
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return btn2;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return btn2;
	}
	
}
