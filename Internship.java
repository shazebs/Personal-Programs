// Author: Shazeb Suhail
// Date:   11/23/20
// Time:   2:20 AM

// start of class 'Intern'
class Intern {

    // Constructor
// ---------------------------------------------
    public Intern() {} // initialize to default


    // private variables
// ---------------------------------------------
    private double CompetitivePay;     // salary
    private String RelocationBenefits; // TBD
    private int LearningXP;            // learning experience
    private String Support;            // support team
    private String Network;            // social networking
    private String TeamMember;         // teamMember 1
    private String TeamMember2;        // " " 2
    private String MagentaSpirit;      // TBD
    private String Requirements;       // educational level
    private String InternshipTitle;     // title of internship
    private String Location;           // location of internship
    private String InternshipPeriod;


    // more variables
// ---------------------------------------------
    String StartDate = " ";
    String EndDate   = " ";
    String ScreeningDate;
    String RecruitingStart;
    String RecruitingEnd;



// ---------------------------------------------
    // 'SET' Methods:
    // ---------------------------------------------

    // set StartDate
    public void pressStartDate(String StartDate) {
        this.StartDate = StartDate;
    }


    // set EndDate
    public void pressEndDate(String EndDate) {
        this.EndDate = EndDate;
    }


    // set ScreeningDate
    public void setScreeningDate (String ScreeningDate) {
        this.ScreeningDate = ScreeningDate;
    }


    // set RecruitingStart
    public void setRecruitingStart(String RecruitingStart) {
        this.RecruitingStart = RecruitingStart;
    }


    // set RecruitingEnd
    public void setRecruitingEnd(String RecruitingEnd) {
        this.RecruitingEnd = RecruitingEnd;
    }


    // set Requirements
    public void setRequirements(String Requirements) {
        this.Requirements = Requirements;
    }


    // set InternshipPeriod
    public void setInternshipPeriod(String InternshipPeriod) {
        this.InternshipPeriod = InternshipPeriod;
    }


    // set InternshipTitle
    public void setInternshipTitle(String InternshipTitle) {
        this.InternshipTitle = InternshipTitle;
    }


    // set startDate
    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }


    // set endDate
    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }


    // set Location
    public void setLocation(String Location) {
        this.Location = Location;
    }



// ---------------------------------------------
    // 'GET' Methods
    // ---------------------------------------------

    // get RecruitingStart
    public String getRecruitingStart() {return RecruitingStart;}

    // get RecruitingEnd
    public String getRecruitingEnd() {return RecruitingEnd;}

    // get InternshipPeriod
    public String getInternshipPeriod() {return InternshipPeriod;}

    // get InternShipType
    public String getInternshipTitle() {return InternshipTitle;}

    // get Requirements
    public String getRequirements() {return Requirements;}

    // get StartDate
    public String getStartDate() {return StartDate;}

    // get EndDate
    public String getEndDate() {return EndDate;}

    // get Location
    public String getLocation() {return Location;}


// ---------------------------------------------
    // 'Additional' Methods
    // ---------------------------------------------

    // toString method
    @Override
    public String toString() {
        return String.format(
                "%n%s %s \n\t%s \n\t%s %s %s \n\t%s %s \n\t%s \n",

                // InternshipType
                //      InternshipPeriod
                //      StartDate "to" EndDate
                //      "Requirements:" Requirements
                //      Location

                getInternshipTitle(), "Internship",
                    getInternshipPeriod(),
                    getStartDate(), "to", getEndDate(),
                    "Requirements:", getRequirements(),
                    getLocation()
        );
    }

} // END OF CLASS INTERN
// -------------------------------------------------------------------------------------------------------------------------




// Main Method: "Driver class"
// ---------------------------------------------
public class Internship {
    public static void main(String[] args) {


        // CREATE T-MOBILE INTERNSHIP
        Intern TMobile = new Intern();
        //
        TMobile.setInternshipTitle(
                "T-Mobile");
        TMobile.setInternshipPeriod(
                "12-week paid learning");
        TMobile.setStartDate(
                "May 2021");
        TMobile.setEndDate(
                "August 2021");
        TMobile.setRequirements(
                "Java,C++,Python,HTML,CSS,and Bachelor's.");
        TMobile.setLocation("" +
                "Bellevue, Washington");


        // CREATE DROPBOX INTERNSHIP
        Intern DropBox = new Intern();
        //
        DropBox.setInternshipTitle(
                "DropBox");
        DropBox.setInternshipPeriod(
                "Summer 2021");
        DropBox.setRequirements(
                "Python,Front-End,Databases,Excel,and Tableau.");
        DropBox.setLocation("United States");


        // CREATE BLIZZARD INTERNSHIP
        Intern Blizzard = new Intern();
        //
        Blizzard.setInternshipTitle("Blizzard Gaming/Software");
        Blizzard.setRequirements("C++,Python,Java,API's,Javascript, and CSS.");
        Blizzard.setInternshipPeriod("11-12 weeks Full Time");
        Blizzard.setStartDate("May or June 2021");
        Blizzard.setEndDate("August or September 2021");
        Blizzard.setLocation("Irvine, California");


        // CREATE LENOVO INTERNSHIP
        Intern Lenovo = new Intern();
        //
        Lenovo.setInternshipTitle("Lenovo Android Engineer");
        Lenovo.setInternshipPeriod("Summer 2021");
        Lenovo.setRequirements("Android Development Tools,Java,C++ or Python, and mobile app familiarity");
        Lenovo.setLocation("North Carolina");


        // CREATE SPLUNK INTERNSHIP
        Intern Splunk = new Intern();
        //
        Splunk.setInternshipTitle("Splunk Product Security");
        Splunk.setRequirements("C++,Python,Java,UNIX/LINUX,GO,JavaScript, and pursuing a Bachelor's Degree");
        Splunk.setLocation("United States");


        // CREATE PETSMART INTERNSHIP
        Intern PetSmart = new Intern();
        //
        PetSmart.setInternshipTitle("PetSmart IT Engineer");
        PetSmart.setInternshipPeriod("10 week paid summer");
        PetSmart.setRequirements("Graduating by May 2022,React,Java script,.net");
        PetSmart.setLocation("Tuscon, Arizona");


        // CREATE APPLE INTERNSHIP
        Intern Apple = new Intern();
        //
        Apple.setInternshipTitle("Apple Software Engineering");
        Apple.setLocation("Santa Clara Valley(Cupertino), California");
        Apple.setInternshipPeriod("12 weeks for Winter,Spring, or Summer 2021");
        Apple.setRequirements("Java,C++,Python,Html,CSS,Javascript, so basically back-end programming proficiency");


        // CREATE MICROSOFT INTERNSHIP
        Intern Microsoft = new Intern();
        //
        Microsoft.setInternshipTitle("Microsoft Quantum Programming Internship");
        Microsoft.setRequirements("C++,Python,or other programming languages");
        Microsoft.setLocation("Redmond, Washington");


        // new Intern object goes here...


        // Print Report
        System.out.printf("%s%s%s%s%s%s", TMobile, DropBox, Blizzard, Lenovo, PetSmart, Apple);
        System.out.println();

    }
}
