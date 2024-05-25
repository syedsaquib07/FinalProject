import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserAuthentication auth = new UserAuthentication();
        try (Scanner scanner = new Scanner(System.in)) {
			YourUserClass user = null;

			// Register
			System.out.println("Register - Enter Username:");
			String regUsername = scanner.nextLine();
			System.out.println("Register - Enter Password:");
			String regPassword = scanner.nextLine();
			user = auth.register(regUsername, regPassword);
			
			if(user != null) {
			    // Login
			    System.out.println("Login - Enter Username:");
			    String loginUsername = scanner.nextLine();
			    System.out.println("Login - Enter Password:");
			    String loginPassword = scanner.nextLine();
			    user = auth.login(loginUsername, loginPassword);
			    
			    if(user != null) {
			        // Adding products to the cart
			        ShoppingCart cart = new ShoppingCart();
			        cart.addProduct(new Product("T-shirt", 19.99));
			        cart.addProduct(new Product("Watch", 149.99));
			        
			        // Display cart contents
			        System.out.println("Products in Cart:");
			        for (Product product : cart.getProducts()) {
			            System.out.println("- " + product.getName() + " - $" + product.getPrice());
			        }
			        
			        // Simulate payment
			        boolean paymentSuccessful = simulatePayment(cart.calculateTotalPrice());
			        
			        if(paymentSuccessful) {
			            System.out.println("Payment successful! Thank you for shopping with us.");
			        } else {
			            System.out.println("Payment failed. Please try again.");
			        }
			    } else {
			        System.out.println("Login failed.");
			    }
			} else {
			    System.out.println("Registration failed.");
			}
		}
    }

    // Simulate payment process
    private static boolean simulatePayment(double totalPrice) {
        // Simulate payment process
        System.out.println("Total amount to be paid: $" + totalPrice);
        // Assuming payment always succeeds in this simulation
        return true;
    }
}
