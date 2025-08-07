package designpatterns.interpreterDesignPattern.expression;


// leaf node
public class NumberExpression implements Expression{

    private int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
