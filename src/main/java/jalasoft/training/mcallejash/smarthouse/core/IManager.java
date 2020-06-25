package jalasoft.training.mcallejash.smarthouse.core;

public interface IManager{
    void linkDevice(IDevice device);
    void unlinkDevice(IDevice device);
    void power(boolean value);
}
