public class SolveMaze
{
	public static void main(String[] args)
	{
		SolveMaze obj1 = new SolveMaze();
		obj1.run();
	}//end of main class
	
	public void run()
	{
		Maze m;
		Position start =  new Position(1,6);
		Position goal =  new Position(1,15);
		m = new Maze(start, goal);
		Position square = new Position();
		Stack path = new Stack(start);
		
		//path.push(start);
		
		
		while(!path.isEmpty())
		{	
			square = path.pop();
			System.out.println(square);
			if(!m.wasVisited(square))
			{
				if(!square.isSameAs(goal))
				{
					m.visit(square);
					System.out.println(square);
					
					if(m.isClear(square.north()))
						path.push(square.north());
					if(m.isClear(square.east()))
						path.push(square.east());
					if(m.isClear(square.south()))
						path.push(square.south());
					if(m.isClear(square.west()))
						path.push(square.west());
						
					
				}
				else
					m.printMaze();
			}
			
		}
		System.out.println(square);
		
	}//end of run method
	
	
}//end of class
