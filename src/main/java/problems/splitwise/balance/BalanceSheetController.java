package problems.splitwise.balance;


import problems.splitwise.expense.Expense;
import problems.splitwise.split.Split;
import problems.splitwise.user.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {

    public void updateBalances(Expense expense) {

        User payingUser = expense.getPayingUser();

        UserBalanceSheet payingUserBalanceSheet = payingUser.getUserBalanceSheet();
        payingUserBalanceSheet.setTotalPaid(payingUserBalanceSheet.getTotalPaid() + expense.getAmount());

        List<Split> splitList = expense.getSplits();
        for(Split split: splitList) {
            User user = split.getUser();

            if(user.getId() != payingUser.getId()) {
                Balance balance = payingUserBalanceSheet.getBalanceMap().getOrDefault(user.getId(), new Balance());
                balance.setAmountToGet(balance.getAmountToGet() + split.getAmount());
                payingUserBalanceSheet.getBalanceMap().put(user.getId(), balance);
                payingUserBalanceSheet.setTotalYouGetBack(payingUserBalanceSheet.getTotalYouGetBack()+ split.getAmount());

                Balance balance2 = user.getUserBalanceSheet().getBalanceMap().getOrDefault(payingUser.getId(), new Balance());
                balance2.setAmountOwe(balance2.getAmountOwe() + split.getAmount());
                user.getUserBalanceSheet().getBalanceMap().put(payingUser.getId(), balance2);
                user.getUserBalanceSheet().setTotalYouOwe(user.getUserBalanceSheet().getTotalYouOwe()+ split.getAmount());
                user.getUserBalanceSheet().setTotalExpense(user.getUserBalanceSheet().getTotalExpense()+ split.getAmount());
            } else {
                payingUserBalanceSheet.setTotalExpense(payingUserBalanceSheet.getTotalExpense() + split.getAmount());
            }
        }
        payingUser.setUserBalanceSheet(payingUserBalanceSheet);
    }

    public void printBalanceSheetOfUser(User user) {
        UserBalanceSheet userBalanceSheet = user.getUserBalanceSheet();
        System.out.println( user.getName());
        System.out.println( "Total expenses : " + userBalanceSheet.getTotalExpense());
        System.out.println( "Total paid : " + userBalanceSheet.getTotalPaid());
        System.out.println( "Total you owe : " + userBalanceSheet.getTotalYouOwe());
        System.out.println( "Total you will get back : " + userBalanceSheet.getTotalYouGetBack());
        Map<Integer, Balance> balances = userBalanceSheet.getBalanceMap();
        for(Map.Entry<Integer, Balance> entry : balances.entrySet()) {
            if(entry.getValue().getAmountOwe() >= entry.getValue().getAmountToGet()) {
                System.out.println(user.getId() + " owes " + entry.getKey() + " : " + (entry.getValue().getAmountOwe() - entry.getValue().getAmountToGet()));
            } else {
                System.out.println(entry.getKey() + " owes " + user.getId() + " : " + (entry.getValue().getAmountToGet() - entry.getValue().getAmountOwe()));
            }
        }
    }
}
