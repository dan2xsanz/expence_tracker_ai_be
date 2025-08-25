package expense_tracker.expense_tracker.functions.download.service;

import expense_tracker.expense_tracker.functions.download.dto.DownloadDto;

public interface DownloadService {

    DownloadDto downloadDataByAccount(String email);
}
