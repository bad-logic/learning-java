package fundamentals.labs.lab04.lab04_05.good;

public interface Polygon {
    public double[] getArrayOfSides();
    static double sum(double[] arr) {
        double sum = 0.0;
        for(double num:arr){
            sum += num;
        }
        return sum;
    }
    default double computePerimeter(){
        return Polygon.sum(getArrayOfSides());
//        double perimeter = 0;
//        for(double side: getArrayOfSides()){
//            perimeter += side;
//        }
//        return perimeter;
    }

}
