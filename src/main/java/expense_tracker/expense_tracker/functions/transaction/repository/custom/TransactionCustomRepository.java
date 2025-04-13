package expense_tracker.expense_tracker.functions.transaction.repository.custom;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.DailyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.MonthlyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.YearlyExpenseDto;

import java.util.List;

public interface TransactionCustomRepository {


    List<TransactionDto> listOfTransaction(TransactionGetAllDto transactionGetAllDto);

    List<DailyExpenseDto> getAllDailyExpense();

    List<MonthlyExpenseDto> getAllMonthExpense();

    List<YearlyExpenseDto> getAllYearlyExpense();
}
