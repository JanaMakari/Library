/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Library;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       //--Books
       
       //Fiction
       Book Mockingbird1 = new Book("#B01","To Kill a Mockingbird","Harper Lee","Fiction",5,281,"A Pulitzer Prize-winning novel set in the American South during the 1930s, addressing racial injustice and moral growth.",1960,10.99);
       Book B19841 = new Book("#B02","1984","George Orwell","Fiction",3,328,"A dystopian novel depicting a totalitarian regime and the struggle for individual freedom.",1949,9.99);
       Book hungergames = new Book("#B03","The Hunger Games","Suzanne Collins","Fiction",4,374,"The first book in the Hunger Games trilogy, set in a dystopian future where teenagers are forced to participate in a televised fight to the death.",2008,10.99);
       //
       
       //Literatture
       Book gatsby = new Book("#B05","The Great Gatsby","F. Scott Fitzgerald","Literature",1,180,"A classic American novel set in the 1920s, exploring themes of love, wealth, and the American Dream.",1925,8.50);
       Book wuthering = new Book("#B06","Wuthering Heights","Emily Brontë","Literature",8,288,"A novel exploring the destructive love between Catherine Earnshaw and Heathcliff, set on the Yorkshire moors.",1847,8.99);
       //
       
       //Romance
       Book pnp = new Book("#B07","Pride and Prejudice","Jane Austen","Romance",2,279,"A romantic novel set in Georgian England, focusing on the dynamics of class, marriage, and morality.",1813,7.99);
       Book jane = new Book("#B08","Jane Eyre","Charlotte Brontë","Romance",3,624,"A Bildungsroman novel following the orphaned Jane Eyre as she faces adversity and seeks independence in Victorian England.",1847,10.50); 
       //
       
       //Mystery
       Book davinci = new Book("#B09","The Da Vinci Code","Dan Brown","Mystery",5,454,"A thriller novel following symbologist Robert Langdon as he investigates a murder in the Louvre Museum and unravels a conspiracy involving the Priory of Sion and the Holy Grail.",2003,11.49);
       Book wmn = new Book("#B10","The Woman in White","Wilkie Collins","Mystery",2,185,"A mystery novel featuring mistaken identities, ghostly apparitions, and a woman dressed in white, as the protagonist Walter Hartright unravels the truth behind Laura Fairlie's identity.",1859,9.99);
       //--//
        
       //-- Genres
       Genre fiction = new Genre("#G01","Fiction");
       fiction.addBook(Mockingbird1);fiction.addBook(B19841);fiction.addBook(hungergames);
       //
       Genre classic = new Genre("#G02","Literature");
       classic.addBook(gatsby);classic.addBook(wuthering);
       //
       Genre romance = new Genre("#G03","Romance");
       romance.addBook(pnp);romance.addBook(jane);
       //
       Genre mystery = new Genre("#G04","Mystery");
       mystery.addBook(davinci);mystery.addBook(wmn);
       //--//
       
       //--The Library
       Library library = new Library("Bookshop");
       library.addGenre(fiction);library.addGenre(classic);library.addGenre(romance);library.addGenre(mystery);
       //--//
       
       //--The Program
       Scanner input = new Scanner(System.in);
       int firstlimit = 1;int secondlimit = 8;
       int integer = 0;boolean again;boolean exit = false;
       System.out.println("\t"+library.getName()+"\n1-Show Library Details\n2-Show Genres Details\n3-Show Book Details\n4-Check For The Existence Of A Book\n5-Add A Book\n6-Delete Book\n7-Update Book\n8-Close the Program\nPlease Enter a Nb: ");
        while(!exit){
            do{
                try
                {
                    again = false;
                    integer = input.nextInt();
                    if(integer < firstlimit || integer > secondlimit)
                    {
                        System.out.println("Invalid Input. Please Enter an Integer between 1-6: ");
                        again = true;
                    }
                 }
                 catch(InputMismatchException e)
                 {
                     System.out.println("Invalid Input. Please Enter an Integer: ");
                     again = true;
                     input.nextLine(); 
                 }
            }while(again);

            switch(integer)
            {
                case 1 :
                    listLibraryGenres(library);
                    break;
                case 2 :
                    getAllGenresDescription(library);
                    break;
                case 3 :
                    showBookDetails(library);
                    break;
                case 4 :
                    searchForBook(library);
                    break;
                case 5 :
                    addBook(library);
                    break;
                case 6 :
                    deleteBook(library);
                    break;
                case 7 :
                    updateBook(library);
                    break;
                case 8 :
                    System.out.println("Program Closed");
                    exit=true;
                    break;
                default : 
                    System.out.println("Invalid Nb");
                    break;
            }
        }
       }
        public static void listLibraryGenres(Library library)
        {
            System.out.println(library.listLibraryGenres());
        }
        public static void getAllGenresDescription(Library library)
        {
            System.out.println(library.getAllGenresDescription());
        }
        public static String validId(String idFormat)
        {
            Scanner input = new Scanner(System.in);
            String id; boolean again; boolean validId;
            do
            {
                again = false;
                id = input.next();
                validId = Book.validateIdFormat(id, idFormat);
                if(!validId)
                {
                    System.out.println("Invalid ID. Please Try Again: ");
                    again = true;
                }
            }while(again);
            return id;
        }
        public static void showBookDetails(Library library)
        {
            String bookId;
            String genreId;
            System.out.println(library.getAllGenresIdAndTitle()+"Please Enter Genre ID : ");
            //Validate Genre ID
            genreId = validId(Genre.idFormat);
            //
            System.out.println("Please Enter Book ID : ");
            //Validate Book ID
            bookId = validId(Book.idFormat);
            //
            try
               {
                   Genre inputGenre = library.getGenreById(genreId);
                   Book inputBook = inputGenre.getBook(bookId);
                   System.out.println(inputBook.toString());
               }
            catch(NullPointerException e)
               {
                   System.out.println(e.getMessage());
               }
        }
        public static void searchForBook(Library library)
        {
            Scanner input = new Scanner(System.in);
            String id;String output;
            System.out.println("Enter Book ID : ");
            id = input.next();
            if(library.bookExists(id))
            {
                output = "Book exist.\n";
            }
            else
            {
                output = "Book Not Found.\n";
            }
            System.out.println(output);
        }
        
        public static void addBook(Library library)
        {
            Book book;
            try
            {
                book = createBook();
                String validBookGenreName = book.getGenre().trim();
                String validlibraryGenreName;
                for(Genre genre : library.getGenres())
                {
                   validlibraryGenreName = genre.getGenreName().trim();
                   if(validlibraryGenreName.equalsIgnoreCase(validBookGenreName)) 
                   {
                       genre.addBook(book);
                       break;
                   }
                }
                System.out.println("The book was not added to the library because the appropriate genre was not found.");
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
        
        public static String getStringInput(String message)
        {
            Scanner input = new Scanner(System.in);
            System.out.println(message);
            return input.nextLine();
        }
        public static int getIntInput(String message)
        {
            Scanner input = new Scanner(System.in);
            System.out.println(message);
            int value;
            try
            {
                value = input.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Input. Default value 0 will be set.");
                value = 0;
            }
            return value;
        }
        //Book(String id,String title,String AuthorName,String genre,int qty,int NbPages,String Description,int PublishedYear,double Price)
        public static Book createBook()
        {
            Scanner input = new Scanner(System.in);
            //
            String id = getStringInput("Enter Book ID : ");
            if(!Book.validateIdFormat(id, Book.idFormat))
            {
                throw new IllegalArgumentException("Invalid ID");
            }
            //
            String title = getStringInput("Enter Book Title : ");
            //
            String authorName = getStringInput("Enter Book AuthorName : ");
            //
            String genre = getStringInput("Enter Book Genre : ");
            //
            int quantity = getIntInput("Enter Book Quantity : ");
            //
            int nbOfPages = getIntInput("Enter Book nbOfPages : ");
            //
            String description = getStringInput("Enter Book Description : ");
            //
            int publishedYear = getIntInput("Enter Book PublishedYear : ");
            //
            int price = getIntInput("Enter Book Price : ");
            //
            Book book = new Book(id,title,authorName,genre,quantity,nbOfPages,description,publishedYear,price);
            return book;
        }
        public static void deleteBook(Library library)
        {
            String bookid;int qty;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter The Book ID : ");
            bookid = input.next();
            
            if(!Book.validateIdFormat(bookid,Book.idFormat))
            {
                throw new IllegalArgumentException("Invalid ID. Deletion Failed");
            }
            
            input.nextLine();
            
            System.out.println("Enter The Quantity : ");
            try
            {
                qty = input.nextInt();
                for(Genre genre : library.getGenres())
                {
                    if(genre.removeBook(bookid, qty))
                    {
                        System.out.println("Deletion Succeed");
                        return;
                    }
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Input. Deletion Failed.");
            }
        }
        public static void updateBook(Library library)
        {
           Scanner input = new Scanner(System.in);
           System.out.println("Enter Genre ID : ");
           String genreId = input.next();
           if(!Genre.validateIdFormat(genreId,Genre.idFormat))
           {
               System.out.println("Invalid Genre ID. Update Failed");
               return;
           }
           input.nextLine();
           System.out.println("Enter Book ID : ");
           String bookId = input.next();
           if(!Book.validateIdFormat(bookId,Book.idFormat))
           {
               System.out.println("Invalid Book ID. Update Failed");
               return;
           }
           System.out.println("Enter Property : ");
           String property = input.next();
           System.out.println("Enter The New Value : ");
           String value = input.next();
           try{
               Genre genre = library.getGenreById(genreId);
               if(genre.updateBookGenre(bookId, property, value))
               {
                   System.out.println("Update Succeeded");
               }
           }
           catch(NullPointerException e)
           {
               System.out.println("Genre ID not found. Update Failed");
           }
        }
    }
    
    
    
    
    
    
    

