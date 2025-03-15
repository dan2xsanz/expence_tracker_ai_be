package expense_tracker.expense_tracker.functions.transaction.controller;

import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.service.TransactionService;
import expense_tracker.expense_tracker.model.ApiResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("add-transaction")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel addTransaction(@RequestBody TransactionDto transactionDto) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(transactionService.createNewTransaction(transactionDto))
                .isSuccess(true)
                .build();
    }

    @PostMapping("all-transaction")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel getAllTransaction(@RequestBody TransactionDto transactionDto) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(transactionService.getAllTransaction(transactionDto))
                .isSuccess(true)
                .build();
    }
}
