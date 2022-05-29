package GUI;

import DAO.DB2022TEAM01_LogInDAO;
import DAO.DB2022TEAM01_ProductDAO;
import DAO.DB2022TEAM01_UserDAO;
import DTO.DB2022TEAM01_ProductDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DB2022TEAM01_ProductRegister extends JFrame {

    DB2022TEAM01_LogInDAO logInFunc = new DB2022TEAM01_LogInDAO();

    private String [] categories = {"포토카드", "앨범", "인형", "시즌그리팅", "공식키트", "폴라로이드", "포스터", "잡지", "기타"};



    public DB2022TEAM01_ProductRegister(){
        setTitle("상품 등록");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel title = new JLabel("상품 등록");

        Font basic = new Font("맑은 고딕", Font.BOLD, 30);

        c.setBackground(Color.white);

        JLabel productName = new JLabel("상품명 ");
        JLabel IdolGroup = new JLabel("아이돌그룹 ");
        JLabel IdolMember = new JLabel("멤버명 ");
        JLabel categoryTitle = new JLabel("카테고리 ");
        JLabel price = new JLabel("가격 ");

        JTextField productNameInput = new JTextField(45);
        JTextField IdolGroupInput = new JTextField(45);
        JTextField IdolMemberInput = new JTextField(45);
        JComboBox<String> category = new JComboBox<String>(categories);
        JTextField priceInput = new JTextField(45);

        productName.setBounds(200, 100, 300, 45);
        IdolGroup.setBounds(200, 180, 300, 45);
        IdolMember.setBounds(200, 260, 300, 45);
        categoryTitle.setBounds(200, 340, 300, 45);
        price.setBounds(200, 420, 300, 45);

        productNameInput.setBounds(550, 100, 300, 45);
        IdolGroupInput.setBounds(550, 180, 300, 45);
        IdolMemberInput.setBounds(550, 260, 300, 45);
        category.setBounds(550, 340, 300, 45);
        priceInput.setBounds(550, 420, 300, 45);

        price.setFont(basic);
        productName.setFont(basic);
        IdolGroup.setFont(basic);
        IdolMember.setFont(basic);
        categoryTitle.setFont(basic);
        productNameInput.setFont(basic);
        priceInput.setFont(basic);
        IdolGroupInput.setFont(basic);
        IdolMemberInput.setFont(basic);
        category.setFont(basic);

        JButton conform = new JButton("등록");	//등록 버튼
        
        Color buttonColor = new Color(0xFF6472);

        conform.setBackground(buttonColor);
        conform.setBounds(400, 500, 200, 100);
        conform.setFont(basic);
        c.add(conform);
        
        
        JButton home = DB2022TEAM01_Main.make_home();
        home.setBounds(950, 5, 30, 30);
        c.add(home);


        c.add(productName);
        c.add(productNameInput);
        c.add(IdolGroup);
        c.add(IdolMemberInput);
        c.add(IdolMember);
        c.add(IdolGroupInput);
        c.add(categoryTitle);
        c.add(price);
        c.add(priceInput);
        c.add(category);

        conform.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DB2022TEAM01_UserDAO dao = new DB2022TEAM01_UserDAO();

                Long userId = logInFunc.getLogInUser();
                System.out.println(userId);
                String sellerName = logInFunc.getLogInUserName(userId);
                System.out.println(sellerName);

                // gui에 입력된 값 가져오기
                String productName = productNameInput.getText();
                String IdolGroup = IdolGroupInput.getText();
                String IdolMember = IdolMemberInput.getText();
                String categoryInput = category.getSelectedItem().toString();
                String price_str = priceInput.getText();
                Long price = Long.parseLong(price_str);

                DB2022TEAM01_ProductDTO dto = new DB2022TEAM01_ProductDTO(userId, productName, price, sellerName, categoryInput, IdolGroup, IdolMember);
                new DB2022TEAM01_ProductDAO().productRegister(dto);
            }
        });
        
        //홈버튼
        home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new DB2022TEAM01_Main();
			}
		});

        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);	//화면 중앙에 뜸
        setVisible(true);
    }
    
}
