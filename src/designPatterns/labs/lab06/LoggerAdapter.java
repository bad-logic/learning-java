package designPatterns.labs.lab06;

public class LoggerAdapter implements Logger{

    private final Lock4JMocker log4j;

    LoggerAdapter(String scope){
        this.log4j = Lock4JMocker.getLogger(scope);
    }

    /**
     * @param logLevel
     * @param message
     */
    @Override
    public void log(LogLevel logLevel, String message) {
        switch (logLevel){
            case DEBUG:
                this.log4j.debug(message);
                break;
            case ERROR:
                this.log4j.error(message);
                break;
            case FATAL:
                this.log4j.fatal(message);
                break;
            case INFO:
                this.log4j.info(message);
                break;
            case TRACE:
                this.log4j.trace(message);
                break;
            case WARNING:
                this.log4j.warning(message);
                break;
            default:
                break;
        }

    }
}
