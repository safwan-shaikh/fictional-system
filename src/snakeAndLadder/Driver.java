package snakeAndLadder;

import snakeAndLadder.entities.Player;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game= new Game(10, 1);
		game.addPlayer(new Player("P1"));
		game.addPlayer(new Player("P2"));
		game.addPlayer(new Player("P3"));
		game.launch();
	}

}

