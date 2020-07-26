import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
        Scanner scan = null;
        boolean running = true;
        String line = null;
        Queue<String> buff = new LinkedList<>();

        try {
            scan = new Scanner(System.in);
            run(scan, buff);
        } catch (Exception e) {
            // blind catch
            System.out.println("Could not start scanner.");
        }
        try {
            scan.close();
        } catch (Exception e) {
            //blind
        }
    }

    public static void run(Scanner scan, Queue<String> buff) {
        boolean running = true;
        String line, begin;

        while (running) {
            line = getInput(scan);
            begin = line.substring(0, 1).toUpperCase();

            if (begin.equals("O")) {
                line = extract(buff);
                System.out.println(line);
            } else if (begin.equals("X")) {
                running = false;
            } else {
                buff.add(line);
            }
        }
    }

    public static String extract(Queue<String> buff) {
        if (buff.size() == 0) {
            return "Buffer empty.";
        }
        return "Data: " + buff.remove();
    }

    public static String getInput(Scanner scan) {
        String in = new String();
        try {
            in = scan.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid.");
        }
        return in;
    }
}
