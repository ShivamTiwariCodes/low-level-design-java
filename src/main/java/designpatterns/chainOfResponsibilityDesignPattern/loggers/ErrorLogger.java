package designpatterns.chainOfResponsibilityDesignPattern.loggers;

public class ErrorLogger extends Logger{
    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void logMessage(int log, String message) {
        if(log == Logger.ERROR) {
            printLog("ERROR :: ", message);
        } else {
            super.logMessage(log, message);
        }
    }
}
