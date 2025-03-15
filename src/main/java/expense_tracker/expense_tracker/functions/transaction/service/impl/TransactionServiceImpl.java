package expense_tracker.expense_tracker.functions.transaction.service.impl;


import expense_tracker.expense_tracker.functions.account.repository.AccountMasterRepository;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;
import expense_tracker.expense_tracker.functions.transaction.repository.TransactionRepository;
import expense_tracker.expense_tracker.functions.transaction.repository.custom.TransactionCustomRepository;
import expense_tracker.expense_tracker.functions.transaction.service.TransactionService;
import expense_tracker.expense_tracker.model.AccountMaster;
import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionCustomRepository transactionCustomRepository;

    @Autowired
    private AccountMasterRepository accountMasterRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public TransactionDto createNewTransaction(TransactionDto transactionDto) {

        TransactionMaster transactionMaster = new TransactionMaster();
        BeanUtils.copyProperties(transactionDto, transactionMaster);

        // TODO
        AccountMaster accountMaster = accountMasterRepository.findAccountById(1L);
        transactionMaster.setAccountMaster(accountMaster);

        transactionRepository.save(transactionMaster);
        return transactionDto;
    }

    @Override
    public List<TransactionDto> getAllTransaction(TransactionGetAllDto transactionDto) {

        return transactionCustomRepository.listOfTransaction(transactionDto);

    }
}
