import java.awt.*;
import javax.swing.*;

public class DB2022TEAM01_TradeList extends JFrame{

	public DB2022TEAM01_TradeList() {
		setTitle("���������� - �ŷ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setBackground(Color.WHITE);
		
		String header[] = {"��ǰ��", "���̵� �׷�", "�����", "ī�װ�", "�ŵ���", "����"};
		//db���� �ҷ��� �κ�
		String contents[][] = {
				{"�������� �ֿ� �������̵� �̰��� �絵", "��������", "�ֿ�", "��ī", "dagef", "3500"},
				{"�������� ���� ���� �ް� �Ǹ�", "��������", "����", "����", "dlksjdf", "50000"}
		};
		JTable list = new JTable(contents,header);
		JScrollPane scrollpane = new JScrollPane(list);
		cp.add(scrollpane);
		
		setSize(1000, 700);
		setVisible(true);
	}
	public static void main(String[] args) {
		DB2022TEAM01_TradeList tradeList = new DB2022TEAM01_TradeList();

	}

}
