<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Shazeb's Webpage</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!-- css section --> 
        <style>

            body {
                background-color:black;
                background-image:url(https://www.lockheedmartin.com/content/dam/lockheed-martin/space/photo/exploration/Earth_Moon_Mars.jpg.pc-adaptive.full.medium.jpeg); 
                background-repeat: no-repeat; 
                background-position: center;  
                background-size: cover;
                text-align: center;
                color: navajowhite;
                margin: auto; 
            }

            .g2mamu {
            font-size:22px;
            color:blue;
            background-image:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhiFeWK8SRbq_4epXDjLoPVbB97g7oG_yFRQ&usqp=CAU);
            background-size:152%;
            background-repeat: no-repeat;
            background-color:white;
            background-position:left;
            width:300px;
            height:100px;     
        }
        
        .ronnie {
            width:300px;
            height:100px;
            background:white; 
            background-image:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_ptCidq9c2kvxFydSO4RJfNJP40qui43gQA&usqp=CAU);
            background-position:center;
            background-size:85%; 
            background-repeat:no-repeat;
        }
        
        .lilpeep {
            width:300px;
            height:100px;
            background:black;
            background-image:url(images/lil_peep.png); 
            background-size:50%;
            background-repeat:no-repeat;
            color:white;
            font-size:215%; 
            font-family:courier;
            line-height:0.6; 
            text-align:right;
            padding-right:5px;
        }
        
        .GCU {
            width:300px;
            height:100px;
            background-color: white;
            background-image:url(https://i.pinimg.com/originals/4c/de/b5/4cdeb53d7bb0a16f935b100b01be18a1.jpg); 
            background-size:55%; 
            background-repeat:no-repeat;
            color:rebeccapurple; 
            font-size:265%;
            text-align: right;
            padding-right:5px;
        }
        
        button.immortality {
            width:300px;
            height:100px;
            background-image:url(https://t3.ftcdn.net/jpg/01/75/09/70/360_F_175097055_S6L3gm4PjWnMKrFGrfJYlPbxHPjkBF8U.jpg); 
            background-size:cover;
            color:white;
            font-size:22px;
        }
        
        button.groceries {
            width:300px;
            height:100px;
            font-size:200%;
            background-color:white;
            background-image:url(https://st.depositphotos.com/1066961/1972/i/950/depositphotos_19721419-stock-photo-torn-lined-paper-banner-isolated.jpg);
            background-size:95%;
            background-repeat:no-repeat;
            background-position:center;
            
        }
        
        button.itinerary {
            width:300px;
            height:100px;
            font-size:150%;
            background-image:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_M6SzMy82SMHPAcWvpDIZoTiPKYXvhxnswA&usqp=CAU);
            background-size:25%;
            background-position:left;
            background-repeat:no-repeat;
            background-color:white;
        }
        
        button.calendar {
            width:300px; 
            height:100px;
            font-size:28px;
            background-image:url(https://www.teahub.io/photos/full/6-61670_material-design.jpg);
            background-size:100%;
            background-repeat:no-repeat;
            background-position:bottom;
            color:white;
        }
        
        button.earthButton {
            width:300px; 
            height:100px;
            background-image:url(https://orsted.com/-/media/www/images/corp/campaign/spacesafari/space-safari-background.png);
            background-size:175px;
            text-align:center;
            margin-bottom:4px;
        }
        
        button.hourly {
            width: 300px;
            height: 100px;
            background-image:url(https://images.squarespace-cdn.com/content/v1/591faa5a20099ec6b0cf3e80/1533774724372-7H97EE2DVHXM74MF70ZV/Hourly.PNG?format=1000w);
            background-size:40%;
            background-repeat:no-repeat;
            background-position:right;
            text-align:left;
            font-size:20px;
            font-weight:bold;
            background-color:white;
        }

        button.tweeter {
            width:300px;
            height: 100px;
            background:lightblue;
            background-image:url(https://miro.medium.com/max/1200/0*YiX-u7Ma0l7-veKQ.jpg);
            background-size:100%;
            background-position:center;
            background-repeat:no-repeat;
        }
        
            .progress {
                border: 2px solid navajowhite;
                width: 10%;
                position: fixed;
                top: 10px; right: 10px;
            }
            /* ??? */ 
            .progress > div {
                height: 12px; 
                background: #32a852;
                width: 0%;
            }
            .code {
                font-weight:100;
            }
        </style>
    </head>

    <body> 

    <!-- Create the status bar here --> 
    <div class="progress"><div></div></div>
        <p>Author: Shazeb Suhail</p>
        <!-- Javascript --> 
        <script>
            // create an object that targets the status bar <div>
            var bar = document.querySelector(".progress div");
            addEventListener("scroll", function() {
                var max = document.body.scrollHeight - innerHeight;
                var percent = (pageYOffset / max) * 100; 
                // Adjust the css <style> 'width'
                bar.style.width = percent + "%";
            });
        </script>
    
    
    
    
    
    
    <!-- Website Header 1 Text -->    
    <h1 style="text-align: center; color:navajowhite; font-size: 300%;">
    <i>Welcome to Shazebalopolis</i></h1><hr>
    <pre style="color:ghostwhite; text-align:center; padding-right:25px;">
    <b style="font-size:180%">Main Menu:</b><i> (click a button)</i></pre>
    
    
    
    
    <!-- Rotating Earth --> 
    <form action="RotatingEarth.html" method="get" target="_blank">
    <button class="earthButton">
        
        <!-- The Earth --> 
        <img src="https://cdn.freelogovectors.net/wp-content/uploads/2017/05/Earth.png" style="position:relative; width:50px; margin-top:15px" id="earthImg">     
        
        
        <script>
            var cat = document.querySelector("img")
            var angle = 0, lastTime = null;
            function animate(time) {
                angle += (time - lastTime) * 0.001;
                lastTime = time; 
                cat.style.top = (Math.sin(angle) * 3) + "px"; 
                cat.style.left = (Math.cos(angle) * 85) + "px"; 
                requestAnimationFrame(animate);
            } 
            requestAnimationFrame(animate);
        </script>
        
        <p id="currentDate" style="color:white; font-size:110%; line-height:0; font-family:monospace; position:relative;">We Are Here</p>
        <script>
            var today = new Date();
            var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            console.log(date);

            var element = document.getElementById("currentDate"); 
            element.textContent = date; 
        </script>
        
    </button>
    </form>
    
    
    
    
    <!-- ///////////////////////////// Days Between Dates Button ///////////////////////////// --> 
    
    <form action="days.html" method="get" target="_self"> 
        <button style="width:300px; 
                       height:100px; 
                       background:black; 
                       color:black; 
                       font-size:140%;
                       background-image:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUs6UgexaE7i2Niz_qMWTBtT6OAAsU5DdXnw&usqp=CAU); 
                       background-size:65%; 
                       background-repeat: repeat-x; 
                       text-align: center; 
                       background-position: center; 
                       font-family: monospace; ">
            <b style="background:lightcoral">Days Between Dates <span style="color:white">Calculator</span></b>
        </button>
    </form>
    
    
    
        <!-- Hourly Schedule Button --> 
    <form action="HourlySchedule.html" method="get" target="_self">
    <button class="hourly"><span style="margin-left:15px">Hourly Schedule</span>
    </button>
    </form>
    
    
    
    <!-- /////////////////////////////// Twitch Button ///////////////////////////// -->
    
    <!-- background-image:url(https://www.graphis.com/media/uploads/cfe/entry/a6403de8-e17e-46b1-8e34-e97371714ab4/01_twitch_logo1.jpg); -->
    <form action="https://www.twitch.tv/sapherons" method="get" target="_blank">
    <button  style="background:black; 
                    width:300px; 
                    height:100px; 
                    background-image:url(https://blog.twitch.tv/assets/uploads/generic-email-header-1.jpg);
                    background-size: 100%; 
                    background-repeat: no-repeat;
                    background-position: center">
        <!-- 
        <p style="color:white">
            <a href="https://www.twitch.tv/sapherons" style="color:rebeccapurple; font-size: 200%" target="_blank" 
               title="twitch.tv/sapherons">
            Twitch.tv
            </a>
        </p> --> 
    </button></form>
    
    
      
    
    <!-- //////////////////////////////////// Youtube Button ///////////////////////////////////--> 
    
    <form action="https://www.youtube.com/" method="get" target="_blank"> 
    <button style="background:white;
                   background-image:url(https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Logo_of_YouTube_%282015-2017%29.svg/1280px-Logo_of_YouTube_%282015-2017%29.svg.png); 
                   background-size:contain;
                   background-size: 60%;
                   background-repeat: no-repeat;
                   background-position: center;
                   width:300px; 
                   height:100px;">
        <!-- 
        <p style="color:white; font-size: 200%">Youtube
        <span style="color:yellow; font-size:50%">
            <br>(This feature is not yet available)
        </span></p> --> 
    </button></form>
    
    
    
    <!-- /////////////////////////////////// Github Button ////////////////////////////////// -->   
    
    <!-- background-image: url(https://www.dsxhub.org/wp-content/uploads/2021/03/DataLab_-_Chapitre_0_-_Fabriquer_sa_station_de_mesure_connect_e_github-logo-640x320-1.png); --> 
    <form action="https://github.com/shazebs/Personal-Programs" method="get" target="_blank">
    <button style="background:black; 
                   width:300px; 
                   height:100px; 
                   background-image:url(https://ih1.redbubble.net/image.981584875.3083/flat,750x,075,f-pad,750x1000,f8f8f8.jpg);
                   background-size: 105%; 
                   background-repeat: no-repeat;
                   background-position: center" 
            title="github.com/shazebs/personal-programs"
            type="submit">
        <!-- 
        <p style="color:black; font-size:150%">
            <a href="https://github.com/shazebs/Personal-Programs" style="color:blue; font-size:150%" target="_blank">
                Github </a>
        </p> -->  
    </button></form>

    
            <!-- ////////////////////////////////// Juice WRLD Tribute Button ///////////////////////////////// --> 
    
    <form action="juiceWRLD.html" method="get" target="_self">
    <button style="width:300px; height:100px;
                   
                   background-image: url(https://media.pitchfork.com/photos/5b44ddb642074f59ca4a9827/2:1/w_790,h_395,c_limit/Juice%20WRLD%20and%20Lil%20Uzi%20Vert.png); 
                   
                   background-size:cover">
        
        <p style="color:red; font-size:185%"><b style="background-color: aliceblue">Juice WRLD<br>Tribute</b><br>
            <!-- <span style="color:black; font-size:66%; background-color: yellow">(This feature is not yet available)</span> --> 
        </p>
    </button>
    </form> 
    
        
    <!-- //////////////////////////// Lil Peep Tribute Button ////////////////////////////// --> 
    
    <form action="peep.html" method="get" target="_self">
    <button class="lilpeep">Tribute<br>
        <!-- <span style="font-size:30%; color:white; background:#d246eb;">(Feature not yet available)</span> --> 
    </button>
    </form> 
    
    
    

    
    
    
    
    <!-- Calendar Button --> 
    <form action="calendar.html" method="get" target="_self">
    <button class="calendar"><div style="border:3px solid white">2021 CALENDAR</div></button>
    </form>
    
    
    
    
    
    <!-- Itinerary Button --> 
    <form action="itinerary.html"
          method="get"
          target="_self">
    <button class="itinerary"><b style="margin-left:60px;">Daily Itinerary</b></button>
    </form>
    
    
    
    
    
    <!-- Groceries List Button --> 
    <form action="groceries.html" 
          method="get"
          target="_self">
    <div id="overlayGroceries">
        <button class="groceries">Groceries List</button>
    </div>
    </form>
    
    
    
    
    
    
    
    <!-- Immortality Button  
    <form action="rickrollpage.html" method="get" target="_self">
        <button class="immortality">
            Click Here for Immortality
    </button>
    </form> -->
    
    
    

    
          
    
    <!-- ////////////////////////////// Classic World Rugs Button ///////////////////////////// --> 
    
    <form action="https://classicworldrugs.com/" method="get" target="_blank">
        <button class="g2mamu">
        </button>
    </form>
    
    
    
    
    <!-- ////////////////////////////// Falling in Reverse Button //////////////////////////// --> 
    
    <button class="ronnie" onclick="radke()">
    </button>
    <br>
    
           
    
    
    
    <!-- //////////////////////////// GCU Vlogs Button ///////////////////////////// --> 
    
    <button class="GCU" onclick="gcuVlogs()"><b>Vlogs</b>
    </button>
    
    
    
    
    <!-- ///////////////////////////// Fitness Journey Button ////////////////////////////////--> 
    <br>
    <button style="width:300px; height:100px; 
                   background-size:cover;
                   background-color:lightslategrey;
                   background-image:url(https://previews.123rf.com/images/fredex8/fredex81505/fredex8150500080/39505904-under-construction-tape-background.jpg);
                   background-position: left;"
            onclick="fitnessJourney();">
        
        <p style="color:black; font-size:200%;"><b style="background:black; color:lightgreen">Fitness Journey</b><br>
        <span style="color:white; background:black; font-size:66%;">(This feature is not yet available)</span></p>
    </button><br>     
    
    


    <!-- Twitter Button -->
    <form action="tweeter.html" method="get" target="_blank">
        <button class="tweeter">
        </button>
    </form>
    
    
    <!-- ////////////////////////////////// Instagram Button ////////////////////////////// --> 
    
    <form action="https://www.instagram.com/shazebs" method="get" target="_blank">
    <button  style="background:; 
                    width:300px; 
                    height:100px; 
                    background-image:url(https://www.logogenie.net/images/articles/instagram-logo2.jpg);
                    background-size: 135%; 
                    background-repeat: no-repeat;
                    background-position: center">
    </button>
    </form>
    
    
    
    <!-- Scratch-Pad     -->
    <center><textarea style="width:300px; height:100px; position:inherit;">Scratch-Pad:</textarea></center>       
    
    <!-- Test Button --> 
    <br><br>
    <button onclick="test_button()">Test Button</button><br><br>
        
    
    <!-- Site Last Updated Tag --> 
    <br>
    <span style="background-color: black">
    (site last updated <span style="color:white">7/21/21</span> 10:33 PM) </span><br><br>
    
    
        
    
    
    <!-- ////////////////////////// ** Test Output ** /////////////////////////// -->
    
    <!-- <span style="color:lawngreen">The following section is test code:</span> -->
    
    <!-- Macronutrients Button 
    <button>Macronutrients Calculator</button><br>  -->
    
    <!-- iFrame 
    <iframe src="https://www.instagram.com/"></iframe><br> -->    
    
    <!-- ** TEST OUTPUT ** 
    <br><br> 
    
    Username: <input type="password"><br>
    <input type="radio" /> Bulls<br>
    
    <select multiple="multiple">
        <option>Macronutrients</option>
        <option>DaysBetweenDates</option>
        <option>Twitch</option>
        <option>Youtube</option>
        <option>Basketball Highlights</option>
    </select><br><br> -->
    
    <!-- <input type="file" /><br> -->
    
    <!-- <input type="submit" /> -->
    
    
    <hr>
    <p style="color:navajowhite; font-size:70%; font-family: arial">
        <span style="background-color: black;">End of Webpage.</span></p>


    </body>
</html>