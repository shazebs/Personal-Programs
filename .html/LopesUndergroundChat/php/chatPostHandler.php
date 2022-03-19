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

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Underground.css</title>
    <link rel="stylesheet" src="">
</head>
    
    
<body>
    <h1>Welcome to the Underground</h1>
</body>

</html>

