<?php

/* set up a database connection */ 
$server = "localhost";
$username = "u300175299_sora";
$password = "Glydeub40"; 
$database = "u300175299_dbsora"; 
$db = new mysqli($server, $username, $password, $database);
if (!$db) {
  die("Sorry we failed to connect: ". mysqli_connect_error()); }

/* retrieve all recent chats into an array */ 

/* insert a new chat into the database */
/*
$sql = "INSERT INTO `chats` (`chat_id`, `chat_text`, `chat_date`, `chat_user`) VALUES (NULL, 'First chat attempt', current_timestamp(), 'anonymous');";
$result = mysqli_query($db, $sql);
if ($result){
    echo 'Successful Insert!<br>'; }
else { echo 'Unsuccessful Insert.<br>'; }
*/ 

/* close the connection */ 
// $db->close();
?>
