<?php 
echo "Welcome to scope and local/global vars in php<br><br>";
$a = 98; // global variable
$b = 9; 

function printValue(){
    // $a = 97; // local variable.
    global $a, $b; // give me access to this global variable.
    $a = 100;
    $b = 1000; 
    echo "<br>The value of your variable a is $a and b is $b";
}

echo $a; 
printValue(); 
echo "<br>The value of your variable a is $a and b is $b <br>";
// echo var_dump($GLOBALS); // prints all the global variables
echo var_dump($GLOBALS["a"]);
echo var_dump($GLOBALS["b"]); 

?>