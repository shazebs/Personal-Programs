<?php

require('../php/dbconnect.php'); 

/* retrieve POST variables */ 
$chat_text = $_POST["chat"];
$chat_user = $_POST["username"];

/* insert new chat into database */
$sql = "INSERT INTO `chats` (`chat_id`, `chat_text`, `chat_date`, `chat_user`) VALUES (NULL, '".$chat_text."', current_timestamp(), '".$chat_user."');";
$result = mysqli_query($db, $sql);

/* if success */ 
if ($result){
    echo 'Successful Insert!<br>'; 
}
/* if fail */ 
else {
    echo 'Unsuccessful Insert.<br>'; 
}

/* close the connection */ 
$db->close();
?>
