package expense_tracker.expense_tracker.functions.transaction.service.impl;


import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.repository.TransactionRepository;
import expense_tracker.expense_tracker.functions.transaction.service.TransactionService;
import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
