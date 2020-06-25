package jalasoft.training.mcallejash.smarthouse.domain;

public class Device {
    private String name;
    private boolean turnedOn;

    public Device(String name, boolean turnedOn){
        this.name = name;
        this.turnedOn = turnedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }
}
