package modernpractises.labs.Lab09.lab09_09;
import java.util.*;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {MEAT, FISH, OTHER}

    public static final List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Type.MEAT),
                    new Dish("beef", false, 700, Type.MEAT),
                    new Dish("chicken", false, 400, Type.MEAT),
                    new Dish("french fries", true, 530, Type.OTHER),
                    new Dish("rice", true, 350, Type.OTHER),
                    new Dish("season fruit", true, 120, Type.OTHER),
                    new Dish("pizza", true, 550, Type.OTHER),
                    new Dish("prawns", false, 400, Type.FISH),
                    new Dish("salmon", false, 450, Type.FISH));

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public static boolean isVegetarianMealAvailable() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    public static boolean isThereAnyDishWithCaloriesLessThan1000() {
        return menu.stream().anyMatch(x -> x.getCalories() < 1000);
    }

    public static boolean isThereAnyDishWithCaloriesGreaterThan1000() {
        return menu.stream().anyMatch(x -> x.getCalories() > 1000);
    }

    public static Optional<Dish> getFirstMeatMeal() {
        return menu.stream().filter(x -> x.getType() == Type.MEAT).findFirst();
    }

    public static int getTotalCalories() {
        return menu.stream().map(x -> x.getCalories()).reduce(0, (x, y) -> x + y);
    }

    public static int getTotalCaloriesWithMethodReference() {
        return menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
    }

    public static void main(String[] args) {

        //a. Is there any Vegetarian meal available ( return type boolean)
        System.out.println("Is there any vegetarian dish? " + isVegetarianMealAvailable());
        System.out.println();

        //b. Is there any healthy menu have calories less than 1000 ( return type boolean)
        System.out.println("Is there any healthy dish with calories less than 1000? " + isThereAnyDishWithCaloriesLessThan1000());
        System.out.println();

        //c. Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
        System.out.println("Is there any un healthy dish with calories greater than 1000? " + isThereAnyDishWithCaloriesGreaterThan1000());
        System.out.println();

        //d. find and return the first item for the type of MEAT( return type Optional<Dish>)
        Optional<Dish> firstMeatItem = getFirstMeatMeal();
        if (firstMeatItem.isPresent()) {
            System.out.println("First meat item: " + firstMeatItem.get());
        } else {
            System.out.println("No meat item");
        }
        System.out.println();

        //e. calculateTotalCalories() in the menu using reduce. (return int);
        System.out.println("Total Calories: " + getTotalCalories());
        System.out.println();

        //f. calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
        System.out.println("Total Calories using method reference : " + getTotalCaloriesWithMethodReference());


    }
}