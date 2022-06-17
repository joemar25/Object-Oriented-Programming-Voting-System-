public class Object_Candidate {

    private String firstName, lastName, initial, suffix, politicalParty, educationalBackground, chosenPosition,
            crimeRecord;

    public Object_Candidate(final String firstName, final String lastName, final String initial, final String suffix,
            final String politicalParty,
            final String educationalBackground, final String chosenPosition, final String crimeRecord) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setInitial(initial);
        this.setSuffix(suffix);
        this.setPoliticalParty(politicalParty);
        this.setEducationalBackground(educationalBackground);
        this.setChosenPosition(chosenPosition);
        this.setCrimeRecord(crimeRecord);
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getInitial() {
        return initial;
    }

    private void setInitial(final String initial) {
        this.initial = initial;
    }

    public String getSuffix() {
        return suffix;
    }

    private void setSuffix(final String suffix) {
        this.suffix = suffix;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    private void setPoliticalParty(final String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public String getEducationalBackground() {
        return educationalBackground;
    }

    private void setEducationalBackground(final String educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    public String getChosenPosition() {
        return chosenPosition;
    }

    private void setChosenPosition(final String chosenPosition) {
        this.chosenPosition = chosenPosition;
    }

    public String getCrimeRecord() {
        return crimeRecord;
    }

    private void setCrimeRecord(final String crimeRecord) {
        this.crimeRecord = crimeRecord;
    }

    @Override
    public String toString() {
        return "Test";
    }

}
