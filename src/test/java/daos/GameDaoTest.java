package daos;

import models.Game;
import models.GameDao;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

import static org.junit.Assert.assertEquals;

public class GameDaoTest
{
    @Test
    public void findByIdTest()
    {
        String expectedTitle = "God of War";
        LocalDate expectedDate = LocalDate.of(2018, 4, 20);
        GameDao test = new GameDao();

        Game actual = test.findById(2);
        String actualTitle = actual.getTitle();
        Date actualDate = actual.getReleaseDate();

        assertEquals(expectedTitle, actualTitle);
        assertEquals(expectedDate, actualDate);
    }

    @Test
    public void findAllTest()
    {
        String expectedTitle = "God of War";
        GameDao test = new GameDao();

        ArrayList<Game> testList = test.findAll();
        String actualTitle = testList.get(1).getTitle();

        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void deleteTest()
    {
        GameDao test = new GameDao();

        test.delete(6);
    }
}