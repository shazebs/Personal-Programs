#Chapter 4: Strings and Other Things
first_name = "Shazeb"
last_name = "Suhail"
print(first_name + last_name)
full_name = first_name + last_name
print(full_name)
print(first_name + " " + last_name)

#Lists
my_favorite_rappers = ['Lil Uzi Vert', 'Juice Wrld', 'Nav', 'Travis Scott', 'Mac Miller']
favorite_places_to_hoop = ['Seneca Springs', 'Wildflower', 'Yucaipa', 'Chatigney', 'Sports Park']
bunnies_spotted = [3, 5, 2, 8, 4, 5, 4, 3, 3]
robot_answers = [True, False, False, True, True]

#(Lists don't alwasys have to be the same data type)
# Example:
facts_about_Shazeb = ['Shazeb', 'Pakistani', 24, 'Hooper', 'Programmer', True]

# Lists are ordered example:
citrus_fruits = ['Orange', 'Lemon', 'Grapefruit', 'Pomelo', 'Lime']
more_citrus_fruits = ['Orange', 'Grapefruit', 'Lemon', 'Pomelo', 'Lime']
print(f"\nWorking with LISTS:\n{citrus_fruits == more_citrus_fruits}")
print(citrus_fruits[0])
print(citrus_fruits[0] == more_citrus_fruits[0])
print(citrus_fruits[2:4])
print(citrus_fruits[:4])
print(citrus_fruits[2:])
print(f"'Pomelo' in citrus_fruits = {'Pomelo' in citrus_fruits}")
print(f"'Donuts' in citrus_fruits = {'Donuts' in citrus_fruits}")
print(f"Strawberry not in citrus_fruits = {'Strawberry' is not citrus_fruits}")
#Add another object to the list.
citrus_fruits.append('Apple')
print(citrus_fruits)
#Remove an object from the list.
citrus_fruits.remove('Pomelo')
print(citrus_fruits)
print(f"Is 'Pomelo' still in citrus_fruits = {'Pomelo' in citrus_fruits}")
#Try use del() function to delete items in the list according to index.
del citrus_fruits[0]
print(citrus_fruits)
del citrus_fruits[2:]
print(citrus_fruits)
#Add more fruits into citrus_fruits
citrus_fruits.append('Banana')
print(citrus_fruits)
citrus_fruits.append('Mango')
citrus_fruits.append('Kiwi')
citrus_fruits += ['Melon', 'Cantaloupe']
print(citrus_fruits)
