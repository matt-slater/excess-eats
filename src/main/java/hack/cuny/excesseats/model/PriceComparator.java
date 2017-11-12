package hack.cuny.excesseats.model;

import java.util.Comparator;

public class PriceComparator implements Comparator<EatsDTO> {

    @Override
    public int compare(EatsDTO o1, EatsDTO o2) {
        if (o1.getDiscountedPrice() > o2.getDiscountedPrice()) {
            return 1;
        }
        else if (o2.getDiscountedPrice() > o1.getDiscountedPrice()) {
            return -1;
        } else return 0;

    }
}
