<?php

echo "This is for loop in action <br>"; 

// for loop 
for ($index = 1; $index < 6; $index++) {
    // for (initialization; condition; updation)
    echo "The number is $index <br>"; 
}
echo "The loop has ended.<br><br>"; 

/* while (condition) {
    some lines of code here; 
}
*/

/*
for ($i=0; $i < 87; $i++) {
    echo $i . "<br>"; 
} */

// do while loop 
$i = 0; 
do {
    echo "$i <br>"; 
    $i++; 
} while ($i<5); 
echo "<br>"; 

// while loop 
$i = 0; 
while ($i<5) {
    echo "The value of i is "; 
    echo $i+1; 
    echo "<br>";
    $i+=1; 
}


?> 