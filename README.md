# Fawry E-Commerce Challenge

This Java project implements an e-commerce system with product management, shopping cart functionality, and checkout processing. The system handles both shippable and non-shippable products, as well as expirable and non-expirable items.

## Features

- Product management with name, price, and quantity
- Support for expirable (Cheese, Biscuits) and non-expirable products (TV, Mobile scratch cards)
- Shipping requirements based on product type
- Shopping cart with quantity validation
- Checkout process with:
  - Subtotal calculation
  - Shipping fee calculation
  - Balance verification
  - Expiration checks
  - Receipt generation

## Class Structure

- `Product.java`: Abstract base class for all products
- `ExpirableProduct.java`: Abstract class for expirable products
- `NonExpirableProduct.java`: Abstract class for non-expirable products
- `ShippableProducts.java`: Concrete shippable products (Cheese, Biscuits, TV)
- `NonShippableProducts.java`: Non-shippable products (MobileScratchCard)
- `Customer.java`: Customer information and balance management
- `Cart.java`: Shopping cart implementation
- `CartItem.java`: Represents items in the cart
- `CheckoutService.java`: Handles checkout process
- `ShippingService.java`: Calculates shipping costs
- `FawryECommerce.java`: Main class with demonstration

## How to Run

1. Compile all Java files:

```bash
javac *.java
```

2. Run the main class:

```bash
java FawryECommerce
```
