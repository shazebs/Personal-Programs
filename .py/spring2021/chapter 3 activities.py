#Activity 1: How old are you?
#----------------------------
name = "Shazeb"
age = 12 * 2
#Print out a message using the defined variables
print(f"Activity 1:\nHi! My name is {name} and I am {age} years old!")
#---------------------------------------------------------------------

#Activity 2: Operation PEMDAS
#----------------------------
magic_number = 11 * 3 * 10 + 3
print(f"\nActivity 2:\nmagic_number = {magic_number}\n")
#-------------------------------------------------------

#Activity 3: Cookie Comparisons
#------------------------------
raul_chocolate_chips = 13
amanda_chocolate_chips = 9
cookie_comparison_result = f"""Activity 3:
Does Raul have more chocolate chips in his cookie than Amanda?
The result of the comparison is: {raul_chocolate_chips > amanda_chocolate_chips}.
Raul has {raul_chocolate_chips} chocolate chips, while Amanda has {amanda_chocolate_chips} chocolate chips.
"""
#Print the results
print(cookie_comparison_result)
#----------------------------------------------------------------------------------------------------------

#Activity 4: Pie Party!
#----------------------
total_people = 124
graham_cracker_crust_lovers = 40
vanilla_wafer_crust_lovers = 64
oreo_crust_lovers = 20
#Determine if you can evenly divide the number of pies between the number
#of people in that crust lover's group.
#Pie 1:
pie_name = "Banana Cream Pie"
pie_crust = "Graham Cracker"
pie_slices = 10
print_result = (graham_cracker_crust_lovers % pie_slices) == 0
print(f"\nActivity 4:\n'Can the {pie_name} be evenly divided for all {pie_crust} Lovers?' {print_result}")
#Pie 2:
pie_name = "Triple Berry Pie"
pie_crust = "Vanilla Wafer"
pie_slices = 12
print_result = (vanilla_wafer_crust_lovers % pie_slices) == 0
print(f"'Can the {pie_name} be evenly divided for all {pie_crust} Lovers?' {print_result}")
#Pie 3:
pie_name = "Pumpkin Pie"
pie_crust = "Graham Cracker"
pie_slices = 12
print_result = (graham_cracker_crust_lovers % pie_slices) == 0
print(f"'Can the {pie_name} be evenly divided for all {pie_crust} Lovers?' {print_result}")
#Pie 4:
pie_name = "S'mores Pie"
pie_crust = "Oreo"
pie_slices = 10
print_result = (oreo_crust_lovers % pie_slices) == 0
print(f"'Can the {pie_name} be evenly divided for all {pie_crust} Lovers?' {print_result}")
#-------------------------------------------------------------------------------------------------------------

#Activity 5: Outfit Checker
#--------------------------
#Cher and Dionne's Outfit variables
cher_dress_color = 'pink'
cher_shoe_color = 'white'
cher_has_earrings = True
dionne_dress_color = 'purple'
dionne_shoe_color = 'pink'
dionne_has_earrings = True

#Comparison variables
is_wearing_pink_comparison = (cher_dress_color == 'pink' or dionne_dress_color == 'pink') or (cher_shoe_color == 'pink' or dionne_shoe_color == 'pink')
is_wearing_green_comparison = (cher_dress_color == 'green' or dionne_dress_color == 'green') or (cher_shoe_color == 'green' or dionne_shoe_color == 'green')
same_shoe_color_comparison = cher_shoe_color and dionne_shoe_color == cher_shoe_color

#Print Output
print(f"\nActivity 5:\nIs at least one person wearing purple? {(cher_dress_color == dionne_dress_color) or (dionne_dress_color == dionne_dress_color)}")
print(f"Do Cher and Dionne have separated dress colors? {not cher_dress_color == dionne_dress_color}")
print(f"Are Cher and Dionne both wearing earrings? {cher_has_earrings and dionne_has_earrings == True}")
print(f"Is at least one person wearing pink? { (cher_shoe_color == 'pink') or (dionne_shoe_color == 'pink')}")
print(f"No one is wearing green? {not is_wearing_green_comparison}")
print(f"Do Cher and Dionne have the same shoe color? {same_shoe_color_comparison}")
#--------------------------------------------------------------------------------------------------------------------------------------------------------

#Activity 6: Logical Lab!
#------------------------
beakers = 20
tubes = 30
rubber_gloves = 10
safety_glasses = 4


#Problem: Ada has 3 friends coming to help her out, you need to determine if there are enough materials for each friend.
#Each friend needs: 1 pair of safety glasses, 2 rubber gloves, 5 beakers, and 10 tubes.
number_of_safety_glasses_needed = 4
number_of_rubber_gloves_needed = 8
number_of_beakers_needed = 20
number_of_tubes_needed = 40

enough_safety_glasses = (safety_glasses - number_of_safety_glasses_needed) >= 0
enough_rubber_gloves = (rubber_gloves - number_of_rubber_gloves_needed) >= 0
enough_beakers = (beakers - number_of_beakers_needed) >= 0
enough_tubes = (tubes - number_of_tubes_needed) >= 0

#Print Output
final_report = f'''
Activity 6: Logical Lab!
    Each girl has enough safety glasses: {enough_safety_glasses}
    Each girl has enough rubber gloves: {enough_rubber_gloves}
    Each girl has enough beakers: {enough_beakers}
    Each girl has enough tubes: {enough_tubes}
    -
    There are enough gloves and safety glasses for each girl: {enough_safety_glasses and enough_rubber_gloves}
    There are enough tubes and or enough beakers for each girl: {enough_tubes or enough_beakers}
    There are enough safety glasses and beakers or enough tubes and beakers for each girl: {(enough_safety_glasses and enough_beakers) or (enough_tubes and enough_beakers)}
    Each girl has enough gloves, safety glasses, tubes, and beakers: {(enough_safety_glasses and enough_beakers) and (enough_tubes and enough_beakers)}
'''
print(final_report)
#----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

#Activity 7: Modulus Math
#------------------------
print("\nActivity 7:")
print(12345 % 88)
print (101 % 11)
print (111 % 11)
#------------------------

#Activity 8: Planetary Exponentiation
#------------------------------------
total_planets = 9
pentatopia_galaxy_magic_number = 5
tripolia_galaxy_magic_number = 3
deka_galaxy_magic_number = 10
heptaton_galaxy_magic_number = 7
oktopia_galaxy_magic_number = 8
final_report = f'''
Activity 8:
    The Pentatopia Galaxy has {total_planets ** pentatopia_galaxy_magic_number} planets!
    The Tripolia Galaxy has {total_planets ** tripolia_galaxy_magic_number} planets!
    The Deka Galaxy has {total_planets ** deka_galaxy_magic_number} planets!
    The Heptaton Galaxy has {total_planets ** heptaton_galaxy_magic_number} planets!
    The Oktopia Galaxy has {total_planets ** oktopia_galaxy_magic_number} planets!
'''
print(final_report)
#---------------------------------------------------------------------------------------

#Challenge 1: Dinner Decisions
name = "Shazeb"
entree = "Boneless Buffalo Wings"
side_one = "French Fries"
side_two = "Samosas"
dessert_one = "Ice Cream Cones"
dessert_two = "Root Beer Floats"
dessert_three = "Oreos"

dinner_decisions = f'''
Challenge 1:
    Hi, my name is {name}.
    I chose {entree} as my main meal!
    To go with it, I chose {side_one} and {side_two} as my sides.
    And the best part, I have {dessert_one}, {dessert_two}, and
    {dessert_three} waiting for me as my dessert!
    Let's eat!
'''
print(dinner_decisions)


























































