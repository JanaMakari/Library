/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Library 
{
    //Properties
    private String name;
    private ArrayList<Genre>genres;
    //
    
    //Constructors
    public Library(String name)
    {
        this.name = name;
        this.genres = new ArrayList<Genre>();
    }
    
    public Library(String name,ArrayList<Genre >genres)
    {
        this.name = name;
        this.genres = genres;
    }
    //
    
    //A method to check the existence of book
    public boolean bookExists(String bookId)
    {
        for(Genre genre : genres)
        {
            return genre.findBookById(bookId);
        }
        return false;
    }
    //
    
    //A Method for listing Genre ID and Name
    public String listLibraryGenres()
    {
        String s = "\t"+this.name+"\t"+getCurrentDateTimeFormatted()+"\noffers books across "+this.genres.size()+" genres: \nGenre ID : Genre Name\n";
        for(Genre g : genres)
        {
            s+=g.getID()+" : "+g.getGenreName()+"\n";
        }
        return s;
    }
    //
    
    //A method to return all the details of a genre
    public String getAllGenresDescription()
    {
        String description = "Genres Description:\t"+getCurrentDateTimeFormatted()+"\n";
        for(Genre genre : genres)
        {
            description += genre.toString()+"\n";
        }
        return description;
    }
    //
    
    //
    public String getAllGenresIdAndTitle()
    {
        String description = "";
        for(Genre genre : genres)
        {
            description += genre.getID() + genre.getGenreName() +" :\n"+ genre.getIdBookAndTitleBook()+"\n";
        }
        return description;
    }
    
    //A method for returning a Genre by Id
    public Genre getGenreById(String Id)
    {
        if(Id==null || !Genre.validateIdFormat(Id,Genre.idFormat))
        {
            return null;
        }
        for(Genre genre : this.genres)
        {
            if(genre.getID().equals(Id))
            {
                return genre;
            }
        }
        throw new NullPointerException("Genre not Found");
    }
    //
    
    //A method for adding a genre to the list
    public void addGenre(Genre genre)
    {
        if(genre!=null)
            this.genres.add(genre);
    }
    //
    
    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }
    
    public static String getCurrentDateTimeFormatted()
    {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatedDate = formatDate.format(date);
        return formatedDate;
    }
}
