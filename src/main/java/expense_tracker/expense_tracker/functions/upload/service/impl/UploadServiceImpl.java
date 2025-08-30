package expense_tracker.expense_tracker.functions.upload.service.impl;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.functions.account.service.AccountMasterService;
import expense_tracker.expense_tracker.functions.upload.dto.UploadRequestDto;
import expense_tracker.expense_tracker.functions.upload.service.UploadService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private AccountMasterService accountMasterService;

    @Override
    public void uploadAllDataByAccounts(UploadRequestDto uploadRequestDto) {

        if (!ObjectUtils.isEmpty(uploadRequestDto.getAccountMaster())) {
            AccountMasterDto accountMasterDto = new AccountMasterDto();
            BeanUtils.copyProperties(uploadRequestDto.getAccountMaster(), accountMasterDto);

            accountMasterDto.setId(null);
            accountMasterDto.setLastTransmit(LocalDateTime.now());

            accountMasterService.uploadAccounts(accountMasterDto);
        }
    }
}
