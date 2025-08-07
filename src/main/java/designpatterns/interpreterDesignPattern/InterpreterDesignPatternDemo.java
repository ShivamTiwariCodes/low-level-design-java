package designpatterns.interpreterDesignPattern;

import designpatterns.interpreterDesignPattern.expression.Expression;
import designpatterns.interpreterDesignPattern.expression.MultiplyExpression;
import designpatterns.interpreterDesignPattern.expression.NumberExpression;
import designpatterns.interpreterDesignPattern.expression.SumExpression;

public class InterpreterDesignPatternDemo {

    public void run() {

        //    2*(5+(3*4)) = 34
        Expression expression = new MultiplyExpression(new NumberExpression(2),
                new SumExpression(new NumberExpression(5),
                        new MultiplyExpression(new NumberExpression(3), new NumberExpression(4))));
        System.out.println("Result of expression is : " + expression.evaluate());

    }

}
