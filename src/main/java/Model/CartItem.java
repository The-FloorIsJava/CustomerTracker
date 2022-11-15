package Model;

public class CartItem {
    private int cartItemId;
    private int item;
    private int ownedBy;

    public CartItem() {
    }

    public CartItem(int cartItemId, int item, int ownedBy) {
        this.cartItemId = cartItemId;
        this.item = item;
        this.ownedBy = ownedBy;
    }

    public CartItem(int item, int ownedBy) {
        this.item = item;
        this.ownedBy = ownedBy;
    }



    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(int ownedBy) {
        this.ownedBy = ownedBy;
    }
}
