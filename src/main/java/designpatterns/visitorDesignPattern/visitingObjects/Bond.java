package designpatterns.visitorDesignPattern.visitingObjects;

import designpatterns.visitorDesignPattern.visitors.IFinancialVisitor;

public class Bond implements FinancialInstrument{

    private String issuer;
    private double faceValue;

    public Bond(String issuer, double faceValue) {
        this.issuer = issuer;
        this.faceValue = faceValue;
    }

    public String getIssuer() {
        return issuer;
    }

    public double getFaceValue() {
        return faceValue;
    }

    @Override
    public void accept(IFinancialVisitor financialVisitor) {
        financialVisitor.visit(this);
    }
}
