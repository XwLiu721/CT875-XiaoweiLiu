package dao.basedao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnUtil {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    //private static ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();
    //private static ThreadLocal<Object> threadLocal3 = new ThreadLocal<>();

    public static  String DRIVER = null ;
    public static  String URL =null;
    public static  String USER = null;
    public static  String PWD = null;

    private static Connection createConn(){
        try {
            //druid also has same function

            Class.forName(DRIVER);
            Connection con= DriverManager.getConnection(URL, USER, PWD);

            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null ;
    }
    static {

        DRIVER = "com.mysql.jdbc.Driver";
        URL = "jdbc:mysql://localhost:3306/assignment3";
        USER = "root";
        PWD = "123456789";


    }


    public static Connection getConn(){
        Connection conn = threadLocal.get();
        if(conn==null){
            conn =createConn();
            threadLocal.set(conn);
        }
        return threadLocal.get() ;
    }

    public static void closeConn() throws SQLException {
        Connection conn = threadLocal.get();
        if(conn==null){
            return ;
        }
        if(!conn.isClosed()){
            conn.close();
            //threadLocal.set(null);
            threadLocal.remove();
        }
    }
}
