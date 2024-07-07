package org.artem.projects.entities;

import org.artem.projects.Cloneable;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class User implements java.lang.Cloneable, Serializable {
    public String name;

    @Cloneable
    public Animal pet;

    public User(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    @Override
    public User clone() {
        User cloned;
        try {
            cloned = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Cloneable.class)) {
                field.setAccessible(true);
                Object value;
                try {
                    value = field.get(this);
                    field.set(cloned, field.getType().getMethod("clone").invoke(value));
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return cloned;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pet=" + pet +
                '}';
    }
}
