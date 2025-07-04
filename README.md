# Fawry E-Commerce System

This Java project implements a comprehensive e-commerce system with product management, shopping cart functionality, and checkout processing. The system handles both shippable and non-shippable products, as well as expirable and non-expirable items.

## Features

- **Product Management**: Manage products with name, price, and quantity
- **Product Categories**:
  - Expirable products (Cheese, Biscuits)
  - Non-expirable products (TV, Mobile scratch cards)
- **Shipping Handling**: Differentiates between shippable and non-shippable products
- **Shopping Cart**: Supports adding products with quantity validation
- **Checkout Process**:
  - Subtotal calculation
  - Shipping fee calculation based on weight
  - Customer balance verification
  - Product expiration checks
  - Detailed receipt generation
- **Inventory Management**: Automatically reduces stock after successful purchase

## Class Structure

```text
Fawry_e-commerce_system/
├── FawryECommerce.java
│
├── interfaces/
│   └── Shippable.java
│
├── models/
│   ├── Product.java
│   ├── ExpirableProduct.java
│   ├── NonExpirableProduct.java
│   ├── Cheese.java
│   ├── Biscuits.java
│   ├── TV.java
│   └── MobileScratchCard.java
│
├── roles/
│   └── Customer.java
│
└── services/
    ├── Cart.java
    ├── CheckoutService.java
    └── ShippingService.java
```

## How to Run

1. Compile all Java files using the following command:

```bash
javac -d . FawryECommerce.java
```

2. Run the main class:

```bash
java FawryECommerce
```

## Expected Output

When you run the program, you should see output similar to:

```
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
1x TV
Total package weight 29.2kg

** Checkout receipt **
2x Cheese 400g     100
1x Biscuits 700g    35
2x Scratch Card     16
1x TV            15000
----------------------
Subtotal 15151
Shipping 653
Amount 15804
Current balance after payment: 84196
```

## Key Components

1. **Product Hierarchy**:

   - `Product` (abstract base class)
     - `ExpirableProduct` (for products with expiration dates)
     - `NonExpirableProduct` (for non-perishable products)

2. **Shipping System**:

   - `Shippable` interface defines products that require shipping
   - `ShippingService` calculates shipping costs based on weight

3. **Shopping Process**:

   - `Cart` manages selected products and quantities
   - `CheckoutService` handles the entire checkout process
   - `Customer` manages balance and payment

4. **Main Application**:
   - `FawryECommerce.java` demonstrates the system with sample products and a customer
