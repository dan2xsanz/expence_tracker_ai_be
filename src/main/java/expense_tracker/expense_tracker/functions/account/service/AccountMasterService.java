package expense_tracker.expense_tracker.functions.account.service;

import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.model.AccountMaster;

public interface AccountMasterService {

    void uploadAccounts(AccountMasterDto accountMasterDto) throws ExemptionError;

    AccountMaster updatePassword(AccountMasterDto accountMasterDto) throws ExemptionError;
}

