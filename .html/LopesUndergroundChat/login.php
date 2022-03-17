<?php

require('../phpdocs/dbconnectLopes.php'); 

/* retrieve POST variables */ 
$chat_text = $_POST["chat"];
$chat_user = $_POST["username"]; 

if ($chat_text && $chat_user) 
{
    /* insert a new chat into the database */
    $sql = "INSERT INTO `chats` (`chat_id`, `chat_text`, `chat_date`, `chat_user`) VALUES (NULL, '".$chat_text."', current_timestamp(), '".$chat_user."');";
    $result = mysqli_query($db, $sql);

    /* insertion success message */ 
    if ($result){
        echo 'Successful Insert!<br>'; 
        // echo '<a href="../phpdocs/login.php">Click here to return to chat.</a>'; 
        // echo '<a href="../phpdocs/underground.php">Click here to return to chat.</a>'; 
    }
    else {
        echo 'Unsuccessful Insert (Empty fields).<br>'; 
    }
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
    <title>Login-LopesUnderground</title>

    <!-- Bootstrap and jQuery plugins -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>

    <style>

        @import url('https://fonts.googleapis.com/css2?family=League+Spartan:wght@300&family=Roboto+Mono&family=Source+Code+Pro&display=swap');

        body {
            margin-top: 10px;
            background:black;
            color:white;
            text-align:center;
            background-image:url(https://www.theregreview.org/wp-content/uploads/2020/06/regulatingcommercialspace.jpg);
            background-size:cover;
            background-repeat: no-repeat;
            background-attachment:fixed;
            text-shadow: 2px 2px black;
            background-position: center;
            font-family: 'League Spartan', sans-serif;
        }
        h1 {
            text-align: center;
            font-size: 2.5rem;
        }
        form {
            /* margin-left:50px; */
        }
        textarea {
            width: 300px;
            height: 300px; 
        }

        div.firstname {
            font-size:2rem;
            margin: 10px 0 20px 0; 
        }
        .firstname input {
            width: 30%; 
            font-size:16px;
        }

        div.lastname {
            font-size:2rem;
            margin: 10px 0 20px 0; 
        }
        .lastname input {
            width: 30%; 
            font-size:16px;
        }

        div.username {
            font-size:2rem;
            margin: 10px 0 20px 0; 
        }
        .username input {
            width: 30%; 
            font-size:16px;
        }

        div.password {
            font-size:2rem;
            margin: 10px 0 20px 0; 
        }
        .password input {
            width: 30%; 
            font-size:16px;
        }

        .btn-submit {
            font-size:1.25rem;
            margin-top:10px;
            padding:7px;
            border-radius:8px;
        }
        .btn-submit:hover {
            opacity: 0.8; 
        }

        
        @media (max-width: 500px)
        {
            h1 {
                font-size:2rem;
            }
            .firstname input {
                width: 50%; 
                font-size:16px;
            }
            .lastname input {
                width: 50%; 
                font-size:16px;
            }
            .username input {
                width: 50%; 
                font-size:16px;
            }
            .password input {
                width: 50%; 
                font-size:16px;
            }
        }

    </style>

</head>

<body>
    <h1>Add a Public Comment</h1>

    <!-- chat form -->
    <form action="underground.php" method="POST">

        <!-- chat -->
        <div class="">
            Chat<br>
            <textarea name="chat" type="text"></textarea>
        </div><br>
        <!-- username -->
        <div class="">From:<br>
            <input name="username" type="text">
        </div>
        
        <!-- Submit button -->
        <br>
        <input class="btn-submit" name="Submit" type="submit"/><br>

    </form>

</body>

</html>
