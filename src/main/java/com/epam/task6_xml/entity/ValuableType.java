package com.epam.task6_xml.entity;

/**
 * Created by piatr on 02.09.18.
 */
public enum ValuableType {
    COLLECTION("collection"),
    HISTORICAL("historical"),
    THEMATIC("thematic");
    private String value;
    private ValuableType(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }
}
