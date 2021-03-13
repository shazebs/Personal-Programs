# -*- coding: utf-8 -*-
"""
Created on Tue Mar  2 18:06:43 2021
CIS-830 Wednesday march 2
@author: shazeb
"""

# this is my newline function in python
def newline(n) :
    # function variables
    space = "\n"
    print(n * space)
# end of function newline
newline(1)

# String examples
myString = "It's a good day!"
print(myString)

# Checking for the type of a string
print(type(myString))


# Integer examples
myInt1 = 17;
myInt2 = -20;

newline(1)
print(myInt1 + myInt2)
print(type(myInt1 + myInt2))


# List examples
newline(1)
#
list1 = [1, 3, 5670]
list2 = ['cat', 'dog', 6.2]
print(type(list1))
print(type(list2))


newline(1)
# Dictionary Example
state_capitals = {'CA' : 'Sacremento', 
                  'TX' : 'Austin',
                  'MA' : 'Boston'}
print(type(state_capitals))
print(state_capitals['CA'])
print(state_capitals['MA'])
newline(1)


# Boolean examples
x = True
y = False
print(type(x))
print(type(y))

print(x+y)
print(x*y)

if x:
    print('Python executes this block of code')
    
if False:
    print('Python DOES NOT execute this block of code')    
newline(1)


# Converting between data types
# (known as type casting OR type conversion)

# str() converts a variable to a string
# int() converts a variable to a integer
# float() converts a variable to a float

# Explicit casting
myInt = 99
string = str(myInt)
print(myInt)
print(string)
print(type(string))

myFloat = float(myInt)
print(myFloat)
print(str(int(myFloat)))


newString = '3.14'
newFloat = float(newString)
print(type(newFloat))
print(newFloat)

newFloat = 1.22
print(int(newFloat))







































