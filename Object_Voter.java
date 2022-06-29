public class Object_Voter {

    private String lastName, firstName, initial, suffix, age, votedPres, votedVp, votedSenate[] = new String[12];

    public Object_Voter(String lastName, String firstName, String initial, String suffix, String age, String votedPres,
            String votedVp, String[] votedSenate) {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setInitial(initial);
        this.setSuffix(suffix);
        this.setAge(age);
        this.setVotedPres(votedPres);
        this.setVotedVp(votedVp);
        this.setVotedSenate(votedSenate);
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInitial() {
        return initial;
    }

    private void setInitial(String initial) {
        this.initial = initial;
    }

    public String getSuffix() {
        return suffix;
    }

    private void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getAge() {
        return age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    public String getVotedPres() {
        return votedPres;
    }

    private void setVotedPres(String votedPres) {
        if (votedPres != "")
            this.votedPres = votedPres;
        this.votedPres = "0";
    }

    public String getVotedVp() {
        return votedVp;
    }

    private void setVotedVp(String votedVp) {
        if (votedVp != "")
            this.votedVp = votedVp;
        this.votedVp = "0";
    }

    public String[] getVotedSenate() {
        return votedSenate;
    }

    public void setVotedSenate(String[] votedSenate) {
        this.votedSenate = votedSenate;
    }

    String senateList(String votedSenate[]) {
        String list = "";
        for (String data : votedSenate) {
            if (data != null)
                list += "\n\t\t " + data;
        }
        return list;
    }

    @Override
    public String toString() {
        return String.format(
                "Full Name: %s, %s %s %s\nChosen President: %s\nChosen Vice-President: %s\nChosen Senators: %s",
                this.getLastName(), this.getFirstName(), this.getInitial(),
                this.getSuffix(), this.getVotedPres(), this.getVotedVp(), senateList(this.getVotedSenate()));
    }
}
