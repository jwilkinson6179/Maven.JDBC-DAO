package daos;

import models.ConnectionFactory;
import models.Game;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;
import static models.ColorConstants.ANSI_CYAN;

public class GameDao implements MyDao<Game> {

    private static final Logger LOGGER = Logger.getLogger(GameDao.class.getName());

    public GameDao() {
    }

    public Game findById(Integer id) {
        Connection connection = null;

        try {
            connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM games");

            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    Game result = new Game(rs.getInt("id"), rs.getString("title"),
                            rs.getString("publisher"), rs.getString("genre"),
                            rs.getString("platform"), rs.getDate("release_date"),
                            rs.getString("franchise"));

                    stmt.close();
                    rs.close();
                    return result;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                LOGGER.log(INFO, ANSI_CYAN + "Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public ArrayList<Game> findAll()
    {
        Connection connection = null;
        ArrayList<Game> gameList = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM games");

            rs.beforeFirst();
            while (rs.next()) {
                Game entry = new Game(rs.getInt("id"), rs.getString("title"),
                        rs.getString("publisher"), rs.getString("genre"),
                        rs.getString("platform"), rs.getDate("release_date"),
                        rs.getString("franchise"));

                gameList.add(entry);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                LOGGER.log(INFO, ANSI_CYAN + "Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return gameList;
    }

    public Game update(Game dto)
    {
        return null;
    }

    public Game create(Game dto)
    {
        return null;
    }

    public void delete(Integer id) {

    }
}