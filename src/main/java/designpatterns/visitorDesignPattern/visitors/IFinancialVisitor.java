package designpatterns.visitorDesignPattern.visitors;

import designpatterns.visitorDesignPattern.visitingObjects.Bond;
import designpatterns.visitorDesignPattern.visitingObjects.Options;
import designpatterns.visitorDesignPattern.visitingObjects.Stock;

import javax.swing.text.html.Option;

public interface IFinancialVisitor {

    void visit(Stock stock);
    void visit(Bond bond);
    void visit(Options options);
}
