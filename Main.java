import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        File candidateFile = new File("D:/F/My PROGRAMMING Codes/Java/DAILY_PRACTICE/oop_project1/files/candidate.txt");
        ArrayList<Object_Candidate> candidate = new ArrayList<>();
        ArrayList<Object_Voter> voter = new ArrayList<>();
        Scanner sc, in = new Scanner(System.in);

        String firstName, lastName, initial, suffix, votedPres, votedVp, votedSenate[] = new String[12];
        int input, age;

        while (true) {
            System.out.println("\nOOP Project 1 : Voting System\n");
            System.out.println("1 - Show All Candidates");
            System.out.println("2 - Vote Candidates");
            System.out.println("3 - Fill a Candidacy");
            System.out.println("4 - Show Voting Logs");
            System.out.println("5 - Show Final Result");
            System.out.println("6 - Load Existing Value");
            System.out.println("7 - Clear Data");
            System.out.println("8 - Exit");
            System.out.print("\nOption: ");
            input = in.nextInt();

            if (input == 1) {
                sc = new Scanner(candidateFile);
                if (!sc.hasNextLine()) {
                    System.out.println("Note: No data loaded.");
                } else {
                    System.out.println("\nAll Candidate from File");
                    while (sc.hasNextLine())
                        System.out.println(sc.nextLine());
                }
            }

            if (input == 2) {
                if (candidate.size() == 0) {
                    System.out.println("No Candidate to Vote, Please load or Fill candidacy.");
                } else {
                    System.out.println("\nVote Candidates");

                    System.out.print("Enter Age: ");
                    age = in.nextInt();

                    if (age <= 17) {
                        System.out.println("Invalid");
                    } else {
                        System.out.print("Enter First Name: ");
                        firstName = in.nextLine();
                        System.out.print("Enter Last Name: ");
                        lastName = in.nextLine();
                        System.out.print("Enter Initial (press enter if none): ");
                        initial = in.nextLine();
                        System.out.print("Enter Suffix (press enter if none): ");
                        suffix = in.nextLine();

                        System.out.print("Enter President of Choice: ");
                        votedPres = in.nextLine();

                        System.out.print("Enter Vice President of Choice: ");
                        votedVp = in.nextLine();

                        votedSenate[0] = "Pres1";
                        votedSenate[1] = "Pres2";
                        votedSenate[2] = "Pres3";

                        voter.add(new Object_Voter(firstName, lastName, initial, suffix, age, votedPres, votedVp,
                                votedSenate));

                    }
                }
            }

            if (input == 3) {
                System.out.println("\nCandidacy Form");

            }

            if (input == 4) {
                System.out.println("\nVoting Logs");
            }

            if (input == 5) {
                System.out.println("\nFinal Result");
            }

            if (input == 6) {
                System.out.println("\nNote: The Data is now Loaded, Ready for Voting.");
            }

            if (input == 7) {
                System.out.println("\nNote: Data is now Clear.");
            }

            if (input == 8) {
                System.out.println("\nThank you for using the program.");
                break;
            }
        }
        in.close();
    }
}