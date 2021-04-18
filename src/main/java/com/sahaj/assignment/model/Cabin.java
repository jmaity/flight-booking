package com.sahaj.assignment.model;

public enum Cabin {
    ECONOMY ("Economy"),
    PREMIUM_ECONOMY("Premium Economy"),
    BUSINESS ("Business"),
    FIRST("First");

    private String cabinName;

    Cabin(String value) {
        cabinName = value;
    }

    public String getValue(){
        return cabinName;
    }
}
