package jalasoft.training.mcallejash.smarthouse.core.impl;

import io.jsondb.annotation.Document;
import jalasoft.training.mcallejash.smarthouse.core.BaseEntity;
import jalasoft.training.mcallejash.smarthouse.core.IHub;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "hubs", schemaVersion = "1.0")
public class Hub extends BaseEntity implements IHub {
    private List<Manager> managers;

    public Hub() {
        this.managers = new ArrayList<Manager>();
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    @Override
    public void linkManager(Manager manager) {
        this.managers.add(manager);
    }

    @Override
    public void unlinkManager(Manager manager) {
        this.managers.remove(manager);
    }

    @Override
    public void setManagersStatuses(boolean value) {
        this.managers.forEach((manager) -> {
            manager.updateStatus(value);
        });
    }

    @Override
    public String toString() {
        String message = String.format("%s has %s linked managers", this.getName(), this.managers.size());
        if (this.managers.size() == 0) {
            message += ".";
        } else {
            message += "...\n";
            for (Manager manager : this.managers) {
                message += manager.toString();
                message += "\n";
            }
        }
        return message;
    }
}
