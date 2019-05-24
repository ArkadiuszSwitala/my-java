package com.company.helper;

import java.io.*;

public class Serializer {
    public void serialize(Object object, String filepath) {
        serializeProcess(object, filepath);
    }

    private void serializeProcess(Object objectToSerialize, String outputFilePath) {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(outputFilePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(objectToSerialize);
            out.close();
            fileOut.close();
            System.out.printf("\nSerialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
