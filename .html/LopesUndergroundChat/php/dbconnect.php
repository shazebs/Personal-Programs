<?php

/*
if ($db->connect_error){
    die("Connection failed: " . $db->connect_error);
}
else {
    echo '<h3>Successfully connected to Database : ' . $database . '</h3>';
}
*/

$server = "localhost";
$username = "RemoteMySQL";
$password = "hostinger123"; 
$database = "LopesChat"; 

$db = new mysqli($server, $username, $password, $database);

// Die if the connection was not successful
if (!$db) {
  die("Sorry we failed to connect: ". mysqli_connect_error()); 
}


?>
