<?php

/*
if ($db->connect_error){
    die("Connection failed: " . $db->connect_error);
}
else {
    echo '<h3>Successfully connected to Database : ' . $database . '</h3>';
}
*/

// execute the query 
/*
if ($db->query($sql) === TRUE){
        echo 'Successful Insert!<br>'; 
}
else{
    echo 'Unsuccessful Insert.<br>'; 
}
*/

/* set up a database connection */ 
$server = "localhost";
$username = "u300175299_sora";
$password = "Glydeub40"; 
$database = "u300175299_dbsora"; 
$db = new mysqli($server, $username, $password, $database);
// Die if the connection was not successful
if (!$db) {
  die("Sorry we failed to connect: ". mysqli_connect_error()); 
}


/* retrieve all recent chats into an array */ 


/* insert a new chat into the database */
// sql query 
$sql = "INSERT INTO `chats` (`chat_id`, `chat_text`, `chat_date`, `chat_user`) VALUES (NULL, 'First chat attempt', current_timestamp(), 'anonymous');";
// execute the query 
$result = mysqli_query($db, $sql);
if ($result){
    echo 'Successful Insert!<br>'; 
}
else{
    echo 'Unsuccessful Insert.<br>'; 
}


/* close the connection */ 
$db->close();


?>
