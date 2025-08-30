package expense_tracker.expense_tracker.common.utils.scheduler;


import expense_tracker.expense_tracker.functions.transaction.repository.TransactionRepository;
import expense_tracker.expense_tracker.model.TransactionMaster;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private TransactionRepository transactionRepository;

    // RUN EVERY MID NIGHT
    //@Scheduled(fixedRate = 60000)
    @Scheduled(cron = "0 0 0 * * *")
    public void recurringTransactions() {

        LocalDate currentDate = LocalDate.now();
        List<TransactionMaster> recurringTransactions = transactionRepository.findRecurringTransaction();

        System.out.println("RECURSION TRIGGERED " + LocalDateTime.now().toLocalTime());

        if (!recurringTransactions.isEmpty()) {
            for (TransactionMaster transactions : recurringTransactions) {
                if (ObjectUtils.isNotEmpty(transactions.getFrequency())) {
                    // Validate if allows recurring end
                    if (transactions.isNoRecurringEnd() && currentDate.isAfter(transactions.getRecurringFrom()) && currentDate.isBefore(transactions.getRecurringTo())) {
                        recreatedNewTransaction(transactions, currentDate);
                    } else if (currentDate.isAfter(transactions.getRecurringFrom())) {
                        recreatedNewTransaction(transactions, currentDate);
                    }
                }
            }
        }
    }

    private void recreatedNewTransaction(TransactionMaster transactionMaster, LocalDate currentDate) {

        TransactionMaster newTransaction = new TransactionMaster();
        BeanUtils.copyProperties(transactionMaster, newTransaction);

        newTransaction.setDate(currentDate);
        newTransaction.setTime(LocalDateTime.now());
        newTransaction.setRecurringTransaction(false);
        newTransaction.setArchiveTransaction(false);
        newTransaction.setId(null);

        switch (transactionMaster.getFrequency()) {
            // DAILY
            case "1": {
                transactionRepository.save(newTransaction);
                break;
            }
            // WEEKLY
            case "2": {
                if (currentDate.getDayOfWeek() == java.time.DayOfWeek.MONDAY) {
                    transactionRepository.save(newTransaction);
                }
                break;
            }
            // MONTHLY
            case "3": {
                if (currentDate.getDayOfMonth() == 15) {
                    transactionRepository.save(newTransaction);
                }
                break;
            }
            // SEMI MONTHLY
            case "4": {
                LocalDate endOfMonth = YearMonth.from(LocalDate.now()).atEndOfMonth();
                if (currentDate.equals(endOfMonth)) {
                    transactionRepository.save(newTransaction);

                }
                break;
            }
            // SEMI ANNUALLY
            case "5": {

                boolean isSemiAnnual =
                        (currentDate.getMonth() == Month.JUNE && currentDate.getDayOfMonth() == 30) ||
                                (currentDate.getMonth() == Month.DECEMBER && currentDate.getDayOfMonth() == 31);

                if (isSemiAnnual) {
                    transactionRepository.save(newTransaction);

                }
                break;
            }
            // QUARTERLY
            case "6": {
                boolean isQuarterEnd =
                        (currentDate.getMonth() == Month.MARCH && currentDate.getDayOfMonth() == 31) ||
                                (currentDate.getMonth() == Month.JUNE && currentDate.getDayOfMonth() == 30) ||
                                (currentDate.getMonth() == Month.SEPTEMBER && currentDate.getDayOfMonth() == 30) ||
                                (currentDate.getMonth() == Month.DECEMBER && currentDate.getDayOfMonth() == 31);

                if (isQuarterEnd) {
                    transactionRepository.save(newTransaction);

                }
                break;
            }
            // ANNUALLY
            case "7": {
                if (currentDate.getMonth() == Month.DECEMBER && currentDate.getDayOfMonth() == 31) {
                    transactionRepository.save(newTransaction);

                }
                break;
            }
        }
    }
}