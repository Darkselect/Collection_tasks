package org.example;

import java.util.List;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private int age;
    private List<PhoneNumber> phoneNumber;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<PhoneNumber> getPhoneNumber() {
        return phoneNumber;
    }
}
