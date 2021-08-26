<?php
// Connecting to the Database
$servername = 'localhost'; 
$username = 'root'; 
$password = ''; 
$database = 'dbshazeb';

// Create a connection
$conn = mysqli_connect($servername, $username, $password, $database); 

// Die if connection was not successful
if (!$conn){
    die("Sorry we failed to connect: ". mysqli_connect_error()); 
}
else {
    echo "Connection was successful<br>"; 
}

// create a table in the db
// create a db pt.2
$sql = "CREATE TABLE `newTable` ( `serialNum` INT(6) NOT NULL , `name` VARCHAR(12) NOT NULL , `position` VARCHAR(6) NOT NULL , PRIMARY KEY (`serialNum`))"; 
$result = mysqli_query($conn, $sql); // query function 

// check for the table creation success
if ($result) {
    echo "<br>The table was created successfully! <br>";  
}
else {
    echo "<br>The database was not created successfully because of this error --> ". mysqli_error($conn); 
    echo "<br>"; 
}


?>