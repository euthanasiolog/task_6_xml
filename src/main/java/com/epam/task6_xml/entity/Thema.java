package com.epam.task6_xml.entity;

/**
 * Created by piatr on 02.09.18.
 */
public enum  Thema {
    CITY("city"),
    NATURE("nature"),
    SPACE("space"),
    ANIMAL("animal"),
    PEOPLE("people"),
    ARCHITECTURE("architecture"),
    SPORT("sport"),
    FLOWER("flower"),
    ABSTRACT("abstract"),
    OTHER("other");
    private String value;

    private Thema (String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
