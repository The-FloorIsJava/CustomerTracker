package com.revature.CustomerTracker.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {
    @Query(value = "FROM Customer WHERE customerName = :customerName AND password = :password")
    Optional<Customer> loginCheck(String customerName, String password);

    Optional<Customer> findByCustomerNameAndPassword(String customerName, String password);
}
