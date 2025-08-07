package designpatterns.visitorDesignPattern.visitingObjects;

import designpatterns.visitorDesignPattern.visitors.IFinancialVisitor;

public class Stock implements FinancialInstrument{

    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(IFinancialVisitor financialVisitor) {
        financialVisitor.visit(this);
    }
}
