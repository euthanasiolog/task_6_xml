package com.epam.task6_xml.parser;

import entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by piatr on 05.09.18.
 */
public class CardHandler extends DefaultHandler {
    private Set<Card> cards;
    private CardTag currentTag = null;
    private Card currentCard = null;
    private EnumSet<CardTag> withText;
    public CardHandler() {
        cards = new HashSet<>();
        withText = EnumSet.range(CardTag.THEMA, CardTag.LASTNAME);
    }

    public Set<Card> getCards() {
        return cards;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        CardTag curElement = CardTag.valueOf(localName.toUpperCase());
        switch (curElement){
            case REGCARD:
                currentCard = new RegularCard();
                for (int i=0;i<attributes.getLength();i++){
                    if ("send".equals(attributes.getLocalName(i))){
                        if ("1".equals(attributes.getValue(i))){
                            currentCard.setSent(true);
                        }else currentCard.setSent(false);
                    } else if ("dateOfSend".equals(attributes.getLocalName(i))){
                        currentCard.setDateOfSend(attributes.getValue(i));
                    } else if ("valuable".equals(attributes.getLocalName(i))){
                        currentCard.setValuable(ValuableType.valueOf(attributes.getValue(i).toUpperCase()));
                    } else if ("price".equals(attributes.getLocalName(i))){
                        ((RegularCard)currentCard).setPrice(new Double(attributes.getValue(i)));
                    }
                }
                break;
            case PROMCARD:
                currentCard = new PromotionCard();
                for (int i=0;i<attributes.getLength();i++){
                    if ("send".equals(attributes.getLocalName(i))){
                        if ("1".equals(attributes.getValue(i))){
                            currentCard.setSent(true);
                        }else currentCard.setSent(false);
                    } else if ("dateOfSend".equals(attributes.getLocalName(i))){
                        currentCard.setDateOfSend(attributes.getValue(i));
                    } else if ("valuable".equals(attributes.getLocalName(i))){
                        currentCard.setValuable(ValuableType.valueOf(attributes.getValue(i).toUpperCase()));
                    } else if ("company".equals(attributes.getLocalName(i))){
                        ((PromotionCard)currentCard).setCompany(attributes.getValue(i));
                    }
                }
                break;
            case CONGRCARD:
                currentCard = new CongratulatoryCard();
                for (int i=0;i<attributes.getLength();i++){
                    if ("send".equals(attributes.getLocalName(i))){
                        if ("1".equals(attributes.getValue(i))){
                            currentCard.setSent(true);
                        }else currentCard.setSent(false);
                    } else if ("dateOfSend".equals(attributes.getLocalName(i))){
                        currentCard.setDateOfSend(attributes.getValue(i));
                    } else if ("valuable".equals(attributes.getLocalName(i))){
                        currentCard.setValuable(ValuableType.valueOf(attributes.getValue(i).toUpperCase()));
                    }
                }
                break;
            default:
                if (withText.contains(curElement)){
                    currentTag = curElement;
                }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("regCard".equals(localName)||"congrCard".equals(localName)||"promCard".equals(localName)){
            cards.add(currentCard);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
            String s = new String(ch, start, length).trim();
            if (currentTag!=null){
                switch (currentTag){
                    case NAME:
                        currentCard.setName(s);
                        break;
                    case COUNTRY:
                        currentCard.setCountry(s);
                        break;
                    case YEAR:
                        currentCard.setYear(s);
                        break;
                    case LANGUAGE:
                        currentCard.setLanguage(s);
                        break;
                    case THEMA:
                        currentCard.setThema(Thema.valueOf(s.toUpperCase()));
                        break;
                    case FIRSTNAME:
                        if (currentCard.getAuthor().getFirstName()!=null){
                            if (currentCard instanceof CongratulatoryCard){
                                if (((CongratulatoryCard)currentCard).getDestinationPerson().getFirstName()==null){
                                    ((CongratulatoryCard)currentCard).getDestinationPerson().setFirstName(s);
                                }
                            }
                        } else {
                            currentCard.getAuthor().setFirstName(s);
                        }
                        break;
                    case LASTNAME:
                        if (currentCard.getAuthor().getSecondName()!=null){
                            if (currentCard instanceof CongratulatoryCard){
                                if (((CongratulatoryCard)currentCard).getDestinationPerson().getSecondName()==null){
                                    ((CongratulatoryCard)currentCard).getDestinationPerson().setSecondName(s);
                                }
                            }
                        } else {
                            currentCard.getAuthor().setSecondName(s);
                        }
                        break;
                }
            }
    }
}
