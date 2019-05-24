package com.company.helper;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Deserializer<T> {
    public T deserialize(String filePath, Class<T> cls) throws NoSuchMethodException {
        T deserializedObject = null;

        try {
            deserializedObject = cls.getDeclaredConstructor().newInstance();
            try {
                FileInputStream fileIn = new FileInputStream(filePath);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                deserializedObject = (T) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.println("\nEmployee class not found");
                c.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return deserializedObject;
    }
}
