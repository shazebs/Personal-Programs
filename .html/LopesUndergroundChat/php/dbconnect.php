<?php

/* set up a database connection */ 
$server = "localhost";
$username = "";
$password = ""; 
$database = ""; 
$db = new mysqli($server, $username, $password, $database);
if (!$db) {
  die("Sorry we failed to connect: ". mysqli_connect_error()); }

?>
