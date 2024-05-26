package designPatterns.compositePattern;

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

    public int getCount(){
        int count =1;

        for (Component cmp : this.components){
            count += cmp.getCount();
        }

        return count;
    }

    public void print(){
        System.out.println("-- drive >> " + this.name);
        for (Component cmp : this.components){
            cmp.print();
        }
    }
}