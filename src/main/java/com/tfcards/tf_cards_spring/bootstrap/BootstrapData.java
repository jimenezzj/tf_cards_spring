package com.tfcards.tf_cards_spring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tfcards.tf_cards_spring.domain.CollectionGroup;
import com.tfcards.tf_cards_spring.domain.Figure;
import com.tfcards.tf_cards_spring.domain.FiguresCollector;
import com.tfcards.tf_cards_spring.repositories.FigureRepository;
import com.tfcards.tf_cards_spring.repositories.ICollectionGroupRepo;
import com.tfcards.tf_cards_spring.repositories.IFiguresCollectorRepo;

@Component
public class BootstrapData implements CommandLineRunner {

    private final FigureRepository figuresRepo;
    private final IFiguresCollectorRepo collectrsRepo;
    private final ICollectionGroupRepo collectionGrpRepo;

    public BootstrapData(FigureRepository pFigureRepo, IFiguresCollectorRepo pCollectorRepo, ICollectionGroupRepo pCollectionGrp) {
        this.figuresRepo = pFigureRepo;
        this.collectrsRepo = pCollectorRepo;
        this.collectionGrpRepo = pCollectionGrp;
    }

    @Override
    public void run(String... args) throws Exception {
        var grpBay = new CollectionGroup("Bayverse (Transformers Live Action Movie 1)", 2018);
        
        
        var fg1 = new Figure("Optimus Prime Bayverse 1", 2018);
        var colltor1 = new FiguresCollector("Sam Windwicky");
        
        colltor1.getFigures().add(fg1);
        fg1.getFigureCollectors().add(colltor1);
        grpBay.getFigures().add(fg1);

        this.figuresRepo.save(fg1);
        this.collectrsRepo.save(colltor1);
        this.collectionGrpRepo.save(grpBay);

        var fg2 = new Figure("Megatron Bayverse 1", 2019);
        var colltor2 = new FiguresCollector("Mikeila Hariris");

        colltor2.getFigures().add(fg2);
        fg2.getFigureCollectors().add(colltor2);
        grpBay.getFigures().add(fg2);

        this.figuresRepo.save(fg2);
        this.collectrsRepo.save(colltor2);
        // this.collectionGrpRepo.save(grpBay);

        System.out.println("tfc =====>  Started in Bootstrap");
        System.out.println("tfc =====>" + "FG1 number of figures: " + this.figuresRepo.count());

    }

}
