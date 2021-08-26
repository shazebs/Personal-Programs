<?php
echo "Welcome to associative arrays in php <br>"; 

// these are called indexed arrays 
// $arr = array('this', 'that', 'what'); 
// echo $arr[0];
// echo $arr[1];
// echo $arr[2];


// Associative arrays
$favCol = array(
    'Dev' => 'red', 
    'Rohan' => 'green', 
    'Shazeb' => 'blue',
    8 => 'this'
); 

// (enhanced) for loop 
foreach ($favCol as $key => $value) {
    echo "<br>Favorite color of $key is $value"; 
} echo "<br>"; 


/*
echo $favCol['Shazeb']; echo "<br>"; 
echo $favCol['Rohan']; echo "<br>"; 
echo $favCol['Dev']; echo "<br>"; 
echo $favCol[8]; 
*/


?> 