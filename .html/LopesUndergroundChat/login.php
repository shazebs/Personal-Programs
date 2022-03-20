<?php
require('dbconnect.php'); 

/* retrieve POST variables */ 
// $chat_text = $_POST["chat"];
// $chat_user = $_POST["username"]; 

/* chat POST handler on current page */ 
/*
if ($chat_text && $chat_user) 
{
    // insert a new chat into the database
    $sql = "INSERT INTO `chats` (`chat_id`, `chat_text`, `chat_date`, `chat_user`) VALUES (NULL, '".$chat_text."', current_timestamp(), '".$chat_user."');";
    $result = mysqli_query($db, $sql);

    // insertion success message  
    if ($result){
        echo 'Successful Insert!<br>'; 
    }
    else {
        echo 'Unsuccessful Insert (Empty fields).<br>'; 
    }
} */

?>

<!DOCTYPE html>
<html lang="en">
    
<!-- start of head section --> 
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login-Lopes-Underground</title>

    <!-- Bootstrap and jQuery plugins -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    
    <link rel="stylesheet" href="../shazebalopolis/css/underground.css">

</head>
<!-- end of head section --> 

    
<!-- start of body section --> 
<body>
    
    <!-- page title --> 
    <h1 style="">Members Only</h1><hr>

    <!-- chat form -->
    <form action="underground.php" method="POST">


        <div class="username"><input name="username" placeholder="Username" style="text-align:center"></div>
        <div class="password" style="margin-top: -5px;"><input name="password" type="password" placeholder="Password" style="text-align:center"></div>
        <input class="btn-submit" name="submit" type="submit" value="Login"><hr>

    </form>
    <!-- end of chat form --> 

</body>
<!-- end of body section --> 

</html>
