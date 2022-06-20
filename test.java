import java.util.ArrayList;

public class test {

    static boolean isValidAge(int age) {
        if (age <= 17)
            return false;
        return true;
    }

    public static void main(String[] args) {

        ArrayList<Object_Voter> voter = new ArrayList<>();
        String firstName = "Joemar", lastName = "Cardiño", initial = "J.", suffix = "", votedPres = "", votedVp = "",
                votedSenate[] = new String[12];
        int age = 18;

        if (!isValidAge(age)) {
            System.out.println("Invalid");
        } else {
            firstName = "Joemar";
            lastName = "Cardiño";
            initial = "J.";
            suffix = "";

            votedPres = "";

            votedVp = "";

            votedSenate[0] = "Pres1";
            votedSenate[1] = "Pres2";
            votedSenate[2] = "Pres3";

            voter.add(new Object_Voter(firstName, lastName, initial, suffix, age, votedPres, votedVp, votedSenate));
            for (Object_Voter data : voter)
                System.out.println(data);
        }

    }
}

// ArrayList<Object_Candidate> candidate = new ArrayList<>();
// candidate.add(new Object_Candidate("Shaira", "Cardiño", "J.", "", "", "", "",
// ""));
// System.out.println(candidate.get(0));