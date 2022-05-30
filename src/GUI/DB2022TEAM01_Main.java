package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import DAO.DB2022TEAM01_LogInDAO;

public class DB2022TEAM01_Main extends JFrame{
	public DB2022TEAM01_Main() {
		setTitle("홈");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);
		
		//user 정보
		DB2022TEAM01_LogInDAO userInfo = new DB2022TEAM01_LogInDAO();
		Long user_id = userInfo.getLogInUser();
		String user_name = userInfo.getLogInUserName(user_id);
		JLabel userName = new JLabel(user_name+"님");
		userName.setHorizontalAlignment(JLabel.RIGHT);
		Font font_u = new Font("맑은 고딕", Font.BOLD, 20);
		userName.setFont(font_u);
		userName.setBounds(745, 23, 221, 30);
		
		// 버튼 생성
	    JButton btn1 = new JButton("상품등록");
	    JButton btn2 = new JButton("상품상세");
	    JButton btn3 = new JButton("검색");
 	    JButton btn4 = new JButton("마이페이지-위시리스트");
	    JButton btn5 = new JButton("마이페이지-거래내역");
	    
	    //버튼색 지정-지원
	    Color btn_color=new Color(0xFF6472);
	    Font font = new Font("맑은 고딕", Font.BOLD, 20);
	    
	    btn1.setBackground(btn_color);
	    btn1.setForeground(Color.white);
	    btn1.setFont(font);
	    
	    btn2.setBackground(btn_color);
	    btn2.setForeground(Color.white);
	    btn2.setFont(font);
	    
	    btn3.setBackground(btn_color);
	    btn3.setForeground(Color.white);
	    btn3.setFont(font);
	    
	    btn4.setBackground(btn_color);
	    btn4.setForeground(Color.white);
	    btn4.setFont(font);
	    
	    btn5.setBackground(btn_color);
	    btn5.setForeground(Color.white);
	    btn5.setFont(font);

	    // 버튼 위치와 크기 설정
	    btn1.setBounds(125,150,300,100);
	    btn2.setBounds(575,150,300,100);
 	    btn3.setBounds(350,300,300,100);
    	btn4.setBounds(125,450,300,100);
		btn5.setBounds(575,450,300,100);
	
		// 프레임에다가 버튼 추가
		contentPane.add(userName);
		contentPane.add(btn1);
		contentPane.add(btn2);
		contentPane.add(btn3);
		contentPane.add(btn4);
		contentPane.add(btn5);
		
		//버튼 클릭시 이동 - 지원
		//상품 등록 버튼
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new DB2022TEAM01_ProductRegister();
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new DB2022TEAM01_ProductDetail();
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new DB2022TEAM01_Search();
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new DB2022TEAM01_WishList();
			}
		});

		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DB2022TEAM01_TradeList();
			}
		});
		
		setSize(1000, 700);
		setResizable(false);
		setLocationRelativeTo(null);	//화면 중앙에 뜸
		setVisible(true);
	}
	/*
	public static void main(String[] args) {
		DB2022TEAM01_Main main = new DB2022TEAM01_Main();
		
	}
	*/
	public static JButton make_home() {
		ImageIcon icon = new ImageIcon("home.png");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon home = new ImageIcon(changeImg);
		JButton home_btn = new JButton(home);
		home_btn.setBackground(Color.white);
		home_btn.setFocusPainted(false);
		
		return home_btn;
	}
}


