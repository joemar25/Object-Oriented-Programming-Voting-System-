import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;

public class Main {

    private ArrayList<Object_Candidate> presList = new ArrayList<>();
    private ArrayList<Object_Candidate> vpList = new ArrayList<>();
    private ArrayList<Object_Candidate> senList = new ArrayList<>();
    private ArrayList<Object_Voter> voter = new ArrayList<>();
    private Scanner scan;
    private String firstName, lastName, initial = "", suffix = "", politicalParty, educationalBackground,
            chosenPosition,
            crimeRecord, votedPres, votedVp, votedSenate[] = new String[12];
    private int input, age, dPres, dVp, dSen;

    void Menu() {
        scan = new Scanner(System.in);
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
        input = scan.nextInt();
        // try
    }

    void Sort(ArrayList<Object_Candidate> list) {
        if (list.size() == 0)
            return;
        Collections.sort(list, new Comparator<Object_Candidate>() {
            public int compare(Object_Candidate c1, Object_Candidate c2) {
                return c1.getLastName().compareTo(c2.getLastName());
            }
        });
    }

    void LoadData() throws Exception {
        File file = new File("files/candidate.txt");
        scan = new Scanner(file);
        while (scan.hasNextLine()) {
            scan.findInLine(": ");
            lastName = scan.nextLine();

            scan.findInLine(": ");
            firstName = scan.nextLine();

            scan.findInLine(": ");
            initial = scan.nextLine();

            scan.findInLine(": ");
            suffix = scan.nextLine();
            if (suffix.equalsIgnoreCase("Suffix:"))
                suffix = "";

            scan.findInLine(": ");
            politicalParty = scan.nextLine();

            scan.findInLine(": ");
            educationalBackground = scan.nextLine();

            scan.findInLine(": ");
            chosenPosition = scan.nextLine();

            scan.findInLine(": ");
            crimeRecord = scan.nextLine();
            scan.nextLine();

            if (chosenPosition.equalsIgnoreCase("President")) {
                presList.add(new Object_Candidate(firstName, lastName, initial, suffix, politicalParty,
                        educationalBackground, chosenPosition, crimeRecord));
            }
            if (chosenPosition.equalsIgnoreCase("Vice-President"))
                vpList.add(new Object_Candidate(firstName, lastName, initial, suffix, politicalParty,
                        educationalBackground, chosenPosition, crimeRecord));
            if (chosenPosition.equalsIgnoreCase("Senator"))
                senList.add(new Object_Candidate(firstName, lastName, initial, suffix, politicalParty,
                        educationalBackground, chosenPosition, crimeRecord));
        }
        Sort(presList);
        Sort(vpList);
        Sort(senList);
        System.out.println("Note: The Data is now Loaded, Ready for Voting.");
    }

    // Printing
    void GetFullName(Object_Candidate data) {
        System.out.println(data.getLastName() + ", " + data.getFirstName() + " " + data.getInitial() + " "
                + data.getSuffix());
    }

    void GetFullNameQualified(Object_Candidate data) {

        if (!data.getCrimeRecord().equalsIgnoreCase("None"))
            return;

        System.out.println(data.getLastName() + ", " + data.getFirstName() + " " + data.getInitial() + " "
                + data.getSuffix());

    }

    void GetFullNameUnqualified(Object_Candidate data) {

        if (data.getCrimeRecord().equalsIgnoreCase("None"))
            return;

        System.out.println(data.getLastName() + ", " + data.getFirstName() + " " + data.getInitial() + " "
                + data.getSuffix());
        System.out.println("Cause of Disqualification: " + data.getCrimeRecord());

    }

    void PrintAllCandidatePresident() {
        if (presList.size() == 0) {
            System.out.println("Note: No available candidate for President.");
            return;
        }
        System.out.println("\n*For President*");
        for (Object_Candidate data : presList)
            GetFullName(data);
    }

    void PrintAllQualifiedPresident() {
        if (presList.size() == 0) {
            System.out.println("Note: No available candidate for President.");
            return;
        }
        System.out.println("\n*Qualified President*");
        for (int i = 0; i < presList.size(); i++) {
            GetFullNameQualified(presList.get(i));
        }
    }

    void PrintAllUnqualifiedPresident() {
        if (presList.size() == 0) {
            System.out.println("Note: No available candidate for President.");
            return;
        }
        System.out.println("\n*Disqualified President*");
        for (int i = 0; i < presList.size(); i++) {
            GetFullNameUnqualified(presList.get(i));
        }
    }

    void PrintAllCandidateVPresident() {
        if (vpList.size() == 0) {
            System.out.println("Note: No available candidate for Vice-President.");
            return;
        }
        System.out.println("\n*For Vice-President*");
        for (Object_Candidate data : vpList)
            GetFullName(data);
    }

    void PrintAllCandidateSenator() {
        if (senList.size() == 0) {
            System.out.println("Note: No available candidate for Senator.");
            return;
        }
        System.out.println("\n*For Senator*");
        for (Object_Candidate data : senList)
            GetFullName(data);
    }

    void PrintAllCandidates() {
        System.out.println("\nAll Candidate");
        PrintAllCandidatePresident();
        PrintAllCandidateVPresident();
        PrintAllCandidateSenator();
    }

    void PrintAllQualifiedCandidates() {
        System.out.println("\nAll Qualified Candidate");
        PrintAllQualifiedPresident();
    }

