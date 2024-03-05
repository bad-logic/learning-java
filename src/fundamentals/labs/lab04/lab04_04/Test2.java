package fundamentals.labs.lab04.lab04_04;

import fundamentals.labs.lab04.lab04_04.good.*;

public class Test2 {

    public static void main(String[] args) {

        Polygon[] objects = {
                new Square(3),
                new Triangle(4,5,6),
                new Rectangle(4,3),
               };


        for(Polygon cc : objects) {
            // using java reflection api to get the class name values
            String className = cc.getClass().getSimpleName();
            System.out.println("For this " + className + "\nNumber of sides = " + cc.getNumberOfSides() + "\nPerimeter = "+cc.computePerimeter());
        }

    }


}
