public class Square extends Shape {
    private double side;

    public Square (double side, String color){
        super(color);
        this.side = side;
    }

    public double getSide(double side){
        return side;
    }

    public void setSide(){
        this.side = side;
    }

    public double calculateArea(){
        return side * side;
    }

    @Override 
    public void printInfo(){
        System.out.println("Square colored " + color + ",Area = " + calculateArea());
    }

}