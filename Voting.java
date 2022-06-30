import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;

public class Voting {

    private Scanner scan, in = new Scanner(System.in);
    private ArrayList<Object_Candidate> candidates = new ArrayList<>();
    private ArrayList<Object_Voter> voter = new ArrayList<>();
    private String firstName, lastName, initial, suffix, age, politicalParty, educationalBackground, chosenPosition,
            crimeRecord, isQualified, votedPres, votedVp, votedSenate[] = new String[12];
    private int sizeCount[] = new int[6], counter;

    void Menu() {
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

    void IncrementPosSize(String pos, String qualification) {
        if (pos.equalsIgnoreCase("President") && qualification.equalsIgnoreCase("Qualified"))
            sizeCount[0]++;
        if (pos.equalsIgnoreCase("Vice-President") && qualification.equalsIgnoreCase("Qualified"))
            sizeCount[1]++;
        if (pos.equalsIgnoreCase("Senator") && qualification.equalsIgnoreCase("Qualified"))
            sizeCount[2]++;
        if (pos.equalsIgnoreCase("President") && qualification.equalsIgnoreCase("Unqualified"))
            sizeCount[3]++;
        if (pos.equalsIgnoreCase("Vice-President") && qualification.equalsIgnoreCase("Unqualified"))
            sizeCount[4]++;
        if (pos.equalsIgnoreCase("Senator") && qualification.equalsIgnoreCase("Unqualified"))
            sizeCount[5]++;
    }

    void DecrementPosSize(String pos, String qualification) {
        if (pos.equalsIgnoreCase("President") && qualification.equalsIgnoreCase("Qualified") && sizeCount[0] != 0)
            sizeCount[0]--;
        if (pos.equalsIgnoreCase("Vice-President") && qualification.equalsIgnoreCase("Qualified") && sizeCount[1] != 0)
            sizeCount[1]--;
        if (pos.equalsIgnoreCase("Senator") && qualification.equalsIgnoreCase("Qualified") && sizeCount[2] != 0)
            sizeCount[2]--;
        if (pos.equalsIgnoreCase("President") && qualification.equalsIgnoreCase("Unqualified") && sizeCount[3] != 0)
            sizeCount[3]--;
        if (pos.equalsIgnoreCase("Vice-President") && qualification.equalsIgnoreCase("Unqualified")
                && sizeCount[4] != 0)
            sizeCount[4]--;
        if (pos.equalsIgnoreCase("Senator") && qualification.equalsIgnoreCase("Unqualified") && sizeCount[5] != 0)
            sizeCount[5]--;
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
            if (initial.equalsIgnoreCase("Initial:"))
                initial = "";

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

            if (crimeRecord.equalsIgnoreCase("none"))
                isQualified = "Qualified";
            else
                isQualified = "Unqualified";

            IncrementPosSize(chosenPosition, isQualified);
            candidates.add(new Object_Candidate(lastName, firstName, initial, suffix, politicalParty,
                    educationalBackground, chosenPosition, crimeRecord, isQualified));
        }
        Sort(candidates);
        System.out.println("Note: The Data is now Loaded, Ready for Voting.");
        scan.close();
    }

    void QueryName(Object_Candidate data, String pos, String qualification) {
        if (data.getChosenPosition().equalsIgnoreCase(pos) && data.getIsQualified().equalsIgnoreCase(qualification))
            System.out.println(data.getLastName() + ", " + data.getFirstName() + " " + data.getInitial() + " "
                    + data.getSuffix());
    }

    void Option() {
        System.out.print("1 - Show All Valid Candidates | 2 - Show All Disqualified Candidates | 3 - Menu\nOption: ");
        String input = in.nextLine();
        if (input.equals("1"))
            PrintAllValidCandidates();
        if (input.equals("2"))
            PrintAllInvalidCandidates();
    }

