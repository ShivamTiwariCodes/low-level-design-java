package designpatterns.visitorDesignPattern.visitingObjects;

import designpatterns.visitorDesignPattern.visitors.IFinancialVisitor;

public class Options implements FinancialInstrument{

    private String optionType;
    private double strikePrice;

    public Options(String optionType, double strikePrice) {
        this.optionType = optionType;
        this.strikePrice = strikePrice;
    }


    public String getOptionType() {
        return optionType;
    }

    public double getStrikePrice() {
        return strikePrice;
    }

    @Override
    public void accept(IFinancialVisitor financialVisitor) {
        financialVisitor.visit(this);
    }
}
