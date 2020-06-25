package jalasoft.training.mcallejash.smarthouse.core;

import java.util.ArrayList;
import java.util.List;

public class HouseHub implements IHub {
    private List<IDevice> controllers;
    private String name;

    public HouseHub(String name){
        this.controllers = new ArrayList<IDevice>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void linkManager(IDevice device) {
        this.controllers.add(device);
    }

    @Override
    public void unlinkManager(IDevice device) {
        this.controllers.remove(device);
    }

    @Override
    public void triggerActions(boolean value) {
        this.controllers.forEach((controller) -> {
            controller.updateState(value);
        });
    }
}
