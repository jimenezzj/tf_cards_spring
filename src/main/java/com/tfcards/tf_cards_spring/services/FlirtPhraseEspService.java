package com.tfcards.tf_cards_spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// @Profile({"ESP", "default"})
@Profile("ESP")
@Service("FlirtPhraseServImpl")
public class FlirtPhraseEspService implements IFlirtPhraseService {

    protected List<String> frases = new ArrayList<>(List.of(
            "Mi amigo quiere saber si crees que soy guapo. ¿Que le digo?",
            "¿Eres Wifi?, porque creo que podriamos tener una gran coneccion",
            "¿Te gustaría algo para tomar?",
            "Cuando te puedo ver de nuevo? Escoge un dia que termino con \"s\" u \"o\"",
            "Crees en el amor al primer texto? Porque puede eliminar este hasta que lo haga"));

    @Override
    public String getRandFlirtPhrase() {
        return this.frases.get(
            new Random().nextInt(0, this.frases.size())    
        );
    }

}
