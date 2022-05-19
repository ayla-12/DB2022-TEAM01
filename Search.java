package db2022;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Search {
	public static void main(String[] args) {
		// ������ ����
        JFrame frm = new JFrame("Search");
 
        // ������ ũ�� ����
        frm.setSize(1000, 700);
 
        // �������� ȭ�� ����� ��ġ
        frm.setLocationRelativeTo(null);
 
        // �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // ���̾ƿ� ����
        frm.getContentPane().setLayout(null);
        
        //��Ʈ
        Font font = new Font("���� ���", Font.PLAIN, 50);
 
        // �� ����
        JLabel lb1 = new JLabel("�˻�");
        lb1.setFont(font);
        
        // �ؽ�Ʈ �ʵ� ����
        JTextField tf1 = new JTextField("���̵� �׷�");
        JTextField tf2 = new JTextField("�����");
        JTextField tf3 = new JTextField("�˻� Ű����");
        
        
        // ��ư ����          
 		JButton btn1 = new JButton("Home");
 		JButton btn2 = new JButton("�˻��ϱ�");
 		
		// ��Ӵٿ� �޴� ����
		String[] optionsToChoose = {"���� ī�װ�", "�ٹ�", "����ī��", "������̵�", "������", "���� �׸���", "��Ÿ"};
        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);

 
        // ������ ��ġ�� ũ�� ����
        lb1.setBounds(454,189,100,61);
        
		tf1.setBounds(50,300,280,90);
		tf2.setBounds(360,300,280,90);
		tf3.setBounds(50,420,590,90);
		
		btn1.setBounds(865,30,75,75);
		btn2.setBounds(670,420,280,90);

        jComboBox.setBounds(670,300,280,90);


 
        // ���̱�!
        frm.getContentPane().add(lb1);
        frm.getContentPane().add(tf1);
        frm.getContentPane().add(tf2);
        frm.getContentPane().add(tf3);
        frm.getContentPane().add(btn1);
        frm.getContentPane().add(btn2);
        frm.getContentPane().add(jComboBox);


 
        // �������� ���̵��� ����
        frm.setVisible(true);
 

	}

}
