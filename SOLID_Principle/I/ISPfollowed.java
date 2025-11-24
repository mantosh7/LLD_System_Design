package SOLID_Principle.I;

interface Shape2D{
    void area() ;
}

interface Shape3D extends Shape2D{
    void volume() ;
}

class Square2 implements Shape2D{
    private double side ;

    public Square2(double side){
        this.side = side ;
    }

    @Override
    public void area(){
        System.out.println("The area of square2 with side " + this.side + " = " + this.side*this.side);
    }
}

class Rectangle2 implements Shape2D{
    private double length ;
    private double width ;;

    public Rectangle2(double l, double w){
        this.length = l ;
        this.width = w ;
    }

    @Override
    public void area(){
        System.out.println("The area of rectangle2 with length " + this.length + " and width " + this.width + " = " + this.length*this.width);
    }
}

class Cube2 implements Shape3D{
    private double side ;

    public Cube2(double side){
        this.side = side ;
    }

    @Override
    public void area(){
        System.out.println("The area of cube2 with side " + this.side + " = " + 6*this.side*this.side);
    }

    @Override
    public void volume(){
        System.out.println("The volume of cube2 with side " + this.side + " = " + this.side*this.side*this.side);
    }
}

public class ISPfollowed {
    public static void main(String[] args) {
        Shape2D square2 = new Square2(4.5) ;
        square2.area() ;

        Shape2D rect = new Rectangle2(2, 4) ;
        rect.area();

        Shape3D cube2 = new Cube2(4.5) ;
        cube2.area();
        cube2.volume();
    }
}
