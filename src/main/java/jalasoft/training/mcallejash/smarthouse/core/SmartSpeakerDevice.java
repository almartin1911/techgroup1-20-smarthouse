package jalasoft.training.mcallejash.smarthouse.core;

public class SmartSpeakerDevice extends BaseEntity implements IDevice {
    private short volume;

    public SmartSpeakerDevice(String name, short volume){
        super(name, false);
        this.volume = volume;
    }

    @Override
    public void updateState(boolean value) {
        this.setPowered(value);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return (this.getName() + "is" + this.isPowered() + " with " + this.volume + " volume level");
    }
}
