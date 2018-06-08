package Services;
import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BootstrapService {

    /**
     *
     * @throws SQLException
     */
    public static void startDb() throws SQLException {
        Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
    }

    /**
     *
     * @throws SQLException
     */
    public static void stopDb() throws SQLException {
        Server.shutdownTcpServer("tcp://localhost:9092", "", true, true);
    }


    /**
     * Metodo para recrear las tablas necesarios
     * @throws SQLException
     */
    public static void crearTablas() throws  SQLException{
        String sql = "CREATE TABLE IF NOT EXISTS USERS\n" +
                "(\n" +
                "  USERNAME VARCHAR(100) PRIMARY KEY NOT NULL,\n" +
                "  NOMBRE VARCHAR(100) NOT NULL,\n" +
                "  PASSWORD VARCHAR(100) NOT NULL,\n" +
                "  ADMINISTRATOR INTEGER NOT NULL,\n" +
                "  AUTHOR INTEGER NOT NULL\n" +
                ");";
        Connection con = DatabaseService.getInstancia().getConexion();
        Statement statement = con.createStatement();
        statement.execute(sql);
        statement.close();
        con.close();
    }

}
