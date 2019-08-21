#Ziyaad Lakay
#---------------------------------------
#---------------------------------------

#Fibonacci Numbers

prev = 0  #initialise variables
curr = 1
next = 0
count = 0
i = 0        #range
i_2 = 999

print(prev)  #printing first 2 values 
print (curr)

while prev < 100000 :  #loops while previous number is less than 100,000 
	
	if prev >= i and prev < i_2 :  #checks if number is in range
		next = curr + prev
		print(next)
		prev = curr
		curr = next
		count = count + 1
		continue               #does not go further until if statement is not true
	
	if count > 0 :
		print(count , " number : ", i , "-" , i_2)  #prints number of fibonacci in range
	
	i = i + 1000     #incrementing the range
	i_2 = 999 + i
	
	if count > 0 :  
		count = 0    #resetting the count
		
	


#--------------------------------------------------------------------------
#--------------------------------------------------------------------------
	
