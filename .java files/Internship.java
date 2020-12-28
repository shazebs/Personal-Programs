// Author: Shazeb Suhail
// Date:   11/23/20
// Time:   2:20 AM

// import libraries
import java.util.ArrayList;

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
    private String Status;             // accepted or rejected value


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

    public void setStatus(String Status) { this.Status = Status;}



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

    public String getStatus() {return Status;}



// ---------------------------------------------
    // 'Additional' Methods
    // ---------------------------------------------

    // toString method
    @Override
    public String toString() {
        return String.format(
                "%n%s %s \n\t%s \n\t%s %s %s \n\t%s: %s \n\t%s \n\t%s: %s \n",

                // InternshipType
                //      InternshipPeriod
                //      StartDate "to" EndDate
                //      "Requirements:" Requirements
                //      Location
                //      "Status:" Status

                getInternshipTitle(), "Internship",
                    getInternshipPeriod(),
                    getStartDate(), "to", getEndDate(),
                    "Requirements", getRequirements(),
                    getLocation(),
                    "Status", getStatus()
        );
    }

} // END OF CLASS INTERN
// -------------------------------------------------------------------------------------------------------------------------




// Main Method: "Driver class"
// ---------------------------------------------
public class Internship {
    public static void main(String[] args) {

        // Local Variables
        ArrayList<Intern> internships = new ArrayList<Intern>();


        // CREATE T-MOBILE INTERNSHIP
        Intern TMobile = new Intern();
        internships.add(TMobile);
        //
        TMobile.setInternshipTitle("1. T-Mobile");
        TMobile.setInternshipPeriod("12-week paid learning");
        TMobile.setStartDate("May 2021");
        TMobile.setEndDate("August 2021");
        TMobile.setRequirements("Java,C++,Python,HTML,CSS,and Bachelor's.");
        TMobile.setLocation("Bellevue, Washington");
        TMobile.setStatus("PENDING");



        // CREATE DROPBOX INTERNSHIP
        Intern DropBox = new Intern();
        internships.add(DropBox);
        //
        DropBox.setInternshipTitle("2. DropBox");
        DropBox.setInternshipPeriod("Summer 2021");
        DropBox.setRequirements("Python,Front-End,Databases,Excel,and Tableau.");
        DropBox.setLocation("United States");
        DropBox.setStatus("PENDING");



        // CREATE BLIZZARD INTERNSHIP
        Intern Blizzard = new Intern();
        internships.add(Blizzard);
        //
        Blizzard.setInternshipTitle("3. Blizzard Gaming/Software");
        Blizzard.setRequirements("C++,Python,Java,API's,Javascript,and CSS.");
        Blizzard.setInternshipPeriod("11-12 weeks Full Time");
        Blizzard.setStartDate("May or June 2021");
        Blizzard.setEndDate("August or September 2021");
        Blizzard.setLocation("Irvine, California");
        Blizzard.setStatus("REJECTED");



        // CREATE LENOVO INTERNSHIP
        Intern Lenovo = new Intern();
        internships.add(Lenovo);
        //
        Lenovo.setInternshipTitle("4. Lenovo Android Engineer");
        Lenovo.setInternshipPeriod("Summer 2021");
        Lenovo.setRequirements("Android Development Tools,Java,C++ or Python,and mobile app familiarity.");
        Lenovo.setLocation("North Carolina");
        Lenovo.setStatus("PENDING");



        // CREATE SPLUNK INTERNSHIP
        Intern Splunk = new Intern();
        internships.add(Splunk);
        //
        Splunk.setInternshipTitle("5. Splunk Product Security");
        Splunk.setRequirements("C++,Python,Java,UNIX/LINUX,GO,JavaScript,and pursuing a Bachelor's Degree.");
        Splunk.setLocation("United States");
        Splunk.setStatus("PENDING");



        // CREATE PETSMART INTERNSHIP
        Intern PetSmart = new Intern();
        internships.add(PetSmart);
        //
        PetSmart.setInternshipTitle("6. PetSmart IT Engineer");
        PetSmart.setInternshipPeriod("10 week paid summer");
        PetSmart.setRequirements("Graduating by May 2022,React,Java script,or .net.");
        PetSmart.setLocation("Tuscon, Arizona");
        PetSmart.setStatus("PENDING");



        // CREATE APPLE INTERNSHIP
        Intern Apple = new Intern();
        internships.add(Apple);
        //
        Apple.setInternshipTitle("7. Apple Software Engineering");
        Apple.setLocation("Santa Clara Valley(Cupertino), California");
        Apple.setInternshipPeriod("12 weeks for Winter,Spring, or Summer 2021");
        Apple.setRequirements("Java,C++,Python,Html,CSS,Javascript,so basically back-end programming proficiency.");
        Apple.setStatus("PENDING");



        // CREATE MICROSOFT INTERNSHIP
        Intern Microsoft = new Intern();
        internships.add(Microsoft);
        //
        Microsoft.setInternshipTitle("8. Microsoft Quantum Programming Internship");
        Microsoft.setRequirements("C++,Python,or other programming languages.");
        Microsoft.setLocation("Redmond, Washington");
        Microsoft.setStatus("PENDING");



        // CREATE ACTIVISION INTERNSHIP
        Intern Activision = new Intern();
        internships.add(Activision);
        //
        Activision.setInternshipTitle("9. Activision/Treyarch Engineering");
        Activision.setInternshipPeriod("12-week full time");
        Activision.setRequirements("C++,Algorithms,Data Structures,Python, and pursuing a Bachelor's in Computer Science.");
        Activision.setLocation("Santa Monica, California");
        Activision.setStatus("REJECTED");



        // CREATE FEDEX INTERNSHIP
        Intern FedEx = new Intern();
        internships.add(FedEx);
        //
        FedEx.setInternshipTitle("10. FedEx Information Technology");
        FedEx.setInternshipPeriod("10-week assignment");
        FedEx.setRequirements("C++,Java,Python,HTML5,Javascript,and Python.");
        FedEx.setLocation("Lakeland, Florida");
        FedEx.setStatus("REJECTED");



        // CREATE CBS INTERNSHIP
        Intern CBS = new Intern();
        internships.add(CBS);
        //
        CBS.setInternshipTitle("11. ViacomCBS Mobile Development");
        CBS.setInternshipPeriod("Summer 2021");
        CBS.setLocation("United States");
        CBS.setRequirements("Java,Scrum,Android Studio,IOS,and Xcode.");
        CBS.setStatus("PENDING");



        // CREATE NVIDIA INTERNSHIP
        Intern NVIDIA = new Intern();
        internships.add(NVIDIA);
        //
        NVIDIA.setInternshipTitle("12. NVIDIA SOFTWARE INTERN");
        NVIDIA.setInternshipPeriod("Summer 2021");
        NVIDIA.setRequirements("Linux,C++,Python,Android,and Chrome.");
        NVIDIA.setLocation("Santa Clara, California");
        NVIDIA.setStatus("PENDING");



        // CREATE EA INTERNSHIP
        Intern EA = new Intern();
        internships.add(EA);
        //
        EA.setInternshipTitle("13. EA Software Engineer");
        EA.setLocation("Redwood City, CA");
        EA.setInternshipPeriod("12-weeks paid full-time");
        EA.setRequirements("Competency in C++,knowledge on API's and SDK's,pursuing a Bachelor's in Computer Science.");
        EA.setStatus("REJECTED");



        // REJECTED * CREATE ESRI INTERNSHIP
        Intern Esri = new Intern();
        internships.add(Esri);
        //
        Esri.setInternshipTitle("14. Esri Software Development and Engineering");
        Esri.setInternshipPeriod("12 weeks Summer 2021");
        Esri.setRecruitingStart("September 1st, 2020");
        Esri.setRecruitingEnd("December 31, 2020 @ 5:00 PM");
        Esri.setLocation("United States");
        Esri.setRequirements("C++,Python,Java,JavaScript,HTML5,iOS,and Android or Windows mobile technology.");
        Esri.setStatus("REJECTED");



        // CREATE OSISOFT INTERNSHIP
        Intern OSIsoft = new Intern();
        internships.add(OSIsoft);
        //
        OSIsoft.setInternshipTitle("15. OSIsoft Software Developer");
        OSIsoft.setInternshipPeriod("Summer 2021");
        OSIsoft.setStartDate("May 17 or June 28");
        OSIsoft.setEndDate("August 6 or September 10");
        OSIsoft.setLocation("Scottsdale, Arizona");
        OSIsoft.setRequirements("3.0 GPA,C++,HTML5,and JavaScript.");
        OSIsoft.setStatus("PENDING");



        // CREATE FORMLABS INTERNSHIP
        Intern Formlabs = new Intern();
        internships.add(Formlabs);
        //
        Formlabs.setInternshipTitle("16. Formlabs Desktop Software");
        Formlabs.setInternshipPeriod("Summer 2021");
        Formlabs.setLocation("Somerville, Massachusetts");
        Formlabs.setRequirements("Comfortable developing in C++/Python,interface development,and complicated algorithm designs.");
        Formlabs.setStatus("PENDING");


        // 1) 12-11-20
        // CREATE TARGET INTERNSHIP
        Intern Target = new Intern();
        internships.add(Target);
        //
        Target.setInternshipTitle("17. Target Software Engineering");
        Target.setInternshipPeriod("Summer 2021");
        Target.setLocation("Minneapolis, Minnesota");
        Target.setRequirements("Be a C.S. student,and demonstrate proficiency in at least one language.");
        Target.setStatus("PENDING");



        // 2) 12-11-20
        // CREATE GOOGLE INTERNSHIP
        Intern Google = new Intern();
        internships.add(Google);
        //
        Google.setInternshipTitle("18. Google Software Engineering");
        Google.setInternshipPeriod("12-14 weeks paid Summer 2021");
        Google.setLocation("Irvine, California");
        Google.setRequirements("Master's Degree,C++,Java,Data Structures,Algorithms,Python,Javascript, and mobile/web applications.");
        Google.setStatus("PENDING");



        // 3) 12-12-20
        // CREATE PAYPAL INTERNSHIP
        Intern PayPal = new Intern();
        internships.add(PayPal);
        //
        PayPal.setInternshipTitle("19. PayPal Software Engineer");
        PayPal.setInternshipPeriod("Paid Summer 2021");
        PayPal.setLocation("Los Angeles, California");
        PayPal.setRequirements("B.A. Degree,Java,C++,Python,SceneBuilder,HTML/CSS,and Javascript.");
        PayPal.setStatus("PENDING");



        // 4) 12-12-20
        // CREATE DELTA DESIGN INTERNSHIP
        Intern DeltaDesign = new Intern();
        internships.add(DeltaDesign);
        //
        DeltaDesign.setInternshipTitle("20. Delta Design Software Engineer");
        DeltaDesign.setInternshipPeriod("Summer 2021");
        DeltaDesign.setLocation("Poway, California");
        DeltaDesign.setRequirements("C++,B.A. Degree,Data structures,excellent attendance.");
        DeltaDesign.setStatus("PENDING");



        // 5) 12-14-20
        // CREATE TIKTOK INTERNSHIP
        Intern TikTok = new Intern();
        internships.add(TikTok);
        //
        TikTok.setInternshipTitle("21. TikTok Mobile Software Engineer");
        TikTok.setInternshipPeriod("12-week Summer 2021");
        TikTok.setLocation("Mountain View, California");
        TikTok.setRequirements("Android,IOS,Java,Python,and C++.");
        TikTok.setStatus("PROCESSING!");



        // 6) 12-20-20
        // CREATE INTEL INTERNSHIP
        Intern Intel = new Intern();
        internships.add(Intel);
        //
        Intel.setInternshipTitle("22. Intel Software Engineer");
        Intel.setInternshipPeriod("Summer 2021");
        Intel.setRequirements("Coursework in C++,Java,Python,Data Structures,Algorithms, and assembly language.");
        Intel.setLocation("Phoenix, Arizona");
        Intel.setStatus("PENDING");



        // 7) 12-24-20
        // CREATE MOTOROLA INTERNSHIP
        Intern Motorola = new Intern();
        internships.add(Motorola);
        //
        Motorola.setInternshipTitle("23. Motorola Software Engineering");
        Motorola.setInternshipPeriod("Summer 2021");
        Motorola.setRequirements("Java,Javascript,Unit Testing,Agile/Scrum,Azure DevOps,and Git.");
        Motorola.setLocation("Temecula, California");
        Motorola.setStatus("PENDING");



        // 8) 12-24-20
        // CREATE SONY INTERNSHIP
        Intern Sony = new Intern();
        internships.add(Sony);
        //
        Sony.setInternshipTitle("24. Sony Software Development Engineer");
        Sony.setInternshipPeriod("Paid Summer 2021");
        Sony.setLocation("Los Angeles, California");
        Sony.setRequirements("Java,debugging skills,data structures,object-oriented design,and algorithms.");
        Sony.setStatus("PENDING");



        // 9) 12-25-20
        // CREATE FACEBOOK INTERNSHIP
        Intern Facebook = new Intern();
        internships.add(Facebook);
        //
        Facebook.setInternshipTitle("25. Facebook Software Engineer");
        Facebook.setInternshipPeriod("12-week Summer 2021");
        Facebook.setLocation("Sausalito, California");
        Facebook.setRequirements("C++,Java,CSS,JavaScript,and Python.");
        Facebook.setStatus("PENDING");



        // 10) 12-25-20
        // CREATE AMERICAN EXPRESS INTERNSHIP
        Intern AmericanExpress = new Intern();
        internships.add(AmericanExpress);
        //
        AmericanExpress.setInternshipTitle("26. American Express Technology Software Engineer");
        AmericanExpress.setInternshipPeriod("10-week Summer 2021");
        AmericanExpress.setLocation("Phoenix, Arizona");
        AmericanExpress.setRequirements("Creative,collaborative,innovative,communication-skills,and capable of working in a team environment.");
        AmericanExpress.setStatus("PENDING");



        // Print Results
        for (Intern intern : internships) {
            System.out.print(intern.toString());
        } System.out.println();


    }
}