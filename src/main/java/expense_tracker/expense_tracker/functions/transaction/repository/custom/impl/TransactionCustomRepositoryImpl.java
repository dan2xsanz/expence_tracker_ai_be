package expense_tracker.expense_tracker.functions.transaction.repository.custom.impl;

import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionGetAllDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.DailyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.MonthlyExpenseDto;
import expense_tracker.expense_tracker.functions.transaction.dto.reports.YearlyExpenseDto;
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

    public List<YearlyExpenseDto> getAllYearlyExpense() {
        String mainQuery = "SELECT " +
                "    MONTHNAME(STR_TO_DATE(CONCAT('2024-', LPAD(m.month, 2, '0'), '-01'), '%Y-%m-%d')) AS transactionMonth, " +
                "    COALESCE(SUM(CASE WHEN t.transactionType = 'IN' THEN t.amountValue ELSE 0 END), 0) AS transactionIn, " +
                "    COALESCE(SUM(CASE WHEN t.transactionType = 'OUT' THEN t.amountValue ELSE 0 END), 0) AS transactionOut " +
                "FROM ( " +
                "    SELECT 1 AS month UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL\n" +
                "    SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL\n" +
                "    SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL\n" +
                "    SELECT 10 UNION ALL SELECT 11 UNION ALL SELECT 12\n" +
                ") AS m " +
                "LEFT JOIN bmo_db.transactionmaster t  " +
                "    ON MONTH(t.date) = m.month " +
                "    AND YEAR(t.date) = YEAR(CURRENT_DATE()) " +
                "GROUP BY m.month " +
                "ORDER BY m.month;";

        return jdbcTemplate.query(mainQuery, new BeanPropertyRowMapper<>(YearlyExpenseDto.class));
    }
}