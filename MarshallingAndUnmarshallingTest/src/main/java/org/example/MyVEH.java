package org.example;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class MyVEH implements ValidationEventHandler {

    @Override
    public boolean handleEvent(ValidationEvent event) {
        System.out.println("\nEVENT");
        System.out.println("SEVERITY:" + event.getSeverity());
        System.out.println("MESSAGE:" + event.getMessage());
        System.out.println("LINKED EXCEPTION:" + event.getLinkedException());
        System.out.println("LOCATOR");
        System.out.println("LINE NUMBER:" + event.getLocator().getLineNumber());
        System.out.println("COLUMN NUMBER:" + event.getLocator().getColumnNumber());
        System.out.println("OFFSET:  " + event.getLocator().getOffset());
        System.out.println("OBJECT:  " + event.getLocator().getObject());
        System.out.println("NODE:  " + event.getLocator().getNode());
        System.out.println("URL:  " + event.getLocator().getURL());

        return true;
    }
}
