package expense_tracker.expense_tracker.functions.systemsetting.service;

import expense_tracker.expense_tracker.model.AccountMaster;
import expense_tracker.expense_tracker.model.SystemSetting;

public interface SystemSettingService {

    void uploadSystemSettings(SystemSetting systemSettingDto, AccountMaster accountMaster);

    SystemSetting downloadSystemSettings(AccountMaster accountMaster);
}
