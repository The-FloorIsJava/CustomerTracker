package com.revature.CustomerTracker.Service;

import com.revature.CustomerTracker.customer.CustomerDAO;
import com.revature.CustomerTracker.customer.Customer;
import com.revature.CustomerTracker.customer.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CustomerServiceTestSuite {

    CustomerService sut;
    CustomerDAO mockCustomerDAO;

    @Before
    public void testPrep(){
        mockCustomerDAO = mock(CustomerDAO.class);
        sut = new CustomerService(mockCustomerDAO);
    }

    @Test
    public void test_addCustomer_returnsNewCustomer_givenValidCustomer(){
        // AAA

        //Arrange
        Customer newCustomer = new Customer("valid", 10.40, "valid");

        //Act
        when(mockCustomerDAO.create(newCustomer)).thenReturn(newCustomer);

        Customer customer = sut.addCustomer(newCustomer);

        //Assert
        verify(mockCustomerDAO, times(1)).create(newCustomer);
        Assert.assertNotNull(customer);
    }

}
