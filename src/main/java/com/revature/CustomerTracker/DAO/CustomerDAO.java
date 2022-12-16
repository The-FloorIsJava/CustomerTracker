package com.revature.CustomerTracker.DAO;

import com.revature.CustomerTracker.Model.Customer;
import com.revature.CustomerTracker.Util.ConnectionFactory;
import com.revature.CustomerTracker.Util.Exceptions.InvalidCustomerInputException;
import com.revature.CustomerTracker.Util.Interface.Crudable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements Crudable<Customer> {

    private Logger logger = LogManager.getLogger();
    @Override
    public Customer create(Customer newCustomer) {

        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {

//            String sql = "insert into customer (customer_name, balance, password) values (" +
//                                    "\'"+ newCustomer.getCustomerName() + "\', \'"
//                                        + newCustomer.getBalance() + "\', \'"
//                                        + newCustomer.getPassword();

            // Statement does NOT prevent SQL injection ( someone can insert malicious SQL statements that end up executing)
            // newCustomer.getCustomerName() = Johnny; drop table Customer;
//              ONE exception to use Statement is......GET all info with no restraints: select * from customer;
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(sql);


            String sql = "insert into customer (customer_name, balance, password, tier) values (?, ?, ?, ?)";
            // PreparedStatements prevent SQL injection
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // set the information for the ?
            preparedStatement.setString(1, newCustomer.getCustomerName());
            preparedStatement.setDouble(2, newCustomer.getBalance());
            preparedStatement.setString(3, newCustomer.getPassword());
            preparedStatement.setString(4, newCustomer.getTier());

            int checkInsert = preparedStatement.executeUpdate();

            if(checkInsert == 0){
                logger.warn("Information provided was not able to be persisted {}", newCustomer);
                throw new RuntimeException("Customer was not added to database");
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    newCustomer.setCustomerId(generatedKeys.getInt(1));
                }else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            

            logger.info("New customer with info {} was persisted to the database", newCustomer);
            return newCustomer;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Customer> findAll() {

        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            List<Customer> customers = new ArrayList<>();

            String sql = "select * from customer";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                customers.add(convertSqlInfoToCustomer(resultSet));
            }

            return customers;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public boolean update(Customer updatedCustomer) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    public Customer loginCheck(String customerName, String password){

        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){

            String sql = "select * from customer where customer_name = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            // column headers return in first line - customer_id, customer_name, balance, password
            if(!resultSet.next()){
                throw new InvalidCustomerInputException("Entered information for " + customerName + "was incorrect. Please try again");
            }

            return convertSqlInfoToCustomer(resultSet);

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    // This is a wonderful example of the DRY principle
    private Customer convertSqlInfoToCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();

        customer.setCustomerId(resultSet.getInt("customer_id"));
        customer.setCustomerName(resultSet.getString("customer_name"));
        customer.setBalance(resultSet.getDouble("balance"));
        customer.setPassword(resultSet.getString("password"));
        customer.setTier(resultSet.getString("tier"));

        return customer;
    }
}
