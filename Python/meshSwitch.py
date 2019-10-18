import pdb
from mininet.topo import Topo

class MyTopo(Topo):

	def __init__(self):
		"Create custom topo"

		Topo.__init__(self)

	# Add Host and switches

		H1 = self.addHost('h1')
		H2 = self.addHost('h2')
		H3 = self.addHost('h3')
		H4 = self.addHost('h4')

		S1 = self.addSwitch('s1')
		S2 = self.addSwitch('s2')
		S3 = self.addSwitch('s3')
		S4 = self.addSwitch('s4')

		SwitchList = (S1,S2,S3,S4)

	#Add Links
		for index in range(0, len(SwitchList)):
			for index2 in range(index+1, len(SwitchList)):
				self.addLink(SwitchList[index], SwitchList[index2])

		self.addLink(H1,S1)
		self.addLink(H2,S2)
		self.addLink(H3,S3)
		self.addLink(H4,S4)

topos = {'mytopo': (lambda : MyTopo())}
	