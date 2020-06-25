package jalasoft.training.mcallejash.smarthouse.core;

public abstract class BaseEntity {
    private String name;
    private boolean powered;

    protected BaseEntity(String name, boolean powered){
        this.name = name;
        this.powered = powered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPowered() {
        return powered;
    }

    public void setPowered(boolean powered) {
        this.powered = powered;
    }
}
