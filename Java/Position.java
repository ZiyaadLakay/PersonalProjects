public class Position
{
	private int row = 0;
	private int col = 0;
	
	public Position()
	{
	}
	
	public Position(int r, int c)
	{
		row = r;
		col = c;
	}//end of object method
	
//-----------------------------------------------------
//Getters

	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	
//Setters 

	public void setRow(int r)
	{
		row = r;
	}
	
	public void setCol(int c)
	{
		col = c;
	}
	
	public void setPos(int r, int c)
	{
		row = r;
		col = c;
	}
	
//-------------------------------------------------------------
//Direction methods
	
	public Position north()
	{
		return new Position(getRow()-1,getCol());
	}//end of north
	
	public Position south()
	{
		return new Position(getRow()+1, getCol());
	}//end of south method
	
	public Position west()
	{
		return new Position(getRow(), getCol()-1);
	}//end of west method
	
	public Position east()
	{
		return new Position(getRow(), getCol()+1);
	}//end of east method
	
//-------------------------------------------------------

	public boolean isSameAs(Position pos)
	{
		if(row == pos.row && col == pos.col)
			return true;
		else
			return false;
	}//end of same position
	
	public String toString()
	{
		return("Row : "+row+" Col : "+col);
	}
	
	
	
}//end of class
