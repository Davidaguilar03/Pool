package model;

public class Pool {
	public static int TAM = 5;
	private Cell[][] pool;
	private Cell[] ballMoves;
	
	// Crear la Piscina
	public Pool() {
		ballMoves = new Cell[8];
		for (int i = 0; i < ballMoves.length; i++) {
			ballMoves[i] = null;
		}
		pool = new Cell[TAM][TAM];
		for (int i = 0; i < pool.length; i++) {
			for (int j = 0; j < pool.length; j++) {
				pool[i][j] = new Cell(i, j, this.getRandomNumber(0, 6), 'v');
			}
		}
	}

	// Mostrar La Piscina
	public String showPool() {

		// Parte Superior
		String showMatrix = "    0   1   2   3   4\n";
		showMatrix += "  ╔";
		for (int k = 0; k < pool.length - 1; k++) {
			showMatrix += "═══╦";
		}
		showMatrix += "═══╗\n";

		// Numeros
		for (int i = 0; i < pool.length; i++) {
			showMatrix += i + " ║";
			for (int j = 0; j < pool.length; j++) {

				if (pool[i][j].getBall() == 'v') {
					showMatrix += " " + pool[i][j].getHeight() + " ║";
				} else {
					showMatrix += " " + pool[i][j].getBall() + " ║";
				}
			}
			if (i < pool.length - 1) {
				showMatrix += "\n  ╠";
				for (int j = 0; j < pool.length - 1; j++) {
					showMatrix += "═══╬";
				}
				showMatrix += "═══╣\n";
			}
		}
		// Parte inferior
		showMatrix += "\n  ╚";
		for (int a = 0; a < pool.length - 1; a++) {
			showMatrix += "═══╩";
		}
		showMatrix += "═══╝";

		return showMatrix;
	}

	// Poner la Pelota
	public void putBall() {
		int x = this.getRandomNumber(0, 5);
		int y = this.getRandomNumber(0, 5);
		pool[x][y].setBall('P');
	}

	// Buscar la Pelota
	public Cell searchBall() {
		Cell Ball = null;
		int i = 0;
		while (i < pool.length) {
			int j = 0;
			while (j < pool.length) {
				if (pool[i][j].getBall() == 'P') {
					Ball = pool[i][j];
				}
				j++;
			}
			i++;
		}
		return Ball;
	}

	// Verificar Limites

	private boolean isValidMove(int x, int y) {
		return x >= 0 && x < 5 && y >= 0 && y < 5;
	}

	// Analizar Trayectoria

	public void ballMoves() {
		int ballX, ballY;
		Cell maxHeight = null;
		int i = 0;
		int ballHeight,fallHeight;
		ballX = this.searchBall().getX();
		ballY = this.searchBall().getY();
		ballHeight = this.searchBall().getHeight();
		fallHeight = 0;
		while (ballHeight > fallHeight){
			fallHeight = 0;
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					if (x == 0 && y == 0) {
						y++;
					}
					if (this.isValidMove((ballX + x),(ballY + y))) {
						if (pool[ballX + x][ballY + y].getHeight() < ballHeight
								&& pool[ballX + x][ballY + y].getHeight() > fallHeight) {
							fallHeight = pool[ballX + x][ballY + y].getHeight();
							maxHeight = pool[ballX + x][ballY + y];
						}
					}
				}
			}
			
			ballX = maxHeight.getX();
			ballY = maxHeight.getY();
			ballHeight = maxHeight.getHeight();
			ballMoves[i] = maxHeight;
			i++;
		}
	}

	// Mostrar ruta

	public String showBallRoute() {
		String ballRoute = "Posicion X,Y: ";
		for (int i = 0; i < ballMoves.length; i++) {
			if (ballMoves[i] != null) {
				ballRoute += ballMoves[i].getX() + ", " + ballMoves[i].getY() + "\n";
			}
		}
		return ballRoute;
	}

	// Metodo Random
	public int getRandomNumber(int lower, int upper) {
		int randomNumber = (int) (Math.random() * (upper - lower)) + lower;
		return randomNumber;
	}

	public Cell[] getBallMoves() {
		return ballMoves;
	}

	public void setBallMoves(Cell[] ballMoves) {
		this.ballMoves = ballMoves;
	}

}
