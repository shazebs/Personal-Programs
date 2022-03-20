<?php
require('dbconnect.php');

$username = $_POST["username"];
$password = $_POST["password"];
$writeName = false;

if ($username && $password) {
    // $sql = "";
    // $result = mysqli_query($db, $sql);
    $writeName = true;
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Underground</title>
    <link rel="stylesheet" href="../shazebalopolis/css/underground.css">

    <!-- bootstrap css -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">

</head>


<body style="
background-image:url(https://i.ytimg.com/vi/WxpAEBXqWKs/maxresdefault.jpg);">


    <h1 class="lopesWelcome"><span style="border-bottom: 4px dashed white">Welcome to Lopes</span> <big><sub style="">Underground.</sub></big></h1>
    <hr>




</body>

<!-- Bootstrap and jQuery plugins -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>


</html>
