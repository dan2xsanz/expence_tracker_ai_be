package expense_tracker.expense_tracker.functions.transaction.service.impl;


import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.repository.TransactionRepository;
import expense_tracker.expense_tracker.functions.transaction.service.TransactionService;
import expense_tracker.expense_tracker.model.AccountMaster;
import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<TransactionDto> downloadTransactionMaster(AccountMaster accountMaster) {

        List<TransactionDto> transactionMasterListResponse = new ArrayList<>();

        List<TransactionMaster> transactionMasterList = transactionRepository.findAllTransactionByAccounts(accountMaster.getEmail());

        if (!ObjectUtils.isEmpty(transactionMasterList)) {

            for (TransactionMaster transactionMaster : transactionMasterList) {
                TransactionDto transaction = new TransactionDto();
                BeanUtils.copyProperties(transactionMaster, transaction);

                transactionMasterListResponse.add(transaction);
            }
        }

        return transactionMasterListResponse;
    }
}