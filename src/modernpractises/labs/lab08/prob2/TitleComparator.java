package modernpractises.labs.lab08.prob2;

import java.util.Comparator;

class TitleComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getTitle().compareTo(p2.getTitle());
    }
}