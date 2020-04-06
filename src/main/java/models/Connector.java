package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import static java.util.logging.Level.*;
import static models.ColorConstants.*;

public class Connector
{
    private static final Logger LOGGER = Logger.getLogger(Connector.class.getName());

    public static final String URL = "jdbc:mysql://localhost:3306/collectables?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "collectables";
    public static final String PASS = "collectables";
    public static Connection getConnection()
    {
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(URL, USER, PASS);
            LOGGER.log(INFO, ANSI_CYAN + "Connection Established to MYSQL Database" + ANSI_RESET);
        }
        catch (SQLException e)
        {
            LOGGER.log(WARNING, ANSI_RED + "Rejected" + ANSI_RESET);
            System.err.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args)
    {
        Connection connection = Connector.getConnection();
    }
}