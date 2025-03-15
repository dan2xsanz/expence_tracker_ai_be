package expense_tracker.expense_tracker.functions.transaction.repository.custom;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;

import java.util.List;

public interface TransactionCustomRepository {


    List<TransactionDto> listOfTransaction(TransactionGetAllDto transactionGetAllDto);
}
