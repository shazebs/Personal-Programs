"""
Title:   InClass_Mar16_arrays.py
Purpose: Explore NumPy's array structure.
Author:  ** SHAZEB SUHAIL **
"""

# Find documentation on Numpy here:
# https://numpy.org/doc/stable/user/absolute_beginners.html


# To access the numpy library, we must import numpy 
import numpy as np


# Generate NumPy arrays using each of the following NumPy
# routines. Explain what each of them does.
# np.array()
# np.zeros()
# np.ones()
# np.ones_like()
# np.random.rand() 
# Hint: use the websites written at the top of this assignment as a 
# resource if you need to. 
print('\n---------------------')
print('Question 1')

# declare a numpy array of integers
x = np.array([9,8,7,6,5,4,3,2,1])

# answers to question 1
print(f"""
an \'np.array()\'        : {np.array([9,9,9])}                  # syntax to declare a NumPy array
an \'np.zeros()\'        : {np.zeros(4)}            # create a user sized array w/ each element set to 0
an \'np.ones()\'         : {np.ones(5)}         # create a user sized array w/ each index element set to 1
an \'np.ones_like()\'    : {np.ones_like(x)}      # turn an existing array's elements all to 1
an \'np.random.rand()\'  : {np.random.rand(2)}  # returns random elements for a user sized array      
""")


# A simple array is defined below. Use the Python console (the prompt)
# to count all of the methods that apply to that array. How many are
# there? Demonstrate how to use the .max(), .argmax(), 
# .sum(), and .tolist() methods. What do each of these methods do?
print('\n---------------------')
print('Question 2')
myArray = np.array([1,2,3])

# There are 71 methods to numpy, here are some:
print(f"""
myArray : {myArray}  
    
\'np.max(myArray)\'    : {np.max(myArray)}          # finds max value
\'np.argmax(myArray)\' : {np.argmax(myArray)}          # finds index of max value   
\'np.sum(myArray)\'    : {np.sum(myArray)}          # finds the sum of element values
\'np.tolist(myArray)\' : {myArray.tolist()}  # turns NumPy array into a list
\'np.mean(myArray)\'   : {myArray.mean()}        # finds the mean of the entire array
\'np.size(myArray)\'   : {np.size(myArray)}          # finds the size of the entire array
""")



# Use the NumPy routine np.asarray() to convert the objects defined
# below into NumPy arrays. Print the results of each conversion and
# describe anything unusual that may be happening.
print('\n---------------------')
print('Question 3')
pets = ['dog','cat','alligator']
nums1 = (1,2,3,4,5)
nums2 = [1,2,3,True,(5,6,7),[8,9,10]]

print(np.asarray(pets))
print(np.asarray(nums1))
print(np.asarray(nums2)) # the array prints out its type


# A NumPy array is defined below. Use the .reshape() method to create
# a separate, 3-dimensional (3-D) array that has shape [3,3,3]. 
# Imagine that 3-D array is a cube of elements. Like any other
# cube, it has 8 corners. Use indexing to set the corner elements of 
# your 3-D array equal to 1, leaving all other elements equal to 0.
print('\n---------------------')
print('Question 4a')
arr1D = np.zeros(27)

print(arr1D)
print('\n↥ 1-Dimensional array is shown above ↥')

newline(1)
print(arr1D.reshape([3,3,3]))
print('\n↥ 3-Dimensional array is shown above ↥')
newline(1)
arr1D = np.zeros(32)
print(arr1D.reshape([4,2,2,2]))
print('\n↥ 4-Dimensional array is shown above ↥')



# Using your cube of elements from the previous quesiton, demonstrate
# how to find the NumPy attributes np.ndim, np.shape, and np.size.
print('\n---------------------')
print('Question 4b')

# np.ndim finds the number of array dimensions
# np.shape returns the shape of an array
# np.size returns the number of elements in the array

array = np.array( [ [1,2,3] , [4,5,6] ] )
print(f'\'np.ndim(array)\'  : {np.ndim(array)}       # return the dimension of the array')
print(f'\'np.shape(array)\' : {np.shape(array)}  # return the shape of the array')
print(f'\'np.size(array)\'  : {np.size(array)}       # return the number of elements in the array')




# Imagine that you are taking a trip to Germany. You are very much
# looking forward to driving on the autobahns. These are roads
# that (in parts) have no speed limits. The car that you use shows
# the speed in KMH, or kilometers per hour, which is different
# than the usual MPH, or miles per hour, that we are used to here
# in the United States. Thankfully, you kept track of the 
# speeds you achieved while driving on the autobahns, and with
# your superb Python skills, you can now convert those KMH values
# to MPH using NumPy arrays. 
# Hint:  1.6 kilometers = 1 mile.  
print('\n---------------------')
print('Question 5a')
KMH_speeds = np.array([66,100,183,145,255])
arr = KMH_speeds

c = (1/1.6)
MPH_speeds = np.array([arr[0]*c, arr[1]*c, arr[2]*c, arr[3]*c, arr[4]*c ])
print(MPH_speeds)



# Use the .max() method to determine your overall top speed in MPH.
print('\n---------------------')
print('Question 5b')
print(f'\'KMH_speeds.max()\' : {KMH_speeds.max()}')
