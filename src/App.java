
public class App {
    public static void main(String[] args) throws Exception {
        // Make a hashtable.
        // Try to put 10 things in it.
        // Try to get 10 out.
        var table = new HashTable<Integer, Integer>();
        for (int i = 0; i < 20; i++) {
            table.insert(i, i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(i + ": " + table.lookup(i));
        }
    }
}