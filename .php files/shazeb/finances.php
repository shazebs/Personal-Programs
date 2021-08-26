<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <title>PHP Finances</title>

    <style>
        h1 {
            text-align:center;
            color: blue; 
        }

        .header {
            font-size:22px; 
        }

        .debt {
            color:red;
        }

        .money {
            color:green;
        }

        .box {
            border: 2px solid black;
            padding:0.5%; 
        }

        .min {
            color: green; 
        }

    </style>
  </head>
  <body>
    <?php
        $name = "Shazeb"; 
        // access to money 
        $checkings = 31.21; 
        $savings = 23.99; 
        $cash = 232.00; 
        $coins = 42.69; 
        // access money total 
        $moneyTotal = ($checkings + $savings + $cash + $coins); 
        // debt money 
        $bestbuyTotal = 2267.76; $bestbuyMin = 226.71;  // 7th 
        $walmartTotal = 1221.23; $walmartMin = 97.00;   // 5th
        $chaseTotal   = 2478.79; $chaseMin   = 162.00;  // 11th
        $ramonaTotal  = 580.05;  $ramonaMin  = 74.00;   // 1st
        $staplesTotal = 150.36;  $staplesMin = 63.00;   // 16th   
        // debt money totals
        $debtTotal = ($bestbuyTotal + $walmartTotal + $chaseTotal + $ramonaTotal + $staplesTotal); 
        $debtMinPayment = ($bestbuyMin + $walmartMin + $chaseMin + $ramonaMin + $staplesMin); 
    ?> 

    <!-- Welcome back, user. tag --> 
    <h1>Welcome back, <?php echo $name ?>.</h1><hr>

    <!-- My Wallet --> 
    <p class="header" style="color:green; margin-left:15px;">MY WALLET:</p>
    <?php
        echo "<ul>"; 
        echo "<li>Checkings: <span class=\"money\">$" . $checkings . "</span></li>"; 
        echo "<li>Savings: <span class=\"money\">$" . $savings . "</span></li>";
        echo "<li>Cash: <span class=\"money\">$" . $cash . "</span></li>";
        echo "<li>Coins: <span class=\"money\">$" . $coins . "</span></li>";
        echo "</ul>"; 
        echo "<p style=\"margin-left:15px\"><div class=\"box\">Total Money: <span class=\"money\">$" . $moneyTotal . "</span></div></p>"; 
    ?>

    <!-- My Debt -->
    <p class="header" style="color:red; margin-left:15px;">MY DEBT:</p> 
    <?php
        echo "<ul>";
        echo "<li>Best Buy CC: <span class=\"debt\">$" . $bestbuyTotal . "</span><p>Min.payment: <span class=\"min\">$" . $bestbuyMin . "</span></p>"; 
        echo "<li>Walmart CC: <span class=\"debt\">$" . $walmartTotal . "</span><p>Min.payment: <span class=\"min\">$" . $walmartMin . "</span></p>"; 
        echo "<li>Chase CC: <span class=\"debt\">$" . $chaseTotal . "</span><p>Min.payment: <span class=\"min\">$" . $chaseMin . "</span></p>"; 
        echo "<li>Ramona Tire CC: <span class=\"debt\">$" . $ramonaTotal . "</span><p>Min.payment: <span class=\"min\">$" . $ramonaMin . "</span></p>"; 
        echo "<li>Staples CC: <span class=\"debt\">$" . $staplesTotal . "</span><p>Min.payment: <span class=\"min\">$" . $staplesMin . "</span></p>"; 
        echo "</ul>"; 
        echo "<p style=\"margin-left:15px\"><div class=\"box\">Total Debt: <span class=\"debt\">$". $debtTotal . "</span>" . 
             "<span class=\"margin-left:15px\"><br>Monthly Minimum: <span class=\"min\">$". $debtMinPayment . "</span></span></div></p>"; 
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
