import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Cart {
    private List<CartItem> products;
    private List<Shippable> shippableProducts;

    public Cart() {
        products = new ArrayList<CartItem>();
    }

    public List<CartItem> getProducts() {
        return products;
    }

    public void addProduct(Product product, int quantity) throws CustomException {
        if (product.getQuantity() < quantity) {
            throw new CustomException("Insufficient quantity for product: " + product.getName());
        }
        if (product.getQuantity() <= 0) {
            throw new CustomException("Product " + product.getName() + " is not available.");
        }
        // check if product is expired
        if (product instanceof Expirable) {
            Expirable expirableProduct = (Expirable) product;
            LocalDate currentDate = LocalDate.now();
            if (expirableProduct.isExpired(currentDate.toString())) {
                throw new CustomException("Product " + product.getName() + " is expired.");
            }
        }
        CartItem cartItem = new CartItem(product, product.getQuantity());
        if (product instanceof Shippable) {
            shippableProducts.add((Shippable) product);
        }
        product.setQuantity(product.getQuantity() - quantity);
        products.add(cartItem);
    }

    public void removeProduct(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProduct().getName().equals(productName)) {
                products.remove(i);
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : products) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public List<Shippable> getShippableProducts() {
        return shippableProducts;
    }

    public void clearCart() {
        products.clear();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}
