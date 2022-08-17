
public class publisher {
    private int publisher_id;
    private String publisher_name;
    private String publisher_url;
    private String publisher_email;

    public publisher(int publisher_id, String publisher_name, String publisher_url, String publisher_email) {
        this.publisher_id = publisher_id;
        this.publisher_name = publisher_name;
        this.publisher_url = publisher_url;
        this.publisher_email = publisher_email;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getPublisher_url() {
        return publisher_url;
    }

    public void setPublisher_url(String publisher_url) {
        this.publisher_url = publisher_url;
    }

    public String getPublisher_email() {
        return publisher_email;
    }

    public void setPublisher_email(String publisher_email) {
        this.publisher_email = publisher_email;
    }
    
    
}
