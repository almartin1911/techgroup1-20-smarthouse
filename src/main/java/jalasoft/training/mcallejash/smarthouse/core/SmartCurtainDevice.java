package jalasoft.training.mcallejash.smarthouse.core;

import java.util.concurrent.ThreadLocalRandom;

public class SmartCurtainDevice extends BaseEntity implements IDevice {
    private short batteryLevel;

    public SmartCurtainDevice(String name){
        super(name, false);
        this.batteryLevel = (short) ThreadLocalRandom.current().nextInt(0, 100 + 1);;
    }

    @Override
    public void updateState(boolean value) {
        if (this.batteryLevel > 5) {
            this.setPowered(value);
            System.out.println(this);
        } else {
            System.out.println("Low battery level. Please recharge before using.");
        }

    }

    @Override
    public String toString() {
        return (this.getName() + "is" + this.isPowered() + " with " + this.batteryLevel + " % battery left");
    }
}
