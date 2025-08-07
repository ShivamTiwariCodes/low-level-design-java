package designpatterns.visitorDesignPattern.visitingObjects;

import designpatterns.visitorDesignPattern.visitors.IFinancialVisitor;

public interface FinancialInstrument {
    void accept(IFinancialVisitor financialVisitor);
}
