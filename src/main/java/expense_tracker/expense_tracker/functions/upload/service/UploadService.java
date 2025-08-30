package expense_tracker.expense_tracker.functions.upload.service;

import expense_tracker.expense_tracker.functions.upload.dto.UploadRequestDto;

public interface UploadService {

    void uploadAllDataByAccounts(UploadRequestDto uploadRequestDto);
}