    void PrintAllUnqualifiedCandidates() {
        System.out.println("\nAll Unqualified Candidate");
        PrintAllUnqualifiedPresident();
    }

    void Main() throws Exception {

        scan = new Scanner(System.in);

        LoadData();
        PrintAllCandidates();
        PrintAllQualifiedCandidates();
        PrintAllUnqualifiedCandidates();

        scan.close();
        // System.out.println("\n1- Disqualified Candidates | 2 - Qualified Candidates |
        // 3 - Main Menu");
        /*
         * 
         * ArrayList<Object_Candidate> candidate = new ArrayList<>();
         * ArrayList<Object_Voter> voter = new ArrayList<>();
         * Scanner sc, in = new Scanner(System.in);
         * 
         * String firstName, lastName, initial = "", suffix = "", politicalParty,
         * educationalBackground, chosenPosition,
         * crimeRecord, votedPres, votedVp, votedSenate[] = new String[12];
         * int input, age;
         * 
         * while (true) {
         * System.out.println("\nOOP Project 1 : Voting System\n");
         * System.out.println("1 - Show All Candidates");
         * System.out.println("2 - Vote Candidates");
         * System.out.println("3 - Fill a Candidacy");
         * System.out.println("4 - Show Voting Logs");
         * System.out.println("5 - Show Final Result");
         * System.out.println("6 - Load Existing Value");
         * System.out.println("7 - Clear Data");
         * System.out.println("8 - Exit");
         * System.out.print("\nOption: ");
         * input = in.nextInt();
         * 
         * if (input == 1) {
         * if (candidate.size() == 0) {
         * System.out.println("Note: No data loaded.");
         * } else {
         * System.out.println("\nAll Candidate\n");
         * System.out.println("=For President=");
         * for (Object_Candidate data : candidate) {
         * if (data.getChosenPosition().equalsIgnoreCase("President"))
         * System.out.println(data + "\n");
         * }
         * System.out.println("=For Vice-President=");
         * for (Object_Candidate data : candidate) {
         * if (data.getChosenPosition().equalsIgnoreCase("Vice-President"))
         * System.out.println(data + "\n");
         * }
         * System.out.println("=For Senator=");
         * for (Object_Candidate data : candidate) {
         * if (data.getChosenPosition().equalsIgnoreCase("Senator"))
         * System.out.println(data + "\n");
         * }
         * }
         * }
         * 
         * if (input == 2) {
         * if (candidate.size() == 0) {
         * System.out.
         * println("No Candidate to Vote, Please load or Fill a candidacy form.");
         * } else {
         * System.out.println("\nVote Candidates");
         * 
         * System.out.print("Enter Age: ");
         * age = in.nextInt();
         * 
         * if (age <= 17) {
         * System.out.println("Invalid");
         * } else {
         * System.out.print("Enter First Name: ");
         * firstName = in.nextLine();
         * System.out.print("Enter Last Name: ");
         * lastName = in.nextLine();
         * System.out.print("Enter Initial (press enter if none): ");
         * initial = in.nextLine();
         * System.out.print("Enter Suffix (press enter if none): ");
         * suffix = in.nextLine();
         * 
         * System.out.print("Enter President of Choice: ");
         * votedPres = in.nextLine();
         * 
         * System.out.print("Enter Vice President of Choice: ");
         * votedVp = in.nextLine();
         * 
         * votedSenate[0] = "Pres1";
         * votedSenate[1] = "Pres2";
         * votedSenate[2] = "Pres3";
         * 
         * voter.add(new Object_Voter(firstName, lastName, initial, suffix, age,
         * votedPres, votedVp,
         * votedSenate));
         * 
         * }
         * }
         * }
         * 
         * if (input == 3) {
         * System.out.println("\nCandidacy Form");
         * 
         * }
         * 
         * if (input == 4) {
         * System.out.println("\nVoting Logs");
         * }
         * 
         * if (input == 5) {
         * System.out.println("\nFinal Result");
         * }
         * 
         * if (input == 6) {
         * File file = new File("files/candidate.txt");
         * sc = new Scanner(file);
         * while (sc.hasNextLine()) {
         * sc.findInLine(": ");
         * firstName = sc.nextLine();
         * 
         * sc.findInLine(": ");
         * lastName = sc.nextLine();
         * 
         * sc.findInLine(": ");
         * initial = sc.nextLine();
         * 
         * sc.findInLine(": ");
         * suffix = sc.nextLine();
         * if (suffix.equalsIgnoreCase("Suffix:"))
         * suffix = "";
         * 
         * sc.findInLine(": ");
         * politicalParty = sc.nextLine();
         * 
         * sc.findInLine(": ");
         * educationalBackground = sc.nextLine();
         * 
         * sc.findInLine(": ");
         * chosenPosition = sc.nextLine();
         * 
         * sc.findInLine(": ");
         * crimeRecord = sc.nextLine();
         * sc.nextLine();
         * 
         * candidate.add(new Object_Candidate(firstName, lastName, initial, suffix,
         * politicalParty,
         * educationalBackground, chosenPosition, crimeRecord));
         * }
         * System.out.println("Note: The Data is now Loaded, Ready for Voting.");
         * }
         * 
         * if (input == 7) {
         * candidate.clear();
         * voter.clear();
         * System.out.println("Note: Data is now Clear.");
         * }
         * 
         * if (input == 8) {
         * System.out.println("\nThank you for using the program.");
         * break;
         * }
         * }
         * in.close();
         */
    }

}