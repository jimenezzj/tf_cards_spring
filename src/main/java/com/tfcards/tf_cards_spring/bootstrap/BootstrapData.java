package com.tfcards.tf_cards_spring.bootstrap;

import com.tfcards.tf_cards_spring.datasource.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    @Qualifier("fakeDataSrc")
    protected FakeDataSource fakeDataSource;

    @Autowired
    @Qualifier(value = "fakeYmlDataSrc")
    private FakeDataSource ymlDataSource;

    public BootstrapData() {
    }

    @Override
    public void run(String... args) throws Exception {
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
