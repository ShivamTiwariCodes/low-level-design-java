package designpatterns.chainOfResponsibilityDesignPattern.loggers;

public abstract class Logger {

    private static final String LOGGER_CLASS_NAME = Logger.class.getName();
    public static int ERROR = 3;
    public static int INFO = 2;
    public static int DEBUG = 1;

    private Logger nextLogger;

    public Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int log, String message) {
        if(nextLogger != null) nextLogger.logMessage(log, message);
    }

    protected void printLog(String level, String message) {
        StackTraceElement caller = getCaller();
        long timestamp = System.currentTimeMillis();

        System.out.printf(
                "[%s] [%d] [%s.%s:%d] - %s\n",
                level,
                timestamp,
                caller.getClassName(),
                caller.getMethodName(),
                caller.getLineNumber(),
                message
        );
    }

    private StackTraceElement getCaller() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        for (StackTraceElement ste : stackTrace) {
            String className = ste.getClassName();
//            walking through the stack trace to find the first non-logger, ( java.lang.Thread.getStackTrace() )
//            — which is the actual business logic that called the logger.
            if (!className.contains("Logger") &&
                    !className.equals(Thread.class.getName())) {
                return ste;
            }
        }

        return stackTrace[stackTrace.length - 1];
    }


}
