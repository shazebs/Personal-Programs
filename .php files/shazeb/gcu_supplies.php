<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <title>GCU Supplies</title>

    <style>
        li {
            color:#036bfc; 
        }
    </style>
  </head>

  <body>

<h1 style="color:rebeccapurple">GCU Supplies </h1><hr>

<?php

    // create an array of items. 
    $items = array(
        'Twin extra-long bedding', 
        'Mini-fridge',
        'Small fan', 
        'Desk lamp',
        'Stereo',
        'Calendar', 
        'Microwave', 
        'Iron (with auto-off function)',
        '3-monitor computer',
        'i7 Laptop', 
        'Non-wireless printer',
        'Television', 
        'Alarm clock', 
        'Blanket',
        'Foldable chairs',
        'Toiletries', 
        'Plexi-cabinets',
        'Laundry basket',
        'Laundry detergents',
        'Small trash can', 
        'Passport',
        'Medical insurance card',
        'cups, plates, bowls, and flatware',
        'Duffle bag or suitcase',
        'First aid kit',
        'Hand sanitizer and kleenex',
        'Power strips and extension cords',
        'School supplies',
        'Sleeping bags',
        'Toilet paper',
        'Towels',
        'Water flask',
        'Toilet brush',
        'Cleaning clothes',
        'Vaccum', 
        'Toilet and shower cleaner',
        'Cleaning wipes and disinfectant spray',
        'Coffee table',
        'Side table',
        'Night table',
        'Bean bag chairs',
        'Pictures/posters', 
        'Floor rug'
    ); 

    echo "<ul>"; 
    foreach ($items as $item) {
        echo "<li>" . $item . "</li>"; 
    }
    echo "</ul>"; 

?> 







    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->
  </body>
</html>