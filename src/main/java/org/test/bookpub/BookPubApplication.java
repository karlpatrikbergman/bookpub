package org.test.bookpub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.test.bookpubstarter.dbcount.EnableDbCounting;

@Slf4j
@Configuration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = @ComponentScan.Filter(UsedForTesting.class))
@EnableScheduling
@EnableDbCounting
public class BookPubApplication {

    public static void main(String[] args) {
        log.debug("************** Verifying logback ************** ");
        SpringApplication.run(BookPubApplication.class, args);
    }

    @Bean
    public PopulateDatabaseRunner populateDatabaseRunner() {
        return new PopulateDatabaseRunner();
    }

//    @Bean
//    public ScheduleExampleRunner scheduleExampleRunner() {
//        return new ScheduleExampleRunner();
//    }
}

@interface UsedForTesting {}
