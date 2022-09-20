package com.vmo.springboot.Demo.constant;

public enum Status {
    ENABLE(1),
    DISABLE(2);

    private int id;

    Status(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
