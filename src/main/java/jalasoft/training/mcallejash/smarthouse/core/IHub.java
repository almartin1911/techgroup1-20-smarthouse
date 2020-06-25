package jalasoft.training.mcallejash.smarthouse.core;

public interface IHub {
    void linkManager(IDevice device);
    void unlinkManager(IDevice device);
    void triggerActions(boolean value);
}
