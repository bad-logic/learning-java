package modernpractises.labs.Lab09.lab09_08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        System.out.println();
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> transFrom2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((x,y)-> x.getValue() - y.getValue())
                .collect(Collectors.toList());
        System.out.println("Query 1: Find all transactions from year 2011 and sort them by value (small to high).");
        System.out.println(transFrom2011);
        System.out.println();
        
        // Query 2: What are all the unique cities where the traders work?
        List<String> cities = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Query 2: What are all the unique cities where the traders work?");
        System.out.println(cities);
        System.out.println();

        // Query 3: Find all traders from Cambridge and sort them by name.
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(x-> x.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("Query 3: Find all traders from Cambridge and sort them by name.");
        System.out.println(traders);
        System.out.println();

        // Query 4: Return a string of all traders names sorted alphabetically.
        List<String> traderNameList = transactions.stream()
                .map(x->x.getTrader().getName())
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println("Query 4: Return a string of all traders names sorted alphabetically.");
        System.out.println(traderNameList);
        System.out.println();

        // Query 5: Are there any trader based in Milan?
        int traderBasedOnMilan = (int) transactions.stream().filter(x -> x.getTrader().getCity()=="Milan").count();
        System.out.println("Query 5: Are there any trader based in Milan?");
        System.out.println(traderBasedOnMilan > 0);
        System.out.println();
   
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        List<Transaction> newTransactions = transactions.stream().map(x-> {
            if(x.getTrader().getCity() == "Milan"){
                x.getTrader().setCity("Cambridge");
            }
            return x;
        }).collect(Collectors.toList());
        System.out.println("Query 6: Update all transactions so that the traders from Milan are set to Cambridge.");
        System.out.println(newTransactions);
        System.out.println();

        // Query 7: What's the highest value in all the transactions?
        int highestValue = transactions.stream().map(Transaction::getValue).max((x,y)->x-y).get();
        System.out.println("Query 7: What's the highest value in all the transactions?");
        System.out.println(highestValue);
        System.out.println();
    }
}
