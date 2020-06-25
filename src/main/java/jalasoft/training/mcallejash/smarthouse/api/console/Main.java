package jalasoft.training.mcallejash.smarthouse.api.console;

import jalasoft.training.mcallejash.smarthouse.core.*;
import jalasoft.training.mcallejash.smarthouse.dao.stub.DataFeedStubDao;
import jalasoft.training.mcallejash.smarthouse.services.*;
import jalasoft.training.mcallejash.smarthouse.services.impl.SmartHouseService;

public class Main {
    public static void main(String[] args) {
        DataFeedStubDao stubDao = new DataFeedStubDao();
        IService smartHouseService = new SmartHouseService(stubDao);
        System.out.println(smartHouseService.GetHubName());
        smartHouseService.ExecuteActions(true);
    }
}
