package org.example.unit2;

public class Cat extends Animal {
    private boolean ball;
    public Cat(String name, int age) {
        super(name, age);
    }

    public boolean hasBall() { return ball; }
}
