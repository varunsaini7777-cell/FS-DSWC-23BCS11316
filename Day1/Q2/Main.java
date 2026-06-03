class ControlUnit {
    byte deviceStatus = 0;

    public void activateDevice(int deviceIndex) {
        deviceStatus = (byte) (deviceStatus | (1 << deviceIndex));
    }

    public void deactivateDevice(int deviceIndex) {
        deviceStatus = (byte) (deviceStatus & ~(1 << deviceIndex));
    }

    public boolean isDeviceActive(int deviceIndex) {
        return (deviceStatus & (1 << deviceIndex)) != 0;
    }
}

public class Main {
    public static void main(String[] args) {

        ControlUnit unit = new ControlUnit();

        unit.activateDevice(0);
        unit.activateDevice(3);
        unit.activateDevice(7);

        System.out.println(unit.isDeviceActive(3));
        System.out.println(unit.isDeviceActive(2));

        unit.deactivateDevice(3);

        System.out.println(unit.isDeviceActive(3));
    }
}