package jalasoft.training.mcallejash.smarthouse.services.impl;

import jalasoft.training.mcallejash.smarthouse.dao.*;
import jalasoft.training.mcallejash.smarthouse.core.*;
import jalasoft.training.mcallejash.smarthouse.services.*;

public class SmartHouseService implements IService {
    private IDataFeedDao dao;
    private HouseHub hub;

    public SmartHouseService(IDataFeedDao dao){
        this.dao = dao;
        this.hub = (HouseHub) this.GetHub();
    }

    @Override
    public IHub GetHub() {
        return this.dao.GetData();
    }

    @Override
    public void ExecuteActions(boolean value) {
        this.hub.triggerActions(value);
    }

    @Override
    public String GetHubName() {
        return this.hub.getName();
    }
}
