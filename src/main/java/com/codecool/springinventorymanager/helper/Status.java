package com.codecool.springinventorymanager.helper;

public enum Status {

    AVAILABLE(1),
    LOST(0),
    STOLEN(-1),
    DESTROYED(-2);


    private int status;

    Status (int status){
        this.status = status;
    }






}
