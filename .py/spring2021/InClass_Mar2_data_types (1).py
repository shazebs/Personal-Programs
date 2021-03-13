"""
Title:   InClass_Mar2_data_types.py
Purpose: Explore Python's built-in data types.
Name:    ** SHAZEB SUHAIL **
"""

# Assign the number 2 to the variable "x" and use "type()" to 
# determine what kind of object "x" is.
print('Question 1') #Prints question number to make output easy to read
x = 2               #Assigns the value "2" to the variable "x"
print(type(x))      #Prints the object type of "x"



# Multiply x by 5.3 and assign the result to the variable "y". Use the
# "type()" class to determine what type of object "y" is.
print('\nQuestion 2')
y = x * 5.3
print(type(y))



# Assign two words (text, not numbers) to variables, using single quotes ' '
# for one and double quotes " " for another. Then, add the variables 
# together with the "+" sign and determine the object type of the result.
print('\nQuestion 3')
text_1 = "elephant"
text_2 = 'pharoah'
print(type(text_1 + text_2))



# Create a list of numeric and text items and assign it to a variable.
# Then, determine the type of object that variable is.
print('\nQuestion 4')
list_1 = [7, 'boat', 9.9]
z = list_1
print(type(z))


# Create a dictionary of several  'key':value  pairs and assign it to a
# variable. Then, determine the type of object that variable is.
print('\nQuestion 5')
dictionary_1 = {'Jan' : 'January',
                'Feb' : 'February',
                'Mar' : 'March'}
print(type(dictionary_1))




# Now experiment with coverting between data types (casting). 
# Give an example of...

# ...converting an integer number to text.
print('\nQuestion 6')
newInt = 67
newString = str(newInt)
print(f'int version = {newInt}\nstring version = {newString}')



# ...converting a float number to an integer number.
print('\nQuestion 7')
aFloat = 14.99
anInt = int(aFloat)
print(f'float version = {aFloat}\nint version = {anInt}')



# ...converting a string number to a float.
print('\nQuestion 8')
aString = '789.1'
bFloat = float(aString)
print(f'string version = {aString}\nfloat version = {bFloat}')



# ...converting a the text 'dog' to an integer. Is this casting allowed?
print('\nQuestion 9')
lastInt = int('dog')
print(type(lastInt)) # this type of casting is NOT ALLOWED!