    void PrintAllCandidates() {
        if (candidates.size() == 0) {
            System.out.println("Note: No Available Candidates. Please Load or fill a candidacy.");
            return;
        }
        System.out.println("\nAll Candidate for President");
        for (Object_Candidate data : candidates)
            QueryName(data, "President", data.getIsQualified());
        System.out.println("\nAll Candidate for Vice-President");
        for (Object_Candidate data : candidates)
            QueryName(data, "Vice-President", data.getIsQualified());
        System.out.println("\nAll Candidate for Senator");
        for (Object_Candidate data : candidates)
            QueryName(data, "Senator", data.getIsQualified());
        Option();
    }

    void ValidPresCandidates() {
        if (sizeCount[0] == 0) {
            System.out.println("Note: No Valid Candidate For President.");
            return;
        }
        System.out.println("\nAll Valid Candidate for President");
        for (Object_Candidate data : candidates)
            QueryName(data, "President", "Qualified");
    }

    void ValidVPresCandidates() {
        if (sizeCount[1] == 0) {
            System.out.println("Note: No Valid Candidate For Vice-President.");
            return;
        }
        System.out.println("\nAll Valid Candidate for Vice-President");
        for (Object_Candidate data : candidates)
            QueryName(data, "Vice-President", "Qualified");
    }

    void ValidSenCandidates() {
        if (sizeCount[2] == 0) {
            System.out.println("Note: No Valid Candidate For Senator.");
            return;
        }
        System.out.println("\nAll Valid Candidate for Senator");
        for (Object_Candidate data : candidates)
            QueryName(data, "Senator", "Qualified");
    }

    void InvalidPresCandidates() {
        if (sizeCount[3] == 0) {
            System.out.println("Note: No Disqualified Candidate For President.");
            return;
        }
        System.out.println("\nAll Disqualified Candidate for President");
        for (Object_Candidate data : candidates)
            QueryName(data, "President", "Unqualified");
    }

    void InvalidVPresCandidates() {
        if (sizeCount[4] == 0) {
            System.out.println("Note: No Disqualified Candidate For Vice-President.");
            return;
        }
        System.out.println("\nAll Disqualified Candidate for Vice-President");
        for (Object_Candidate data : candidates)
            QueryName(data, "Vice-President", "Unqualified");
    }

    void InvalidSenCandidates() {
        if (sizeCount[5] == 0) {
            System.out.println("Note: No Disqualified Candidate For Senator.");
            return;
        }
        System.out.println("\nAll Disqualified Candidate for Senator");
        for (Object_Candidate data : candidates)
            QueryName(data, "Senator", "Unqualified");
    }

    void PrintAllValidCandidates() {
        ValidPresCandidates();
        ValidVPresCandidates();
        ValidSenCandidates();
    }

    void PrintAllInvalidCandidates() {
        InvalidPresCandidates();
        InvalidVPresCandidates();
        InvalidSenCandidates();
    }

    void Vote() {
        System.out.print("Enter Age: ");
        age = in.nextLine();

        if (age.isEmpty() || age.contains("a-zA-Z"))
            return;

        System.out.print("Last Name: ");
        lastName = in.nextLine();

        System.out.print("First Name: ");
        firstName = in.nextLine();

        System.out.print("Initial (skip if none): ");
        initial = in.nextLine();

        System.out.print("Suffix (skip if none): ");
        suffix = in.nextLine();

        System.out.print("President (enter 0 if none): ");
        votedPres = in.nextLine();

        System.out.print("Vice-President (enter 0 if none): ");
        votedVp = in.nextLine();

        counter = 1;
        while (counter <= 12) {
            System.out.println("Vote Remaning is " + counter);
            System.out.println("Senator (enter 0 if none): ");
            counter++;
        }
        // to-do: checker if voted senate exist..
        // to-do: checker if voted senate exist already on the list for voting..
        voter.add(new Object_Voter(lastName, firstName, initial, suffix, age, votedPres, votedVp, votedSenate));
    }

    // end
    void ClearAll() {
        if (candidates.size() == 0 && voter.size() == 0) {
            System.out.println("Note: Nothing To Clear. Try Again.");
            return;
        }
        candidates.clear();
        voter.clear();
        System.out.println("Note: All Data Is Now Clear.");
    }

    void CloseAll() {
        candidates.clear();
        voter.clear();
        in.close();
        System.out.println("\nThank you for using the program.");
    }

}