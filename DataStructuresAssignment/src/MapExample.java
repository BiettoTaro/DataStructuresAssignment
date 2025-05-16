import java.util.HashMap;
import java.util.Map;

// Define an enum to represent a set of students
enum Student {
    RAM, RAVI, RAJU, KUMAR
}

public class MapExample {
    public static void main(String[] args) {
        // Create a HashMap to store student names (as enum constants) and their marks
        Map<Student, Integer> students = new HashMap<>();

        // Add key-value pairs to the map
        students.put(Student.RAM, 50);
        students.put(Student.RAVI, 60);
        students.put(Student.RAJU, 70);
        students.put(Student.KUMAR, 80);

        // Print the entire map: shows all key-value pairs
        System.out.println(students);
        // Output example: {RAM=50, RAVI=60, RAJU=70, KUMAR=80}

        // Remove RAJU from the map and print the removed value
        System.out.println(students.remove(Student.RAJU));
        // Expected output: 70

        // Check if RAM is a key in the map
        boolean checkKey = students.containsKey(Student.RAM);
        System.out.println(checkKey);
        // Expected output: true

        // Get and print KUMAR's marks
        System.out.println(students.get(Student.KUMAR));
        // Expected output: 80

        // Print all keys in the map (i.e., the remaining students)
        System.out.println(students.keySet());
        // Expected output: [RAM, RAVI, KUMAR]
//
        // Iterate through all entries and print each student's name and marks
        for (Student key : students.keySet()) {
            System.out.println(key + " : " + students.get(key));
            // Expected output:
            // RAM : 50
            // RAVI : 60
            // KUMAR : 80
        }

        // Assign KUMAR's marks to a variable and print it
        int kumarMarks = students.get(Student.KUMAR);
        System.out.println("kumar marks: " + kumarMarks);
        // Expected output: kumar marks: 80
    }
}
