<?php
// Operators in PHP
/*
1. Arithmetic Operators
2. Assignment Operators 
3. Comparison Operators 
4. Logical Operators
*/

$a = 45; 
$b = 8; 

// 1. Arithmetic Operators
echo "For a + b, the result is " . ($a + $b) . "<br>"; 
echo "For a - b, the result is " . ($a - $b) . "<br>"; 
echo "For a * b, the result is " . ($a * $b) . "<br>"; 
echo "For a / b, the result is " . ($a / $b) . "<br><br>"; 

// 2. Assignment Operators 
// $x = $a; 
$a += 24; 
echo "For x, the value is " . $a . "<br><br>"; 

// 3. Comparison Operators 
$x = 6; 
$y = 9; 

echo "For $x > $y, the result is "; 
var_dump(($x > $y));
echo "<br>"; 

echo "For $x < $y, the result is ";
var_dump(($x < $y));
echo "<br>";

echo "For $x == $y, the result is ";
var_dump(($x == $y));
echo "<br>"; 

echo "For $x <> $y, the result is ";
var_dump(($x <> $y));
echo "<br><br>"; 

// 4. Logical Operators
$m = true; 
$n = false; 

echo "For m and n, the result is ";
echo var_dump($m and $n);
echo "<br>"; 

echo "For m && n, the result is ";
echo var_dump($m && $n);
echo "<br>"; 

echo "For m or n, the result is ";
echo var_dump($m or $n);
echo "<br>"; 

echo "For m || n, the result is ";
echo var_dump($m || $n);
echo "<br>"; 

echo "For !m , the result is ";
echo var_dump(!$m);
echo "<br>";

?>