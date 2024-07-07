package org.artem.projects;

import org.artem.projects.entities.Dog;
import org.artem.projects.entities.User;

import java.io.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CloneService service = new CloneService();
        User user = new User("User", new Dog("Dog", 1, 2));
        User clonedUser = service.cloneObject(user);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clonedUser.txt"))) {
            oos.writeObject(clonedUser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        User returnUser;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clonedUser.txt"))) {
            returnUser = (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main user: " + user);
        System.out.println("Main user hashCode: " + user.getPet().hashCode() + "\n");
        System.out.println("Cloned user: " + clonedUser);
        System.out.println("Cloned user hashCode: " + clonedUser.getPet().hashCode() + "\n");
        System.out.println("Returned user: " + returnUser);
        System.out.println("Returned user hashCode: " + returnUser.getPet().hashCode() + "\n");
    }
}
