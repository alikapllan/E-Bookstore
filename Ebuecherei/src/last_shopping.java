
public class last_shopping {
    private int basket_id;
    private int total_price;
    private String shopping_date;

    public last_shopping(int basket_id, int total_price,String shopping_date) {
        this.basket_id = basket_id;
        this.total_price = total_price;
        this.shopping_date = shopping_date;
    }

    public int getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(int basket_id) {
        this.basket_id = basket_id;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getShopping_date() {
        return shopping_date;
    }

    public void setShopping_date(String shopping_date) {
        this.shopping_date = shopping_date;
    }
    
    
}
