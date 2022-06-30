import java.util.Scanner;

public class test {

    static Scanner in = new Scanner(System.in);

    static void Vote() {

        System.out.print("Enter Age: ");
        String age = in.nextLine();
        // age.isEmpty() ||
        if (!age.matches("[0-9]+"))
            return;

        System.out.println("Passed!");
    }

    public static void main(String[] args) {
        Vote();
    }

}
