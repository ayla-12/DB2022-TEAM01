import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DB2022TEAM01_Idol extends JFrame{
	public DB2022TEAM01_Idol() {
		setTitle("���̵� ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setBackground(Color.WHITE);
		cp.setLayout(null);
		
		//����
		JLabel title = new JLabel("���̵� ���", SwingConstants.CENTER);
		title.setBounds(320, 110, 360, 50);
		Font font1 = new Font("���� ���", Font.BOLD, 35);
		title.setFont(font1);		
		cp.add(title);
		
		//�׷�, �����
		JLabel group = new JLabel("���̵� �׷�");
		JTextField groupText = new JTextField(20);
		group.setBounds(270, 200, 100, 40);
		groupText.setBounds(350, 200, 300, 40);
		
		JLabel member = new JLabel("���̵� ���");
		JTextField memText = new JTextField(20);	
		member.setBounds(270, 260, 100, 40);
		memText.setBounds(350, 260, 300, 40);
		
		cp.add(group);
		cp.add(groupText);
		cp.add(member);
		cp.add(memText);
		
		//��ư
		JButton idol = new JButton("����ϱ�");
		idol.setBounds(400, 340, 200, 50);
		Color color=new Color(0xFF6472);
		idol.setBackground(color);
		idol.setForeground(Color.white);
		cp.add(idol);
		
		idol.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String group_value = groupText.getText();
				String mem_value = memText.getText();
				DBProject_idolSQL idolRegister = new DBProject_idolSQL();
				
				if(idolRegister.idolReg(group_value, mem_value) == 1)
					JOptionPane.showMessageDialog(DB2022TEAM01_Idol.this, "�̹� ��ϵ� ���̵��Դϴ�.", "���̵� ��� ����", JOptionPane.PLAIN_MESSAGE);
				else if(idolRegister.idolReg(group_value, mem_value) == 0)
					JOptionPane.showMessageDialog(DB2022TEAM01_Idol.this, "����� �Ϸ�Ǿ����ϴ�.", "���̵� ��� �Ϸ�", JOptionPane.PLAIN_MESSAGE);
				else if(idolRegister.idolReg(group_value, mem_value) == -1)
					JOptionPane.showMessageDialog(DB2022TEAM01_Idol.this, "���̵� �׷�� ������� �Է����ּ���", "���̵� ���", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		
		setSize(1000, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		DB2022TEAM01_Idol dbIdol = new DB2022TEAM01_Idol();
	
	}
}
