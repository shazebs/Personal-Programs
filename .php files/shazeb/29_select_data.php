<style>
    .notif {
        color:green;
    }
</style>

<?php
// Connecting to the database
$servername = 'localhost';
$username = 'root';
$password = '';
$database = 'contact_us';

// Create connection
$conn = mysqli_connect($servername, $username, $password, $database); 
if (!$conn){
    die("Sorry we failed to connect to Shazeb's server". mysqli_connect_error());
} else{
    echo "Connection to Shazeb's database was successful. <br>";
}

// create a sql query
$sql = "SELECT * FROM `messages`"; // sql query content
$result = mysqli_query($conn, $sql); // call the sql query 

// find the number of records returned
$num = mysqli_num_rows($result); 
echo '<span class="notif">Number of messages saved: '. $num . '</span><br>'; 

// Display the rows returned by the sql query one by one
// if ($num > 0){
//     $row = mysqli_fetch_assoc($result); 
//     echo var_dump($row); 
//     echo "<br>";
//     $row = mysqli_fetch_assoc($result); 
//     echo var_dump($row); 
//     echo "<br>"; 
// }

// Display the rows returned by the sql query by looping (fetching data from database)
while ($row = mysqli_fetch_assoc($result)){
    // echo var_dump($row); 
    echo $row['sno'] . ") Hello ". $row['name'] . ", email: " . $row['email'] . ", concern: " . $row['concern']; 
    echo "<br>"; 
}

?>