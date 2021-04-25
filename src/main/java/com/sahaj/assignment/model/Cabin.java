package com.sahaj.assignment.model;

public enum Cabin {
    Economy("Economy"),
    Premium_Economy("Premium Economy"),
    Business("Business"),
    First("First");

    private String cabinName;

    Cabin(String value) {
        cabinName = value;
    }

    public String getValue(){
        return cabinName;
    }
}
