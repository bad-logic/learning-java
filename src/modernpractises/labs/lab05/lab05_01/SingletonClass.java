package modernpractises.labs.lab05.lab05_01;

public class SingletonClass {

    private static SingletonClass instance;;

    private SingletonClass(){
        this.generateSevenDigitKey();
    }
    private int generateSevenDigitKey(){
        System.out.println("Key generated Successfully ");
        int key = (int) (Math.random() * 10000000);
        System.out.println("Your key to activate Avast anti virus is:"+ key);
        return key;
    }

    public static SingletonClass getSingletonObject(){
        if(SingletonClass.instance == null){
            SingletonClass.instance = new SingletonClass();
            return instance;
        }else{
            System.out.println("Unsuccessful to produce the key....");
            return null;
        }
    }
}
