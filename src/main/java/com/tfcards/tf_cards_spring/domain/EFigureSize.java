package com.tfcards.tf_cards_spring.domain;

public enum EFigureSize {
    CORE("Core"),
    DELUXE("Deluxe"),
    VOYAGER("Voyager"),
    LEADER("Leader");

    private String normalizeVal;

    EFigureSize(String size) {
        this.normalizeVal = size;
    }

    public String getNormalizeVal() {
        return normalizeVal;
    }

    public void setNormalizeVal(String normalizeVal) {
        this.normalizeVal = normalizeVal;
    }
}
