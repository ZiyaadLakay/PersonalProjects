#Ziyaad Lakay

#--------------------------------------------------------------------------------------------
#--------------------------------------------------------------------------------------------

#Validating SA ID numbers


yy = ""
mm = ""
dd = ''
ssss = ""                                        #initialising variables
z = ""
r = ""
k = ""
gender = ""
citizenship = ""

idNum = input("Enter ID Number : ")              #ask for user input


if len(idNum) == 13 :                           #Checks if the number of characters entered is correct
    
    a = 0
    i = 0

    while i < 12 :                              #Looping all odd digits except last one
        a = a + int(idNum[i])                   #adds the number at i to a
        i = i + 2                               #skipping each even number

    b = ""
    i = 1                                       #starting at the even position

    while i < 13 :                              #same calculation like before
        b = b + idNum[i]
        i = i + 2

    b2 = str(2 * int(b)) 
    c = 0
    i = 0

    while i < len(b2) :
        c = c + int(b2[i])                      #summing each number in the string b2
        i = i + 1

    d = a + c                                   #calculating D

    q = d % 10                                  #the check number to be subtracted by 10

    yy = idNum[0 : 2] 
    mm = idNum[2 : 4]
    dd = idNum[4 : 6]
    ssss = idNum[6 : 10]                        #Breaking up the ID number to perform individual checks
    z = idNum[10]
    r = idNum[11]
    k = idNum[12]

    if int(ssss) >= 0 and int(ssss) < 5000 :    #checking for a male or female
        gender = "Female"

    else :
        gender = "Male"

    

    if int(mm) < 13 and int(dd) < 32  :         #checks whether if birthday is true

        if int(z) == 0 :

            citizenship = "SA citizen"          #checks the citizenship

        if int(z) == 1 :

            citizenship = "perminant resident"
            

        if int(r) == 8 or int(r) == 9 : 
            
            if (10 - q) == int(k) or q == 0 :   #compares the check number to see if its valid
       
                print("This is a Valid SA ID . For a ", gender , citizenship, " Born on " ,dd, "/",mm, "/"," 19",yy )

            else :
                print("This is NOT a valid SA ID")
        else :
            print("This is NOT a valid SA ID")                                  #Error messages 
            
    else :
        print("This is NOT a valid SA ID, Date of Birth cannot be true")
        
    
else :
    print("Invalid ID input, must be 13 digits")

#---------------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------------


#Playing with digits out of a string

#Question 1

    #num = int(mystring)

#Question 2

    #fourth = int(mystring[4])

#Question 3
    
num = ""
highest = 0
i = 0
product = 1

num = input("Enter a positive whole number : ")     #asks for user input

while i < len(num) :                                #loops the whole string to find biggest number
    if int(num[i]) > highest :                      #checks if current number is bigger than the highest number
        highest = int(num[i])
    i = i + 1

print("The highest number in the string '", num , "' is '", highest ,"'")

#Question 4 & 6

i = int(input("Enter at which index you want the product of 3 consecutive numbers ? : "))
j = 0

while j < 3  :

    if int(num[i]) == 0 :                           #Skips over if a number equals zero
        i += 1
        continue
    
    product = product * int(num[i])                 #multiplies each number
    j += 1
    i += 1

print("The product of the 3 consecutive numbers is : ", product)




#Question 5

#The whole product will equal 0




#Question 7

#if int(num[i]) == 0 :
        #i += 1
        #continue


