package com.tfcards.tf_cards_spring.config;

import com.tfcards.tf_cards_spring.services.lang.QuotePhraseEspService;
import com.tfcards.tf_cards_spring.services.lang.QuotePhrasesEngService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LanguageConfig {

    @Bean()
    @Primary
    QuotePhrasesEngService quotePhraseEngService() {
        return new QuotePhrasesEngService();
    }

    @Bean
    QuotePhraseEspService quotePhraseEspService() {
        return new QuotePhraseEspService();
    }

}
