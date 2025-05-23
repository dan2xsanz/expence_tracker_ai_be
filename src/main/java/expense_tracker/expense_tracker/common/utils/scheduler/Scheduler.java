package expense_tracker.expense_tracker.common.utils.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Scheduler {

    // @Scheduled(cron = "0 0 0 * * *") RUN EVERY MID NIGHT
    @Scheduled(fixedRate = 60000)
    public void recurringTransactions() {
        System.out.println("IM A TRIGGERED " + LocalDateTime.now().toLocalTime());
    }

}
