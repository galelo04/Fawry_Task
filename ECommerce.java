import java.util.List;

public class ECommerce {
  public static void main(String[] args) {
    ExpirableProduct cheese = new ExpirableProduct("2026-12-31", "Cheese", 5.99, 10);
    ExpirableShippableProduct biscuits = new ExpirableShippableProduct("2026-11-30", "Biscuits", 2.49, 20, 0.5);
    ShippableProduct tv = new ShippableProduct("TV", 499.99, 5, 15.0);

    NonShippableNonExpirableProduct mobileScratchCard = new NonShippableNonExpirableProduct("Mobile Scratch Card", 9.99,
        100);
    Customer customer = new Customer("John Doe", 1000.00, new Cart());
    try {
      customer.getCart().addProduct(cheese, 2);
      customer.getCart().addProduct(biscuits, 3);
      customer.getCart().addProduct(tv, 1);
      customer.getCart().addProduct(mobileScratchCard, 5);
      customer.checkout();
    } catch (CustomException e) {
      System.out.println(e.getMessage());
    } finally {
      // Shipping products if any
      List<Shippable> shippableProducts = customer.getCart().getShippableProducts();
      if (!shippableProducts.isEmpty()) {
        ShippingService shippingService = new ShippingService(shippableProducts);
        shippingService.shipProducts();
      } else {
        System.out.println("No shippable products in the cart.");
      }
    }

  }
}
