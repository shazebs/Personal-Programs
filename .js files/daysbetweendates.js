// Author: Shazeb Suhail
// Date:   4/19/21
// Time:   1:01 AM

/* Basics
 console.log(object); ==> cout or System.out.print
*/


// Global Variables. 
var month1 = 4, day1 = 19, year1 = 2021; 
var month2 = 6, day2 = 11, year2 = 2021; 


// Start of Main Method.  
function main()
{
	var month1,day1,year1;
	var month2,day2,year2; 
	selectDates();
		
}
// End of Main Method. 

function selectDates()
{
    // window.alert("Inside selectDates function.")
    // Get some input from user.  
	month1 = prompt("Enter a month:")
	day1 = prompt("Enter the day of the month:")
	year1 = prompt("Enter a year:")
	month2 = prompt("Enter a second month:")
	day2 = prompt("Enter a day from this month:")
	year2 = prompt("Enter this month's year:")

	console.log("Date 1 = "+month1+"/"+day1
	+"/"+year1+"\nDate 2 = "+month2+"/"+day2
	+"/"+year2)
}





// 
// Function List. 
//


// Function Test 0 
// True and False Comparisons:
function test0()
{
    console.log("(Test 0):True/False example")
    console.log(3 > 2)
    console.log(3 < 2)
    console.log("Aardvark" < "Zoroaster")
    console.log("Itchy" != "Scratchy")
    console.log(NaN == NaN)// value representing not a number.
    console.log(true && false)
    console.log(true && true)
    console.log(false || true)
    console.log(false || false)
    console.log(1+1==2 && 10*10>50)
    console.log(true ? 1:2); // if true =1 if false =2
}


// Function Test 1
// Basic while loop, data type init, and print example.
function test1()
{
    console.log("(Test 1):while loop example\n")
    var total = 0, count = 1; 
    while (count <= 10)
        {
            total += count; 
            count += 1; 
        }
    console.log(total);     
}


// Function Test 2
// typeof() method tests
function test2()
{
    console.log("(Test 2):typeof() example\n")
    console.log(typeof 4.5)
    console.log(typeof "x")
}


// Newline Function. *(Not That Useful Right Now)*
function newline(n)
{
    var count = 0; 
    while (count < n)
        {
            console.log("\n"); 
            count += 1; 
        }
}
