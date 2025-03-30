package expense_tracker.expense_tracker.functions.account.service;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.model.AccountMaster;

public interface AccountMasterService {

    AccountMaster createAccount(AccountMasterDto accountMasterDto);
}
