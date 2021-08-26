<?php
/*
php data types
1. String
2. Integer
3. Float
4. Boolean
5. Object
6. Array
7. NULL
*/

// String - sequence of characters
$name = "Shazeb";
$friend = "Rooha";
echo "$name ka friend is $friend."; 
echo "<br>";

// Integer - Non decimal number
$income = 999;
$debts = -333;
echo $income;
echo $debts;

echo "<br>"; 

// Float - Decimal point number
$income = 344.5; 
$debts = -45.5;
echo $income;
echo $debts; 
echo "<br>";

// Boolean - Can be either true or false
$x = false;
$is_friend = true;
echo var_dump($x);
echo "<br>";
echo var_dump($is_friend); 
echo "<br>";
// var_dump is the function to know an object's type

// Object - Instances of classes
// Employee is a class ---> shazeb can be one object 

// Array - Used to store multiple values in a single variable
$friends = array("Rooha", "Maira", "Ryan", "Shahan"); 
echo var_dump($friends). "<br>"; 
echo $friends[0]. "<br>"; 
echo $friends[1]. "<br>"; 
echo $friends[2]. "<br>"; 
echo $friends[3]. "<br>"; 
// echo $friends[4]; // will throw an error as the size of array is 4

// NULL 
$name = NULL;
$newNum = 999; 
echo var_dump($name); echo "<br>";
echo var_dump($newNum); echo "<br>";

?>