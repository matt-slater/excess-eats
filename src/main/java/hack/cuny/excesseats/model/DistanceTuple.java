package hack.cuny.excesseats.model;

public class DistanceTuple {
    private String humanReadable;
    private double distance;

    public DistanceTuple(String humanReadable, double distance) {
        this.humanReadable = humanReadable;
        this.distance = distance;
    }


    public String getHumanReadable() {
        return humanReadable;
    }

    public void setHumanReadable(String humanReadable) {
        this.humanReadable = humanReadable;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
