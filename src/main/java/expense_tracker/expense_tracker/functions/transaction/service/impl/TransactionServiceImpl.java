package expense_tracker.expense_tracker.functions.transaction.service.impl;


import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.config.exemption.ExemptionErrorMessages;
import expense_tracker.expense_tracker.enums.ExpenseTypeEnums;
import expense_tracker.expense_tracker.functions.account.repository.AccountMasterRepository;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.DailyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.MonthlyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.YearlyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.totals.TransactionTotalRequestDto;
import expense_tracker.expense_tracker.functions.transaction.dto.totals.TransactionTotalResponseDto;
import expense_tracker.expense_tracker.functions.transaction.repository.TransactionRepository;
import expense_tracker.expense_tracker.functions.transaction.repository.custom.TransactionCustomRepository;
import expense_tracker.expense_tracker.functions.transaction.service.TransactionService;
import expense_tracker.expense_tracker.model.AccountMaster;
import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionCustomRepository transactionCustomRepository;

    @Autowired
    private AccountMasterRepository accountMasterRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public TransactionDto createNewTransaction(TransactionDto transactionDto) {

        TransactionMaster transactionMaster = new TransactionMaster();
        BeanUtils.copyProperties(transactionDto, transactionMaster);

        AccountMaster accountMaster = accountMasterRepository.findAccountById(transactionDto.getAccountMasterId())
                .orElseThrow(() -> new ExemptionError(ExemptionErrorMessages.GENERIC_EXCEPTION_MESSAGE));
        transactionMaster.setAccountMaster(accountMaster);

        transactionRepository.save(transactionMaster);
        return transactionDto;
    }

    @Override
    public List<TransactionDto> getAllTransaction(TransactionGetAllDto transactionDto) {
        return transactionCustomRepository.listOfTransaction(transactionDto);

    }

    @Override
    public List<DailyExpenseDto> getAllDailyExpense(Long accountMasterId) {
        return transactionCustomRepository.getAllDailyExpense(accountMasterId);

    }

    @Override
    public List<MonthlyExpenseDto> getAllMonthlyExpense(Long accountMasterId) {

        List<MonthlyExpenseDto> monthlyExpenseListResponse = new ArrayList<>();

        List<MonthlyExpenseDto> monthlyExpenseList = transactionCustomRepository.getAllMonthExpense(accountMasterId);

        if (!monthlyExpenseList.isEmpty()) {
            for (MonthlyExpenseDto monthlyExpense : monthlyExpenseList) {
                MonthlyExpenseDto monthlyExpenseResponse = new MonthlyExpenseDto();
                monthlyExpenseResponse.setExpenseId(monthlyExpense.getExpenseId());
                monthlyExpenseResponse.setExpenseName(ExpenseTypeEnums.getExpenseName(monthlyExpense.getExpenseId()));
                monthlyExpenseResponse.setTotalExpense(monthlyExpense.getTotalExpense());
                monthlyExpenseListResponse.add(monthlyExpenseResponse);
            }
        }

        return monthlyExpenseListResponse;
    }

    @Override
    public List<YearlyExpenseDto> getAllYearlyExpense(Long accountMasterId) {
        return transactionCustomRepository.getAllYearlyExpense(accountMasterId);

    }

    @Override
    public TransactionTotalResponseDto getTotalTransactionsSummary(TransactionTotalRequestDto transactionTotalRequestDto) {

        return switch (transactionTotalRequestDto.getFilterType()) {
            // WEEKLY FILTER
            case "1" -> transactionCustomRepository.getAllTransactionWeekly(transactionTotalRequestDto);
            // MONTHLY FILTER
            case "2" -> transactionCustomRepository.getAllTransactionMonthly(transactionTotalRequestDto);
            // YEARLY FILTER
            case "3" -> transactionCustomRepository.getAllTransactionYearly(transactionTotalRequestDto);
            default -> null;
        };
    }
}