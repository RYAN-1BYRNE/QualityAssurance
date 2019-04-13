package bikerepair;

public class MountainBike extends Bike {
    private int suspensionDepth;

    public int getSuspensionDepth() {
        return suspensionDepth;
    }

    public void setSuspensionDepth(int suspensionDepth) {
        this.suspensionDepth = suspensionDepth;
    }

    public int calculateServiceInterval() {
        return getWheelDiameter() * getGears() - suspensionDepth;
    }

    @Override
    public String toString() {
        return "MTB|" + getOwner() + "|" +
                getModel() + "|" +
                getWheelDiameter() + "|" +
                getGears() + "|" +
                getKmsRidden() + "|" +
                suspensionDepth;
    }
}
