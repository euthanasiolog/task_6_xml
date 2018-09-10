package com.epam.task6_xml.parser;

/**
 * Created by piatr on 31.08.18.
 */
public class XMLParserBuilderFactory {
    public XMLParserBuilder getXMLParserBuilder (BuilderType builderType){
        switch (builderType){
            case DOM:
                return new DOMBuilder();
            case SAX:
                return new SAXBuilder();
            case STAX:
                return new StAXBuilder();
        }
        return null;
    }
}
