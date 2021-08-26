<?php
// Connecting to the Database
$servername = "localhost";
$username = 'root';
$password = '';
$database = 'dbshazeb'; 

// Create a connection
$conn = mysqli_connect($servername, $username, $password, $database); 
// Die if the connection was not successful
if (!$conn) {
    die('Sorry we failed to connec: ' . mysqli_connect_error());
} else {
    echo "Connection was successful<br>";
}

// Variables to be inserted into the table
$name = "Sharoon"; 
$destination = "Cop";

// Sql query to be executed
$sql = "INSERT INTO `table1` (`sno`, `name`, `position`) VALUES (NULL, '$name', '$destination');";
$result = mysqli_query($conn, $sql); // send an execution query to the database

// Add a new user to the newTable in the database
if ($result){
    echo "The record has been inserted successfully!<br>";
} else{
    echo "The record was not inserted successfully because of this error ---> " .
    mysqli_error($conn); 
}

?> 