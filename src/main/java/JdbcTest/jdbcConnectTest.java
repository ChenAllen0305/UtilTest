package JdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @title: jdbcConnectTest
 * @Author Chen Lun
 * @Date: 2021/3/25
 */
public class jdbcConnectTest {
    public static void main(String[] args) {
        try
        {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://192.168.2.228:3306/sgool_opical?useUnicode=true&characterEncoding=utf-8", "wanke", "5j1#H!^d");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
