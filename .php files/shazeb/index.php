<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php echo "Shazeb's "; echo "Webpage" ?></title>

    <style>
        a {
            font-size:22px;
            color: blue; 
        }
    </style>
</head>
<body>
    <?php
    // echo "Hello WRLD"; 
    // echo 999;
    echo "<h1>Shazebalopolis.php Server</h1><hr>";  
    $name = "<span style=\"color:red\">Shazeb</span>";
    $income = 20000000; 
    echo "This guy is $name and his income is <span style=\"color:green\">$income</span>.";
    echo "<br>";  
    

    echo '<br><a href="/shazeb/finances.php">finances.php</a><br>'; 
    echo '<a href="http://shazebs.com/">shazebs.com</a><br>'; 
    echo '<a href="/shazeb/gcu_supplies.php">gcu_supplies.php</a><br>';
    echo '<a href="/shazeb/resume_notes.php">resume_notes.php</a><br>';
    echo "<br>"; 
    echo '<a href="/shazeb/24_MySql.php">24_MySql.php</a><br>'; 
    echo '<a href="/shazeb/25_create_db.php">25_create_db.php</a><br>'; 
    echo '<a href="/shazeb/26_create_table.php">26_create_table.php</a><br>';
    echo '<a href="/shazeb/27_insert_data.php">27_insert_data.php</a><br>';

    echo "<br>"; 
    echo '<a href="/shazeb/21_get_post.php">21_get_post.php</a><br>';
    echo '<a href="/shazeb/28_form.php">28_form.php</a><br>';
    echo '<a href="/shazeb/29_select_data.php">29,_select_data.php</a><br>';
    ?>

</body>
</html>

