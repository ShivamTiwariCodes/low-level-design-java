package designpatterns.chainOfResponsibilityDesignPattern;

import designpatterns.chainOfResponsibilityDesignPattern.loggers.DebugLogger;
import designpatterns.chainOfResponsibilityDesignPattern.loggers.ErrorLogger;
import designpatterns.chainOfResponsibilityDesignPattern.loggers.InfoLogger;
import designpatterns.chainOfResponsibilityDesignPattern.loggers.Logger;

public class ChainOfResponsibilityDemo {


    public void run() {

        Logger logger = new ErrorLogger(new InfoLogger(new DebugLogger(null)));
        logger.logMessage(Logger.INFO, "This is Info Message.");
        logger.logMessage(Logger.DEBUG, "This is Debug Message.");
        logger.logMessage(Logger.ERROR, "This is Error Message.");
    }
}
