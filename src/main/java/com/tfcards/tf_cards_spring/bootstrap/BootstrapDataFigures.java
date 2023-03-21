package com.tfcards.tf_cards_spring.bootstrap;

import com.tfcards.tf_cards_spring.domain.*;
import com.tfcards.tf_cards_spring.repositories.ICollectionGroupRepo;
import com.tfcards.tf_cards_spring.repositories.IFigureRepository;
import com.tfcards.tf_cards_spring.repositories.IFiguresCollectorRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BootstrapDataFigures implements ApplicationListener<ContextRefreshedEvent> {

    private final ICollectionGroupRepo collectionGroupRepo;
    private final IFigureRepository figureRepo;
    private final IFiguresCollectorRepo figuresCollectorRepo;

    public BootstrapDataFigures(ICollectionGroupRepo collectionGroupRepo, IFigureRepository figureRepo, IFiguresCollectorRepo figuresCollectorRepo) {
        this.collectionGroupRepo = collectionGroupRepo;
        this.figureRepo = figureRepo;
        this.figuresCollectorRepo = figuresCollectorRepo;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.figureRepo.saveAll(this.getFigures());
        System.out.println("Figures loaded on refresh context...");
    }

    private List<Figure> getFigures() {
        var fgsList = new ArrayList<Figure>(1);
//
        Optional<CollectionGroup> tf1Grp = this.collectionGroupRepo.findByNameContaining("2007");
        if (tf1Grp.isEmpty()) throw new RuntimeException("Transformers 2007 group not found");
        Optional<CollectionGroup> tf2Grp = this.collectionGroupRepo.findByNameContaining("ROFT");
        if (tf2Grp.isEmpty()) throw new RuntimeException("Transformers ROFT group not found");
        Optional<CollectionGroup> tf3Grp = this.collectionGroupRepo.findByNameContaining("DOM");
        if (tf3Grp.isEmpty()) throw new RuntimeException("Transformers DOM group not found");

        var fg1 = new Figure("Optimus Prime Bayverse 1", 2018);
        fg1.setCollectGrp(tf1Grp.get());
        fg1.setSize(EFigureSize.VOYAGER);
        var fg1Notes = new ItemNotes();
        fg1Notes.setDescription("Studio Series 05 Voyager Class Movie 2 Optimus Prime figure\n" +
                "Premium figure and packaging inspired by the iconic Forest Fight scene\n" +
                "The figure scale reflects the character's size in the world of Transformers Movie 2\n" +
                "Converts between robot and truck models in 35 steps\n" +
                "Removable backdrop displays Optimus Prime figure in the Forest Fight scene\n" +
                "Includes Transformers Studio Series 05 Voyager Class Movie 2 Optimus Prime figure, 2 accessories, and instructions. Ages 8 and up.");
        fg1.setNotes(fg1Notes);
        fg1.addAccessory(new FigureAccessory("Optimus Bayverve Hooks", "Glow orange color", BigDecimal.valueOf(5.0)));
        fg1.addAccessory(new FigureAccessory("Optimus Bayverve DOM Guns & Blades", "Set of weapons used by Optimus in DOM", BigDecimal.valueOf(15.99)));
        fg1.addAccessory(new FigureAccessory("Optimus Bayverve DOM Wings", "Trailer wings used by Optimus in DOM", BigDecimal.valueOf(20.99)));

        fgsList.add(fg1);
//        this.figureRepo.save(fg1);

//        fg1.getFigureCollectors().add(colltor1);
//        var colltor1 = new FiguresCollector("Sam Windwicky");
//        colltor1.getFigures().add(fg1);
//
//        this.figuresRepo.save(fg1);
//        this.collectrsRepo.save(colltor1);
//        this.collectionGrpRepo.save(grpBay);
//
//        var fg2 = new Figure("Megatron Bayverse 1", 2019);
//        var colltor2 = new FiguresCollector("Mikeila Hariris");
//
//        colltor2.getFigures().add(fg2);
//        fg2.getFigureCollectors().add(colltor2);
//        grpBay.getFigures().add(fg2);
//
//        this.figuresRepo.save(fg2);
//        this.collectrsRepo.save(colltor2);
//        // this.collectionGrpRepo.save(grpBay);
//        System.out.println("tfc =====>  Started in Bootstrap");
//        System.out.println("tfc =====>" + "number of figures: " + this.figuresRepo.count());

        return fgsList;
    }
}
