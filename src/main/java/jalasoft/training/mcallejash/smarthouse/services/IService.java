package jalasoft.training.mcallejash.smarthouse.services;

import jalasoft.training.mcallejash.smarthouse.core.*;

public interface IService {
    IHub GetHub();
    void ExecuteActions(boolean value);
    String GetHubName();
}
