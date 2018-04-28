package com.sss.enums;

public enum  BTestEnum {

    A("a",1),
    B("b",1),
    C("c",1);


    private String name;
    private int value;

    private BTestEnum(String name , int value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
