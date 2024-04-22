package poolDemo;

import java.util.HashMap;
import java.util.Objects;

public final class MyPair{
    // this is not a thread safe implementation
    private static final HashMap<MyPair,MyPair> POOL_RESOURCE = new HashMap<>();

    private final int x;
    private final int y;

    MyPair(int a, int b){
        this.x = a;
        this.y = b;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public MyPair usePool(){
        MyPair.POOL_RESOURCE.putIfAbsent(this,this);
        return MyPair.POOL_RESOURCE.get(this);
    }

    @Override
    public boolean equals(Object o){
        if(this.getClass() != o.getClass()) return false;
        MyPair myPair = (MyPair) o;
        return this.x == myPair.x && this.y == myPair.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.x,this.y);
    }

    @Override
    public String toString(){
        return "MyPair (" + this.x + ", " + this.y + ")";
    }
}