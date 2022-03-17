<?php

require('../php/dbconnect.php'); 

/* retrieve POST variables */ 
$chat_text = "";
$chat_user = ""; 

/* insert a new chat into the database */
$sql = "INSERT INTO `chats` (`chat_id`, `chat_text`, `chat_date`, `chat_user`) VALUES (NULL, '".$chat_text."', current_timestamp(), '".$chat_user."');";
$result = mysqli_query($db, $sql);

/* insertion success message */ 
if ($result){
    echo 'Successful Insert!<br>'; 
}
else {
    echo 'Unsuccessful Insert.<br>'; 
}

/* close the connection */ 
$db->close();
?>
