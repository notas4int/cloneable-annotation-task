package org.artem.projects;

import org.artem.projects.entities.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CloneService {
    public User cloneObject(User object) {
        User clonedUser = object.clone();
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("clonedUser.txt")))) {
            oos.writeObject(clonedUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clonedUser;
    }
}
