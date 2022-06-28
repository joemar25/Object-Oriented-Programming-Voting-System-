import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;

public class Main2 {

    private ArrayList<Object_Candidate> candidates = new ArrayList<>();
    private ArrayList<Object_Candidate> presList = new ArrayList<>();
    private ArrayList<Object_Candidate> vpList = new ArrayList<>();
    private ArrayList<Object_Candidate> senList = new ArrayList<>();

    private ArrayList<Object_Candidate> dPresList = new ArrayList<>();
    private ArrayList<Object_Candidate> dVpList = new ArrayList<>();
    private ArrayList<Object_Candidate> dSenList = new ArrayList<>();

    private ArrayList<Object_Voter> voter = new ArrayList<>();

    private Scanner scan;
    private String firstName, lastName, initial = "", suffix = "", politicalParty, educationalBackground,
            chosenPosition,
            crimeRecord, isQualified, votedPres, votedVp, votedSenate[] = new String[12];
    private int input, age, dPres, dVp, dSen;

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

            if (criminalRecord.equalsIgnoreCase("None")) {

            }

            candidates.add(new Object_Candidate(lastName, firstName, initial, suffix, politicalParty,
                    educationalBackground, chosenPosition, crimeRecord));
        }
        Sort(candidates);
        LoadPresident();
        System.out.println("Note: The Data is now Loaded, Ready for Voting.");
    }

    void LoadPresident() {
        for (Object_Candidate data : candidates) {
            lastName = data.getLastName();
            firstName = data.getFirstName();
            initial = data.getInitial();
            suffix = data.getSuffix();
            politicalParty = data.getPoliticalParty();
            educationalBackground = data.getEducationalBackground();
            chosenPosition = data.getChosenPosition();
            crimeRecord = data.getCrimeRecord();

            if (chosenPosition.equalsIgnoreCase("President") && crimeRecord.equalsIgnoreCase("None"))
                presList.add(new Object_Candidate(lastName, firstName, initial, suffix, politicalParty,
                        educationalBackground, chosenPosition, crimeRecord));
            if (chosenPosition.equalsIgnoreCase("President") && !crimeRecord.equalsIgnoreCase("None"))
                dPresList.add(new Object_Candidate(lastName, firstName, initial, suffix, politicalParty,
                        educationalBackground, chosenPosition, crimeRecord));
        }
    }

    void GetFullName(Object_Candidate data, String pos) {
        if (data.getChosenPosition().equalsIgnoreCase(pos))
            System.out.println(data.getLastName() + ", " + data.getFirstName() + " " + data.getInitial() + " "
                    + data.getSuffix());
    }

    void PrintAllCandidates() {
        if (candidates.size() == 0) {
            System.out.println("Note: No Available Candidates. Please Load or fill a candidacy.");
            return;
        }
        System.out.println("\nAll Candidate for President");
        for (Object_Candidate data : candidates)
            GetFullName(data, "President");
        System.out.println("\nAll Candidate for Vice-President");
        for (Object_Candidate data : candidates)
            GetFullName(data, "Vice-President");
        System.out.println("\nAll Candidate for Senator");
        for (Object_Candidate data : candidates)
            GetFullName(data, "Senator");
    }

    void ValidPresidentCandidates() {
        if (presList.size() == 0) {
            System.out.println("Note: No Valid Candidate For President.");
            return;
        }
        System.out.println("\nAll Valid Candidate for President");
        for (Object_Candidate data : presList)
            GetFullName(data);
    }

    void InvalidPresidentCandidates() {
        if (dPresList.size() == 0) {
            System.out.println("Note: No Disqualified Candidate For President.");
            return;
        }
        System.out.println("\nAll Disqualified Candidate for President");
        for (Object_Candidate data : dPresList)
            GetFullName(data);
    }

    void PrintAllValidCandidates() {
        ValidPresidentCandidates();
        // add ValidVPresidentCandidates
        // add ValidSenatorCandidates
    }

    void PrintAllInvalidCandidates() {
        InvalidPresidentCandidates();
        // add InvalidVPresidentCandidates
        // add InvalidSenatorCandidates
    }

    void Main() throws Exception {
        scan = new Scanner(System.in);

        LoadData();
        PrintAllCandidates();

        scan.close();
    }

}