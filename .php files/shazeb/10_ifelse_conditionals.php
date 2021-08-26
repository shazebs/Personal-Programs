<?php
$a = 65; 
$b = 9; 

echo "a = $a and b = $b <br>"; 

if ($a > 78) {
    echo "a is greater than 78 <br>"; 
}
else {
    echo "a is not greater than 78 <br>"; 
}
echo "<br>"; 


$age = 13; 

echo "(if age is greater than 18): "; 
// If else ladder 
if ($age > 18) {
    echo "you can drink water with chai and alcohol <br>"; 
}
elseif ($age > 13) {
    echo "You can drink chai only with water. No alcohol for you <br>"; 
}
else {
    echo "you can drink water only <br>"; 
}
echo "Your age = $age" . "<br><br>"; 

?> 