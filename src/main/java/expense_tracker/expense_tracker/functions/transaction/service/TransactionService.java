package expense_tracker.expense_tracker.functions.transaction.service;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.model.AccountMaster;

import java.util.List;

public interface TransactionService {

    void uploadTransactions(TransactionDto transactionDto, AccountMaster accountMaster);

    List<TransactionDto> downloadTransactionMaster(AccountMaster accountMaster);

}
