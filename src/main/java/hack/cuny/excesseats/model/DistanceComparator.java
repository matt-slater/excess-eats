package hack.cuny.excesseats.model;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Eats>{


    @Override
    public int compare(Eats o1, Eats o2) {
        if (o1.getDistance() > o2.getDistance()) {
            return 1;
        }
        else if (o2.getDistance() > o1.getDistance()) {
            return -1;
        } else return 0;

    }




}
