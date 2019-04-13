package bikerepair;

public class RoadBike extends Bike{
    private int reflectorsFitted;

    public int getReflectorsFitted() {
        return reflectorsFitted;
    }

    public void setReflectorsFitted(int reflectorsFitted) {
        this.reflectorsFitted = reflectorsFitted;
    }

    public int calculateServiceInterval() {
        return getKmsRidden() * reflectorsFitted;
    }

    @Override
    public String toString() {
        return "RB|" + getOwner() + "|" +
                getModel() + "|" +
                getWheelDiameter() + "|" +
                getGears() + "|" +
                getWheelDiameter() + "|" +
                reflectorsFitted;
    }
}
