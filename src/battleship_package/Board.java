package battleship_package;

public class Board
{

	private String[][] squares;

	public Board()
	{
		squares = new String[10][10];
		for (int i = 0; i < squares.length; i++)
		{
			for (int j = 0; j < squares[i].length; j++)
			{
				squares[i][j] = ("-");
			}
		}
	}

	public String toString()
	{
		String s = ("");
		for (int i = 0; i < squares.length; i++)
		{
			for (int j = 0; j < squares[i].length; j++)
			{
				s = s + squares[i][j] + " ";
			}
			s = s + ("\n");
		}
		return s;
	}

	public boolean addShip(int row, int col, int len, boolean horizontal)
	{
		if (row >= 0 && row < 10 && col >= 0 && col < 10)
		{
			if (horizontal == true)
			{
				if (col + len - 1 < squares[0].length)
				{
					for (int i = col; i < col + len; i++)
					{
						if (!(squares[row][i].equals("-")))
						{
							return false;
						}
					}
					for (int i = col; i < col + len; i++)
					{
						squares[row][i] = ("b");
					}
					return true;
				}
			}
			else if (horizontal == false)
			{
				if (row + len - 1 < squares.length)
				{
					for (int i = row; i < row + len; i++)
					{
						if (!(squares[i][col].equals("-")))
						{
							return false;
						}
					}
					for (int i = row; i < row + len; i++)
					{
						squares[i][col] = ("b");
					}
					return true;
				}
			}
		}
		return false;
	}

	public boolean foundShip(int len)
	{
		if (len > 0 && len <= 10)
		{
			// first, search horizontally
			for (int i = 0; i < squares.length; i++)
			{
				for (int j = 0; j < squares[i].length; j++)
				{
					if (squares[i][j].equals("b"))
					{
						j++;
						int count = 1;
						while (j < squares[i].length && squares[i][j].equals("b"))
						{
							count++;
							j++;
						}
						if (count == len)
						{
							return true;
						}
					}
				}
			}
			// now search vertically
			for (int j = 0; j < squares[0].length; j++)
			{
				for (int i = 0; i < squares.length; i++)
				{
					if (squares[i][j].equals("b"))
					{
						int count = 1;
						i++;
						{
							while (i < squares[0].length && squares[i][j].equals("b"))
							{
								count++;
								i++;
							}
							if (count == len)
							{
								return true;
							}
						}
					}
				}
			}
		}
		else
		{
			return false;
		}
		return false;
	}

	public int shoot(int row, int col)
	{
		if (row >= 0 && row < squares.length && col >= 0 && col < squares[row].length)
		{
			if (squares[row][col].equals("-"))
			{
				squares[row][col] = ("m");
				return 0;
			}
			else
			{
				if (squares[row][col].equals("b"))
				{
					squares[row][col] = ("x");
					return 1;
				}
				else
				{
					return 2;
				}
			}
		}
		else
		{
			return -1;
		}
	}

	public boolean gameOver()
	{
		for (int i = 0; i < squares.length; i++)
		{
			for (int j = 0; j < squares[i].length; j++)
			{
				if (squares[i][j].equals("b"))
				{
					return false;
				}
			}
		}
		return true;
	}

}
