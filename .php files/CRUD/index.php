<!-- 
Author: Shazeb Suhail & (CodeWithHarry)
Date:   8/27/21
Time:   12:22 AM 
--> 


<!-- Start of PHP script --> 
<?php

// INSERT INTO `notes` (`sno`, `title`, `description`, `tstamp`) VALUES (NULL, 'buy books', 'Please by books from store.', current_timestamp());

  $insert = false;
  $insertElse = false;
  $update = false;
  $delete = false;

  // Connect to the Database details
  $servername = "localhost";
  $username = "root";
  $password = "";
  $databse = "notes"; 


// Create a connection
$conn = mysqli_connect($servername, $username, $password, $databse); 

// Die if the connection was not successful
if (!$conn) {
  die("Sorry we failed to connect: ". mysqli_connect_error()); 
}



// if a delete process when executed as a get request 
if(isset($_GET['delete'])){
  $sno = $_GET['delete'];  
  $delete = true;
  $sql = "DELETE FROM `notes` WHERE `sno` = $sno"; 
  $result = mysqli_query($conn, $sql);
}



// POST method handling 
if($_SERVER['REQUEST_METHOD'] == "POST")
{
  
  if (isset($_POST['snoEdit']))
  {  
    // update the record 
    $sno = $_POST['snoEdit']; 
    $title = $_POST["titleEdit"]; 
    $description = $_POST["descriptionEdit"]; 

    // query some SQL 
    $sql = "UPDATE `notes` SET `title` = \"$title\" , `description` = '$description' WHERE `notes`.`sno` = $sno"; 
    $result = mysqli_query($conn, $sql);

    // update (flag) 
    if ($result)
      $update = true;
    else 
      echo "We could not update the record successfully.";
    
  } 
  else 
  {
    // update variables 
    $title = $_POST["title"]; 
    $description = $_POST["description"]; 

    // query some SQL 
    $sql = "INSERT INTO `notes` (`title`, `description`) VALUES ('$title', '$description')"; 
    $result = mysqli_query($conn, $sql); 

    
    // print success or error message for record insertion completion 
    if ($result) 
    {
      // echo "The record has been inserted successfully! <br>"; 
      $insert = true;
    } 
    else 
    {
      // echo "The record was not inserted successfully because of this error ---> ". mysqli_error($conn); 
      $insertElse = true;
    }
    
  } // end of else 
  
} // end of if 

?> <!-- End of PHP scipt -->  




