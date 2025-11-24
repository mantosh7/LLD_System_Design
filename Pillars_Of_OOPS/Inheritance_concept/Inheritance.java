package Pillars_Of_OOPS.Inheritance_concept;

class Shape {
    int length ;
    int breadth ;

    Shape(int length, int breadth){
        this.length = length ;
        this.breadth = breadth;
    }
}

class Rectangle extends Shape{
    String name;
    Rectangle(int length, int breadth, String name){
        super(length, breadth);
        this.name = name ;
    }

    void area(){
        System.out.println("Area of " + this.name + " is: " + length*breadth);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Rectangle react = new Rectangle(4, 10, "rectangle");
        react.area() ;
    }
}
