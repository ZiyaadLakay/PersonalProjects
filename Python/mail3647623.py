# ZIYAAD LAKAY
# 3647623
# CSC311 - COMPUTER NETWORKS
# PRAC1 - QUESTION 3

# ----------------------------------------------------------------- 
import smtplib #import STMP Libraries

print("\n**NOTE Your Less Secure app Access should be turned on in your Google Account** \n **This will not work if it is off**\n")
#Go to Google Account>Security>Less Secure App Access>On

sender =input("Your Email : ") #your email address
passwd = input("Login Password : ")#password

def send_email(subject , msg, reciever ): #fuction to send email
	try:
		server = smtplib.SMTP('smtp.gmail.com', 587) #establish SMTP connection through port 587 on gmail server
		#server.ehlo()
		server.starttls() #general protocol for establishing connection to server
		#print("Break")
		server.login(sender,passwd) #login to gmail
		message = 'Subject: {}\n\n{}'.format(subject,msg) #message formatted to stanard email 
		server.sendmail(sender,reciever, message) #send message to other person
		print('Successfuly sent !')

	except:
		print('Failed to send')


reciever = input("Enter the Email of person : ")
subject = input("Enter Subject : ")
msg = input("Enter Message : ") 

send_email(subject,msg, reciever) #calling function