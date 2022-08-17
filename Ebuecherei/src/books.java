
public class books {
    
    private int isbn;
    private String name;
    private int year;
    private int price;
    private int page_number;
    private int author_id;
    private int publisher_id;

    public books(int isbn, String name, int year, int price, int page_number, int author_id, int publisher_id) {
        this.isbn = isbn;
        this.name = name;
        this.year = year;
        this.price = price;
        this.page_number = page_number;
        this.author_id = author_id;
        this.publisher_id = publisher_id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }
    
    
}
