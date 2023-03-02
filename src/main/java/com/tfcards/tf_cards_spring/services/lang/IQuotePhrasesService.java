package com.tfcards.tf_cards_spring.services.lang;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.List;

import com.tfcards.tf_cards_spring.domain.Quote;

public interface IQuotePhrasesService {
    
    Map<String, Set<Quote>> getAll();
    Map<String, Set<Quote>> getAll(Optional<List<String>> filters);

}
