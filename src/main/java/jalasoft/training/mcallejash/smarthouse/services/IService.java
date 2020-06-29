package jalasoft.training.mcallejash.smarthouse.services;

import jalasoft.training.mcallejash.smarthouse.core.ManagerType;
import jalasoft.training.mcallejash.smarthouse.core.impl.Hub;

import java.util.List;

public interface IService {
    List<Hub> GetHubs();

    // Should identify a manager by it's ID. Using ManagerType for now
    void TriggerActionOnManager(ManagerType managerType, boolean value);

    // Should identify a device by it's ID. Using and index for now
    void UnlinkDeviceFromManager(ManagerType managerType, int index);
}
