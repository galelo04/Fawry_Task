import java.util.List;

public class ShippingService {
    public ShippingService(List<Shippable> shippableProducts) {
        this.shippableProducts = shippableProducts;
    }

    private List<Shippable> shippableProducts;

    public void shipProducts() {
        for (Shippable product : shippableProducts) {
            System.out.println("Shipping product: " + product.getName() + " with weight: " + product.getWeight());
        }
    }
}
