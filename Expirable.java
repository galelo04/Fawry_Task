public interface Expirable {
    String getExpirationDate();

    void setExpirationDate(String expirationDate);

    boolean isExpired(String currentDate);
}
