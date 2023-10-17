package model;

public class Cell {
	int x;
	int y;
	int height;
	char ball;
	
	public Cell(int x, int y, int height, char ball) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.ball = ball;
	}

	public char getBall() {
		return ball;
	}

	public void setBall(char ball) {
		this.ball = ball;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Cell [x=" + x + ", y=" + y + ", height=" + height + "]";
	}
	
	
	
}
