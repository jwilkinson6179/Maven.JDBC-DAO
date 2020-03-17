package daos;

import models.Game;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameDaoTest
{
    @Test
    public void findByIdTest()
    {
        String expectedTitle = "God of War";
        GameDao test = new GameDao();

        Game actual = test.findById(2);
        String actualTitle = actual.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }
}