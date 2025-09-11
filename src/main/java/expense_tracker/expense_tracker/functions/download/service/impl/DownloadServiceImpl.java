package expense_tracker.expense_tracker.functions.download.service.impl;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.functions.account.repository.AccountMasterRepository;
import expense_tracker.expense_tracker.functions.download.dto.DownloadDto;
import expense_tracker.expense_tracker.functions.download.service.DownloadService;
import expense_tracker.expense_tracker.functions.expensecategory.service.ExpenseCategoryService;
import expense_tracker.expense_tracker.functions.incomecategory.service.IncomeCategoryService;
import expense_tracker.expense_tracker.functions.systemsetting.service.SystemSettingService;
import expense_tracker.expense_tracker.functions.transaction.service.TransactionService;
import expense_tracker.expense_tracker.model.AccountMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private AccountMasterRepository accountMasterRepository;

    @Autowired
    private IncomeCategoryService incomeCategoryService;

    @Autowired
    private ExpenseCategoryService expenseCategoryService;

    @Autowired
    private SystemSettingService systemSettingService;

    @Autowired
    private TransactionService transactionService;

    @Override
    public DownloadDto downloadDataByAccount(String email) {

        DownloadDto downloadDto = new DownloadDto();

        Optional<AccountMaster> accountMaster = accountMasterRepository.validateEmail(email);

        // GET ACCOUNT MASTER
        if (accountMaster.isPresent()) {
            AccountMasterDto accountMasterDto = new AccountMasterDto();
            BeanUtils.copyProperties(accountMaster.get(), accountMasterDto);
            downloadDto.setAccountMaster(accountMasterDto);

            // GET TRANSACTIONS
            downloadDto.setTransactionMaster(transactionService.downloadTransactionMaster(accountMaster.get()));
            // GET SYSTEM SETTINGS
            downloadDto.setSystemSetting(systemSettingService.downloadSystemSettings(accountMaster.get()));
            // GET EXPENSE CATEGORY
            downloadDto.setExpenseCategories(expenseCategoryService.downloadExpenseCategory(accountMaster.get()));
            // GET INCOME CATEGORY
            downloadDto.setIncomeCategories(incomeCategoryService.downloadIncomeCategory(accountMaster.get()));

        }
        return downloadDto;
    }
}