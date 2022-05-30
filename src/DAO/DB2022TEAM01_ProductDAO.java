package DAO;

import DTO.DB2022TEAM01_ProductDTO;

import java.sql.*;

public class DB2022TEAM01_ProductDAO {

    DB2022TEAM01_LogInDAO logInFunc;

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/DB2022Team01";
    static final String USER = "DB2022Team01";
    static final String PASS = "DB2022Team01";

    private PreparedStatement ps = null; // 명령어
    private ResultSet rs = null;
    private PreparedStatement ps2 = null;


    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Long FindIdol(String IdolGroup, String IdolMember) {
        Connection con = getConnection(); // 연결

        // idol db 불러오기
        String SQL_idol = "select idol_id from DB2022_idol where gp = ? and member = ?";
        Long id = null;
        try {
            ps = con.prepareStatement(SQL_idol);
            ps.setString(1, IdolGroup);
            ps.setString(2, IdolMember);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getLong("idol_id");
                System.out.println(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public boolean productRegister(DB2022TEAM01_ProductDTO dto){
        Connection con = getConnection();

        String SQL = "insert into DB2022_product(name, price, seller, category, idol_id, date)\n" +
                "values\n" +
                "(?, ?, ?, ?, ?, ?);";
        Long idolId = FindIdol(dto.getIdolGroup(), dto.getIdolMember());

        System.out.println(dto.getUserId());

        try{
            ps = con.prepareStatement(SQL);
            ps.setString(1, dto.getName());
            ps.setLong(2, dto.getPrice());
            ps.setString(3, dto.getSeller()); // 임의값
            ps.setString(4, dto.getCategory());
            ps.setLong(5, idolId);
            ps.setDate(6, Date.valueOf("2020-01-01")); // 임의값
            ps.executeUpdate();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}

    

