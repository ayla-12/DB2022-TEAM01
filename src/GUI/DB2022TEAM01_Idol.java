import java.awt.*;
import javax.swing.*;

public class DB2022TEAM01_Idol extends JFrame{
	public DB2022TEAM01_Idol() {
		setTitle("���̵� ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setBackground(Color.WHITE);
		cp.setLayout(new FlowLayout());
		
		cp.add(new JLabel("���̵� �׷�"));
		cp.add(new JTextField(10));
		cp.add(new JLabel("���̵� �̸�"));
		cp.add(new JTextField(10));
		cp.add(new JButton("����ϱ�"));
		
		setSize(1000, 700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		DB2022TEAM01_Idol dbIdol = new DB2022TEAM01_Idol();
	}
}
