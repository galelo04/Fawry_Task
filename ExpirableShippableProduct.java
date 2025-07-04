public class ExpirableShippableProduct extends ExpirableProduct implements Shippable {

    private double weight;

    public ExpirableShippableProduct(String expirationDate, String name, double price, int quantity, double weight) {
        super(expirationDate, name, price, quantity);
        this.weight = weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
