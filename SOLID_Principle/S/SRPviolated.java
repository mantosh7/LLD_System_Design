package SOLID_Principle.S;
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

    public void addProduct(Product1 p){
        products.add(p) ;
    }

    public List<Product1> getProducts(){
        return products ;
    }

    public double calculateTotal(){
        double total = 0 ;
        for(Product1 p: products){
            total += p.price ;
        }
        return total ;
    }

    public void printInvoice(){
        System.out.println("Sopping Cart Invoice:");
        for(Product1 p: products){
            System.out.println(p.name + "- Rs " + p.price);
        }
        System.out.println("Total Price: " + calculateTotal());
    }

    public void saveToDatabase(){
        System.out.println("Saving Shopping Cart to database...");
    }
}

public class SRPviolated {
    public static void main(String[] args) {
        ShoppingCart1 cart = new ShoppingCart1() ;
        cart.addProduct(new Product1("Laptop", 50000));
        cart.addProduct((new Product1("mobile", 20000)));

        cart.printInvoice();
        cart.saveToDatabase();
    }
}
