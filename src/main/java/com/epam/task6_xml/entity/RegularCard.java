package com.epam.task6_xml.entity;

/**
 * Created by piatr on 31.08.18.
 */
public class RegularCard extends Card {
    private double price;

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RegularCard " +'\n'+
                " price = " + price +'\n'+
                super.toString();
    }
}
