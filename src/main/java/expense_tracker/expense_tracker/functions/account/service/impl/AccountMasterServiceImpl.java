package expense_tracker.expense_tracker.functions.account.service.impl;

import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.config.exemption.ExemptionErrorMessages;
import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.functions.account.repository.AccountMasterRepository;
import expense_tracker.expense_tracker.functions.account.service.AccountMasterService;
import expense_tracker.expense_tracker.model.AccountMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountMasterServiceImpl implements AccountMasterService {

    @Autowired
    private AccountMasterRepository accountMasterRepository;

    @Override
    public AccountMaster createAccount(AccountMasterDto accountMasterDto) throws ExemptionError {

        // VALIDATE ACCOUNT VIA EMAIL
        if (accountMasterRepository.validateEmail(accountMasterDto.getEmail()).isPresent()) {
            throw new ExemptionError(ExemptionErrorMessages.EMAIL_ALREADY_EXIST_MESSAGE);
        }

        AccountMaster accountMaster = new AccountMaster();
        BeanUtils.copyProperties(accountMasterDto, accountMaster);

        accountMasterRepository.save(accountMaster);
        return accountMaster;

    }


    @Override
    public AccountMaster updatePassword(AccountMasterDto accountMasterDto) throws ExemptionError {
        // VALIDATE ACCOUNT VIA EMAIL
        AccountMaster accountMaster = accountMasterRepository.validateEmail(accountMasterDto.getEmail()).
                orElseThrow(() -> new ExemptionError(ExemptionErrorMessages.EMAIL_NOT_FOUND));

        accountMaster.setPassword(accountMasterDto.getPassword());
        accountMasterRepository.save(accountMaster);
        return accountMaster;

    }
}
