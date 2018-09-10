package com.epam.task6_xml.parser;

import entity.Card;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by piatr on 31.08.18.
 */
public abstract class XMLParserBuilder {
    protected Set<Card> cards;

    public XMLParserBuilder() {
        cards = new HashSet<>();
    }

    public XMLParserBuilder(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<Card> getCards() {
        return cards;
    }

    abstract public void buildSetCards (String fileName);
}
