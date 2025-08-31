package expense_tracker.expense_tracker.functions.transaction.service.impl;


import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.repository.TransactionRepository;
import expense_tracker.expense_tracker.functions.transaction.service.TransactionService;
import expense_tracker.expense_tracker.model.AccountMaster;
import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void uploadTransactions(TransactionDto transactionDto, AccountMaster accountMaster) {

        TransactionMaster transactionMaster = new TransactionMaster();

        Optional<TransactionMaster> transaction = transactionRepository.findTransactionByGuid(transactionDto.getTrxGuid());

        if (transaction.isPresent()) {
            BeanUtils.copyProperties(transactionDto, transactionMaster);
            transactionMaster.setId(transaction.get().getId());
        } else {
            BeanUtils.copyProperties(transactionDto, transactionMaster);
        }

        transactionMaster.setAccountMaster(accountMaster);
        transactionRepository.save(transactionMaster);
    }
}