package expense_tracker.expense_tracker.functions.account.service.impl;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;


public interface AccountService {
    AccountMasterDto createNewAccount(AccountMasterDto accountMasterDto);
}
