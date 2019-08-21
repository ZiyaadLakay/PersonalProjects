#Ziyaad Lakay
#3647623
#COS101 - ADDRESS BOOK
#====================================================================
#====================================================================


from tkinter import *
import webbrowser

class Gui:
	def __init__(self, win): 
		self.win = win #object of tkinter
		win.title("Address Book") #sets title
		win.geometry("400x350") #sets the size of window
		win.config(background = "green")
		self.name = "" 
		self.adr = ""
		self.email = ""
		self.phone = ""
#-----------------------------------------------------------------
#Labels and TextFields
		self.lblFont = ("arial", 12, "bold", "italic")
		self.lblname = Label(win, text="Name :", bg="green",font=self.lblFont) 
		self.lblname.grid(row = 0, column = 0)
		self.txtname = Entry(win)
		self.txtname.grid(row = 0, column = 1, sticky=W)
		self.txtname.focus_set()
		
		self.lbladr = Label(win, text="Address :", bg="green", font=self.lblFont)
		self.lbladr.grid(row = 1, column = 0)
		self.txtadr = Entry(win)
		self.txtadr.grid(row=1, column = 1, sticky=W)

		self.lblemail = Label(win, text="Email :", bg = "green", font=self.lblFont)
		self.lblemail.grid(row = 2, column = 0)
		self.txtemail = Entry(win)
		self.txtemail.grid(row=2, column = 1, sticky=W)
		
		self.lblphone = Label(win, text="Phone Number :", bg = "green", font=self.lblFont)
		self.lblphone.grid(row = 3, column = 0)
		self.txtphone = Entry(win)
		self.txtphone.grid(row=3, column = 1, sticky= W)
#--------------------------------------------------------------------
#Buttons
		self.btnFont = ("arial", 10, "italic")
		self.btnClear = Button(win, text="Clear", command=self.clear, font=self.btnFont) 
		self.btnClear.grid(row=4, column = 1, sticky=N+W)

		self.btnSave = Button(win, text="Save",command=self.save, font=self.btnFont)
		self.btnSave.grid(row=4, column = 1, sticky=N+W, padx=60)
		
		self.btnDelete = Button(win, text="Delete", command=self.delete, font=self.btnFont)
		self.btnDelete.grid(row = 4, column= 1, sticky=N+W, padx=120)
		
		self.btnEmail = Button(win, text="Send Email", command=self.sendEmail, font=self.btnFont)
		self.btnEmail.grid(row = 4, column = 1, sticky=N+W, pady=60, padx = 30)
		
		self.btnMap = Button(win, text="Map", command=self.maps, font=self.btnFont)
		self.btnMap.grid(row = 4, column = 1, sticky=N+W, pady=100, padx = 50)

		self.btnExit = Button(win, text= "Exit", command=self.win.quit, font=self.btnFont)
		self.btnExit.grid(row=4, column = 1, sticky = S, padx = 30, pady=10)	

#-------------------------------------------------------------------------------------
#ListBox
		self.scroll = Scrollbar(win, orient=VERTICAL)
		self.scroll.grid(row = 4, column = 1, sticky=N+W, pady=60)
		self.lstBox = Listbox(win, yscrollcommand=self.scroll.set)
		self.refreshList()
		self.lstBox.grid(row=4, column=0, sticky=N)
		self.lstBox.bind("<<ListboxSelect>>", self.populate)
		self.scroll.config(command= self.lstBox.yview)

