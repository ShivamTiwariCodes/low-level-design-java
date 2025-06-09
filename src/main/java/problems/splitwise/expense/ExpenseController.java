package problems.splitwise.expense;

import problems.splitwise.balance.BalanceSheetController;
import problems.splitwise.split.ExpenseSplit;
import problems.splitwise.split.ExpenseSplitFactory;
import problems.splitwise.split.ExpenseSplitType;
import problems.splitwise.split.Split;
import problems.splitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class ExpenseController {


    private BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(int id, String description, double amount, User user, List<Split> splits, ExpenseSplitType expenseSplitType) {

        ExpenseSplit expenseSplit = ExpenseSplitFactory.getExpenseSplit(expenseSplitType);
        expenseSplit.validate(splits, amount);
        Expense expense = new Expense(id, description, amount, user, splits);
        balanceSheetController.updateBalances(expense);
        return expense;
    }

}

