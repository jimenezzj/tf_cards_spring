package com.tfcards.tf_cards_spring.domain;

public class Quote {
    
    private Long id;
    private String category;
    private QuoteCharacter characterName;
    private String quote;
    
    public Quote(Long id, String category, QuoteCharacter characterName, String quote) {
        this.id = id;
        this.category = category;
        this.characterName = characterName;
        this.quote = quote;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public QuoteCharacter getCharacterName() {
        return characterName;
    }
    public void setCharacterName(QuoteCharacter characterName) {
        this.characterName = characterName;
    }
    public String getQuote() {
        return quote;
    }
    public void setQuote(String quote) {
        this.quote = quote;
    }

}
