public class Main {
    public static void main(String[] args) {
        System.out.println("--- langsung ---");
        
        Shape generalShape = new Shape("Black");
        generalShape.printInfo();

        Square square = new Square(10.0, "Red");
        square.printInfo();

        Circle circle = new Circle(7.0, "Blue");
        circle.printInfo();

        Cylinder cylinder = new Cylinder(15.0, 7.0, "Yellow");
        cylinder.printInfo();

        System.out.println("\n--- Array ---");
        
        Shape[] shapes = new Shape[3];
        
        shapes[0] = new Square(5.0, "Green");
        shapes[1] = new Circle(10.0, "Purple");
        shapes[2] = new Cylinder(20.0, 14.0, "Orange");

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].printInfo(); 
        }
    }
}