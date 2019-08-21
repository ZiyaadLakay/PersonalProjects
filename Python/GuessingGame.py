import random 
#Ziyaad Lakay

#--------------------------------------------------------------
#--------------------------------------------------------------

#Guessing Game



trial = 0

randNum = random.randint(1,100)  #generates random number

userNum = int(input("Enter a random number from 1 to 100 : ")) #gets input from user



while userNum != randNum :  #loops until user guesses correctly or enters 0

	if userNum == 0 : #exits loop if user enetered 0
		break
		
	if userNum > randNum :  #checks if random number is bigger
		print("Go Smaller")
		trial = trial + 1
		userNum = int(input("Enter a random number from 1 to 100 : ")) #gets input from user

	else :
		print("Go Bigger")
		trial = trial + 1
		userNum = int(input("Enter a random number from 1 to 100 : ")) #gets input from user

	
	if trial == 10 : #exits loop if user guesses more than 10 times
		print("Game over ! The Correct number was " , randNum)
		break
	




if userNum == randNum :
	print("Congradulations ! You did it in " , trial , " attempts !")
	
	





#---------------------------------------------------------------------------
#---------------------------------------------------------------------------







	
