public class Customer {

    private String name;
    double balance;
    Cart cart;

    public Customer(String name, double balance, Cart cart) {
        this.name = name;
        this.balance = balance;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void checkout() throws CustomException {
        if (cart.isEmpty()) {
            throw new CustomException("Cart is empty. Please add products before checkout.");
        }
        double totalCost = cart.calculateTotal();
        if (balance < totalCost) {
            throw new CustomException(
                    "Insufficient balance. Total cost is " + totalCost + ", but balance is " + balance);
        } else if (totalCost <= 0) {
            throw new CustomException("Total cost must be greater than zero.");
        } else {
            balance -= totalCost;
            System.out.println("Checkout successful. Remaining balance: " + balance);
            cart.clearCart();
        }

        // print results of the chedkout
        System.out.println("Checkout Summary:");
        for (CartItem item : cart.getProducts()) {
            System.out.println("Product: " + item.getProduct().getName() + ", Quantity: " + item.getQuantity()
                    + ", Total Price: " + item.getTotalPrice());
        }
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Remaining Balance: " + balance);
        System.out.println("Shippable Products: ");
        for (Shippable shippable : cart.getShippableProducts()) {
            System.out.println("Product: " + shippable.getName() + ", Weight: " + shippable.getWeight());
        }

    }

}
