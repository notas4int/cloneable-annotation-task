package org.artem.projects.entities;


public class Dog extends Animal {
    private int lengthOfTail;

    public Dog(String name, int age, int lengthOfTail) {
        super(name, age);
        this.lengthOfTail = lengthOfTail;
    }

    public int getLengthOfTail() {
        return lengthOfTail;
    }

    public void setLengthOfTail(int lengthOfTail) {
        this.lengthOfTail = lengthOfTail;
    }

    @Override
    public String toString() {
        return "Dog{" +
                super.toString() +
                ", lengthOfTail=" + lengthOfTail +
                '}';
    }
}
