package jalasoft.training.mcallejash.smarthouse.services.impl;

import jalasoft.training.mcallejash.smarthouse.dao.IDevicesDao;
import jalasoft.training.mcallejash.smarthouse.dao.stub.DevicesStubDao;
import jalasoft.training.mcallejash.smarthouse.domain.*;
import jalasoft.training.mcallejash.smarthouse.services.*;

import java.util.List;

public class DevicesService implements IDevicesService {
    private IDevicesDao dao;

    public DevicesService(){
        this.dao = new DevicesStubDao();
    }

    @Override
    public List<Device> GetDevices() {
        return dao.GetDevices();
    }
}
