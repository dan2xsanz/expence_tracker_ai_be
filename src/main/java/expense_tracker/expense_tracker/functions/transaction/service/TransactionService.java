package expense_tracker.expense_tracker.functions.transaction.service;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.model.AccountMaster;

public interface TransactionService {

    void uploadTransactions(TransactionDto transactionDto, AccountMaster accountMaster);
}
