### Put an adapter between the Logger class and an actual implementation of a logger. Here is the "target" interface.

```java

public interface Logger {
    void log(LogLevel logLevel, String message);
}
```

where
```java

public enum LogLevel {
    DEBUG, ERROR, FATAL, INFO, TRACE, WARNING
}
```

Provide an implementation of this adapter (call it LoggerAdapter) that uses Apache Log4j as "adaptee". Then connect the whole thing to your existing code.

Hint: To use Log4j 2.0, you need to add the following dependencies to your Maven `pom.xml` file:

        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.9.1</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.9.1</version>
        </dependency>

and then use the logger as follows:

    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    @Override
    public void method() {
            logger.error("Logging...");

    }