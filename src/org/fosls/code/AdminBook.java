package org.fosls.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jesus
 */
public class AdminBook {
    private Connection con;
    
    public AdminBook(Connection con){
        this.con = con;
    }

    public boolean addBook(Book book){
        String sql = "insert into book values(?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor1());
            ps.setString(3, book.getAuthor2());
            ps.setString(4, book.getAuthor3());
            ps.setString(5, book.getISBN());
            ps.setString(6, book.getState());
            
            ps.executeUpdate();
            return true;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    public boolean modifyBook(int id, Book book){
        if(id != 0){
            String sql = "update book set name=?, author1=?, author2=?, "
                    + "author3=?, isbn=?, state=? where id=?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, book.getName());
                ps.setString(2, book.getAuthor1());
                ps.setString(3, book.getAuthor2());
                ps.setString(4, book.getAuthor3());
                ps.setString(5, book.getISBN());
                ps.setString(6, book.getState());
                ps.setInt(7, id);
                ps.executeUpdate();
                return true;
            }
            catch(SQLException ex){
                System.err.println(ex.getMessage());
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public boolean deleteBook(int id){
        String sql = "delete from book where id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    public int getIdBook(Book book){
        return  this.getIdBook(book.getName(), book.getAuthor1(), 
                book.getAuthor2(), book.getAuthor3(), book.getISBN(), 
                book.getState());
    }
    
    private int getIdBook(String name, String author1, String author2,
            String author3, String isbn, String state){
        String sql = "select id from book where name=? and author1=? and "
                + "author2=? and author3=? and isbn=? and state=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, author1);
            ps.setString(3, author2);
            ps.setString(4, author3);
            ps.setString(5, isbn);
            ps.setString(6, state);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
                return rs.getInt("id");
            else
                return 0;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return 0;
        }
    }
}
