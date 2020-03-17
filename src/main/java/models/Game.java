package models;

import java.util.Date;

public class Game
{
    private Integer id;
    private String title;
    private String publisher;
    private String genre;
    private String platform;
    private Date releaseDate;
    private String franchise;

    public Game()
    {

    }

    public Game(String title, String publisher, String genre, String platform, Date releaseDate, String franchise)
    {
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.platform = platform;
        this.releaseDate = releaseDate;
        this.franchise = franchise;
    }

    public Game(Integer id, String title, String publisher, String genre, String platform,
                Date releaseDate, String franchise)
    {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.platform = platform;
        this.releaseDate = releaseDate;
        this.franchise = franchise;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getPlatform()
    {
        return platform;
    }

    public void setPlatform(String platform)
    {
        this.platform = platform;
    }

    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getFranchise()
    {
        return franchise;
    }

    public void setFranchise(String franchise)
    {
        this.franchise = franchise;
    }
}