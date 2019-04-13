package Interface.com.dao;

import java.sql.*;

public class DBService {

    public static Connection getConn() {
        Connection connection = null;
//		String driver = com.mysql.jdbc.Driver   //老版本
        String driver = "com.mysql.cj.jdbc.Driver";//新版本
        String url = "jdbc:mysql://localhost:3306/UserCenter";
        String user = "root";
        String password = "123456";

        try {
            Class.forName(driver);
            connection = (Connection)DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;

    }

    public static String setSQL(){
        return "select name from UserCenter.Persion where address = 'jilin'";
    }

    public static String getAll(String sql) {
        String str = null;
        Connection conn = getConn();
//        String sql = "select name from UserCenter.Persion where address = 'jilin'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    str = rs.getString(i).toString();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args){
        System.out.println(DBService.getAll(DBService.setSQL()));
    }
}
