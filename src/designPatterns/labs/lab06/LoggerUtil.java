package designPatterns.labs.lab06;

public class LoggerUtil {
    private static final Logger logger = new LoggerAdapter(LoggerUtil.class.getSimpleName());

    public void method() {
        logger.log(LogLevel.ERROR,"Logging...");
    }

    public static void main(String[] args) {
        new LoggerUtil().method();
    }

}
