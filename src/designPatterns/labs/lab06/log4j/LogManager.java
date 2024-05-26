package designPatterns.labs.lab06.log4j;

import java.util.HashMap;
import java.util.Map;

public class LogManager {
    private static final Map<String, Log4J> loggerPool = new HashMap<>();

    private LogManager(){}

    public static Log4J getLogger(String scope){
        loggerPool.computeIfAbsent(scope, Log4J::new);
        return loggerPool.get(scope);
    }
}
