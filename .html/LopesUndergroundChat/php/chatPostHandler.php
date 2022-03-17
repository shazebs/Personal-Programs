<?php

require('../php/dbconnectLopes.php'); 

/* retrieve POST variables */ 
$chat_text = $_POST["chat"];
$chat_user = $_POST["username"]; 

/* insert a new chat into the database */
$sql = "INSERT INTO `chats` (`chat_id`, `chat_text`, `chat_date`, `chat_user`) VALUES (NULL, '".$chat_text."', current_timestamp(), '".$chat_user."');";
$result = mysqli_query($db, $sql);

/* insertion success message */ 
if ($result){
    echo 'Successful Insert!<br>'; 
    // echo '<a href="../login.html">Click here to return to chat.</a>'; 
    echo '<a href="../phpdocs/underground.php">Click here to return to chat.</a>'; 
}
else {
    echo 'Unsuccessful Insert.<br>'; 
}

/* close the connection */ 
$db->close();
?>
