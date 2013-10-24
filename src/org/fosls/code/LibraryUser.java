package org.fosls.code;

/**
 *  Class;          LibraryUser.java
 *  Description:    Class for instance a library user
 * @author jesus
 */
public class LibraryUser {
    private String school_id;
    private String name;
    private String address;
    private String telephone;
    private String email;
    
    public LibraryUser(String school_id, String name, String address,
            String telephone, String email){
        this.school_id = school_id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }
    
    public String getSchoolID(){ return this.school_id; }
    public String getName(){ return this.name; }
    public String getAddress(){ return this.address; }
    public String getTelephone(){ return this.telephone; }
    public String getEmail(){ return this.email; }
    
}
