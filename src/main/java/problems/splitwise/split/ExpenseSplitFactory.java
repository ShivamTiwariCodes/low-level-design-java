package problems.splitwise.split;

public class ExpenseSplitFactory {

    public static ExpenseSplit getExpenseSplit(ExpenseSplitType expenseSplitType) {
        switch (expenseSplitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case PERCENT:
                return new PercentExpenseSplit();
            case EXACT:
                return new ExactExpenseSplit();
            default:
                System.out.println("Choose expense split type from available options.");
        }
        return null;
    }
}
