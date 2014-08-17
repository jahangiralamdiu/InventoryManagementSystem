package inventorymanagementsystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jahangir
 */
public class ConnectivitySupport {
    
    private String driver="com.mysql.jdbc.Driver";
    private String source="jdbc:mysql://localhost:3306/inventorymanagement";
    private String user="root";
    private String password="dontmind!";
    private Connection conn;
    
    public ConnectivitySupport() throws ClassNotFoundException, SQLException {
        
        loadDriver();
        conn=DriverManager.getConnection(source, user, password);
        
        
    }

    public ConnectivitySupport(String driver, String source, String user, String password, Connection conn) throws ClassNotFoundException, SQLException {
        this.driver = driver;
        this.source = source;
        this.user = user;
        this.password = password;
        this.conn = conn;
        
        loadDriver();
        conn=DriverManager.getConnection(source, user, password);
        
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void loadDriver() throws ClassNotFoundException{
        
        Class.forName(driver);
    }
    
    
    
}
