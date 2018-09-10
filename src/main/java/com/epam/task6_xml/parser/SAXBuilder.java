package com.epam.task6_xml.parser;

import entity.Card;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by piatr on 31.08.18.
 */
public class SAXBuilder extends XMLParserBuilder {
    private CardHandler cardHandler;
    private XMLReader reader;

    public SAXBuilder () {
        cardHandler = new CardHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(cardHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void buildSetCards(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        cards = cardHandler.getCards();
    }
}
