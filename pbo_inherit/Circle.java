public class Circle extends Shape {
    protected double radius;
    public static final double phi = 3.14;

    public Circle(double radius, String color){
        super(color);
        this.radius = radius;
    }

    public double getRadius(double radius){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double calculateArea(){
        return phi * radius * radius;
    }

    @Override
    public void printInfo(){
        System.out.println("Circle " + color + ", area = " + calculateArea());
    }
}
