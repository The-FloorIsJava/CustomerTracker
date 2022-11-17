package com.revature.CustomerTracker.Util.Interface;

import com.revature.CustomerTracker.Model.Customer;

import java.util.List;

public interface Crudable<T> {

    // Create
    T create(T newObject);

    // Read
    List<T> findAll();
    T findById(int id);

    // Update
    boolean update(T updatedObject);

    // Delete
    boolean delete(int id);
}
