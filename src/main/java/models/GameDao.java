package models;

import daos.MyDao;

import java.sql.*;
import java.util.ArrayList;
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
            Connector connector = new Connector();
            connection = connector.getConnection();
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
            Connector connector = new Connector();
            connection = connector.getConnection();
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

    public void update(Game dto)
    {
        Connection connection = null;
        try {
            Connector connector = new Connector();
            connection = connector.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE games SET title=?, publisher=?, " +
                    "genre=?, platform=?, release_date=?, franchise=?");
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getPublisher());
            ps.setString(3, dto.getGenre());
            ps.setString(4, dto.getPlatform());
            ps.setDate(5, dto.getReleaseDate());
            ps.setString(6, dto.getFranchise());
            ps.executeUpdate();
            ps.close();
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
    }

    public Game create(Game dto)
    {
        Connection connection = null;
        try {
            Connector connector = new Connector();
            connection = connector.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO games VALUES (NULL, ?, ?, ?, ?, ?, ?");
            ps.setString(1, dto.getTitle());
            ps.setString(2, dto.getPublisher());
            ps.setString(3, dto.getGenre());
            ps.setString(4, dto.getPlatform());
            ps.setDate(5, dto.getReleaseDate());
            ps.setString(6, dto.getFranchise());
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
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

    public void delete(Integer id)
    {
        Connection connection = null;

        try {
            Connector connector = new Connector();
            connection = connector.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM games WHERE id=" + id);
            stmt.close();
        } catch(SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            try {
                if (connection != null) {
                    connection.close();
                }
                LOGGER.log(INFO, ANSI_CYAN + "Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}