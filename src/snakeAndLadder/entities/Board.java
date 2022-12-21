package snakeAndLadder.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Board {
	
	HashMap<Integer, BoardEntity> cells;
	int cellCount;
	Player p;
	
	public Board(int dimention) {
		this.cellCount = dimention*dimention;
		cells = new HashMap<Integer, BoardEntity>();
		for(int i=0; i<dimention; i++) {
			int min = 2;
			int max = cellCount - 1;
			int start = (int) Math.floor(Math.random()*(max-min+1)+min);
			max = start - 1;
			int end = (int) Math.floor(Math.random()*(max-min+1)+min);
			if(!hasSnakeOrLadder(start)) {
				setEntity(start, new Snake(start, end));
			}
			max = cellCount - 1;
			end = (int) Math.floor(Math.random()*(max-min+1)+min);
			max = end - 1;
			start = (int) Math.floor(Math.random()*(max-min+1)+min);
			if(!hasSnakeOrLadder(start)) {
				setEntity(start, new Ladder(start, end));
			}
			
		}
	}
	
	public void print(Queue<Player> p) {
		for(int i=cellCount-1; i>0; i--) {
			for(Player player : p) {
				//System.out.println(player.getUserName()+":"+player.getPosition());
				if(i==player.getPosition()) {
					System.out.print(player.getString());
					break;
				}
			}
			if(hasSnakeOrLadder(i)) {
				System.out.print(cells.get(i).getString());
			}
			else
				System.out.print(i+" ");
			System.out.print("         ");
			if(i%10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
	}
	
	private void setEntity(int index, BoardEntity e) {
		cells.put(index, e);
	}
	
	public BoardEntity getEntity(int index) {
		if(hasSnakeOrLadder(index)) {
			return this.cells.get(index);
		}
		return null;
	}
	
	public boolean hasSnakeOrLadder(int cellIndex) {
		return cells.containsKey(cellIndex);
	}

}
