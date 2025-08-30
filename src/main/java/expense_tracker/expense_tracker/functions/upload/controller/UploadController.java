package expense_tracker.expense_tracker.functions.upload.controller;

import expense_tracker.expense_tracker.functions.upload.dto.UploadRequestDto;
import expense_tracker.expense_tracker.functions.upload.service.UploadService;
import expense_tracker.expense_tracker.model.ApiResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("all-data")
    @ResponseStatus(HttpStatus.OK)
    private ApiResultModel uploadData(@RequestBody UploadRequestDto uploadRequestDto) {
        uploadService.uploadAllDataByAccounts(uploadRequestDto);
        return ApiResultModel.builder()
                .isSuccess(true)
                .build();
    }
}
