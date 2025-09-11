package expense_tracker.expense_tracker.functions.incomecategory.service.impl;

import expense_tracker.expense_tracker.functions.incomecategory.dto.IncomeCategoryDto;
import expense_tracker.expense_tracker.functions.incomecategory.repository.IncomeCategoryRepository;
import expense_tracker.expense_tracker.functions.incomecategory.service.IncomeCategoryService;
import expense_tracker.expense_tracker.model.AccountMaster;
import expense_tracker.expense_tracker.model.IncomeCategory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeCategoryServiceImpl implements IncomeCategoryService {

    @Autowired
    private IncomeCategoryRepository incomeCategoryRepository;

    @Override
    public void uploadIncomeCategory(IncomeCategoryDto incomeCategoryDto, AccountMaster accountMaster) {

        IncomeCategory incomeCategory = new IncomeCategory();

        Optional<IncomeCategory> income = incomeCategoryRepository.findIncomeCategoryByGuid(incomeCategoryDto.getIncomeGuid());

        if (income.isPresent()) {
            BeanUtils.copyProperties(incomeCategoryDto, incomeCategory);
            incomeCategory.setId(income.get().getId());
        } else {
            BeanUtils.copyProperties(incomeCategoryDto, incomeCategory);
        }

        incomeCategory.setAccountMaster(accountMaster);
        incomeCategoryRepository.save(incomeCategory);
    }

    @Override
    public List<IncomeCategoryDto> downloadIncomeCategory(AccountMaster accountMaster) {

        List<IncomeCategoryDto> incomeCategoryListResponse = new ArrayList<>();

        List<IncomeCategory> incomeCategoryList = incomeCategoryRepository.findAllIncomeCategoryByAccounts(accountMaster.getEmail());

        if (!ObjectUtils.isEmpty(incomeCategoryList)) {

            for (IncomeCategory income : incomeCategoryList) {
                IncomeCategoryDto incomeCategoryDto = new IncomeCategoryDto();
                BeanUtils.copyProperties(income, incomeCategoryDto);

                incomeCategoryDto.setCategoryName(income.getName());
                incomeCategoryListResponse.add(incomeCategoryDto);
            }
        }

        return incomeCategoryListResponse;
    }
}
