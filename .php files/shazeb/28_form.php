<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <title>Submit a Form</title>
  </head>
  <body>



  <!-- Navbar --> 
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Shazebalopolis</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<?php // script 
if ($_SERVER['REQUEST_METHOD'] == 'POST'){ // whether a variable has been set or not (isset)
    // variables
    $name = $_POST['name'];
    $email = $_POST['email']; 
    $desc = $_POST['desc']; 

    // Connecting to the Database
    $servername = "localhost";
    $username = 'root';
    $password = '';
    $database = 'contact_us'; 

    // Create a connection
    $conn = mysqli_connect($servername, $username, $password, $database); 
    // Die if the connection was not successful
    if (!$conn) {
        die('Sorry we failed to connect: ' . mysqli_connect_error());
    } else {
        // echo "Connection was successful<br>";
        // Submit these to a database
        // Sql query to be executed
        $sql = "INSERT INTO `messages` (`sno`, `name`, `email`, `concern`, `dt`) VALUES (NULL, '$name', '$email', '$desc', current_timestamp())";
        $result = mysqli_query($conn, $sql); // send an execution query to the database

        if ($result){
            // echo "The record has been inserted successfully!<br>";
            echo '<div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>Success!</strong> Your message was sent to Shazeb.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                  </div>';
        } else{
            echo '<div class="alert alert-danger d-flex align-items-center" role="alert">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
                    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                    </svg>
                    <div>
                    Your message was not sent to Shazeb. Sorry for the inconvenience.
                    </div>
                </div>';
        }
    }
}



?>
<!-- email and password --> 
<div class="container">
<h1>Leave me a message.</h1>

<form action="/shazeb/28_form.php" method="post"> <!-- change action --> 
  <div class="mb-3">
    <label for="name">Name</label> <!-- change for --> 
    <input type="text" name="name" class="form-control" id="name" aria-describedby="emailHelp"> <!-- change id --> 
    <div id="emailHelp" class="form-text"></div>
  </div>

  <div class="mb-3">
    <label for="email">Email</label> <!-- change for --> 
    <input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp"> <!-- change id --> 
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>

  <div class="mb-3">
    <label for="desc" >Description</label>
    <textarea class="form-control" name="desc" id="desc" cols="30" rows="10"></textarea>
    <!-- <input type="password" class="form-control" id="pass" name="pass"> --> 
  </div>

  <!-- Check box 
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div> --> 

  <button type="submit" class="btn btn-primary">Submit</button>

</form>
</div>








    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->
  </body>
</html>
