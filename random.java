package app;

import java.util.Scanner;
import java.util.ArrayList; 

public class example_1 
{
	static Scanner in = new Scanner(System.in);

	// Main Method
	public static void main(String[] args) 
	{
		// Scanner for user input. 
		
		// Instantiate a Linked tasks. 
		ArrayList<Task> tasks = new ArrayList<>(); 
		ArrayList<Song> songs = new ArrayList<>(); 
		
		System.out.println("TASKS:");
		
		// Add class 'ToDoItem' objects to instantiated linked tasks.  
		/*		tasks.add(new Task(""));			*/
		tasks.add(new Task("Car oil change."));
		tasks.add(new Task("Car tire balance."));
		tasks.add(new Task("Clean car."));
		tasks.add(new Task("Go apartment searching with Mama."));
		tasks.add(new Task("Replace retainers."));
		tasks.add(new Task("Clear iPhone storage.")); 
		tasks.add(new Task("Renew Fafsa"));
		tasks.add(new Task("Quit smoking weed"));
		tasks.add(new Task("Quit fapping"));
		
		// Print all tasks 
		printTasks(tasks);
		
		
		System.out.println("FALLING IN REVERSE:");
		// track some songs
		/*		songs.add(new Song("")); 		*/
		songs.add(new Song("I'm Not A Vampire"));
		songs.add(new Song("Zombified"));
		songs.add(new Song("Drugs"));
		songs.add(new Song("Raised By The Wolves"));
		songs.add(new Song("Fuck You and All Your Friends"));
		songs.add(new Song("Not Good Enough For Truth In Cliche"));
		songs.add(new Song("Losing My Mind"));
		songs.add(new Song("The Drug In Me You Is You"));
		songs.add(new Song("Situations"));
		songs.add(new Song("Just Like You"));
		songs.add(new Song("Popular Monster"));
		
		// print all songs
		printSongs(songs); 
		
		calcmpg(); 
		
	}	
	
	
	// Functions 
	
	// print Tasks
	public static void printTasks(ArrayList<Task> tasks)
	{
		int count = 0; 
		for (Task item : tasks){
			System.out.printf("%3d. %s\n", ++count, item.getTitle()); 
		}
		System.out.println(); 
	}
	
	// print Songs 
	public static void printSongs(ArrayList<Song> songs)
	{
		int count = 0; 
		for (Song song : songs){
			System.out.printf("%3d. %s\n", ++count, song.getTitle()); 
		}
		System.out.println(); 
	}
	
	// calculate MPG trip with args
	public static double calcmpg(double miles, double mpg, double price, String title)
	{
		double cost = (miles/mpg) * price; 
		System.out.printf("\n%s\nMiles: %.2f\n  MPG: %.2f\nPrice:  %.3f\n = $%,.2f\n", 
				title, miles, mpg, price, cost); 
		return cost; 
	}
	
	// calculate MPG trip with user input fields
	public static void calcmpg()
	{
		// declare variables
		float miles, mpg, price, cost;
		
		// get user input 
		System.out.println("\nEnter miles, mpg, and price (in that order)");
		miles = in.nextFloat(); 
		mpg = in.nextFloat();
		price = in.nextFloat(); 
		
		// calculate cost
		cost = (miles/mpg) * price; 
		
		// display a result
		System.out.printf("Cost = $%,.2f\n", cost);
	}
}


// Classes 

class Task
{
	// Properties 
	private String title; 
	
	// Constructors
	public Task() {}
	
	public Task(String title)
	{
		this.title = title; 
	}
	 
	// Methods 
	public String getTitle() {return this.title;}
}


class Song
{
	// properties
	private String title; 
	
	// constructors
	public Song() {this.title = "";}
	
	public Song(String song) {
		this.title = song; 
	}
	
	// methods
	public String getTitle() {return this.title;}
}
