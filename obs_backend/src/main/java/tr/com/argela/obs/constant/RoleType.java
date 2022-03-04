package tr.com.argela.obs.constant;

public enum RoleType {
    Student(1), Teacher(2);

    int value;

    RoleType(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }
}
