<?php
/* 
Ways to connect to a MySQL Database
1. MySQLi extension
2. PDO (PHP Data Objects)
*/
// Connecting to the Database
$servername = 'localhost'; 
$username = 'root'; 
$password = ''; 

// Create a connection
$conn = mysqli_connect($servername, $username, $password); 

// Die if connection was not successful
if (!$conn){
    die("Sorry we failed to connect: ". mysqli_connect_error()); 
}
else {
    echo "Connection was successful"; 
}

// create a db
$sql = "CREATE DATABASE dbshazeb"; 
$result = mysqli_query($conn, $sql); // query function 

if ($result) {
    echo "<br>The database was created successfully! <br>";  
}
else {
    echo "<br>The database was not created successfully because of this error --> ". mysqli_error($conn); 
    echo "<br>"; 
} 

?> 