#Ziyaad Lakay
#Fun with graphics

#------------------------------------------------------------------------------
#------------------------------------------------------------------------------

import turtle as bob                #imports and renames turtle
import math
import time

#Question 1


def draw_square(distance) :         #defining function

    for i in range(4) :             #loops 4 times
        bob.fd(distance)            #turtle moves foward
        bob.left(90)                #turtle rotates left 90 degrees

#draw_square(150)

#------------------------------------------------------------------------------
#------------------------------------------------------------------------------

#Question 2


def draw_triangle(distance) :       #defining function
    
    for i in range(3) :             #loops 3 times
        bob.fd(distance)            #moves forward
        bob.left(120)               #rotates to the left 120 degrees

#draw_triangle(150)

#------------------------------------------------------------------------------
#------------------------------------------------------------------------------

#Question 4
# if origin B coordinates = (x,y)
#   then origin A coordinates = ( x+(n/4), y+square.root(((n/2)**2)-((n/4)**2))  )
#   then origin D coordinates = ( x+(n/2), y)

#------------------------------------------------------------------------------
#------------------------------------------------------------------------------

#Question 5

def draw_sp_triangle(x , y, distance) :                                                             #defining function

    if distance <= 10 :                                                                             #terminates repitition (Question 6)
        return

    bob.shape("turtle")
    bob.color("green")                                                                              #changes appearence of program
    bob.bgcolor("orange")
    bob.speed(100)

    bob.penup()                                                                                     #lifts pen up to stop drawing
    bob.goto(x,y)                                                                                   #goes to given position
    bob.pendown()                                                                                   #puts pen down to begin drawing
    
    
    draw_triangle(distance)                                                                         #calls function to draw a triangle
    new_dis = distance / 2                                                                          #changing the value of distance
    draw_sp_triangle(x , y, new_dis)                                                                #origion B, recursive function
    draw_sp_triangle((x+new_dis), y , new_dis)                                                      #origion D
    draw_sp_triangle((x+(new_dis/2)), (y+(math.sqrt((new_dis**2)-((new_dis/2)**2)))), new_dis)      #origion A


#Question 8

#The speed ratio is 1 : 3.28 seconds which means the greater the distance the longer the turtle will take to draw it

#----------------------------------------------------------------------------------------------------------------------------------
#----------------------------------------------------------------------------------------------------------------------------------


#Question 9

def draw_sp_square(x, y, distance) :

    if distance <= 7 :                                                                             #terminates repitition (Question 6)
        return

    bob.shape("turtle")
    bob.color("red")                                                                              #changes appearence of program
    bob.bgcolor("blue")

    bob.speed(100)
    bob.penup()                                                                                     #lifts pen up to stop drawing
    bob.goto(x,y)                                                                                   #goes to given position
    bob.pendown()
    

    draw_square(distance)                                                                           #calling previous function to draw square
    new_dis = distance / 3
    draw_sp_square(x, y, new_dis)                                                                   #recursive function on 1st bottom square
    draw_sp_square((x+new_dis) , y, new_dis)                                                        #recursive function on 2nd bottom square
    draw_sp_square((x+(new_dis*2)), y, new_dis)                                                     #recursive function on 3rd bottom square
    draw_sp_square(x, (y+new_dis), new_dis)                                                         #recursive function on 1st middle square
    draw_sp_square((x+(new_dis*2)), (y+new_dis), new_dis)                                           #recursive function on 3rd middle square
    draw_sp_square(x, (y+(new_dis*2)), new_dis)                                                     #recursive function on 1st top square
    draw_sp_square((x+new_dis), (y+(new_dis*2)), new_dis)                                           #recursive function on 2nd top square 
    draw_sp_square((x+(new_dis*2)), (y+(new_dis*2)), new_dis)                                       #recursive function on 3rd top square



#-------------------------------------------------------------------------------------------
#-------------------------------------------------------------------------------------------

i = int(input("Enter x : "))                                                                    #stores x coordinate
j = int(input("Enter y : "))                                                                    #stores y coordinate
d = int(input("Enter distance : "))                                                             #stores distance

s = time.time()                                                                                 #starts timer
draw_sp_triangle(i, j, d)                                                                       #calls function
print("Time lapse for triangle : ",int(time.time()-s), "s")
bob.clear()                                                                                     #clears drawing

s = time.time()
draw_sp_square(i, j, d)
print("Time lapse for square : ",int(time.time()-s), "s")

#----------------------------------------------------------------------------------------
#----------------------------------------------------------------------------------------



    
   

    



