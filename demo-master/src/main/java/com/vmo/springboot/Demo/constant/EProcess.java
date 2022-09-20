package com.vmo.springboot.Demo.constant;

public enum EProcess {
    PROCESSING(1),
    DONE(2);

    EProcess() {
    }

    EProcess(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

}
