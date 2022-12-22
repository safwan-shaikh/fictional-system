package snakeAndLadder.entities;

import java.util.HashMap;
import java.util.Queue;
import java.util.Random;

public class Board {

	HashMap<Integer, BoardEntity> cells;
	int cellCount;
	Player p;

	public Board(int dimention) {
		this.cellCount = dimention * dimention;
		cells = new HashMap<Integer, BoardEntity>();

		int min = 2;
		int max = cellCount - 1;
		int start = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int end = (int) Math.floor(Math.random() * (max - min + 1) + min);

		for (int i = 0; i < dimention; i++) {

			max = start - 1;
			if (!hasBoardEntity(start)) {
				setEntity(start, new Snake(start, end));
			}

			max = cellCount - 1;
			end = (int) Math.floor(Math.random() * (max - min + 1) + min);
			max = end - 1;
			start = (int) Math.floor(Math.random() * (max - min + 1) + min);
			if (!hasBoardEntity(start)) {
				setEntity(start, new Ladder(start, end));
			}

		}

		Random random = new Random();
        Integer position = random.nextInt(50);
		if (!hasBoardEntity(position)) {
			Rocket rocket = new Rocket(position);
			setEntity(rocket.getStart(), rocket);
		}
	}

	public void print(Queue<Player> p) {
		for (int i = cellCount; i > 0; i--) {
			for (Player player : p) {
				// System.out.println(player.getUserName()+":"+player.getPosition());
				if (i == player.getPosition()) {
					System.out.print(player.getString());
					break;
				}
			}
			if (hasBoardEntity(i)) {
				System.out.print(cells.get(i).getString());
			} else {
				if (i == 1)
					System.out.print("🏠️");
				else if (i == 100)
					System.out.print("🏁️");
				else
					System.out.print(i + " ");
			}
			System.out.print("\t");

			if (i % 10 == 1) {
				System.out.println("\n");
			}
		}
		System.out.println();

	}

	private void setEntity(int index, BoardEntity e) {
		cells.put(index, e);
	}

	public BoardEntity getEntity(int index) {
		if (hasBoardEntity(index)) {
			return this.cells.get(index);
		}
		return null;
	}

	public boolean hasBoardEntity(int cellIndex) {
		return cells.containsKey(cellIndex);
	}

}
