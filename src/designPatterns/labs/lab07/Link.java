package designPatterns.labs.lab07;

public class Link extends File{
    private String link;

    Link(String name, String link, long size){
        super(name,size);
        this.link = link;
    }

    /**
     *
     */
    @Override
    public void print() {
        System.out.println("--link "+ this.name + "link=" + this.link + " size=" + this.sizeInBytes +"bytes");
    }

}
