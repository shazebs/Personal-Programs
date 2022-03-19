<?php

/* set up a database connection */ 
$server = "localhost";
$username = "u300175299_sora";
$password = "Glydeub40"; 
$database = "u300175299_dbsora"; 
$db = new mysqli($server, $username, $password, $database);
if (!$db) {
  die("Sorry we failed to connect: ". mysqli_connect_error()); }

?>
