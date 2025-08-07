package designpatterns.chainOfResponsibilityDesignPattern.loggers;

public class DebugLogger extends Logger{
    public DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void logMessage(int log, String message) {
        if(log == Logger.DEBUG) {
            printLog("DEBUG :: ", message);
        } else {
            super.logMessage(log, message);
        }
    }
}
