package designpatterns.interpreterDesignPattern.expression;


// intermediate node
public class SumExpression implements Expression{

    private Expression leftExpression;
    private Expression rightExpression;

    public SumExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int evaluate() {
        return leftExpression.evaluate()+rightExpression.evaluate();
    }
}
