package problems.splitwise;

import problems.splitwise.balance.BalanceSheetController;
import problems.splitwise.expense.ExpenseController;
import problems.splitwise.split.ExpenseSplitType;
import problems.splitwise.split.Split;
import problems.splitwise.user.User;
import problems.splitwise.user.UserController;

import java.util.ArrayList;
import java.util.List;

public class SplitwiseDemo {


//    User action possible : create/join group , add expenses ( group or individual ), choose split options, settle debts, expense category and notification
//    Group operations : group creation, group expenses, group balances, simplify debts, export data

//    ADD_USER, ADD_EXPENSE, ADD_GROUP, SHOW, SHOW_USER, SHOW_GROUP

//    ADD_USER 101 user1 user1@gmail.com
//    ADD_USER 102 user2 user2@gmail.com
//    ADD_USER 103 user3 user3@gmail.com
//    ADD_USER 104 user4 user4@gmail.com
//    ADD_GROUP 1001 group1 101
//    ADD_EXPENSE EXACT Shopping u1 amount 2 userId1 userId2 amount1 amount2





    private int expenseId = 1001;

    private UserController userController;
    private BalanceSheetController balanceSheetController;
    private ExpenseController expenseController;

    public SplitwiseDemo() {
        this.userController = new UserController();
        this.balanceSheetController = new BalanceSheetController();
        this.expenseController = new ExpenseController();
    }


    public void runDemo(List<String> commands) {

        for(String command: commands) {
            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                case "ADD_USER":
                    userController.addUser(new User(Integer.parseInt(commandArr[1]), commandArr[2], commandArr[3]));
                    break;
                case "ADD_EXPENSE":
                    addExpense(commandArr);
                    break;
                case "SHOW":
                    if(commandArr.length == 2) {
                        balanceSheetController.printBalanceSheetOfUser(userController.getUserById(Integer.parseInt(commandArr[1])));
                    } else {
                        List<User> userList = userController.getUsers();
                        for(User user: userList) {
                            balanceSheetController.printBalanceSheetOfUser(user);
                        }
                    }
                    break;
                default:
                    System.out.println("Give the command with correct prefix");
            }
        }



    }

//    ADD_EXPENSE INDIVIDUAL Shopping u1 amount 2 101 102
//    ADD_EXPENSE EXACT Shopping u1 amount 2 userId1 userId2 amount1 amount2
    private void addExpense(String[] commands) {
        List<Split> splitList = new ArrayList<>();
        User payingUser = userController.getUserById(Integer.parseInt(commands[3]));
        ExpenseSplitType expenseSplitType = ExpenseSplitType.EXACT;
        int count;
        double amount;
        switch (commands[1]) {
            case "INDIVIDUAL":
                Split split = new Split(payingUser, Integer.parseInt(commands[4]), 0);
                splitList.add(split);
                expenseSplitType = ExpenseSplitType.EXACT;
                break;
            case "EQUAL":
                count = Integer.parseInt(commands[5]);
                amount = Double.parseDouble(commands[4]);
                expenseSplitType = ExpenseSplitType.EQUAL;
                for(int i=0; i<count; i++) {
                    splitList.add(new Split(userController.getUserById(Integer.parseInt(commands[6+i])),
                            amount/((double) count), 0));
                }
                break;
            case "EXACT":
                expenseSplitType = ExpenseSplitType.EXACT;
                count = Integer.parseInt(commands[5]);
                amount = Double.parseDouble(commands[4]);
                for(int i=0; i<count; i++) {
                    splitList.add(new Split(userController.getUserById(Integer.parseInt(commands[6+i])),
                            Double.parseDouble(commands[6+i+count]), 0));
                }
                break;
            case "PERCENT":
                count = Integer.parseInt(commands[5]);
                amount = Double.parseDouble(commands[4]);
                for(int i=0; i<count; i++) {
                    splitList.add(new Split(userController.getUserById(Integer.parseInt(commands[6+i])),
                            amount*(Double.parseDouble(commands[6+i+count])/(double) 100), Double.parseDouble(commands[6+i+count])));
                }
                expenseSplitType = ExpenseSplitType.PERCENT;
                break;
            default:
                System.out.println("Provide correct expense type.");
                return;
        }
        payingUser.createExpense(expenseController, expenseId++, commands[2], Integer.parseInt(commands[4]), payingUser,
                splitList, expenseSplitType);
    }



}


//SHOW
//SHOW u1
//EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
//SHOW u4
//SHOW u1
//EXPENSE u1 1250 2 u2 u3 EXACT 370 880
//SHOW
//EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
//SHOW u1
//SHOW