#----------------------------------------------------------------------------------
#Button Methods
		
	def clear(self): #deletes everything in all text fields
		self.txtname.delete(0, END)
		self.txtadr.delete(0, END)
		self.txtemail.delete(0, END)
		self.txtphone.delete(0,END)
		self.txtname.focus_set()
	
	def save(self):
		self.name= self.txtname.get() #get values from text fields
		self.adr = self.txtadr.get()
		self.email = self.txtemail.get()
		self.phone = self.txtphone.get()
	
		lstData = [[self.name, self.adr, self.email, self.phone]] #puts it in list
		for i in self.getlist() :
			if i[0] == lstData[0][0] :
				self.delete()
			
		self.addData(lstData) #adds to file
		self.refreshList() #resets list
		
		print("Saved !", self.name, self.adr, self.email, self.phone)
		self.txtname.focus_set() #sets cursor to field
		
	def delete(self):
		self.name = self.txtname.get() #gets item to search for
		
		lstData = self.getlist()
		for i in lstData :
			if self.name == i[0] : #searches through list 
				lstData.remove(i) #removes item

		self.clearFile() #clears file and adds data again	
		self.addData(lstData) #re-adds data
		self.refreshList()
		self.clear() #clears text fields 
		print(self.name, " Deleted !")
		self.txtname.focus_set()
		self.lstBox.select_set(0)
		
	def sendEmail(self):
		window = Toplevel(self.win) #opens new window
		window.title("Send Email")
		window.geometry("300x300")
		window.config(background="blue")
	
		lblFrom = Label(window, text="From : ", bg="blue", font=self.lblFont)
		lblFrom.grid(row = 0, column = 0)
		lblTo = Label(window, text="To : ", bg = "blue", font=self.lblFont)
		lblTo.grid(row = 1, column = 0) 		#creating labels
		lblSubject = Label(window, text="Subject : ", bg = "blue", font=self.lblFont)
		lblSubject.grid(row = 2, column = 0)
		lblMessage = Label(window, text="Message :", bg = "blue", font=self.lblFont)
		lblMessage.grid(row = 3, column = 0)
		
		txtFrom = Entry(window)
		txtFrom.grid(row=0, column = 1)
		txtFrom.insert(0,self.txtemail.get())
		txtTo = Entry(window) 				#creating the text entries
		txtTo.grid(row=1, column=1)
		txtSubject = Entry(window)
		txtSubject.grid(row=2, column=1)
		txtMessage = Text(window, height = 10, width = 20)
		txtMessage.grid(row=4, column=1)
	
		btnSend = Button(window, text="Send", command= window.destroy, font=self.btnFont) #closes window and "sends" email
		btnSend.grid(row=5, column = 1)
		
	def maps(self):
		adr = self.txtadr.get().replace(" ", "+")
		st = adr.replace(",",",+")
		webbrowser.open("https://google.co.za/maps/place/"+st)

#------------------------------------------------------------------------
#File Methods
	def getlist(self): #to get data from file
		try :
			myfile = open("data.txt", "r")
			filelist = myfile.readlines()
			mylist = []
	
			for i in filelist: #loops list
				mylist.append(i.rstrip("\n").split("#")) #splits the data into list
			myfile.close()
			return mylist
		except IOError:
    			print('An error occurred trying to read the file.')

	def clearFile(self):
		try:		
			myfile = open("data.txt", "w")
			myfile.write("")#clears file
			myfile.close()
		except IOError:
    			print('An error occurred trying to read the file.')

	def addData(self,lstData):
		try :		
			myfile = open("data.txt", "a")
		
			for i in lstData :
				myfile.write(i[0]+"#"+i[1]+"#"+i[2]+"#"+i[3]+"\n") #re-writes the file		
			myfile.close()
		except IOError:
    			print('An error occurred trying to read the file.')
	def refreshList(self): #refresh list data
		self.lstBox.delete(0, END)
		for i in self.getlist() : #loops number of times in list
			self.lstBox.insert(END, i[0]) #populates listbox

	def populate(self, x):
		name = self.lstBox.get(self.lstBox.curselection())
		self.clear()
		lstData = self.getlist()
	
		for i in lstData :
			if name == i[0]:
				self.txtname.insert(0,i[0])
				self.txtadr.insert(0,i[1])
				self.txtemail.insert(0,i[2])
				self.txtphone.insert(0,i[3])

#--------------------------------------------------------------------------
#End of class

root = Tk()		
my_gui = Gui(root)
root.mainloop()


