package designpatterns.interpreterDesignPattern.expression;


// Intermediate node
public class MultiplyExpression implements Expression{

    private Expression leftExpression;
    private Expression rightExpression;

    public MultiplyExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int evaluate() {
        return leftExpression.evaluate()*rightExpression.evaluate();
    }
}
