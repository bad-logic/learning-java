package designPatterns.labs.lab07;

import java.util.ArrayList;
import java.util.Collection;

public class Drive implements Component {
    protected String name;
    protected Collection<Component> components = new ArrayList<Component>();

    public Drive(String name) {
        this.name = name;
    }

    @Override
    public void addComponent(Component cmp){
        this.components.add(cmp);
    }

    public long getSizeInBytes(){
        long sizeInBytes=0;

        for (Component cmp : this.components){
            sizeInBytes+= cmp.getSizeInBytes();
        }

        return sizeInBytes;
    }

    public void print(){
        System.out.println("- drive "+this.name);
        for (Component cmp : this.components) {
            cmp.print();
        }
    }
}