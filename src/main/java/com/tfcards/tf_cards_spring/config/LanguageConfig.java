package com.tfcards.tf_cards_spring.config;

import com.tfcards.tf_cards_spring.datasource.FakeDataSource;
import com.tfcards.tf_cards_spring.services.lang.QuotePhraseEspService;
import com.tfcards.tf_cards_spring.services.lang.QuotePhrasesEngService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class LanguageConfig {

    @Bean
    FakeDataSource fakeDataSrc(
            @Value("${com.tfcards.fake.user}") String pUser,
            @Value("${com.tfcards.fake.password}") String pPassword,
            @Value("${com.tfcards.fake.jdbcurl}") String pJdbcUrl) {
        var fakeDatasrc = new FakeDataSource();
        fakeDatasrc.setUser(pUser);
        fakeDatasrc.setPassword(pPassword);
        fakeDatasrc.setJbcUrl(pJdbcUrl);
        return fakeDatasrc;
    }

    @Bean
    FakeDataSource fakeYmlDataSrc(
            @Value("${com.tfcards.user}") String pUser,
            @Value("${com.tfcards.password}") String pPassword,
            @Value("${com.tfcards.password}") String pJdbcUrl) {
        var fakeDatasrc = new FakeDataSource();
        fakeDatasrc.setUser(pUser);
        fakeDatasrc.setPassword(pPassword);
        fakeDatasrc.setJbcUrl(pJdbcUrl);
        return fakeDatasrc;
    }

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
