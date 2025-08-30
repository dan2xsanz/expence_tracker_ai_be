package expense_tracker.expense_tracker.functions.download.controller;

import expense_tracker.expense_tracker.functions.download.service.DownloadService;
import expense_tracker.expense_tracker.model.ApiResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("download")
public class DownloadController {

    @Autowired
    private DownloadService downloadService;

    @PostMapping("all-data/{email}")
    @ResponseStatus(HttpStatus.OK)
    private ApiResultModel downloadData(@PathVariable String email) {
        return ApiResultModel.builder()
                .resultData(downloadService.downloadDataByAccount(email))
                .isSuccess(true)
                .build();
    }
}
