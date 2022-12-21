package snakeAndLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import snakeAndLadder.entities.Board;
import snakeAndLadder.entities.Player;
import snakeAndLadder.word_find.WordFind;

public class Game {

	Board board;
	Queue<Player> players;
	Queue<Player> winners;
	int size = 100;
	WordFind wordFinder;
	
	public Game() {
		this.wordFinder = new WordFind();

		board = new Board(10);
		players = new LinkedList<Player>();
		winners = new LinkedList<Player>();
		
	}
	
	public void launch() {
		this.board.print(players);
		Scanner in = new Scanner(System.in);
		
		while (players.size() > 1) {
			
			Player currPlayer = players.poll();
			System.out.println();
			System.out.println(currPlayer.getUserName()+"'s turn.");
			
			wordFinder.printWordGrid();
			
			System.out.println("Find a word");
			String word = in.nextLine();

			int move = wordFinder.patternSearch(word);
			
			makeMove(currPlayer, move);
			if (currPlayer.getPosition() == size) {
				System.out.println(currPlayer.getUserName() + " won!!!");
				winners.add(currPlayer);
			} else {
				players.add(currPlayer);
			}
			printPositions();
			board.print(players);
		}
		
		in.close();
	}

	private void printPositions() {
		for(Player player : players) {
			System.out.println(player.getUserName()+":"+player.getPosition());
		}
		
	}

	private void makeMove(Player player, int move) {
		int currPosition = player.getPosition();
		
		if (move == 0) {
			System.out.println("Word Not Found!");
			return;
		}
		
		System.out.println("You got: "+move);
		int finalPos = currPosition + move ;
		if(finalPos <= size) {
			if(board.hasSnakeOrLadder(finalPos)) {
				System.out.println(board.getEntity(finalPos).getEncounterMessage());
				finalPos = board.getEntity(finalPos).getEnd();
			}
			System.out.println("Taking you to "+finalPos);
		} else {
			finalPos = this.size;
		}
		
		player.setPosition(finalPos);
		
	}
	
	public Queue<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public Queue<Player> getWinners() {
		return winners;
	}

	public void setWinners(Queue<Player> winners) {
		this.winners = winners;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
