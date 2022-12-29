package com.revature.CustomerTracker.cartitem;

import com.revature.CustomerTracker.customer.Customer;
import com.revature.CustomerTracker.menuitem.MenuItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private int cartItemId;

    @ManyToOne
    @JoinColumn
    private MenuItem item;

    @ManyToOne
    @JoinColumn(name = "owned_by", nullable = false)
    private Customer ownedBy;


}
