package expense_tracker.expense_tracker.functions.account.service;

import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.model.AccountMaster;

public interface AccountMasterService {

    AccountMaster createAccount(AccountMasterDto accountMasterDto) throws ExemptionError;

    AccountMaster updateAccount(AccountMasterDto accountMasterDto) throws ExemptionError;

    void uploadAccounts(AccountMasterDto accountMasterDto) throws ExemptionError;

    AccountMaster updatePassword(AccountMasterDto accountMasterDto) throws ExemptionError;
}

