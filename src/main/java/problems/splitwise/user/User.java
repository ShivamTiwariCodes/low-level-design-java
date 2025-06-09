package problems.splitwise.user;

import lombok.Getter;
import lombok.Setter;
import problems.splitwise.balance.UserBalanceSheet;
import problems.splitwise.expense.Expense;
import problems.splitwise.expense.ExpenseController;
import problems.splitwise.split.ExpenseSplitType;
import problems.splitwise.split.Split;

import java.util.ArrayList;
import java.util.List;


public class User {

    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private String email;
    @Getter @Setter
    private UserBalanceSheet userBalanceSheet;
    @Getter
    private List<Expense> expenseList;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userBalanceSheet = new UserBalanceSheet();
        this.expenseList = new ArrayList<>();
    }

    public void createExpense(ExpenseController expenseController, int id, String description, double amount, User payingUser,
                              List<Split> splits, ExpenseSplitType expenseSplitType) {
        expenseList.add(expenseController.createExpense(id, description, amount, payingUser, splits, expenseSplitType));
    }


}
