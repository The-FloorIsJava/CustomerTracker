package com.revature.CustomerTracker.cartitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private int cartItemId;
    private int item;
    private int ownedBy;

    public CartItem(int item, int ownedBy) {
        this.item = item;
        this.ownedBy = ownedBy;
    }

}
