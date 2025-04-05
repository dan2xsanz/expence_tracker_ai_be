package expense_tracker.expense_tracker.functions.transaction.service;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.DailyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.MonthlyExpenseDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createNewTransaction(TransactionDto transactionDto);


    List<TransactionDto> getAllTransaction(TransactionGetAllDto transactionDto);

    List<DailyExpenseDto> getAllDailyExpense();

    List<MonthlyExpenseDto> getAllMonthlyExpense();
}
