package expense_tracker.expense_tracker.functions.transaction.service;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;

public interface TransactionService {

    TransactionDto createNewTransaction(TransactionDto transactionDto);
}
