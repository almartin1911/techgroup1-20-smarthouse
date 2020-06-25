package jalasoft.training.mcallejash.smarthouse.api.console;

import jalasoft.training.mcallejash.smarthouse.domain.Device;
import jalasoft.training.mcallejash.smarthouse.services.IDevicesService;
import jalasoft.training.mcallejash.smarthouse.services.impl.DevicesService;

public class Main {
    public static void main(String[] args){
        IDevicesService manager = new DevicesService();
        manager.GetDevices().forEach((device) -> {
            System.out.println(device.getName());
            System.out.println(device.isTurnedOn());
        });
    }
}
