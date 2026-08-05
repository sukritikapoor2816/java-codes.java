import java.util.ArrayList;

public class ArrayL {6

    public static void main(String[] args) {

        // Create an ArrayList to store tasks
        ArrayList<String> tasks = new ArrayList<>();

        // Add tasks
        tasks.add("Complete Java Assignment");
        tasks.add("Study DSA");
        tasks.add("Submit Lab Record");

        // Display all tasks using StringBuffer
        StringBuffer sb = new StringBuffer();

        sb.append("TO-DO LIST\n");
        sb.append("-----------------\n");

        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + ". ");
            sb.append(tasks.get(i));
            sb.append("\n");
        }

        System.out.println(sb);

        // Remove one task
        tasks.remove(1);

        // Display updated list
        sb = new StringBuffer();

        sb.append("UPDATED TO-DO LIST\n");
        sb.append("---------------------\n");

        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + ". ");
            sb.append(tasks.get(i));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}