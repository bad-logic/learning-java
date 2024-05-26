package designPatterns.compositePattern;

public class Directory extends Drive {

    public Directory(String name) {
        super(name);
    }

    public void print(){
        System.out.println("-- dir >> " + this.name);
        for (Component cmp : this.components){
            cmp.print();
        }
    }

}