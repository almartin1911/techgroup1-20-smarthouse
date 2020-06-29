package jalasoft.training.mcallejash.smarthouse.core;

import jalasoft.training.mcallejash.smarthouse.core.impl.Manager;

public interface IHub {
    void linkManager(Manager manager);
    void unlinkManager(Manager manager);
    void setManagersStatuses(boolean value);
}
