package bikerepair;

import java.util.ArrayList;

public class BikeSystem {

    private int bikeHoldLimit;
    private int bikeCount = 0;
    private ArrayList<Bike> bikeList = new ArrayList<>();

    public BikeSystem(int bikeHoldLimit) {
        this.bikeHoldLimit = bikeHoldLimit;
    }

    public boolean insertBike(String bikeString) {
        String[] bikeDetails = bikeString.split("\\|");
        String type = bikeDetails[0].trim();
        String owner = bikeDetails[1].trim();
        String model = bikeDetails[2].trim();
        int wheelDiameter = Integer.parseInt(bikeDetails[3].trim());
        int gears = Integer.parseInt(bikeDetails[4].trim());
        int kmsRidden = Integer.parseInt(bikeDetails[5].trim());
        int suspensionDepth;
        int reflectorsFitted;

        if (bikeCount >= bikeHoldLimit || bikeExists(owner, model)) {
            return false;
        }

        if (type.equalsIgnoreCase("bike")) {
            Bike bike = new Bike();
            bike.setOwner(owner);
            bike.setModel(model);
            bike.setWheelDiameter(wheelDiameter);
            bike.setGears(gears);
            bike.setKmsRidden(kmsRidden);
            bikeList.add(bike);
        } else if (type.equalsIgnoreCase("mtb")) {
            suspensionDepth = Integer.parseInt(bikeDetails[6]);
            MountainBike mountainBike = new MountainBike();
            mountainBike.setOwner(owner);
            mountainBike.setModel(model);
            mountainBike.setWheelDiameter(wheelDiameter);
            mountainBike.setGears(gears);
            mountainBike.setKmsRidden(kmsRidden);
            mountainBike.setSuspensionDepth(suspensionDepth);
            bikeList.add(mountainBike);
        } else if (type.equalsIgnoreCase("rb")) {
            reflectorsFitted = Integer.parseInt(bikeDetails[6]);
            RoadBike roadBike = new RoadBike();
            roadBike.setOwner(owner);
            roadBike.setModel(model);
            roadBike.setWheelDiameter(wheelDiameter);
            roadBike.setGears(gears);
            roadBike.setKmsRidden(kmsRidden);
            roadBike.setReflectorsFitted(reflectorsFitted);
            bikeList.add(roadBike);
        }
        bikeCount++;
        return true;
    }

    public boolean bikeExists(String owner, String model) {
        for (Bike bike: bikeList) {
            if (bike.getOwner().equalsIgnoreCase(owner) && bike.getModel().equalsIgnoreCase(model)) {
                return true;
            }
        }
        return false;
    }

    public void printSystem() {
        for (Bike bike: bikeList) {
            System.out.println(bike.toString());
        }
    }

    public void closeGarage() {
        bikeList.clear();
        bikeCount = 0;
    }

    public void printServiceIntervals() {
        for (Bike bike: bikeList) {
            System.out.println(bike.getOwner() + ", " + bike.getModel() + ", " + bike.calculateServiceInterval());
        }
    }

}
