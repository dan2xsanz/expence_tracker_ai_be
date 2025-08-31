package expense_tracker.expense_tracker.functions.upload.service.impl;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.functions.account.service.AccountMasterService;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.service.TransactionService;
import expense_tracker.expense_tracker.functions.upload.dto.UploadRequestDto;
import expense_tracker.expense_tracker.functions.upload.service.UploadService;
import expense_tracker.expense_tracker.model.AccountMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private AccountMasterService accountMasterService;

    @Autowired
    private TransactionService transactionService;

    @Override
    public void uploadAllDataByAccounts(UploadRequestDto uploadRequestDto) {

        AccountMaster accountMaster = new AccountMaster();

        // UPLOAD ACCOUNT MASTER
        if (!ObjectUtils.isEmpty(uploadRequestDto.getAccountMaster())) {

            AccountMasterDto accountMasterDto = new AccountMasterDto();
            BeanUtils.copyProperties(uploadRequestDto.getAccountMaster(), accountMasterDto);

            accountMasterDto.setId(null);
            accountMasterDto.setLastTransmit(LocalDateTime.now());

            accountMaster = accountMasterService.uploadAccounts(accountMasterDto);
        }

        // UPLOAD TRANSACTION MASTER
        if (!ObjectUtils.isEmpty(uploadRequestDto.getTransactionMaster())) {
            for (TransactionDto transactionUpload : uploadRequestDto.getTransactionMaster()) {

                TransactionDto transaction = new TransactionDto();
                BeanUtils.copyProperties(transactionUpload, transaction);
                transaction.setId(null);

                transactionService.uploadTransactions(transaction, accountMaster);
            }
        }
    }
}
