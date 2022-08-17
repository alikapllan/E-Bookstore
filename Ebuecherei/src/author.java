
public class author {
    private int author_id;
    private String author_name;
    private String author_surname;
    private String author_url;

    public author(int author_id, String author_name, String author_surname, String author_url) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_surname = author_surname;
        this.author_url = author_url;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_surname() {
        return author_surname;
    }

    public void setAuthor_surname(String author_surname) {
        this.author_surname = author_surname;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }
    
    
}
