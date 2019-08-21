#Ziyaad Lakay
#Classes for polygons, inheritance

#---------------------------------------------------------
#---------------------------------------------------------

import math
import turtle as bob

class Polygon:
	
	def __init__(self,edge,angle): 
		self.edge = edge 			#attributes
		self.angle = angle
		self.heading = []
	
	#1
	def get_number_edges(self):
		return len(self.edge) 			#returns the no. of edges

	#2
	def is_regular(self):
		if len(self.edge) == len(self.angle): 	#checks if it is a regular polygon
			return True
		else :
			return False
	#3
	def mean_edge_length(self):
		total = 0 
		for i in self.edge : 			#loops through list
			total = total + i 		#adds all values in list
		return total/len(self.edge) 		#returns total divided by amount of edge lengths
	#4
	def is_larger(self, other) :
			if self.edge > other : 
				return True
			else :
				return False
	#5
	def __str__(self):
		return "Polygon with {0} edges, mean edge length: {1},".format(Polygon.get_number_edges(self),Polygon.mean_edge_length(self))
									#calls other functions within polygon class
	#6
	def draw(self, t, colour, thick, left):
		t.pensize(thick) 				#sets thickness of pen
		t.pencolor(colour) 				#sets colour
		i = 0
		if left==True: 					#checks if turtle turns left
			while i < len(self.edge): 		#loops through list
				t.fd(self.edge[i]) 
				t.lt(self.angle[i])
				t.speed(1)
				self.heading.append(t.heading())
				#print(self.heading)
				i+=1
		else:
			while i < len(self.edge):
				t.fd(self.edge[i])
				t.rt(self.angle[i])
				t.speed(1)
				self.heading.append(t.heading())
				i+=1
#--------------------------------------------------------------------------------------
	#1
	def get_vertices_coordinates(self, left):
		coord = [[0,0]]
		i = 0
		vertex = []
		
		while i < len(self.edge):
			ax = math.cos(self.heading[i]+self.angle[i]) #holding x angle
			ay = math.sin(self.heading[i]+self.angle[i])			
			#print(a)
			x = self.edge[i] * round(ax)
			y = self.edge[i] * round(ay)
			vertex = [x,y]
			
			coord.append(vertex)
			#print(coord)
			i+=1
		return coord
	#2
	def closed_polygon(self):	
		coord = Polygon.get_vertices_coordinates(self,True)
		if coord[0] == coord[len(coord)-1] :
			return True
		else:
			return False
	
	def get_distance(self,c1,c2):
		x1 = c1[0]
		x2 = c2[0]
		y1 = c1[1]
		y2 = c2[1]
		distance = math.sqrt((x2-y2)**2 + (x1 -y1)**2)
		print(distance)
		return distance
	#3	
	def get_diameter(self):
		coord = self.get_vertices_coordinates(True)
		high = 0
		for i in coord :
			for j in coord:
				distance = self.get_distance(i,j)
				if distance > high :
					high = distance
		return high
	#4
	def draw_circum_circle(self, t, colour, thickness):
		t.pensize(thickness)
		t.color(colour)
		t.circle((self.get_diameter()/2))
		
		

class RegularPolygon (Polygon):
	def __init__(self,num_edges, edge_len):		
		list_edge = []
		list_len = []
		list_angle = []
		angle = 360/num_edges
		for i in range(num_edges):
			list_edge.append(edge_len)
			list_angle.append(angle)
		Polygon.__init__(self, list_edges, list_angle)

	def get_area(self):
		total_area =(num_edges*edge_len)/(4*math.tan(math.pi/num_edges))

mysquare = Polygon([100,100,100,100],[90,90,90,90])
mysquare.draw(bob, 'Blue', 3, True)
print(mysquare.get_vertices_coordinates(True))
print(mysquare.closed_polygon())
mysquare.draw_circum_circle(bob, 'Red', 3)

#rt_triangle = Polygon([100, 70, 120], [20, 60.84, 32])
#rt_triangle.draw(bob, 'Blue', 3, True)
#rt_triangle.draw(bob,'blue',3,True)
#print(rt_triangle.get_vertices_coordinates(True))
