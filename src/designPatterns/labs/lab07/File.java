package designPatterns.labs.lab07;

public class File implements Component{
    protected String name;
    protected long sizeInBytes;

    public File(String name, long sizeInBytes) {
        this.name = name;
        this.sizeInBytes = sizeInBytes;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    public void print(){
        System.out.println("--- file "+this.name+" size="+this.sizeInBytes+" bytes");
    }

}