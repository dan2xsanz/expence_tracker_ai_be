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
    public ApiResultModel addTransaction(@RequestBody AccountMasterDto accountMasterDto) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(accountMasterService.createAccount(accountMasterDto))
                .isSuccess(true)
                .build();
    }
}
