package com.epam.task6_xml.entity;

/**
 * Created by piatr on 02.09.18.
 */
public class Person {
    private String firstName;
    private String secondName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "firstName = " + firstName + '\n' +
               "secondName = " + secondName + '\n';
    }
}
