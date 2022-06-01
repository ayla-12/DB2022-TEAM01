package DAO;

import DTO.DB2022TEAM01_ProductDTO;
import java.sql.*;
import java.time.LocalDate;
import java.sql.Date;

public class DB2022TEAM01_ProductDAO {

    DB2022TEAM01_LogInDAO logInFunc = new DB2022TEAM01_LogInDAO();

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
        String SQL_idol = "select idol_id from DB2022_idol " +
                "use index(idx_idol) " +
                "where gp = ? and member = ?";
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
            return -1l;
        }

        return id;
    }

    public boolean productRegister(DB2022TEAM01_ProductDTO dto){
        Connection con = getConnection();

        String SQL = "insert into DB2022_product(name, price, seller, category, idol_id, date, user_id)\n" +
                "values\n" +
                "(?, ?, ?, ?, ?, NOW(), ?);";
        Long idolId = FindIdol(dto.getIdolGroup(), dto.getIdolMember());               
        if(idolId==-1) return false;
        System.out.println(dto.getUserId());

        try{
            ps = con.prepareStatement(SQL);
            ps.setString(1, dto.getName());
            ps.setLong(2, dto.getPrice());
            ps.setString(3, dto.getSeller());
            ps.setString(4, dto.getCategory());
            ps.setLong(5, idolId);
            ps.setLong(6, dto.getUserId());
            ps.executeUpdate();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    // 위시리스트에 상품을 추가하는 함수
    public boolean addWishlist(Long productId){
        Connection con = getConnection();
        String SQL = "insert into DB2022_wishlist(user_id, product_id)\n" +
                "value\n" +
                "(?, ?);";
        Long userId = logInFunc.getLogInUser();
        System.out.println(userId);
        try{
            ps = con.prepareStatement(SQL);
            ps.setLong(1, userId);
            ps.setLong(2, productId);
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    // 위시리스트에서 상품 제거
    public boolean deleteWishList(Long productId){
        Connection conn = getConnection();
        String SQL = "delete from DB2022_wishlist where product_id = ?;";
        try{
            ps = conn.prepareStatement(SQL);
            ps.setLong(1, productId);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    // 상품 구매
    public boolean buyProduct(Long productId){
        Connection conn = getConnection();
        String SQL = "update DB2022_product set isSold = true where id = ?;";
        String SQL2 = "update DB2022_trade set buyer_id = ?;";

        try{
            ps = conn.prepareStatement(SQL);
            ps.setLong(1, productId);
            ps.executeUpdate();

            ps = conn.prepareStatement(SQL2);
            Long userId = logInFunc.getLogInUser();
            ps.setLong(1, userId);
            ps.executeUpdate();

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }






}

    

