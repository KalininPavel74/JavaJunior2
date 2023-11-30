package org.example.unit2;

public class Dog extends Animal {
    private boolean bone;

    public Dog(String name, int age) {
        super(name, age);
    }

    public boolean hasBone() { return bone; }
}
