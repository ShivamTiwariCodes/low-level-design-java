package problems.splitwise.balance;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {

    @Getter @Setter
    private double totalExpense;
    @Getter @Setter
    private double totalPaid;
    @Getter @Setter
    private double totalYouOwe;
    @Getter @Setter
    private double totalYouGetBack;
    @Getter
    private Map<Integer, Balance> balanceMap;

    public UserBalanceSheet() {
        totalExpense = 0;
        totalPaid = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
        balanceMap = new HashMap<>();
    }


}
