package expense_tracker.expense_tracker.functions.account.controller;


import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.functions.account.service.AccountMasterService;
import expense_tracker.expense_tracker.model.ApiResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountMasterController {

    @Autowired
    private AccountMasterService accountMasterService;

    @PostMapping("add-account")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel addAccount(@RequestBody AccountMasterDto accountMasterDto) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(accountMasterService.createAccount(accountMasterDto))
                .isSuccess(true)
                .build();
    }

    @PutMapping("update-account")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel updateAccount(@RequestBody AccountMasterDto accountMasterDto) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(accountMasterService.updateAccount(accountMasterDto))
                .isSuccess(true)
                .build();
    }

    @PutMapping("update-password")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel updatePassword(@RequestBody AccountMasterDto accountMasterDto) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(accountMasterService.updatePassword(accountMasterDto))
                .isSuccess(true)
                .build();
    }
}
