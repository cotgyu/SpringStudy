package DBTest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectTest {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL ="jdbc:oracle:thin:@3.18.203.196:1521:xe";
    private static final String USER ="study";
    private static final String PASSWORD ="0000";

    @Test
    public void Connection() throws Exception{
        Class.forName(DRIVER);

        DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
