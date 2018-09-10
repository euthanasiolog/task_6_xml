package com.epam.task6_xml.entity;

import java.time.LocalDate;

/**
 * Created by piatr on 31.08.18.
 */
public abstract class Card {
    private String name;
    private String country;
    private String year;
    private String language;
    private Person author = new Person();
    private Thema thema;
    private boolean isSent;
    private String dateOfSend;
    private ValuableType valuable;

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setThema(Thema thema) {
        this.thema = thema;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public void setDateOfSend(String dateOfSend) {
        this.dateOfSend = dateOfSend;
    }

    public void setValuable(ValuableType valuable) {
        this.valuable = valuable;
    }

    public Person getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return  " name = " + name + '\n' +
                " country = " + country + '\n' +
                " year = " + year +
                " language = " + language + '\n' +
                " author = " + author +'\n' +
                " thema = " + thema +'\n' +
                " isSent = " + isSent +'\n' +
                " dateOfSend = " + dateOfSend +'\n' +
                " valuable = " + valuable+'\n';
    }
}
