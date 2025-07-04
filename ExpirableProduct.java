public class ExpirableProduct extends Product implements Expirable {
    private String expirationDate;

    public ExpirableProduct(String expirationDate, String name, double price, int quantity) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isExpired(String currentDate) {
        return currentDate.compareTo(expirationDate) > 0;
    }
}
