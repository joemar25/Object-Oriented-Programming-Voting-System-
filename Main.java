import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        Voting v = new Voting();
        String input;

        while (true) {
            v.Menu();
            input = in.nextLine();

            if (input.equals("1"))
                v.PrintAllCandidates();

            if (input.equals("2")) {

            }

            if (input.equals("3")) {
                System.out.println("\nCandidacy Form");

            }

            if (input.equals("4")) {
                System.out.println("\nVoting Logs");
            }

            if (input.equals("5")) {
                System.out.println("\nFinal Result");
            }

            if (input.equals("6"))
                v.LoadData();

            if (input.equals("7"))
                v.ClearAll();

            if (input.equals("8"))
                break;
        }
        v.CloseAll();
        in.close();
    }
}
