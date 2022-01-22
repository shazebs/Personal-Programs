package app;

import java.util.ArrayList; 

public class Activity
{
	
	// properties
	private String title;
	private String status; // good, bad, or neutral
	
	// constructor 
	
	public Activity(String title, String status)
	{
		super();
		this.title = title;
		this.status = status;
	}
	
	public Activity() {}
	
	
	// methods 
	
	public String getTitle() {return this.title;}
	
	public String getStatus() {return this.status;}
	
	
	public void showDetails(int startingCount)
	{
		System.out.printf("%3d. %-50s | Status: %s%n", startingCount, getTitle(), getStatus());
	}
	
	// print activites loop 
	public static void printActivities(ArrayList<Activity> activities)
	{
		int count = 0; 
		for(Activity activity : activities)
		{
			activity.showDetails(++count); 
		}
	}

	// print job loop 
	public static void printJobs(ArrayList<Job> jobs)
	{
		int count = 0; 
		for(Job job : jobs)
		{
			job.showDetails(++count); 
		}
	}
	
	/**
	 * Main Method. 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ArrayList<Activity> activities = new ArrayList<Activity>(); 
		
		// Make activities.
		/*      activities.add(new Activity("", ""));      */
		activities.add(new Activity("Waking-up time", "neutral"));
		activities.add(new Activity("Hygiene time", "good"));
		activities.add(new Activity("Journaling time", "good"));
		activities.add(new Activity("Praying time", "bad"));
		activities.add(new Activity("Eating food", "bad"));
		activities.add(new Activity("Exercising time", "Good"));
		activities.add(new Activity("CST-239 class attendance", "neutral"));
		activities.add(new Activity("CST-250 class attendance", "good"));
		activities.add(new Activity("COM-263 class attendance", "neutral"));
		activities.add(new Activity("CST-345 class attendance", "good"));
		activities.add(new Activity("Studying time", "Good"));
		activities.add(new Activity("Homework time", "neutral"));
		activities.add(new Activity("Programming time", "Good"));
		activities.add(new Activity("Making money time", "Bad"));
		activities.add(new Activity("Walking across campus", "bad"));
		activities.add(new Activity("Washing dishes", "neutral")); 
		activities.add(new Activity("Driving time", "bad"));
		activities.add(new Activity("Errands time", "bad"));
		activities.add(new Activity("Cleaning time", "neutral")); 
		activities.add(new Activity("Leisure time", "Good"));
		activities.add(new Activity("Social Media time", "Good"));
		activities.add(new Activity("Playing PS4 Spider-Man", "neutral")); 
		activities.add(new Activity("Watching Attack on Titan", "Good")); 
		activities.add(new Activity("Twitch/Youtube content creating", "Neutral"));
		activities.add(new Activity("Calling Rooha", "Good"));
		activities.add(new Activity("Calling Mama", "Good"));
		activities.add(new Activity("Meditation time", "Bad"));
		activities.add(new Activity("Sleeping time", "bad"));
		
		// print activities 
		System.out.println("\n\tACTIVITIES LIST"); 
		System.out.print("-------------------------------------------------------------------------"); 
		System.out.println("-------------------------------------------------------------------------");
		printActivities(activities); 
		System.out.println(); 
		
		
		// Create jobs. 
		/* 		jobs.add(new Job("", "", "", ""));		*/
		ArrayList<Job> jobs = new ArrayList<Job>(); 
		jobs.add(new Job("Software Developer Intern", "Blizzard Entertainment", "Denver, Colorado", "Pending")); 
		jobs.add(new Job("Software Engineer Intern", "TuSimple Inc.", "Phoenix, Arizona", "Pending"));
		jobs.add(new Job("Software Engineer", "Two Sigma", "Phoenix, Arizona", "Pending"));
		
		// print jobs 
		System.out.println("\tJOBS LIST");
		System.out.print("-------------------------------------------------------------------------"); 
		System.out.println("-------------------------------------------------------------------------");
		printJobs(jobs); 
	}
}


// Job class 
class Job 
{
	// properties 
	private String position; 
	private String company; 
	private String location; 
	private String status; 		// Pending, Rejected, or In-Progress
	
	// constructor
	public Job() {}
	
	public Job(String position, String company, String location, String status)
	{
		this.position = position;
		this.company = company;
		this.location = location;
		this.status = status; 
	}
	
	// methods
	public String getPosition() {return this.position;}
	
	public String getCompany() {return this.company;}
	
	public String getLocation() {return this.location;}
	
	public String getStatus() {return this.status;}
	
	public void showDetails(int startingCount)
	{
		System.out.printf("%3d. %-40s | %-30s | %-25s | Status: %-20s%n", 
				startingCount, getPosition(), getCompany(), getLocation(), getStatus());
	}
}


// need more java skills 1/20/2022
class Game {
	// properties 
	
	// constructors 
	
	// methods
	
	// main() 
}

class Shazeb 
{
	// properties 
	private int age = 26; 
	private Job job;  
	private Friend[] friends; 
	
	// constructor 
	public Shazeb() {}
	
}

class Friend
{
	// properties
	private String name = ""; 
	private int age; 
	private String relationship = ""; 
	private String phoneNumber = ""; 
	private String location = ""; 
	
	// constructor 
	public Friend() {} 
}



















