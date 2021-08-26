<?php
echo "Welcome to the world of foreach lopos <br>"; 
$arr = array("Bananas", "Apples", "Watermelon", "Carrots", "Rotis"); 

/*
for ($i=0; $i < count($arr); $i++){
    echo $arr[$i]; 
    echo "<br>"; 
}  */

// better way to do this - foreach loops
foreach ($arr as $value) {
    echo "$value <br>"; 
}

?>