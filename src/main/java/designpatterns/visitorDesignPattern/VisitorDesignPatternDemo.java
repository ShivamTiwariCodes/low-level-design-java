package designpatterns.visitorDesignPattern;

import designpatterns.visitorDesignPattern.visitingObjects.Bond;
import designpatterns.visitorDesignPattern.visitingObjects.FinancialInstrument;
import designpatterns.visitorDesignPattern.visitingObjects.Options;
import designpatterns.visitorDesignPattern.visitingObjects.Stock;
import designpatterns.visitorDesignPattern.visitors.IFinancialVisitor;
import designpatterns.visitorDesignPattern.visitors.PricingVisitor;
import designpatterns.visitorDesignPattern.visitors.RiskAssesmentVisitor;


//separate algorithms from the objects on which they operate.
//It allows you to add further operations to objects without modifying them,
//thus adhering to the open/closed principle.
public class VisitorDesignPatternDemo {

    public void run() {

        IFinancialVisitor priceVisitor = new PricingVisitor();
        IFinancialVisitor riskAssesmentVisitor = new RiskAssesmentVisitor();

        FinancialInstrument[] financialInstruments = new FinancialInstrument[] {
                new Bond("Bond-issuer", 10),
                new Stock("Stock-1", 20),
                new Options("Option-type-1", 30)
        };


        for(FinancialInstrument financialInstrument: financialInstruments) {
            financialInstrument.accept(priceVisitor);
        }

        for(FinancialInstrument financialInstrument: financialInstruments) {
            financialInstrument.accept(riskAssesmentVisitor);
        }

    }
}
