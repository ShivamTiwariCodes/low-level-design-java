package problems.splitwise.split;

import java.util.List;

public interface ExpenseSplit {

    void validate(List<Split> splits, double totalAmount);
}
