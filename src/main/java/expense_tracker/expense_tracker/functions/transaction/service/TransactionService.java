package expense_tracker.expense_tracker.functions.transaction.service;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createNewTransaction(TransactionDto transactionDto);


    List<TransactionDto> getAllTransaction(TransactionGetAllDto transactionDto);
}
