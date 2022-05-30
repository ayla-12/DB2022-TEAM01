/*

import java.sql.*;
import java.util.Scanner;
public class DBProject_idolSQL {
	
    static final String DB_URL = "jdbc:mysql://localhost:3306/DB2022Team01";
    static final String USER = "DB2022Team01";
    static final String PASS = "DB2022Team01";
    private Connection connection;
    private Statement stmt;
    private ResultSet rSet;
    private PreparedStatement pStmt;
    
    public DBProject_idolSQL() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connection = DriverManager.getConnection(DB_URL, USER, PASS);
    		System.out.println("connection");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public int idolReg(String group, String mem) {
    	int i = 0;
        try {
        	stmt = connection.createStatement();
            rSet = stmt.executeQuery("select * from `DB2022_idol`");
           
            //db�ߺ� Ȯ��
            while(rSet.next()){
               if(group.equals(rSet.getString("group")) &&  mem.equals(rSet.getString("member")))
            	   i = 1;
            }
            
            //db�� �ߺ��� �����Ƿ� ���
            if(i == 0) {
            	pStmt = connection.prepareStatement("insert into `DB2022_idol` values (?, ?, ?)");
            	pStmt.setString(1, group);
            	pStmt.setString(2, mem);
            	pStmt.setInt(3, 0);
            	pStmt.executeUpdate();
                pStmt.close();
            }
            
            rSet.close();
            stmt.close();
            connection.close();
            
        }catch (Exception e) {
			e.printStackTrace();
    	}
		return i;   
    }
}
   
    
    


*/