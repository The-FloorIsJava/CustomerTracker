package com.revature.CustomerTracker.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Two Design Patterns are needed for our Connection Factory
 *  - Design pattterns are simply common ways of constructing objects inside of java
 *  Singleton Design Pattern
 *      - creational patterns
 *      - A SINGLE instance of that class to be made within the application
 *  Factory Design Pattern
 *      - creational
 *      - used to abstract way the creation and instantiation of the class
 *      - churns out instances of Connections anywhere in the project
 */
@Component
public class ConnectionFactory {
    private static final ConnectionFactory connectionFactory = new ConnectionFactory(); // eager instantiated single
    private Properties properties = new Properties();
    private static String url;
    private static String password;
    private static String username;

    private ConnectionFactory(){
        /* If you want to lazily instantiate a singleton
        if(connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        */

    }

    @Value("${spring.datasource.url}")
    public void setUrl(String dbUrl){
        url = dbUrl;
    }

    @Value("${spring.datasource.password}")
    public void setPassword(String dbPassword){
        password = dbPassword;
    }

    @Value("${spring.datasource.username}")
    public void setUsername(String dbUsername){
        username = dbUsername;
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * The purpose is for anywhere in the program to request access to the single connection factory object
     * @return our singleton connection factory object
     */
    public static ConnectionFactory getConnectionFactory(){
        return connectionFactory;
    }

    /**
     * This method returns a connection for any class that requests it. Will be used purely inside the test suite
     * and our DAO layer.
     * @return utilizes the DriverManager to get a connection to our database from postgresql
     */
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