<!-- start of HTML document --> 
<!doctype html>
<html lang="en">

  
  
  <!-- Start of Head section --> 
  <head>
    
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="//cdn.datatables.net/1.11.0/css/jquery.dataTables.min.css">
    
    
    <!-- Tab Title --> 
    <title>iNotes - Notes taking made easy</title>
    
  </head>
  <!-- End of Head section --> 
  
  

  
  <!-- start of body --> 
  <body>

    
    
    <!-- Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="editModalLabel">Edit this Note</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
        <!-- modal body --> 
        <form action="/CRUD/index.php" method="POST">
          <div class="modal-body">
            <input type="hidden" name="snoEdit" id="snoEdit">
              <!-- modal note title -->
              <div class="mb-3">
                <label for="title" class="form-label">Note Title</label>
                <input type="text" class="form-control" id="titleEdit" name="titleEdit" aria-describedby="emailHelp">
              </div>
              <!-- modal note description -->
              <div class="form-group mb-3">
                <label class ="mb-3" for="description">Note Description</label>
                <textarea class="form-control" id="descriptionEdit" name="descriptionEdit" rows="3"></textarea>
              </div>
          </div>
          <!-- Modal footer --> 
          <div class="modal-footer d-block mr-auto">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">Save changes</button>
          </div>
        </form>
        </div>
      </div>
    </div>
    
    
    

    <!-- start of Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="/CRUD/index.php"><img src="/CRUD/php_oval_logo.png" height="38px" alt="Home"></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <!-- Home navbar option -->  
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <!-- About navbar option -->
              <li class="nav-item">
                <a class="nav-link" href="#">About</a>
              </li>
              <!-- Contact Us navbar option -->
              <li class="nav-item">
                <a class="nav-link" href="#">Contact Us</a>
              </li> 
            </ul> <!-- end of unordered list -->
            <!-- Search navbar option -->
            <form class="d-flex">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
        </div>
      </nav> 
      <!-- end of navbar -->
    
    
    
    
    
     <!-- Start of PHP script --> 
      <?php
      if ($insert){
        echo '<div class="alert alert-success alert-dismissible fade show" role="alert">
              <strong>Success!</strong> Your note has been inserted.
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>'; 
      }
      else if ($insertElse) {
        echo '<div class="alert alert-danger alert-dismissible fade show" role="alert">
              <strong>Error!</strong> Shazeb\'s server has rejected this note and it cannot be inserted.
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>'; 
      }
      ?>
      <?php
      if ($delete){
        echo '<div class="alert alert-success alert-dismissible fade show" role="alert">
              <strong>Success!</strong> Your note has been deleted.
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>'; 
      }
      ?>
      <?php
      if ($update){
        echo '<div class="alert alert-success alert-dismissible fade show" role="alert">
              <strong>Success!</strong> Your note has been updated.
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
              </div>'; 
      }
      ?> <!-- End of PHP script --> 
    
    
    
   
    
      <!-- start of iNotes Form -->
      <div class="container my-4">
          <h2>Add a Note to iNotes</h2>
        <form action="/CRUD/index.php?" method="post">
            <!-- note title -->
            <div class="mb-3">
              <label for="title" class="form-label">Note Title</label>
              <input type="text" class="form-control" id="title" name="title" aria-describedby="emailHelp">
            </div>
            <!-- note description -->
            <div class="form-group mb-3">
              <label class ="mb-3" for="description">Note Description</label>
              <textarea class="form-control" id="description" name="description" rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Add Note</button>
          </form>
      </div> 
      <!-- end of Form -->
    
    
    

      <!-- Start of Data Table --> 
      <div class="container my-4">
        <table class="table" id="myTable">
          <thead>
            <tr>
              <th scope="col">S.No</th>
              <th scope="col">Title</th>
              <th scope="col">Description</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
          <!-- PHP script --> 
          <?php
          $sql = "SELECT * FROM `notes`"; 
          $result = mysqli_query($conn, $sql); 
          $sno = 0; 
          while ($row = mysqli_fetch_assoc($result)){
            $sno = $sno + 1; 
            echo '<tr>
                  <th scope="row">'. $sno . '</th>
                  <td>'. $row['title'] . '</td>
                  <td>'. $row['description'] . '</td>
                  <td><button class="edit btn btn-sm btn-primary" id="' .$row["sno"].'">Edit</button> <button class="delete btn btn-sm btn-primary" id="d' .$row["sno"].'">Delete</button></td>
                </tr>'; 
          }
          ?> <!-- End of PHP script --> 
          </tbody>
        </table>
      </div>
      <hr>
      <!-- End of Data table --> 
    
    
    
    

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="//cdn.datatables.net/1.11.0/js/jquery.dataTables.min.js"></script>
    
    
    
    
    <!-- jQuery --> 
    <script>
      $(document).ready( function () {
          $('#myTable').DataTable();
      } );
    </script>
    
    
    

    <script>
      // For edit button modal toggle
      edits = document.getElementsByClassName('edit'); 
      Array.from(edits).forEach((element)=>{
        element.addEventListener("click", (e)=>{
          console.log("edit ", ); 
          tr = e.target.parentNode.parentNode;
          title = tr.getElementsByTagName("td")[0].innerText;
          description = tr.getElementsByTagName("td")[1].innerText;
          console.log(title, description); 
          titleEdit.value = title;
          descriptionEdit.value = description;
          snoEdit.value = e.target.id;
          console.log(e.target.id); 
          $('#editModal').modal('toggle'); 
        })
      })
      // For delete button modal toggle
      deletes = document.getElementsByClassName('delete'); 
      Array.from(deletes).forEach((element)=>{
        element.addEventListener("click", (e)=>{
          console.log("edit ", ); 
          sno = e.target.id.substr(1,); 
          
          if (confirm("Are you sure you want to delete this note?")){
            console.log("yes"); 
            window.location = `/CRUD/index.php?delete=${sno}`; 
            // to do: Create a form and use post request to submit a form. 
          }
          else {
            console.log("no"); 
          }
        })
      })
    </script>
    <!-- End of Javascript --> 
    
    
    
    

  </body>
  <!-- End of body --> 
</html>
<!-- End of html document --> 
