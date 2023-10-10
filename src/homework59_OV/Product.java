package homework59_OV;

public class Product {
    private String title;
    private String category;
    private double price;
    private double rate;

    public Product(String title, String category, double price, double rate) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getRate() {
        return rate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Product{" + "title='" + title + '\'' + ", category='" + category + '\'' + ", price=" + price + ", rate=" + rate + '}';
    }
}
