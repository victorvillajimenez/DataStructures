public class App {
  public static void main (String[] args) {
    HashTable table = new HashTable(19); // better if you pass a prime number
    
    table.insert("Hello");
    table.insert("Apple");
    table.insert("January");
    table.insert("Water");
    table.insert("Love");
    table.insert("Cats");
    table.insert("Baby");
    table.insert("Day");
    table.insert("Sunday");
    table.insert("Japan");
    table.insert("Europe");
    table.insert("Coffee");
    table.insert("Book");
    table.insert("Cloud");
    
    table.display();
    
    System.out.println(table.find("Love"));
    System.out.println(table.find("Hate"));
    System.out.println(table.find("Book"));
  }
}