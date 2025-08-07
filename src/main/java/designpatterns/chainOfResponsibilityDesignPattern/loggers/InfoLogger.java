package designpatterns.chainOfResponsibilityDesignPattern.loggers;

public class InfoLogger extends Logger {
    public InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    @Override
    public void logMessage(int log, String message) {
        if(log == Logger.INFO) {
            printLog("INFO :: ", message);
        } else {
            super.logMessage(log, message);
        }
    }
}
