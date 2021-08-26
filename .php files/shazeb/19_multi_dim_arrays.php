<?php
echo "Welcome to multi dimensional arrays in php <br><br>"; 

// Creating a 2 dimensional array
$multiDim = array ( array(2,5,7,8),
                    array(1,2,3,4),
                    array(4,5,0,1) );

// echo var_dump($multiDim);                     
// echo $multiDim[1][2] . "<br>"; 

// Printing the contents of a 2 dimensional array
/*
for ($i=0; $i < count($multiDim); $i++) {
    echo var_dump($multiDim[$i]); 
    echo "<br>"; 
} */

// outer loop 
for ($i=0; $i < count($multiDim); $i++) {
    // inner loop 
    for ($j=0; $j < count($multiDim[$i]); $j++){
        echo $multiDim[$i][$j]; 
        echo " "; 
    }
    echo "<br>"; 
}

// three dimensional array (incomplete)
$threeDimArray = (
    array( (array(1,2,3)), (array(4,5,6)), (array(7,8,9)) )
); 


?> 