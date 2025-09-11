package expense_tracker.expense_tracker.functions.systemsetting.service.impl;

import expense_tracker.expense_tracker.functions.systemsetting.repository.SystemSettingRepository;
import expense_tracker.expense_tracker.functions.systemsetting.service.SystemSettingService;
import expense_tracker.expense_tracker.model.AccountMaster;
import expense_tracker.expense_tracker.model.SystemSetting;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemSettingImpl implements SystemSettingService {

    @Autowired
    private SystemSettingRepository systemSettingRepository;

    @Override
    public void uploadSystemSettings(SystemSetting systemSettingDto, AccountMaster accountMaster) {

        Optional<SystemSetting> system = systemSettingRepository.findSystemSettingByGuid(accountMaster.getEmail());

        SystemSetting systemSetting = new SystemSetting();
        BeanUtils.copyProperties(systemSettingDto, systemSetting);

        system.ifPresent(setting -> systemSetting.setId(setting.getId()));
        systemSettingRepository.save(systemSetting);
    }

    @Override
    public SystemSetting downloadSystemSettings(AccountMaster accountMaster) {
        Optional<SystemSetting> system = systemSettingRepository.findSystemSettingByGuid(accountMaster.getEmail());
        SystemSetting systemSetting = new SystemSetting();

        if (system.isPresent()) {
            BeanUtils.copyProperties(system.get(), systemSetting);
            systemSetting.setId(null);
        }

        return systemSetting;
    }
}
