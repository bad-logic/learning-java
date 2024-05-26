package designPatterns.labs.lab06.log4j;


public class Log4J {
    private final String scope;

    Log4J(String scope){
        this.scope = scope;
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
