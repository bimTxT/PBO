public class Cylinder extends Circle{
    private double height;

    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight(double height){
        return height;
    }

    public void setHeight(){
        this.height = height;

    }

    public double calculateVolume(){
        return super.calculateArea() * height;
    }

    @Override 
    public void printInfo(){
        System.out.println("Cylinder " + color + ", Volume = " + calculateVolume());
    }
}
