/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.lang.reflect.Field;

public class Book extends Method{
   //properties
   private String title;
   private int quantity;
   private String id;
   private String authorname;
   private int nbpages;
   private String description;
   private int publishedyear;
   private double price;
   private String genre;
    //
   
   static String idFormat = "#B";
   
   //Constructors
   public Book(String id,String title,String AuthorName,String genre,int qty,int NbPages,String Description,int PublishedYear,double Price)
   {
       this.setID(id);
       this.title = title;
       this.authorname = AuthorName;
       this.genre = genre;
       this.nbpages = NbPages;
       this.description = Description;
       this.publishedyear = PublishedYear;
       this.price=Price;
       this.quantity = qty;
   } 
   //
   
   //toString() Method
    @Override
    public String toString() {
        return "Book{" + "Title=" + title + ", Quantity=" + quantity + ", ID=" + id + ", AuthorName=" + authorname + ", NbPages=" + nbpages + ", Description=" + description + ", PublishedYear=" + publishedyear + ", Price=" + price + "$, genre=" + genre + '}';
    }
    //
    
    //Change a Book property value
    public boolean updateBook(String property, String newValue) {
        String modifiedproperty = property.toLowerCase();
        try
        {
            Field field = this.getClass().getDeclaredField(modifiedproperty);
            field.setAccessible(true);
            field.set(this, newValue);
            System.out.println("Update Succeeded");
            return true;
        }
        catch(NoSuchFieldException e)
        {
            System.out.println("Property not found. Update Failed");
            return false;
        } 
        catch (IllegalAccessException ex) 
        {
            System.out.println("Update Failed");
            return false;
       }
    }
    //
    
    //Method returns BookID + BookTitle + BookQuantity
    public String bookDescription()
    {
        String s ="";
        s+=this.getID()+" : "+this.getTitle()+" : "+this.getQty()+"\n";
        return s;
    }
    //
    
    //Method return BookId + BookTitle
    public String getIdAndTitle()
    {
        String s ="";
        try
        {
            s+=this.getID()+"\t"+this.getTitle()+"\n";
        }
        catch(NullPointerException e)
        {
            s = this.getID() + " Book Has Empty ID And Empty Title";
        }
        return s;
    }
    //
    
    //Getters N Setters
    public int getQty() {
        return quantity;
    } 
    public void setQty(int qty) {
        this.quantity = qty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getID() {
        return id;
    }
    
    public void setID(String id) 
    {
        if(!validateIdFormat(id,Book.idFormat))
        {
            this.id = null;
        }
        this.id = id;
    }

    public String getAuthorName() {
        return authorname;
    }

    public void setAuthorName(String AuthorName) {
        this.authorname = AuthorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublishedYear() {
        return publishedyear;
    }

    public void setPublishedYear(int PublishedYear) {
            this.publishedyear = PublishedYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double Price) {
        try
        {
            this.price = Price;
        }
        catch(NumberFormatException e)
        {
            this.price = 0.0;
        }
    }

    public int getNbPages() {
        return nbpages;
    }

    public void setNbPages(int NbPages) {
            this.nbpages = NbPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    //

}
