package org.artem.projects.entities;

public class Spider extends Animal {
    private boolean isPoisonous;

    public Spider(String name, int age, boolean isPoisonous) {
        super(name, age);
        this.isPoisonous = isPoisonous;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(boolean poisonous) {
        isPoisonous = poisonous;
    }

    @Override
    public String toString() {
        return "Spider{" +
                super.toString() +
                ", isPoisonous=" + isPoisonous +
                '}';
    }
}
