// Author: @shazebs
// Date:   11/28/20
// Time:   5:17 PM

// Last Updated: 12/26/20 @ 4:38 PM

// classs imports
import java.util.Scanner;

// Driver Class
public class WorkExperience {
    public static void main(String[] arg) {
        // Create a Scanner class
        Scanner input = new Scanner(System.in);

        // main method local variables
        boolean loopCondition = true; // initialized to 'true'

        // Test 1
        EmploymentDetails(loopCondition,input);
    }

    // initialize employment details
    public static void EmploymentDetails(boolean loopCondition, Scanner input) {
        do {
            // create an employment position
            WorkHistory employment = new WorkHistory();

            try {
                System.out.printf("%n%s%n", "Enter a position title: ");
                employment.setPositionTitle(input.nextLine());
                System.out.printf("%s%n", "Enter a company name: ");
                employment.setCompanyName(input.nextLine());
                System.out.printf("%s%n", "Enter a start date (month/year): ");
                employment.setStartDate(input.nextLine());
                System.out.printf("%s%n", "Enter end date (month/year): ");
                employment.setEndDate(input.nextLine());
                System.out.printf("%s%n", "Enter job description: ");
                employment.setJobDescription(input.nextLine());

                // * test output *
                System.out.println("\n" + employment.getPositionTitle() + "\n" +
                        employment.getCompanyName() + "\n" +
                        employment.getStartDate() + " to " +
                        employment.getEndDate() + "\n" +
                        employment.getJobDescription());

                // change conditionLoop to 'false'
                loopCondition = false;
            }
            catch(Exception e) {
                System.err.printf("Error: %s\n", e.getMessage());
                System.out.printf("%n%nAn Error has occured, start over.%n%n");
            }
        } while (loopCondition);
    }
}


//-------------------|
// class WorkHistory |
//-------------------|
class WorkHistory {

    // instance variables
    private String positionTitle; // to hold the title of the job position
    private String companyName;   // name of the company where the occupation was held
    private String startDate;     // to hold start date of employment
    private String endDate;       // to hold end date of employment
    private String jobDescription; // duties and responsibilities at this position


    // The following variables holds the details of a reference to a person
    private String referenceName;      // Name of the reference at this job
    private String referenceTelephone; // Phone number of the reference
    private String referenceLocation;  // City name of where the reference lives
    private String relationshipToReference;  // the connection between you and this reference


    // CONSTRUCTORS
//-----------------
    public WorkHistory(){} // all variables initialized to default
    // ... no specific constructors at this moment


    // SET METHODS
//-----------------------------------------

    // (Set 1) : set Employment Description
    // set positionTitle
    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }
    // set companyName
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    // set startDate
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    // set endDate
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    // set jobDescription
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }



    // (Set 2) : set Reference Info
    // set referenceName
    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }
    // set referenceTelephone
    public void setReferenceTelephone(String referenceTelephone) {
        this.referenceName = referenceName;
    }
    // set referenceLocation
    public void setReferenceLocation(String referenceLocation) {
        this.referenceLocation = referenceLocation;
    }
    // set relationshipToReference
    public void setRelationshipToReference(String relationshipToReference) {
        this.relationshipToReference = relationshipToReference;
    }


    // GET METHODS
//-----------------------------------------

    // (Set 1) : get Employment Description
    // get positionTitle
    public String getPositionTitle() {
        return positionTitle;
    }
    // get companyName
    public String getCompanyName() {
        return companyName;
    }
    // get startDate
    public String getStartDate() {
        return startDate;
    }
    // get endDate
    public String getEndDate() {
        return endDate;
    }
    // get jobDescription
    public String getJobDescription() {
        return jobDescription;
    }



    // (Set 2) : get Reference Info
    // get referenceName
    public String getReferenceName() {
        return referenceName;
    }
    // get referenceTelephone
    public String getReferenceTelephone() {
        return referenceTelephone;
    }
    // get referenceLocation
    public String getReferenceLocation() {
        return referenceLocation;
    }
    // get relationshipToReference
    public String getRelationshipToReference() {
        return relationshipToReference;
    }

}
