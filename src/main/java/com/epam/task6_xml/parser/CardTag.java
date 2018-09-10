package com.epam.task6_xml.parser;

/**
 * Created by piatr on 02.09.18.
 */
public enum CardTag {
    OLDCARDS("oldCards"),
    CONGRCARD("congrCard"),
    PROMCARD("promCard"),
    REGCARD("regCard"),
    AUTHOR("author"),
    DESTINATIONNAME("destinationName"),
    THEMA("thema"),
    NAME("name"),
    COUNTRY("country"),
    YEAR("year"),
    LANGUAGE("language"),
    FIRSTNAME("firstName"),
    LASTNAME("lastName");
    private String value;
    private CardTag(String value){
        this.value=value;
    }
    public String getValue() {
        return value;
    }
}
