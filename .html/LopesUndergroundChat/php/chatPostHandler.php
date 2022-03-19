<?php
require('dbconnect.php'); 

$chat_text = $_POST["chat"];
$chat_user = $_POST["username"]; 

if ($chat_text && $chat_user)
{
    $sql = "INSERT INTO `chats` (`chat_id`, `chat_text`, `chat_date`, `chat_user`) VALUES (NULL, '".$chat_text."', current_timestamp(), '".$chat_user."')"; 
    $result = mysqli_query($db, $sql); 
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Underground</title>
    <link rel="stylesheet" href="../phpdocs/css/underground.css">
</head>


<body>
    <h1>Welcome to the Underground, <?php echo $chat_user ?>.</h1>
</body>


</html>
