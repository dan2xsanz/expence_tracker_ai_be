package expense_tracker.expense_tracker.functions.account.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.functions.account.repository.AccountRepository;
import expense_tracker.expense_tracker.model.AccountMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountMasterDto createNewAccount(AccountMasterDto accountMasterDto)
    {
        AccountMaster accountMaster = new AccountMaster();
        BeanUtils.copyProperties(accountMasterDto, accountMaster);
        accountRepository.save(accountMaster);
        return accountMasterDto;
    }



}
