
/* print function */
function print(line){
    document.write(line)
}
/* newline functions */
function newline(){
    print('<br>');
}
function newlinetoo(x){
    for (var i = 0; i < x; i++) {newline();} 
}
/* display entire grid function */
function displayGrid(grid)
{
    // row loop 
    for (var i = 0; i < SIZE; i++) 
    {
        // print top column numbers 
        // if (i == 0){
        //     for (var k = 0; k < 11; k++){
        //         print(`${k} `); 
        //     } newline();
        // }

        // column loop 
        for (var j = 0; j < grid[i].length; j++) 
        {
            // print(`${grid[i][j]} `); 
            // display row letters 
            // if (j == 0 && i > ){
            //     switch (i){
            //         case 1:
            //             print('A ');
            //             break;
                        
            //         }
            //     }
            // }
        }
        // print ('x '); 
        // newline();
    }
}
/* print main menu function  */
function printMainMenu() {
    print('-- Main Menu --');
    newline(); 
}
/* initialize playerGrid 2d array all with Pin objects */
function initializePins(){
    for (var x=0; x < SIZE; x++){
        for (var y=0; y < SIZE; y++){
            playerGrid[x][y] = new Pin(x, y); 
            playerGrid[x][y].marked = "emoji"; 
        }
    }
}

/* Pin class */
class Pin {
    constructor(x, y){
        this.x = x;
        this.y = y;
    } 
    marked = ""; 
}

/* global variables */
const SIZE = 11; 
var playerName = "Michael"; // null 

/* grid variables */
let playerGrid = [
                ["", "1", "2", "3", "4", "5", "6", "7", "8", "9","10"], // 0
                ["A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 1
                ["B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 2
                ["C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 3
                ["D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 4
                ["E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 5
                ["F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 6
                ["G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 7
                ["H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 8
                ["I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 9
                ["J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"] // 10
        ];
let enemyGrid = [
                ["&nbsp;", "1", "2", "3", "4", "5", "6", "7", "8", "9","10"], // 0
                ["A", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 1
                ["B", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 2
                ["C", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 3
                ["D", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 4
                ["E", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 5
                ["F", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 6
                ["G", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 7
                ["H", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 8
                ["I", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"], // 9
                ["J", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"] // 10
        ];



/* program's logic */
printMainMenu();
newlinetoo(1);
initializePins();
displayGrid(playerGrid);
newlinetoo(2);
startNewGame();



function startNewGame(){
    print('Starting new game...'); 
    // playerName = prompt('Please enter a name: ', '');
    print(`The game is now focused on you ${playerName}`); 



    newlinetoo(2);
}

function getBrowserWidth(){}
function getBrowserHeight(){}
function resizeGrid(){}
function markCoordinate(){}
function setPin(){}
function fireMissile(x,y){}
function isGameOver(){}
function sinkShip(){}
function updateScore(){}







