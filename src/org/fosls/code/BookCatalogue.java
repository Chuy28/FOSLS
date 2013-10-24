package org.fosls.code;
/**
 *
 * @author jesus
 */
public class BookCatalogue {
    private String name;
    private String description;
    
    public BookCatalogue(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    public String getName(){ return this.name; }
    public String getDescription(){ return this.description; }
}
