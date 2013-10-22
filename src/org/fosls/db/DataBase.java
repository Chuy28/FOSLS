package org.fosls.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Class:          DataBase.java
 *  Description:    Create a connection to the database (Java DB Emb)
 * @author Jesus Espinoza Garcia
 */
public class DataBase {
    private final String driver;
    private final String url;
    
    private String db_name = "fosls_db";
    private String user = "admin";
    private String pass = "admin123";
    private String create = "true";
    
    
    
    private Connection con;
    
    public DataBase(){
        this.driver = "org.apache.derby.jdbc.EmbeddedDriver";
        this.url = "jdbc:derby:"+db_name+";create="+create+";user="+user+";password="+pass;
        
        try{
            Class.forName(driver);
            this.con = DriverManager.getConnection(this.url);
            
            if(create.equalsIgnoreCase("true"))
                this.createDatabase();
            
        }
        catch(SQLException | ClassNotFoundException e){
            
        }
    }
    
    
    private void createDatabase(){
        if(executeSqlFile(db_name)){
            System.out.println("BD creada con éxito");
        }else{
            System.out.println("Problema al crear db");
        }
    }

    private boolean executeSqlFile(String path){
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String str;
            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str + "\n ");
            }
            br.close();
            Statement st = this.con.createStatement();
            st.execute(sb.toString());
            return true;
        } 
        catch (IOException | SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    public Connection getConnection(){
        return this.con;
    }
}
