package com.company;

import com.company.entity.Employee;
import com.company.helper.Deserializer;
import com.company.helper.Serializer;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        String filePath = "/tmp/employee.ser";
        Serializer serializer = new Serializer();
        Deserializer<Employee> deserializer = new Deserializer();
        Employee e = new Employee();
        e.name = "Mark Twen";
        e.address = "Forońska 34/1, Bydgoszcz";
        e.SSN = 2985782;
        e.number = 341;

        serializer.serialize(e, filePath);

        Employee emp = deserializer.deserialize(filePath, Employee.class);

        emp.mailCheck();
    }
}
