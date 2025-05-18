package expense_tracker.expense_tracker.functions.transaction.service;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.DailyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.MonthlyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.YearlyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.totals.TransactionTotalRequestDto;
import expense_tracker.expense_tracker.functions.transaction.dto.totals.TransactionTotalResponseDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createNewTransaction(TransactionDto transactionDto);

    TransactionDto updateTransaction(TransactionDto transactionDto);

    List<TransactionDto> getAllTransaction(TransactionGetAllDto transactionDto);

    List<DailyExpenseDto> getAllDailyExpense(Long accountMasterId);

    List<MonthlyExpenseDto> getAllMonthlyExpense(Long accountMasterId);

    List<YearlyExpenseDto> getAllYearlyExpense(Long accountMasterId);

    TransactionTotalResponseDto getTotalTransactionsSummary(TransactionTotalRequestDto transactionTotalRequestDto);
}
