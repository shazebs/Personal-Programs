<?php
echo "Welcome to php tutorial on functions <br><br>"; 

// function declaration. 
function processMarks($marksArr) {
    $sum = 0; 
    foreach($marksArr as $value) {
        $sum += $value; 
    }
    return $sum; 
}

// function declaration. 
function avgMarks($marksArr) {
    $sum = 0; 
    $i = 0; 
    foreach($marksArr as $value) {
        $sum += $value; 
        $i++; 
    }
    return $sum/$i; 
}

$rohan = [34, 98, 45, 12, 98, 93];  // array object 
$sumMarks = processMarks($rohan);   // function call  

$shazeb = [99, 98, 93, 94, 87, 100]; 
$sumMarksShazeb = processMarks($shazeb); 

echo "Total marks scored by Rohan out of 600 is $sumMarks.<br>"; 
echo "Total marks scored by Shazeb out of 600 is $sumMarksShazeb.<br>"; 
$avgRohanMarks = avgMarks($rohan); 
echo "Average marks scored by Rohan is $avgRohanMarks.<br>"; 
$avgShazebMarks = avgMarks($shazeb); 
echo "Average marks scored by Shazeb is $avgShazebMarks.<br>"; 

?> 