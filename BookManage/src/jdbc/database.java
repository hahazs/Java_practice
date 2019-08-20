package jdbc;

import java.sql.*;

public class database {
    private static final String URL = "jdbc:mysql://localhost:3306/books";
    private static final String NAME = "root";
    private static final String PASSWORD="root";
    private static Connection conn = null;
    static {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的链接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //对外提供一个方法来获取数据库连接
    public static Connection getConnection(){
        try{
            conn = DriverManager.getConnection(URL,NAME,PASSWORD);
            return conn;
        } catch (SQLException e) {
            // TODO Auto-generated catch bolck
            e.printStackTrace();
            return null;
        }
    }

    //断开数据库连接
    public static void close(Connection conn, Statement stat, ResultSet rs){
        try {
            if (rs != null)
                rs.close();
            if (stat != null)
                stat.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //重载close函数，适用于没有ResultSet的情况
    public static void close(Connection conn, Statement stat){
        close(conn,stat,null);
    }
}
