package expense_tracker.expense_tracker.functions.transaction.controller;

import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;
import expense_tracker.expense_tracker.functions.transaction.dto.totals.TransactionTotalRequestDto;
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

    @PutMapping("update-transaction")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel updateTransaction(@RequestBody TransactionDto transactionDto) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(transactionService.updateTransaction(transactionDto))
                .isSuccess(true)
                .build();
    }

    @PostMapping("all-transaction")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel getAllTransaction(@RequestBody TransactionGetAllDto transactionGetAllDto) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(transactionService.getAllTransaction(transactionGetAllDto))
                .isSuccess(true)
                .build();
    }

    @GetMapping("daily-expense/{accountMasterId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel getAllDailyExpense(@PathVariable Long accountMasterId) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(transactionService.getAllDailyExpense(accountMasterId))
                .isSuccess(true)
                .build();
    }

    @GetMapping("monthly-expense/{accountMasterId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel getAllMonthlyExpense(@PathVariable Long accountMasterId) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(transactionService.getAllMonthlyExpense(accountMasterId))
                .isSuccess(true)
                .build();
    }

    @GetMapping("yearly-expense/{accountMasterId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel getAllYearlyExpense(@PathVariable Long accountMasterId) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(transactionService.getAllYearlyExpense(accountMasterId))
                .isSuccess(true)
                .build();
    }

    @PostMapping("total-transactions")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel getTotalTransactions(@RequestBody TransactionTotalRequestDto transactionTotalRequestDto) throws ExemptionError {
        return ApiResultModel.builder()
                .resultData(transactionService.getTotalTransactionsSummary(transactionTotalRequestDto))
                .isSuccess(true)
                .build();
    }
}