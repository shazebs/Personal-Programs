<?php

// database connection details 
$server = "localhost";
$username = ""; 
$password = ""; 
$databse = ""; 

//Connect with the database
$db = new mysqli($server, $username, $password, $databse);

// Check connection
if ($db->connect_error){
    die("Connection failed: " . $db->connect_error);
}
else {
    echo '<h3>Successfully connected to Database : '.$databse.'</h3>';
}

// Close the connection
$db->close();
?>
