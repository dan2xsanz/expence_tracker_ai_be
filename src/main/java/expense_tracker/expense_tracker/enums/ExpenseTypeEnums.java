package expense_tracker.expense_tracker.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExpenseTypeEnums {

    BABY_STUFF(0, "Baby Stuff"),
    BILLS(1, "Bills"),
    BUSINESS(2, "Business"),
    CABLE(3, "Cable"),
    CAR(4, "Car"),
    DELIVERY(5, "Delivery"),
    CREDIT(6, "Credit"),
    EDUCATIONAL(7, "Educational"),
    UTILITY_BILL(8, "Utility Bill"),
    FOOD(9, "Food"),
    FOOD_DELIVERY(10, "Food Delivery"),
    FOREIGN(11, "Foreign"),
    FUND(12, "Fund"),
    GAMING(13, "Gaming"),
    GAS(14, "Gas"),
    OTHER(15, "Other");

    private final Integer expenseId;
    private final String expenseName;

    public static String getExpenseName(Integer expenseId) {
        String expenseName = "";

        for (ExpenseTypeEnums enums : ExpenseTypeEnums.values()) {
            if (expenseId.equals(enums.getExpenseId())) {
                expenseName = enums.getExpenseName();
            }
        }

        return expenseName;
    }

}
