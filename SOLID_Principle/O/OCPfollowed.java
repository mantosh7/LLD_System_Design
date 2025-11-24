package SOLID_Principle.O;

import java.util.*;

class Product {
    public String name;
    public double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getproducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }
}

class ShoppingCartPrinter {
    private ShoppingCart cart;

    ShoppingCartPrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Sopping Cart Invoice:");
        for (Product p : cart.getproducts()) {
            System.out.println(p.name + "- Rs " + p.price);
        }
        System.out.println("Total Price: " + cart.calculateTotal());
    }
}

interface DBPersistence{
    void save(ShoppingCart cart) ;
}

class SQLPersistence implements DBPersistence{
    @Override
    public void save(ShoppingCart cart){
        System.out.println("saving shopping cart to SQL database...");
    }
}

class MONGODBPersistence implements DBPersistence{
    @Override
    public void save(ShoppingCart cart){
        System.out.println("saving shopping cart to MONGODB database...");
    }
}

class FILEPersistence implements DBPersistence{
    @Override
    public void save(ShoppingCart cart){
        System.out.println("saving shopping cart to FILE database...");
    }
}

public class OCPfollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct((new Product("mobile", 20000)));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        DBPersistence db1 = new SQLPersistence() ;
        DBPersistence db2 = new MONGODBPersistence() ;
        DBPersistence db3 = new FILEPersistence() ;
        db1.save(cart) ;
        db2.save(cart) ;
        db3.save(cart);

    }
}
