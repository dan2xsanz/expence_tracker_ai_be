package expense_tracker.expense_tracker.functions.transaction.service;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createNewTransaction(TransactionDto transactionDto);


    List<TransactionDto> getAllTransaction(TransactionDto transactionDto);
}
