package jalasoft.training.mcallejash.smarthouse.services.impl;

import jalasoft.training.mcallejash.smarthouse.core.ManagerType;
import jalasoft.training.mcallejash.smarthouse.core.impl.Device;
import jalasoft.training.mcallejash.smarthouse.core.impl.Hub;
import jalasoft.training.mcallejash.smarthouse.core.impl.Manager;
import jalasoft.training.mcallejash.smarthouse.dao.IDataFeedDao;
import jalasoft.training.mcallejash.smarthouse.services.IService;

import java.util.List;

public class SmartHouseService implements IService {
    private IDataFeedDao dao;

    public SmartHouseService(IDataFeedDao dao){
        this.dao = dao;
    }

    @Override
    public List<Hub> GetHubs() {
        return this.dao.GetHubs();
    }

    @Override
    public void TriggerActionOnManager(ManagerType managerType, boolean value) {
        // Assuming we have 1 Hub only
        List<Manager> managers = this.dao.GetHubs().get(0).getManagers();
        for(Manager manager : managers) {
            if(manager.getManagerType().equals(managerType)) {
                manager.updateStatus(value);
            }
        }
    }

    @Override
    public void UnlinkDeviceFromManager(ManagerType managerType, int index) {
        // Assuming we have 1 Hub only
        List<Manager> managers = this.dao.GetHubs().get(0).getManagers();
        for(Manager manager : managers) {
            if(manager.getManagerType().equals(managerType)) {
                if (index <= manager.getDevices().size()) {
                    Device targetDevice = manager.getDevices().get(index);
                    manager.unlinkDevice(targetDevice);
                }
            }
        }
    }
}
