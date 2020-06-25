package jalasoft.training.mcallejash.smarthouse.dao.stub;

import jalasoft.training.mcallejash.smarthouse.dao.IDataFeedDao;
import jalasoft.training.mcallejash.smarthouse.core.*;

import java.util.ArrayList;
import java.util.List;

public class DataFeedStubDao implements IDataFeedDao {
    private List<IDevice> devices;
    private List<IManager> managers;
    private IHub hub;

    public DataFeedStubDao(){
        this.devices = new ArrayList<IDevice>();
        this.managers = new ArrayList<IManager>();

        SmartSpeakerDevice huaweiSpeaker = new SmartSpeakerDevice("Speaker-HW100", (short) 30);
        SmartCurtainDevice pangolinCurtain = new SmartCurtainDevice("Curtain-PG1");
        MovementSensorManager mainDoorMovementSensor = new MovementSensorManager("Sensor-Movement");
        mainDoorMovementSensor.linkDevice(huaweiSpeaker);
        mainDoorMovementSensor.linkDevice(pangolinCurtain);

        SmartSpeakerDevice sonySpeaker = new SmartSpeakerDevice("Speaker-SONY3x", (short) 0);
        SmartphoneManager smartphoneAppManager = new SmartphoneManager("Smartphone-GalaxyNote9", (float) 3.2);
        smartphoneAppManager.linkDevice(sonySpeaker);

        this.hub = new HouseHub("Martin's Cave");
        this.hub.linkManager(mainDoorMovementSensor);
        this.hub.linkManager(smartphoneAppManager);
    }

    @Override
    public IHub GetData() {
        return this.hub;
    }
}
