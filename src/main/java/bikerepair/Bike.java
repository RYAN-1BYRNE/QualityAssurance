package bikerepair;

public class Bike {
    private String owner;
    private String model;
    private int wheelDiameter;
    private int gears;
    private int kmsRidden;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWheelDiameter() {
        return wheelDiameter;
    }

    public void setWheelDiameter(int wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public int getKmsRidden() {
        return kmsRidden;
    }

    public void setKmsRidden(int kmsRidden) {
        this.kmsRidden = kmsRidden;
    }

    public int calculateServiceInterval() {
        return owner.length() * gears;
    }

    @Override
    public String toString() {
        return "Bike|" +
                owner + "|" +
                model + "|" +
                wheelDiameter + "|" +
                gears + "|" +
                kmsRidden;
    }
}
