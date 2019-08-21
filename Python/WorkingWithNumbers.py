#Ziyaad Lakay

#-------------------------------------------------------
#-------------------------------------------------------

#Even or Odd

num = input("Enter a whole number : ")                              #Ask the user to enter a positive number
while '.' in num :                                                  #Loop to check if it is a whole number 
    num = input("Error not a whole number : ")                      #If the number is not a positive whole number it will keep asking to enter a number 

if (int(num) % 2) == 0 :                                            #checks if the remainder of the number divided by two equals zero
    print("Even Number" , "\n")                                     #If it does its even
else :                                                              
    print("Odd Number", "\n")                                       #If it doesnt its odd

#--------------------------------------------------------
#--------------------------------------------------------

#Leap Years

year = int(input("Enter the year to test : "))                      #asks the user to input any year 

leapYear = False                                                    #Initialising variable

if (year % 4 ) == 0 and (year % 100) != 0 or (year % 400) == 0 :    #Checks if the year is divisible by 4 but not by 100, unless they are a multiple of 400
           leapYear = True

if leapYear == True :                                               #Checks if leap year is true
    print(year, " Is a Leap Year", "\n")
else :
    print(year, " Is NOT a Leap Year", "\n")


#---------------------------------------------------------
#---------------------------------------------------------

#Counting Number of Vowels (using while loop)

vowels = ['a', 'e' , 'i' , 'o' ,  'u', 'A' , 'E', 'I', 'O', 'U']    #Populating list

userString = input("Enter a string : ")                             #Asks the user to input a string 

i = 0                                                               #Used as index of vowels
j = 0                                                               #Used as index of the string
vowelCount = 0

while i < len(vowels) :                                             #Loops the length of list

    j = 0      
    while j < len(userString) :                                     #Loops the length of string inside of list loop

        if userString[j] == vowels[i] :                             #Checks if the letter at index j is equal to the vowels at index i
            
            vowelCount += 1                                         #Increments the number of  vowels by 1

        j += 1                                                      
                                                                    #Moves to Next index
    i += 1

print("This String contains ", vowelCount , " vowels", "\n")

#---------------------------------------------------------
#---------------------------------------------------------

#Removing all vowels (using while loop)

vowels = ['a', 'e' , 'i' , 'o' ,  'u', 'A' , 'E', 'I', 'O', 'U']

userString = input("Enter a String : ")

i = 0                                                               #Used as index of vowels
j = 0                                                               #Used as index of the string
vowelCount = 0
myList = []
newString = ''

while i < len(userString) :

    myList.append(userString[i])                                #Breaks up string into a list
    i += 1

i = 0

while i < len(vowels) :                                         #Loops the length of list

    j = 0      

    while j < len(myList) :                                     #Loops the length of list inside of list loop

        if myList[j] == vowels[i] :                             #Checks if the letter at index j is equal to the vowels at index i

         myList.pop(j)                                          #removes the item at index j 
            
        j += 1                                                      
                                                                #Moves to Next index
    i += 1


i = 0

while i < len(myList) :
    newString = newString + myList[i]                           #Puts string back together
    i += 1

print(newString, "\n")

#---------------------------------------------------------
#---------------------------------------------------------

#Counting Number of Vowels (Using a for Loop)

vowels = ['a', 'e' , 'i' , 'o' ,  'u', 'A' , 'E', 'I', 'O', 'U']    #Populating list

userString = input("Enter a string : ")                             #Asks the user to input a string 
                                                                   
vowelCount = 0

for c in vowels :                                                   #Stores the first index of the list in variable c and loops till end
    for k in userString :                                           #Stores the first index of the list in variable k and loops till end
        if c == k :                                                 #checks if letter in userString equals letter in vowels 
            vowelCount += 1


print("This String contains ", vowelCount , " vowels", "\n")

#---------------------------------------------------------
#---------------------------------------------------------

#Removing all vowels (using for loop)

vowels = ['a', 'e' , 'i' , 'o' ,  'u', 'A' , 'E', 'I', 'O', 'U']

userString = input("Enter a String : ")

i = 0                                                               #Used as index of vowels
j = 0                                                               #Used as index of the string
vowelCount = 0
myList = []
newString = ''

for c in userString :                                               #breaks up string
    myList.append(c)
    
for c in vowels :                                                   #Stores the first index of the list in variable c and loops till end
    for k in userString :
        if c == k :
            myList.remove(c)

for c in myList :                                                   #puts string back together
    newString = newString + c

print(newString, "\n")


#----------------------------------------------------------
#----------------------------------------------------------

#Repetitions in a string

userString = input("Enter a String : ") 
rep = ''                                                                    #store temporary repetitive letters
i = 1
index = 0
repLong = ''

while i < (len(userString)-1) :                                             #Loops length of string
 
    rep = rep + userString[i]                                               #concatinates letters
    
    if userString[i] != userString[i + 1] :                                 #checks if following letter does not equal current letter
        
        if len(rep) > len(repLong) :                                        #if so checks again if the contents in rep is longer than the current longest string
            repLong = rep
            index = i - (len(repLong)-1)                                    #sets the index to where repition started

        rep = ''                                                            #Clears contents

    i += 1

print("The longest repition is of length ", len(repLong), ": '", repLong , "' starting at index " , index)
    
    










