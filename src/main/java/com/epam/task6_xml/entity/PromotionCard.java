package com.epam.task6_xml.entity;

/**
 * Created by piatr on 31.08.18.
 */
public class PromotionCard extends Card {
    private String company;

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "PromotionCard " +'\n'+
                " company = " + company + '\n' +
                super.toString();
    }
}
