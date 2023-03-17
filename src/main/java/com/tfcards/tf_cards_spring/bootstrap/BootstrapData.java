package com.tfcards.tf_cards_spring.bootstrap;

import com.tfcards.tf_cards_spring.datasource.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tfcards.tf_cards_spring.repositories.IFigureRepository;
import com.tfcards.tf_cards_spring.repositories.ICollectionGroupRepo;
import com.tfcards.tf_cards_spring.repositories.IFiguresCollectorRepo;

@Component
public class BootstrapData implements CommandLineRunner {

    private final IFigureRepository figuresRepo;
    private final IFiguresCollectorRepo collectrsRepo;
    private final ICollectionGroupRepo collectionGrpRepo;
    @Autowired
    @Qualifier("fakeDataSrc")
    protected FakeDataSource fakeDataSource;

    @Autowired
    @Qualifier(value = "fakeYmlDataSrc")
    private FakeDataSource ymlDataSource;

    public BootstrapData(IFigureRepository pFigureRepo, IFiguresCollectorRepo pCollectorRepo, ICollectionGroupRepo pCollectionGrp) {
        this.figuresRepo = pFigureRepo;
        this.collectrsRepo = pCollectorRepo;
        this.collectionGrpRepo = pCollectionGrp;
    }

    @Override
    public void run(String... args) throws Exception {
//        var grpBay = new CollectionGroup("Bayverse (Transformers Live Action Movie 1)", 2018);
//
//        var fg1 = new Figure("Optimus Prime Bayverse 1", 2018);
//        var colltor1 = new FiguresCollector("Sam Windwicky");
//
//        colltor1.getFigures().add(fg1);
//        fg1.getFigureCollectors().add(colltor1);
//        grpBay.getFigures().add(fg1);
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

        System.out.println("--------Manual Application Properties --------");
        System.out.println("tfc =====> " +
                String.format("user(data_user): %s, password(data_user): %s, jdbcUrl(data_user): %s,",
                        this.fakeDataSource.getUser(), this.fakeDataSource.getPassword(), this.fakeDataSource.getJbcUrl())

        );
        System.out.println("-------- SpringBoot Application Properties --------");
        System.out.println("tfc =====> " +
                String.format("user(data_user): %s, password(data_user): %s, jdbcUrl(data_user): %s,",
                        this.ymlDataSource.getUser(), this.ymlDataSource.getPassword(), this.ymlDataSource.getJbcUrl())
        );

    }
}
