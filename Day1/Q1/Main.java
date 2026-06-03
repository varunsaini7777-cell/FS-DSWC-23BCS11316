abstract class SpaceCraft {
    protected short vesselNumber;
    protected boolean activeStatus;
    protected char category;

    public SpaceCraft(short vesselNumber, boolean activeStatus, char category) {
        this.vesselNumber = vesselNumber;
        this.activeStatus = activeStatus;
        this.category = category;
    }
}

class CargoShip extends SpaceCraft {
    private float[][] storageUnits;

    public CargoShip(short vesselNumber, boolean activeStatus,
                     char category, float[][] storageUnits) {
        super(vesselNumber, activeStatus, category);
        this.storageUnits = storageUnits;
    }

    public float getTotalLoad() {
        float totalLoad = 0;

        for (int i = 0; i < storageUnits.length; i++) {
            for (int j = 0; j < storageUnits[i].length; j++) {
                totalLoad += storageUnits[i][j];
            }
        }

        return totalLoad;
    }

    public float getLargestLoad() {
        float largest = storageUnits[0][0];

        for (int i = 0; i < storageUnits.length; i++) {
            for (int j = 0; j < storageUnits[i].length; j++) {
                if (storageUnits[i][j] > largest) {
                    largest = storageUnits[i][j];
                }
            }
        }

        return largest;
    }
}

public class Main {
    public static void main(String[] args) {

        float[][] loads = {
            {1200.5f, 3400.0f, 2500.75f},
            {5000.0f, 4500.25f, 3800.5f}
        };

        SpaceCraft[] fleet = new SpaceCraft[1];
        fleet[0] = new CargoShip((short) 1001, true, 'A', loads);

        CargoShip ship = (CargoShip) fleet[0];

        System.out.println("Total Load: " + ship.getTotalLoad() + " kg");
        System.out.println("Largest Load: " + ship.getLargestLoad() + " kg");
    }
}