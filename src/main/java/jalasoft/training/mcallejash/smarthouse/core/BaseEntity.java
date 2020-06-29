package jalasoft.training.mcallejash.smarthouse.core;

import io.jsondb.annotation.Id;

import java.util.UUID;

public abstract class BaseEntity {
    @Id
    private UUID id;
    private String name;
    private boolean on;
    private String statusMsg;

    protected BaseEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
