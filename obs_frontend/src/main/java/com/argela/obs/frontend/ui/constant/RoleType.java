package com.argela.obs.frontend.ui.constant;

public enum RoleType {
    Student(1), Teacher(2);

    int value;

    RoleType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
