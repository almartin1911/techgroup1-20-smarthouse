package jalasoft.training.mcallejash.smarthouse.dao.stub;

import jalasoft.training.mcallejash.smarthouse.dao.IDevicesDao;
import jalasoft.training.mcallejash.smarthouse.domain.Device;

import java.util.ArrayList;
import java.util.List;

public class DevicesStubDao implements IDevicesDao {
    private List<Device> devices;

    public DevicesStubDao(){
        this.devices = new ArrayList<Device>();
        Device deviceA = new Device("Light Bulb", false);
        Device deviceB = new Device("Speaker", true);
        this.devices.add(deviceA);
        this.devices.add(deviceB);
    }

    @Override
    public List<Device> GetDevices() {
        return this.devices;
    }
}
