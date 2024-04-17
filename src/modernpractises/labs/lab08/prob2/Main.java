package modernpractises.labs.lab08.prob2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    static enum SortMethod {BYTITLE, BYPRICE};

    public static void sort(List<Product> emps, final SortMethod method) {
        class ProductComparator implements Comparator<Product> {
            @Override
            public int compare(Product p1, Product p2) {
                if(method == SortMethod.BYTITLE) {
                    return p1.getTitle().compareTo(p2.getTitle());
                } else {
                    return Double.compare(p1.getPrice(), p2.getPrice());
                }
            }
        }
        Collections.sort(emps, new ProductComparator());
    }

    public static void main(String[] args){
        List<Product> prods = new ArrayList<>();
        prods.add(new Product("MacBook", 1956.99, 3));
        prods.add(new Product("Iphone", 1300.99, 11));
        prods.add(new Product("Iphone", 1400.99, 12));
        prods.add(new Product("Iphone", 1100.99, 13));
        prods.add(new Product("Android", 1367.99, 18));
        prods.add(new Product("Tesla", 98765.99, 5));


        Collections.sort(prods, new PriceComparator());
        System.out.println("comparing by price");
        System.out.println(prods);

        System.out.println();

        Collections.sort(prods, new TitleComparator());
        System.out.println("comparing by title");
        System.out.println(prods);

        System.out.println();

        Main.sort(prods,SortMethod.BYPRICE);
        System.out.println("comparing by price");
        System.out.println(prods);

        System.out.println();

        Main.sort(prods,SortMethod.BYTITLE);
        System.out.println("comparing by title");
        System.out.println(prods);

        System.out.println();

        Collections.sort(prods,(p1,p2)->{
            if(p1.getTitle().equals(p2.getTitle())) {
                return Integer.compare(p1.getModel(),p2.getModel());
            }
            return p1.getTitle().compareTo(p2.getTitle());
        });
        System.out.println("comparing by title and model");
        System.out.println(prods);
    }

}
