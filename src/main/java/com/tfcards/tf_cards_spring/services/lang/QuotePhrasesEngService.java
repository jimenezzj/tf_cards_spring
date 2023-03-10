package com.tfcards.tf_cards_spring.services.lang;

import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.tfcards.tf_cards_spring.domain.Quote;
import com.tfcards.tf_cards_spring.domain.QuoteCharacter;

public class QuotePhrasesEngService implements IQuotePhrasesService {

        private Set<Quote> quotesList;

        public QuotePhrasesEngService() {
                this.quotesList = Set.of(
                                new Quote(Long.valueOf(1), "transformers",
                                                new QuoteCharacter(Long.valueOf(5), "Optimus Prime"),
                                                "Optmus first quote"),
                                new Quote(Long.valueOf(2), "transformers",
                                                new QuoteCharacter(Long.valueOf(5), "Optimus Prime"),
                                                "Optimus second quote"),
                                new Quote(Long.valueOf(3), "transformers",
                                                new QuoteCharacter(Long.valueOf(4), "Megatron"),
                                                "Megatrons only quote"),
                                new Quote(Long.valueOf(5), "transformers",
                                                new QuoteCharacter(Long.valueOf(3), "Starscream"),
                                                "Starscream's first coward quote"),
                                new Quote(Long.valueOf(6), "transformers",
                                                new QuoteCharacter(Long.valueOf(3), "Starscream"),
                                                "Starscream's second coward quote"),
                                new Quote(Long.valueOf(7), "president",
                                                new QuoteCharacter(Long.valueOf(1), "Donald Trump USA"),
                                                "Donald's controversial quote"),
                                new Quote(Long.valueOf(8), "president",
                                                new QuoteCharacter(Long.valueOf(2), "Rodrigo Chavez CRC"),
                                                "Rodrigo's quote about some decree"),
                                new Quote(Long.valueOf(9), "president",
                                                new QuoteCharacter(Long.valueOf(6), "Nayit Bukele ES"),
                                                "Bukele's quote against gangs"));
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
        public Map<String, Set<Quote>> getAll(Optional<List<String>> filters) {

                Map<String, Set<Quote>> quotesMap = new HashMap<>();
                this.quotesList.stream()
                                .filter(q -> true)
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

                return this.getAll();
        }

}
