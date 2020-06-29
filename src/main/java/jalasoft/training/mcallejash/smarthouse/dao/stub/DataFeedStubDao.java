package jalasoft.training.mcallejash.smarthouse.dao.stub;

import jalasoft.training.mcallejash.smarthouse.core.DeviceType;
import jalasoft.training.mcallejash.smarthouse.core.ManagerType;
import jalasoft.training.mcallejash.smarthouse.core.impl.Device;
import jalasoft.training.mcallejash.smarthouse.core.impl.Hub;
import jalasoft.training.mcallejash.smarthouse.core.impl.Manager;
import jalasoft.training.mcallejash.smarthouse.dao.IDataFeedDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataFeedStubDao implements IDataFeedDao {
    private List<Hub> hubs;

    public DataFeedStubDao(){
        this.hubs = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();

        Device huaweiSpeaker = CreateDevice("HW100", DeviceType.Speaker);
        Device pangolinCurtain = CreateDevice("PG-01b", DeviceType.Curtain);
        Device sonyTV = CreateDevice("SX7000", DeviceType.TV);
        Device philipsLightbulb = CreateDevice("LGB-jk9", DeviceType.Lightbulb);

        List<Device> devicesSlice1 = new ArrayList<>();
        devicesSlice1.add(huaweiSpeaker);
        devicesSlice1.add(pangolinCurtain);
        Manager mainDoorMovementSensor = CreateManager("Movement-MainDoor", ManagerType.Sensor, devicesSlice1);
        managers.add(mainDoorMovementSensor);

        List<Device> devicesSlice2 = new ArrayList<>();
        devicesSlice2.add(sonyTV);
        devicesSlice2.add(philipsLightbulb);
        Manager smartphoneSamsung = CreateManager("Smartphone-Samsung", ManagerType.Smartphone, devicesSlice2);
        managers.add(smartphoneSamsung);

        Hub smartHouse = CreateHub("Martin's SmartCave", managers);
        this.hubs.add(smartHouse);
    }

    private Device CreateDevice(String name, DeviceType deviceType){
        Device newDevice = new Device();
        newDevice.setId(UUID.randomUUID());
        newDevice.setName(name);
        newDevice.setDeviceType(deviceType);
        newDevice.setStatusMsg(newDevice.toString());
        return newDevice;
    }


    private Manager CreateManager(String name, ManagerType managerType, List<Device> devices){
        Manager newManager = new Manager();
        newManager.setId(UUID.randomUUID());
        newManager.setName(name);
        newManager.setManagerType(managerType);
        newManager.setDevices(devices);
        newManager.setStatusMsg(newManager.toString());
        return newManager;
    }

    private Hub CreateHub(String name, List<Manager> managers){
        Hub newHub = new Hub();
        newHub.setId(UUID.randomUUID());
        newHub.setName(name);
        newHub.setManagers(managers);
        return newHub;
    }

    @Override
    public List<Hub> GetHubs() {
        return this.hubs;
    }
}
