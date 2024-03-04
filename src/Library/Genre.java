/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Genre extends Method
{
    //Properties
    private String GenreName;
    private ArrayList<Book>Books;
    //private int NbofBooks; we can get it by .siz()
    private String ID;
    //
    
    static String idFormat = "#G";
            
    //Constructors
    public Genre(String id,String GenreName)
    {
        this.setID(id);
        this.GenreName = GenreName;
        this.Books = new ArrayList<Book>();
    }
    
    public Genre(String id,String GenreName,ArrayList<Book> Books)
    {
        this.setID(id);
        this.GenreName = GenreName;
        this.Books = Books;
    }
    //
    
    
    
    //public void UpdateBook(String ID,)
     public boolean updateBookGenre(String bookid, String property, String value)
     {
         String id;
         for(Book b : this.Books)
         {
             id = b.getID();
             if(id.equalsIgnoreCase(bookid))
             {
                 return b.updateBook(property, value);
             }
         }
         System.out.println("Book ID not Found. Update Failed");
         return false;
     }
     //

    //toString()
    @Override
    public String toString() {
        String s = "";
        String str = this.ID + " " + this.GenreName + " Books : \n";
        for(Book book : this.Books)
        {
            s+="Title : " + book.getTitle()+"\tQuantity : "+book.getQty()+"\n";
        }
        str+=s;
        return str;
    }
    //
    
    //A Method returns ID And Title Book
    public String getIdBookAndTitleBook()
    {
        String str = "";
        for(Book book : this.Books)
        {
            str+=book.getIdAndTitle();
        }
        return str;
    }
    //
    
    //A method that returns true/false if the genre contains the book
    public boolean findBookById(String bookId)
    {
        if(!validateIdFormat(bookId,Book.idFormat))
        {
            return false;
        }
        if (this.Books == null)
        {
            return false;
        }
        String bookid;
        for(Book book : this.Books)
        {
            bookid = book.getID();
            if(bookid.equals(bookId))
            {
                return true;
            }
        }
        return false;
    }
    
    //A method for deleting a book.
    public boolean removeBook(String ID,int qty)
    {
        int newqty;String id;int idqty;
        for(Book book : this.Books)
        {
            id = book.getID();
           if(id.equals(ID))
           {
               idqty = book.getQty();
               if(idqty>qty)
               {
                   newqty = idqty - qty;
                   book.setQty(newqty);
                   return true;
                   //break;
               }
                this.Books.remove(book);
                return true;
                //break;
           }
        }
        return false;
    }
    //
    
    //A method that returns a book
    public Book getBook(String bookId)
    {
        if(!validateIdFormat(bookId,Book.idFormat)||bookId==null)
        {
            return null;
        }
        for(Book book : this.Books)
        {
            if(book.getID().equals(bookId))
            {
                return book;
            }
        }
        throw new NullPointerException("Book not Found");
    }
    //
    
    //A Method for adding a book to the List
    public void addBook(Book book)
    {
        this.Books.add(book);
    }
    //
    
    //
    public String genreDetails()
    {
        String s ="",str="";
        s+=this.GenreName+" : \n has "+this.Books.size()+" Books: \nBookID\tBookTitle\tQty\n";
        for(Book b : Books)
        {
            str+=b.bookDescription();
        }
        s+=str;
        return s;
    }
    //
    
    //getter Setters
    public String getGenreName() {
        return GenreName;
    }

    public void setGenreName(String GenreName) {
        this.GenreName = GenreName;
    }

    public ArrayList<Book> getBooks() {
        return Books;
    }

    public void setBooks(ArrayList<Book> Books) {
        this.Books = Books;
    }
    public String getID() {
        return ID;
    }

    public void setID(String id) {
        if(!validateIdFormat(id,"#G"))
        {
            this.ID = null;
        }
        this.ID = id;
    }
    
}
