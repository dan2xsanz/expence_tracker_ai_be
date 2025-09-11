package expense_tracker.expense_tracker.functions.expensecategory.service.impl;

import expense_tracker.expense_tracker.functions.expensecategory.dto.ExpenseCategoryDto;
import expense_tracker.expense_tracker.functions.expensecategory.repository.ExpenseCategoryRepository;
import expense_tracker.expense_tracker.functions.expensecategory.service.ExpenseCategoryService;
import expense_tracker.expense_tracker.model.AccountMaster;
import expense_tracker.expense_tracker.model.ExpenseCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    @Override
    public void uploadExpenseCategory(ExpenseCategoryDto expenseCategoryDto, AccountMaster accountMaster) {

        ExpenseCategory expenseCategory = new ExpenseCategory();

        Optional<ExpenseCategory> expense = expenseCategoryRepository.findExpenseCategoryByGuid(expenseCategoryDto.getExpenseGuid());

        if (expense.isPresent()) {
            BeanUtils.copyProperties(expenseCategoryDto, expenseCategory);
            expenseCategory.setId(expense.get().getId());
        } else {
            BeanUtils.copyProperties(expenseCategoryDto, expenseCategory);
        }

        expenseCategory.setAccountMaster(accountMaster);
        expenseCategoryRepository.save(expenseCategory);
    }

    @Override
    public List<ExpenseCategoryDto> downloadExpenseCategory(AccountMaster accountMaster) {

        List<ExpenseCategoryDto> expenseCategoryListResponse = new ArrayList<>();

        List<ExpenseCategory> expenseCategoryList = expenseCategoryRepository.findAllExpenseCategoryByAccounts(accountMaster.getEmail());

        if (!ObjectUtils.isEmpty(expenseCategoryList)) {

            for (ExpenseCategory expense : expenseCategoryList) {
                ExpenseCategoryDto expenseCategoryDto = new ExpenseCategoryDto();
                BeanUtils.copyProperties(expense, expenseCategoryDto);

                expenseCategoryDto.setExpenceName(expense.getName());
                expenseCategoryListResponse.add(expenseCategoryDto);
            }
        }

        return expenseCategoryListResponse;
    }
}
