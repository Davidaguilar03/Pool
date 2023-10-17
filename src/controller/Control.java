package controller;

import model.*;
import view.IoManager;

public class Control {
	private IoManager io;

	public Control() {
		io = new IoManager();
	}

	public void init() {
		Pool pool = new Pool();
		io.showMessage(pool.showPool());
		pool.putBall();
		io.showMessage(pool.showPool());
		io.showMessage(pool.showBallRoute());
	}
}
