<?php

// database connection details 
$serverName = "localhost";
$userName = ""; 
$password = ""; 
$dbName = ""; 

// try to connect to database 
$dbc = mysqli_connect($servername, $username, $password, $dbname) 
    OR die ( mysqli_connect_error() ); 
    mysqli_set_charset($dbc, 'utf8'); 

// print a successful database response 
if ($dbc->connect_error){
    die("Connection failed: " . $conn->connect_error);
}
else {
    echo '<h3>Successfully connected to Database : ' . $dbName . '</h3>';
}

// Close the connection
$dbc->close();

?>
