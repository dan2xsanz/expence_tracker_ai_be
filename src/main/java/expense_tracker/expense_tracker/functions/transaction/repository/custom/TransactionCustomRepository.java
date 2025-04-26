package expense_tracker.expense_tracker.functions.transaction.repository.custom;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.DailyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.MonthlyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.YearlyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.totals.TransactionTotalRequestDto;
import expense_tracker.expense_tracker.functions.transaction.dto.totals.TransactionTotalResponseDto;

import java.util.List;

public interface TransactionCustomRepository {


    List<TransactionDto> listOfTransaction(TransactionGetAllDto transactionGetAllDto);

    List<DailyExpenseDto> getAllDailyExpense(Long accountMasterId);

    List<MonthlyExpenseDto> getAllMonthExpense(Long accountMasterId);

    List<YearlyExpenseDto> getAllYearlyExpense(Long accountMasterId);

    TransactionTotalResponseDto getAllTransactionWeekly(TransactionTotalRequestDto transactionTotalRequestDto);

    TransactionTotalResponseDto getAllTransactionMonthly(TransactionTotalRequestDto transactionTotalRequestDto);

    TransactionTotalResponseDto getAllTransactionYearly(TransactionTotalRequestDto transactionTotalRequestDto);
}
