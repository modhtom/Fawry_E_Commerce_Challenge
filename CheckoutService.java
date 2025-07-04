import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty");

        for (CartItem item : cart.getItems()) {
            if (item.product.isExpired()) {
                throw new IllegalStateException("Product " + item.product.getName() + " is expired.");
            }
        }

        double subtotal = cart.getSubtotal();
        List<Shippable> shippables = cart.getShippableItems();
        double shipping = ShippingService.ship(shippables);
        double total = subtotal + shipping;

        if (!customer.canAfford(total)) {
            throw new IllegalStateException("You have an insufficient balance.");
        }

        for (CartItem item : cart.getItems()) {
            item.product.decreaseQuantity(item.quantity);
        }

        customer.deduct(total);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s \t %.0f\n", item.quantity, item.product.getName(), item.getTotalPrice());
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", subtotal);
        System.out.printf("Shipping %.0f\n", shipping);
        System.out.printf("Amount %.0f\n", total);
        System.out.printf("Current balance after payment: %.0f\n", customer.getBalance());

        cart.clear();
    }
}