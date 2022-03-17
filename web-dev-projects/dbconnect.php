<?php

// database connection details 
$serverName = "localhost";
$userName = ""; 
$password = ""; 
$dbName = ""; 

// try to connect to database 
$db = mysqli_connect($servername, $username, $password, $dbname) 
    OR die ( mysqli_connect_error() ); 
    mysqli_set_charset($dbc, 'utf8'); 

//Connect with the database
$db = new mysqli($dbHost, $dbUsername, $dbPassword, $dbName);

// Check connection
if ($db->connect_error){
    die("Connection failed: " . $db->connect_error);
}
else {
    echo '<h3>Successfully connected to Database : ' . $dbName . '</h3>';
}

// Close the connection
$db->close();

?>
