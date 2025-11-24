package SOLID_Principle.S;
import java.util.* ;

class Product{
    public String name ;
    public double price ;

    Product(String name, double price){
        this.name = name ;
        this.price = price ;
    }
}

class ShoppingCart{
    private List<Product> products = new ArrayList<>() ;

    public void addProduct(Product p){
        products.add(p) ;
    }

    public List<Product> getProducts(){
        return products ;
    }

    public double calculateTotal(){
        double total = 0 ;
        for(Product p: products){
            total += p.price ;
        }
        return total ;
    }
}

class ShoppingCartPrinter{
    private ShoppingCart cart ;

    ShoppingCartPrinter(ShoppingCart cart){
        this.cart = cart ;
    }

    public void printInvoice(){
        System.out.println("Sopping Cart Invoice:");
        for(Product p: cart.getProducts()){
            System.out.println(p.name + "- Rs " + p.price);
        }
        System.out.println("Total Price: " + cart.calculateTotal());
    }
}

class ShoppingCartStorage{
    private ShoppingCart cart ;

    ShoppingCartStorage(ShoppingCart cart){
        this.cart = cart ;
    }

    public void saveToDatabase(){
        System.out.println("Saving Shopping Cart to database...");
    }
}

public class SRPfollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart() ;
        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct((new Product("mobile", 20000)));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart) ;
        printer.printInvoice();

        ShoppingCartStorage storage = new ShoppingCartStorage(cart) ;
        storage.saveToDatabase();
    }
}
