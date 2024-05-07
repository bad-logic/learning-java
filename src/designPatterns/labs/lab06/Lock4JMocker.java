package designPatterns.labs.lab06;

import java.util.HashMap;
import java.util.Map;

public class Lock4JMocker {
    private static Map<String,Lock4JMocker> loggerPool = new HashMap<>();
    private String scope;

    private Lock4JMocker(String scope){
        this.scope = scope;
    }

    public static Lock4JMocker getLogger(String scope){
        loggerPool.putIfAbsent(scope,new Lock4JMocker(scope));
        return loggerPool.get(scope);
    }

    public void debug(Object s){
        System.out.println(this.scope + ":" + java.time.LocalDateTime.now() + " DEBUG: " + s);
    }

    public void error(Object s){
        System.out.println(this.scope + ":" + java.time.LocalDateTime.now() + " ERROR: " + s);
    }

    public void fatal(Object s){
        System.out.println(this.scope + ":" + java.time.LocalDateTime.now() + " FATAL: " + s);
    }

    public void info(String s){
        System.out.println(this.scope + ":" + java.time.LocalDateTime.now() + " INFO: " + s);
    }

    public void trace(String s){
        System.out.println(this.scope + ":" + java.time.LocalDateTime.now() + " TRACE: " + s);
    }

    public void warning(String s){
        System.out.println(this.scope + ":" + java.time.LocalDateTime.now() + " WARNING: " + s);
    }
}
