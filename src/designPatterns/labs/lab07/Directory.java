package designPatterns.labs.lab07;

public class Directory extends Drive{

    public Directory(String name) {
        super(name);
    }

    public void print(){
        System.out.println("-- dir " + this.name+" size=" + this.getSizeInBytes()+" bytes");
        for (Component cmp : this.components){
            cmp.print();
        }
    }
}