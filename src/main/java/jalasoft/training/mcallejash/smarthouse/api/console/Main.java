package jalasoft.training.mcallejash.smarthouse.api.console;

import jalasoft.training.mcallejash.smarthouse.core.ManagerType;
import jalasoft.training.mcallejash.smarthouse.dao.stub.DataFeedStubDao;
import jalasoft.training.mcallejash.smarthouse.services.IService;
import jalasoft.training.mcallejash.smarthouse.services.impl.SmartHouseService;

public class Main {
    public static void main(String[] args) {
        DataFeedStubDao stubDao = new DataFeedStubDao();
        IService smartHouseService = new SmartHouseService(stubDao);

        System.out.println(smartHouseService.GetHubs().get(0));

        smartHouseService.TriggerActionOnManager(ManagerType.Smartphone, true);
        System.out.println(smartHouseService.GetHubs().get(0));

        smartHouseService.TriggerActionOnManager(ManagerType.Sensor, true);
        System.out.println(smartHouseService.GetHubs().get(0));

        smartHouseService.TriggerActionOnManager(ManagerType.Sensor, false);
        smartHouseService.UnlinkDeviceFromManager(ManagerType.Sensor, 1);
        System.out.println(smartHouseService.GetHubs().get(0));
    }
}
