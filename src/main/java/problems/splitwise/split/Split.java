package problems.splitwise.split;

import lombok.Getter;
import problems.splitwise.user.User;

public class Split {

    @Getter
    private User user;
    @Getter
    private double amount;
    @Getter
    private double percent;

    public Split(User user, double amount, double percent) {
        this.user = user;
        this.amount = amount;
        this.percent = percent;
    }

}
