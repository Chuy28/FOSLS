package org.fosls.code;

/**
 *  Class;          Book.java
 *  Description:    Class for instance a book
 * @author jesus
 */
public class Book {
    private BookCatalogue bc;
    private String name;
    private String author1;
    private String author2;
    private String author3;
    private String isbn;
    private String state;
    
    public Book(BookCatalogue bc, String name, String author1, String author2, 
            String author3, String isbn, String state){
        this.bc = bc;
        this.name = name;
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.isbn = isbn;
        this.state = state;
    }
    
    public BookCatalogue getBookCatalogue(){ return this.bc; }
    public String getName(){ return this.name; }
    public String getAuthor1(){ return this.author1; }
    public String getAuthor2(){ return this.author2; }
    public String getAuthor3(){ return this.author3; }
    public String getISBN(){ return this.isbn; }
    public String getState(){ return this.state; }
}
