package com.tfcards.tf_cards_spring.repositories.fake;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import com.tfcards.tf_cards_spring.domain.Quote;

public class QuoteFakeFilter extends FakeFilterBuildersFactory {

    private FakeFilter<Quote> fakeFilter;

    public QuoteFakeFilter() {
    }

    public QuoteFakeFilter addCharacterNameFilter(IFakeFilterValidator pValidator) {
        Predicate<Quote> predValid = q -> {
            pValidator.setSrcVal(q.getCharacterName().getName());
            return pValidator.validate();
        };
        fakeFilter.addFilter(predValid);
        return this;
    }

    public QuoteFakeFilter addCategoryFilter(IFakeFilterValidator pValidator) {
        Predicate<Quote> prediValid = (q) -> {
            pValidator.setSrcVal(q.getCategory());
            return pValidator.validate();
        };
        getFakeFilter().addFilter(prediValid);
        return this;
    }

    public FakeFilter<Quote> getFakeFilter() {
        return fakeFilter;
    }

    @Override
    public FakeFilter<Quote> build() {
        return fakeFilter;
    }
}
