package com.tfcards.tf_cards_spring.repositories.fake;

public class MatchWordFakeFilter implements IFakeFilterValidator {

    private String srcVal;
    private String valToCompare;

    public MatchWordFakeFilter(String srcVal, String valToCompare) {
        this(valToCompare);
        this.srcVal = srcVal;
    }

    public MatchWordFakeFilter(String pValToCompare) {
        this.valToCompare = pValToCompare;
        this.srcVal = "";
    }

    @Override
    public boolean validate() {
        return getSrcVal().contains(getSrcVal());
    }

    public String getSrcVal() {
        return srcVal;
    }

    public void setSrcVal(String srcVal) {
        this.srcVal = srcVal;
    }

    public String getValToCompare() {
        return valToCompare;
    }

    public void setValToCompare(String valToCompare) {
        this.valToCompare = valToCompare;
    }

}
