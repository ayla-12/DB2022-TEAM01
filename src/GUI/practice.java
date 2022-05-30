package GUI;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class practice extends JFrame{

	public practice() {
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon i = new ImageIcon("home.png");
		JButton b = new JButton(i);
		c.add(b);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new practice();

	}

}
