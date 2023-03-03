package com.tfcards.tf_cards_spring.repositories.fake;

public abstract class FakeFilterBuildersFactory {


    public static FakeFilterBuildersFactory getFilterBuilder(String builderNmae) {
        return switch (builderNmae.toLowerCase()) {
            case "quote", "figure" -> new QuoteFakeFilter();
            default -> throw new RuntimeException("No FakeFilterBuilder with name specified was found");
        };
    }


    public abstract <E> FakeFilter<E> build();

}
