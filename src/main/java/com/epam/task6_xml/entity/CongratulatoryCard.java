package com.epam.task6_xml.entity;

/**
 * Created by piatr on 31.08.18.
 */
public class CongratulatoryCard extends Card {
    private Person destinationPerson = new Person();

    public Person getDestinationPerson() {
        return destinationPerson;
    }

    @Override
    public String toString() {
        return "CongratulatoryCard " +'\n'+
                " destinationPerson = " + destinationPerson +'\n'+
                super.toString()+'\n';
    }
}
