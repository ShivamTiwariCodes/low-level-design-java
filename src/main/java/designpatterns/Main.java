package designpatterns;

import designpatterns.abstractFactoryDesignPattern.AbstractFactoryDesignPatternDemo;
import designpatterns.adaptorDesignPattern.AdaptorDesignPatternDemo;
import designpatterns.bridgeDesignPattern.BridgeDesignPatternDemo;
import designpatterns.builderDesignPattern.BuilderDesignPatternDemo;
import designpatterns.chainOfResponsibilityDesignPattern.ChainOfResponsibilityDemo;
import designpatterns.commandDesignPattern.CommandDesignPatternDemo;
import designpatterns.compositeDesignPattern.CompositeDesignPatternDemo;
import designpatterns.decoratorDesignPattern.DecoratorDesignPatternDemo;
import designpatterns.facadeDesignPattern.FacadeDesignPatternDemo;
import designpatterns.factoryDesignPattern.FactoryDeisgnPatternDemo;
import designpatterns.flyweightPattern.FlyweightPatternDemo;
import designpatterns.interpreterDesignPattern.InterpreterDesignPatternDemo;
import designpatterns.iteratorDesignPattern.IteratorDesignPatternDemo;
import designpatterns.mediatorDesignPattern.MediatorDesignPatternDemo;
import designpatterns.momentoDesignPattern.MomentoDesignPatternDemo;
import designpatterns.nullObjectPattern.NullObjectPatternDemo;
import designpatterns.observerDesignPattern.ObserverDesignPatternDemo;
import designpatterns.prototypeDesignPattern.PrototypeDesignPatternDemo;
import designpatterns.proxyDesignPattern.ProxyPatternDemo;
import designpatterns.singletonDesignPattern.SingletonDesignPatternDemo;
import designpatterns.stateDesignPattern.StateDesignPatternDemo;
import designpatterns.strategyDesignPattern.StrategyPattern;
import designpatterns.templateMethodPattern.TemplateMethodPatternDemo;
import designpatterns.visitorDesignPattern.VisitorDesignPatternDemo;

public class Main {
    public static void main(String[] args) {

        final String designPatternName = "ChainOfResponsibilityDemo";

        switch (designPatternName) {
            case "AbstractFactoryDesignPatternDemo":
                new AbstractFactoryDesignPatternDemo().run();
                break;
            case "AdaptorDesignPatternDemo":
                new AdaptorDesignPatternDemo().run();
                break;
            case "BridgeDesignPatternDemo":
                new BridgeDesignPatternDemo().run();
                break;
            case "BuilderDesignPatternDemo":
                new BuilderDesignPatternDemo().run();
                break;
            case "ChainOfResponsibilityDemo":
                new ChainOfResponsibilityDemo().run();
                break;
            case "CommandDesignPatternDemo":
                new CommandDesignPatternDemo().run();
                break;
            case "CompositeDesignPatternDemo":
                new CompositeDesignPatternDemo().run();
                break;
            case "DecoratorDesignPatternDemo":
                new DecoratorDesignPatternDemo().run();
                break;
            case "FacadeDesignPatternDemo":
                new FacadeDesignPatternDemo().run();
                break;
            case "FactoryDeisgnPatternDemo":
                new FactoryDeisgnPatternDemo().run();
                break;
            case "FlyweightPatternDemo":
                new FlyweightPatternDemo().run();
                break;
            case "InterpreterDesignPatternDemo":
                new InterpreterDesignPatternDemo().run();
                break;
            case "IteratorDesignPatternDemo":
                new IteratorDesignPatternDemo().run();
                break;
            case "MediatorDesignPatternDemo":
                new MediatorDesignPatternDemo().run();
                break;
            case "MomentoDesignPatternDemo":
                new MomentoDesignPatternDemo().run();
                break;
            case "NullObjectPatternDemo":
                new NullObjectPatternDemo().run();
                break;
            case "ObserverDesignPatternDemo":
                new ObserverDesignPatternDemo().run();
                break;
            case "PrototypeDesignPatternDemo":
                new PrototypeDesignPatternDemo().run();
                break;
            case "ProxyPatternDemo":
                new ProxyPatternDemo().run();
                break;
            case "SingletonDesignPatternDemo":
                new SingletonDesignPatternDemo().run();
                break;
            case "StateDesignPatternDemo":
                new StateDesignPatternDemo().run();
                break;
            case "StrategyPattern":
                new StrategyPattern().run("bitcoin");
                new StrategyPattern().run("cash");
                break;
            case "TemplateMethodPatternDemo":
                new TemplateMethodPatternDemo().run();
                break;
            case "VisitorDesignPatternDemo":
                new VisitorDesignPatternDemo().run();
                break;
            default:
                System.out.println("Please choose the correct design pattern. Provided is : " + designPatternName);

        }
    }
}
