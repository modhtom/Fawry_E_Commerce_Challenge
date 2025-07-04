import java.util.Date;
import models.Product;
import models.Cheese;
import models.Biscuits;
import models.TV;
import models.MobileScratchCard;
import roles.Customer;
import services.Cart;
import services.CheckoutService;
public class FawryECommerce {
    public static void main(String[] args) {
        Product cheese = new Cheese("Cheese 400g", 50, 29, new Date(System.currentTimeMillis() + (14L * 24 * 60 * 60 * 1000)), 0.2);
        Product biscuits = new Biscuits("Biscuits 700g", 35, 16, new Date(System.currentTimeMillis() + (30L * 24 * 60 * 60 * 1000)), 0.9);
        Product tv = new TV("TV", 15000, 4, 28.0);
        Product scratchCard = new MobileScratchCard("Scratch Card", 8, 10);

        Customer customer = new Customer("MODHTOM", 100000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 2);
        cart.add(tv, 1);

        CheckoutService.checkout(customer, cart);
    }
}