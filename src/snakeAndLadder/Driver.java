package snakeAndLadder;

import snakeAndLadder.entities.Player;

public class Driver {

	public static void main(String[] args) {

		Game game= new Game();
		game.addPlayer(new Player("🧔️"));
		game.addPlayer(new Player("🧔🏻️"));
//		game.addPlayer(new Player("P3"));
		game.launch();
	}

}

