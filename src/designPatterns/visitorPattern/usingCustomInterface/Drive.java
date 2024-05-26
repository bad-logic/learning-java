package designPatterns.visitorPattern.usingCustomInterface;

import java.util.ArrayList;
import java.util.Collection;

public class Drive implements Component {
    private String name;
    private Collection<Component> components = new ArrayList<Component>();

    public Drive(String name) {
        this.name = name;
    }

    @Override
    public void addComponent(Component cmp){
        this.components.add(cmp);
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    public Collection<Component> getComponents() {
        return this.components;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

        for(Component c: this.components){
            c.accept(visitor);
        }
    }
}