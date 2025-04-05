package expense_tracker.expense_tracker.functions.transaction.repository.custom.impl;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.DailyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.MonthlyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.repository.custom.TransactionCustomRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionCustomRepositoryImpl implements TransactionCustomRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TransactionDto> listOfTransaction(TransactionGetAllDto transactionGetAllDto) {

        StringBuilder queryBuilder = new StringBuilder();

        // GET ALL PRODUCT QUERY
        String mainQuery = "SELECT " +
                "id, " +
                "transactionType, " +
                "amountValue, " +
                "categoryType, " +
                "note, " +
                "date, " +
                "time, " +
                "paymentType " +
                "FROM TransactionMaster ";

        queryBuilder.append(mainQuery);

        queryBuilder.append(String.format("WHERE accountMasterId = '%s' ", "1"));

        if (ObjectUtils.isNotEmpty(transactionGetAllDto.getTransactionType())) {
            queryBuilder.append(String.format("AND transactionType = '%s' ", transactionGetAllDto.getTransactionType()));

        }

        if (ObjectUtils.isNotEmpty(transactionGetAllDto.getNote())) {
            queryBuilder.append(String.format("AND note LIKE '%%%s%%' ", transactionGetAllDto.getNote()));

        }

        if (ObjectUtils.isNotEmpty(transactionGetAllDto.getDateFrom()) && ObjectUtils.isNotEmpty(transactionGetAllDto.getDateTo())) {
            queryBuilder.append(String.format("AND date BETWEEN '%s' AND '%s'  ", transactionGetAllDto.getDateFrom(), transactionGetAllDto.getDateTo()));

        }

        // RETRIEVE PAGINATED SALES TRANSACTION SYNCING DTO FROM THE DATABASE
        return jdbcTemplate.query(queryBuilder.toString(), new BeanPropertyRowMapper<>(TransactionDto.class));
    }


    public List<DailyExpenseDto> getAllDailyExpense() {

        String mainQuery = "SELECT " +
                "categoryType as categoryId, " +
                "SUM(amountValue) as amountValue  " +
                "FROM TransactionMaster  " +
                "WHERE date  = CURRENT_DATE GROUP BY categoryType " +
                "ORDER BY categoryType ASC";

        return jdbcTemplate.query(mainQuery, new BeanPropertyRowMapper<>(DailyExpenseDto.class));
    }


    public List<MonthlyExpenseDto> getAllMonthExpense() {
        String mainQuery = "SELECT categoryType as expenseId, null as expenseName,  SUM(amountValue) as totalExpense FROM TransactionMaster " +
                "WHERE  MONTH(date) = MONTH(CURRENT_DATE()) " +
                "AND YEAR(date) = YEAR(CURRENT_DATE) " +
                "AND transactionType = 'OUT' " +
                "GROUP BY categoryType;";

        return jdbcTemplate.query(mainQuery, new BeanPropertyRowMapper<>(MonthlyExpenseDto.class));
    }

}
