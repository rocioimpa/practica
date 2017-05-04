import java.lang.Math;
import java.util.Scanner;

public class SuperSimpleStockMarket {

  private static Scanner scanner;

  public static void main(String[] args) {    

    showMenu();

    Scanner scanner = new Scanner(System.in);
    String chosenOption;

    boolean repeat = true;
    while (repeat && scanner.hasNextLine()){
      chosenOption = scanner.nextLine();
      System.out.println(chosenOption);
      int value = Integer.parseInt(chosenOption);

      if(value == 0){
        scanner.close();
        System.exit(0);
        repeat = false;
      }
      if(value == 1){
        System.out.println("User's choice was 1: Calculate dividend yield");    
        getAndValidateStockSymbol(); 
        getAndValidateStockPrice();
      }
      if(value == 2){
        System.out.println("User's choice was 2: Calculate P/E ratio");
        getAndValidateStockSymbol();
        getAndValidateStockPrice();
      }
      if(value == 3){
        System.out.println("User's choice was 3: Record a trade");
        getAndValidateTradeParameters();
      }
      if(value == 4){
        System.out.println("User's choice was 4: Calculate Volume Weighted Stock");

      }
      showMenu();
    }

    System.out.println("Exiting application...");

    //Stock aStock = new Stock("POP","Common",8,0,100);
    
    //System.out.println(aStock.getStockSymbol());
    //System.out.println(aStock.calculateDividendYield(0.75));
    //System.out.println(aStock.calculateRatio(0.75));
  }

  private static void showMenu(){
    System.out.println("Select desired option:");
    System.out.println("1: Calculate dividend yield");
    System.out.println("2: Calculate P/E ratio");
    System.out.println("3: Record a trade");
    System.out.println("4: Calculate Volume Weighted Stock");
    System.out.println("0: Quit");
  }

  private static void getAndValidateStockPrice(){

  }

  private static void getAndValidateStockSymbol(){

  }

  private static void getAndValidateTradeParameters(){
    
  }
}

public class Trade{

  private String tradeTimestamp = "";
  private double tradeQuantity = 0;
  private String tradeIndicator = "";
  private double tradePrice = 0;

  public Trade(String timestamp, double quantity, String indicator, double price){
    tradeTimestamp = timestamp;
    tradeQuantity = quantity;
    tradeIndicator = indicator;
    tradePrice = price; 
  }
  
  public String getTimestamp(){
    return tradeTimestamp;
  }

  public double getTradeQuantity(){
    return tradeQuantity;
  }

  public String getTradeIndicator(){
    return tradeIndicator;
  }

  public double getTradePrice(){
    return tradePrice;
  }
}

public class Stock{

  private String stockSymbol = "";
  private String stockType = "";
  private int stockLastDividend = 0;
  private double stockFixedDividend = 0;
  private int stockParValue = 0;

  public Stock(String symbol, String type, int lastDividend, double fixedDividend, int parValue) {
    stockSymbol = symbol;
    stockType = type;
    stockLastDividend = lastDividend;
    stockFixedDividend = fixedDividend;
    stockParValue = parValue;
  }

  public String getStockSymbol(){
    return stockSymbol;
  }

  public String getStockType(){
    return stockType;
  }

  public int getStockLastDividend(){
    return stockLastDividend;
  }

  public double getStockFixedDividend(){
    return stockFixedDividend;
  }

  public int getStockParValue(){
    return stockParValue;
  }

  public double calculateDividendYield(double price){
    try {
      double dividendYield = (stockLastDividend/price);
      return dividendYield;
    } catch(ArithmeticException e){
      System.out.println("Error: " + e);
      return 0;
    }
  }

  public double calculateRatio(double price){
    try {
      double ratio = (price/calculateDividendYield(price)); 
      return ratio;
    } catch(ArithmeticException e){
      System.out.println("Error: " + e);
      return 0;      
    }
  }
}