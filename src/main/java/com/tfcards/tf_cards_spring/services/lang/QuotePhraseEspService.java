package com.tfcards.tf_cards_spring.services.lang;

import com.tfcards.tf_cards_spring.domain.Quote;
import com.tfcards.tf_cards_spring.domain.QuoteCharacter;
import com.tfcards.tf_cards_spring.repositories.fake.FakeFilter;
import com.tfcards.tf_cards_spring.repositories.fake.FakeFilterBuildersFactory;
import com.tfcards.tf_cards_spring.repositories.fake.MatchWordFakeFilter;
import com.tfcards.tf_cards_spring.repositories.fake.QuoteFakeFilter;

import java.util.*;

public class QuotePhraseEspService implements IQuotePhrasesService {
    private Set<Quote> quotesList;

    public QuotePhraseEspService() {
        this.quotesList = Set.of(
                new Quote(Long.valueOf(1), "transformers",
                        new QuoteCharacter(Long.valueOf(5), "Optimus Prime"),
                        "Optmus primera frase"),
                new Quote(Long.valueOf(2), "transformers",
                        new QuoteCharacter(Long.valueOf(5), "Optimus Prime"),
                        "Optimus secunda frase"),
                new Quote(Long.valueOf(3), "transformers",
                        new QuoteCharacter(Long.valueOf(4), "Megatron"),
                        "Megatrons unica frase"),
                new Quote(Long.valueOf(5), "transformers",
                        new QuoteCharacter(Long.valueOf(3), "Starscream"),
                        "Segunda frase de Starscream"),
                new Quote(Long.valueOf(6), "transformers",
                        new QuoteCharacter(Long.valueOf(3), "Starscream"),
                        "Tercera frase de Starscream"),
                new Quote(Long.valueOf(7), "president",
                        new QuoteCharacter(Long.valueOf(1), "Donald Trump USA"),
                        "Frase controversialde Donals"),
                new Quote(Long.valueOf(8), "president",
                        new QuoteCharacter(Long.valueOf(2), "Rodrigo Chavez CRC"),
                        "Frase acerca de algun decreto de Rodrigo"),
                new Quote(Long.valueOf(9), "president",
                        new QuoteCharacter(Long.valueOf(6), "Nayit Bukele ES"),
                        "Frases de Buekle en contra de las pandillas"),
                new Quote(Long.valueOf(10), "video_games",
                        new QuoteCharacter(Long.valueOf(7), "Kratos GOW"),
                        "Frase amenazante de Kratos"));
    }

    @Override
    public Map<String, Set<Quote>> getAll() {
        Map<String, Set<Quote>> quotesMap = new HashMap<>();
        this.quotesList.stream().forEach(q -> {
            var crrCategory = q.getCategory().toLowerCase();
            if (!quotesMap.containsKey(crrCategory)) {
                Set<Quote> newCategorySet = new HashSet<>();
                newCategorySet.add(q);
                quotesMap.put(crrCategory, newCategorySet);
            } else {
                var crrCategorySet = quotesMap.get(crrCategory);
                crrCategorySet.add(q);
            }
        });
        quotesMap.containsKey("category");
        return quotesMap;
    }

    @Override
    public Map<String, Set<Quote>> getAll(Optional<Map<String, Object>> filters) {
        FakeFilterBuildersFactory quoteFakeFilter = FakeFilterBuildersFactory.getFilterBuilder("quote");
        FakeFilter<Quote> fakeFilter = ((QuoteFakeFilter) quoteFakeFilter)
                .addCategoryFilter(new MatchWordFakeFilter("transfomers"))
                .addCharacterNameFilter(new MatchWordFakeFilter("opimus"))
                .build();

        fakeFilter.filter(this.quotesList);

        Map<String, Set<Quote>> quotesMap = new HashMap<>();
        this.quotesList.stream()
//                .filter(q -> true)
                .forEach(q -> {
                    var crrCategory = q.getCategory().toLowerCase();
                    if (!quotesMap.containsKey(crrCategory)) {
                        Set<Quote> newCategorySet = new HashSet<>();
                        newCategorySet.add(q);
                        quotesMap.put(crrCategory, newCategorySet);
                    } else {
                        var crrCategorySet = quotesMap.get(crrCategory);
                        crrCategorySet.add(q);
                    }
                });
        return quotesMap;
    }
}
