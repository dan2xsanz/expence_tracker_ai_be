package expense_tracker.expense_tracker.functions.transaction.service.impl;


import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.repository.TransactionRepository;
import expense_tracker.expense_tracker.functions.transaction.service.TransactionService;
import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDto createNewTransaction(TransactionDto transactionDto) {

        TransactionMaster transactionMaster = new TransactionMaster();
        BeanUtils.copyProperties(transactionDto, transactionMaster);

        transactionRepository.save(transactionMaster);
        return transactionDto;
    }

    public List<TransactionDto> getAllTransaction(TransactionDto transactionDto) {

        List<TransactionDto> transactionsResponseList = new ArrayList<>();

        List<TransactionMaster> transactionMasterList = transactionRepository.allTransactions();

        if (!transactionMasterList.isEmpty()) {
            for (TransactionMaster transactionMaster : transactionMasterList) {
                TransactionDto transaction = new TransactionDto();
                BeanUtils.copyProperties(transactionMaster, transaction);

                transactionsResponseList.add(transaction);
            }
        }

        return transactionsResponseList;

    }
}
