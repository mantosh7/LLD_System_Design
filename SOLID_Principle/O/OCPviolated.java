package SOLID_Principle.O;
import java.util.* ;

class Product1{
    public String name ;
    public double price ;

    Product1(String name, double price){
        this.name = name ;
        this.price = price ;
    }
}

class ShoppingCart1{
    private List<Product1> products = new ArrayList<>() ;

    public void addProduct1(Product1 p){
        products.add(p) ;
    }

    public List<Product1> getproducts(){
        return products ;
    }

    public double calculateTotal(){
        double total = 0 ;
        for(Product1 p: products){
            total += p.price ;
        }
        return total ;
    }
}

class ShoppingCartPrinter1{
    private ShoppingCart1 cart ;

    ShoppingCartPrinter1(ShoppingCart1 cart){
        this.cart = cart ;
    }

    public void printInvoice(){
        System.out.println("Sopping Cart Invoice:");
        for(Product1 p: cart.getproducts()){
            System.out.println(p.name + "- Rs " + p.price);
        }
        System.out.println("Total Price: " + cart.calculateTotal());
    }
}

class ShoppingCartStorage1{
    private ShoppingCart1 cart ;

    ShoppingCartStorage1(ShoppingCart1 cart){
        this.cart = cart ;
    }

    public void saveToSQLDatabase() {
        System.out.println("Saving shopping cart to SQL DB...");
    }

    public void saveToMongoDatabase() {
        System.out.println("Saving shopping cart to Mongo DB...");
    }

    public void saveToFile() {
        System.out.println("Saving shopping cart to File...");
    }
}

public class OCPviolated {
    public static void main(String[] args) {
        ShoppingCart1 cart = new ShoppingCart1() ;
        cart.addProduct1(new Product1("Laptop", 50000));
        cart.addProduct1((new Product1("mobile", 20000)));

        ShoppingCartPrinter1 printer = new ShoppingCartPrinter1(cart) ;
        printer.printInvoice();

        ShoppingCartStorage1 storage = new ShoppingCartStorage1(cart) ;
        storage.saveToSQLDatabase();
    }
}
