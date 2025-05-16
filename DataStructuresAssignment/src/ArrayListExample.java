import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList of Integer
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add integer values to the ArrayList
        numbers.add(10);
        numbers.add(55);
        numbers.add(32);
        numbers.add(75);
        numbers.add(48);
        numbers.add(90);

        // Create an Iterator to traverse the list
        Iterator<Integer> iterator = numbers.iterator();

        System.out.println("Elements less than 50:");

        // Iterate through the list and display values less than 50
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (value < 50) {
                System.out.println(value);
            }
        }
    }
}
