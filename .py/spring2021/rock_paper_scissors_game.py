# -*- coding: utf-8 -*-
"""
Created on Thu Mar 18 18:37:39 2021

@author: shazebs

if-statements lecture & Homework Assignment 03

"""  
    
"""
IF-STATEMENT NOTES:
-------------------    
a = 7
b = 8

if a < b:
    print(f"{a} < {b}")
else :
    print(f"{a} > {b}")
    
    
newline(1)
if a > 10 :
    print('a greater than 10')
elif a > 7:
    print('a greater than 7 but not 10')
elif a > 6 :
    print('a is greater than 6 but not 7')
else :
    print('a is pretty low')
    
# get input from user (basically how the Scanner works in Java)
username = input("Enter a username: ")
print("User entered: " + username)
print(type(username))
"""

# print(f'{moves}\n')
# print(f"""
# { moves[0]}
# {moves[1]}
# {moves[2]}      
#      """)


# PSEUDOCODE FOR ROCK, PAPER, SCISSORS GAME LOGIC # 
"""
# create my newline function
# create a list with values from rock, paper, scissors
# create the program's local variables
# begin a while loop
# get input from the user
# select a random move for the computer
# print the user and computer's move choices
# execute the right if-statement
# if user enter's an invalid input, print an error statement
# ask user if they want to play again
# based on user's input, either end the game or run the game loop again.
# loop the game again
# game over, display final points
"""

#------------------------------------------------------------------------------
# Homework Assignment 03
#------------------------------------------------------------------------------

# create my newline function
def newline(n) :
    print('\n' * n)

# create a list with values from rock, paper, scissors
moves = ['rock', 'paper', 'scissors']

# create the program's local variables
loop = True 
User_points = 0;
AI_points = 0; 

    
# begin a while loop
while loop :
    
    # get input from the user      
    User_choice = input("Enter rock, paper, or scissors: ")
 
    
    # select a random move for the computer 
    AI_choice = moves[random.randint(0,2)]
     
    
    # print the user and computer's move choices
    newline(1)
    print(f"User's choice is: {User_choice}")
    print(f'Computer\'s choice is: {AI_choice}')
    
    
    # execute the right if-statement
    #--------------------------------------------------------------------------
    newline(1)
    if User_choice == AI_choice:
        print("Both players end in a draw!");
        
    elif (User_choice == moves[0]) & (AI_choice == moves[1]) :
        print("Rock does not beat Paper! A.I. wins.")
        AI_points += 1
        
    elif (User_choice == moves[0]) & (AI_choice == moves[2]) :
        print("Rock beats Paper! User wins.")
        User_points += 1
        
    elif (User_choice == moves[1]) & (AI_choice == moves[0]) :
        print("Paper beats Rock! User wins.")
        User_points += 1
        
    elif (User_choice == moves[1]) & (AI_choice == moves[2]) :
        print("Paper does not beat Scissors! A.I. wins.")   
        AI_points += 1
    
    elif (User_choice == moves[2]) & (AI_choice == moves[0]) :
        print("Scissors does not beat Rock! A.I. wins.")
        AI_points += 1
        
    elif (User_choice == moves[2]) & (AI_choice == moves[1]) :
        print("Scissors beats Paper! User wins!") 
        User_points += 1
    
    # if user enter's an invalid input, print an error statement    
    else :
        print("An error occured! End Game.")  
    #--------------------------------------------------------------------------
    
    # ask user if they want to play again
    choice = input("Play again? (y/n): ")
    
    # based on user's input, either end the game or run the game loop again.
    if (choice == 'y') | (choice == 'Y'):
        # loop the game again
        loop = True
        
    elif (choice != 'y') | (choice != 'Y') :
        print("User has ended the game.")
        loop = False;
    
# game over, display final points
print(f"""
Final Score:
User's Points = {User_points}
A.I.'s Points = {AI_points}       
      """)  

#------------------------------------------------------------------------------
# End of Homework Assignment 03

        
    
    
