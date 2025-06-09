package problems.splitwise.expense;

import lombok.Getter;
import problems.splitwise.split.Split;
import problems.splitwise.user.User;

import java.util.List;

public class Expense {

    @Getter
    private int id;
    @Getter
    private double amount;
    @Getter
    private String description;
    @Getter
    private User payingUser;
    @Getter
    private List<Split> splits;

    public Expense(int id, String description, double amount, User payingUser, List<Split> splits) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.payingUser = payingUser;
        this.splits = splits;
    }
}
