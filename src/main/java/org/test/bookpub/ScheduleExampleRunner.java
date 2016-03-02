package org.test.bookpub;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduleExampleRunner implements CommandLineRunner {
    protected final Log logger = LogFactory.getLog(getClass());

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() {
        logger.info("Hello");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
