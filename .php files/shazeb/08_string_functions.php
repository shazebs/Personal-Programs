<?php

$name = "Shazeb Suhail"; 
echo $name; 
echo "<br>"; 

echo "The length of my string is " . strlen($name) . ".<br>"; // prints the length of the string. 
echo str_word_count($name); // prints the number of words in a string 
echo "<br>";
echo strrev($name); // reverses the string 
echo "<br>"; 
echo strpos($name, "zeb") . "<br>"; // print the starting index of text in the string
echo str_replace("Suhail", "the Wizard", $name) . "<br>"; // replace a part of the string
echo ($name) . "<br>";
echo str_repeat($name, 101); // repeat the string a given number of times
echo "<br>";
echo "<pre>"; 
echo rtrim("    Suhail    "); 
echo ltrim("   Suhail    "); 
echo "</pre>";

?>