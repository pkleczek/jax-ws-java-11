package org.example;

import eu.europa.ec.taxud.vies.services.checkvat.CheckVatPortType;
import eu.europa.ec.taxud.vies.services.checkvat.CheckVatService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;

public class App {
    public static void main(String[] args) throws DatatypeConfigurationException {
        CheckVatService checkVatService = new CheckVatService();
        CheckVatPortType checkVatPort = checkVatService.getCheckVatPort();

        Holder<XMLGregorianCalendar> requestDate = new Holder<>();
        Holder<Boolean> valid = new Holder<>();
        Holder<String> name = new Holder<>();
        Holder<String> address = new Holder<>();

        checkVatPort.checkVat(
            new Holder<>("PL"),
            new Holder<>("5252352907"),
            requestDate,
            valid,
            name,
            address
        );


        System.out.println(requestDate.value);
        System.out.println(valid.value);
        System.out.println(name.value);
        System.out.println(address.value);
    }
}
