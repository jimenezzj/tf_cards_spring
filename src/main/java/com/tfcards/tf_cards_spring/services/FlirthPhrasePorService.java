package com.tfcards.tf_cards_spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("POR")
@Service("FlirtPhraseServImpl")
public class FlirthPhrasePorService implements IFlirtPhraseService {

    protected List<String> phrases = new ArrayList<>(List.of(
            "Meu amigo quer saber se você me acha bonito. O que eu digo a eles?",
            "Você é Wifi?, porque acho que poderíamos ter uma ótima conexão",
            "Você gostaria de algo para beber?",
            "Quando posso te ver novamente? Escolha um dia que terminou com \"a\" ou \"o\"",
            "Você acredita em amor à primeira mensagem? Porque você pode excluir este até que você faça"));

    @Override
    public String getRandFlirtPhrase() {
        return phrases.get(
                new Random().nextInt(0, this.phrases.size()));
    }

}
