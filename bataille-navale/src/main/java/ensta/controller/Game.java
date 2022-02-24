package ensta.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Hit;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;
import ensta.ai.PlayerAI;
import ensta.util.ColorUtil;

public class Game {

	/*
	 * *** Constante
	 */
	public static final File SAVE_FILE = new File("savegame.dat");

	/*
	 * *** Attributs
	 */
	private Player player1;
	private Player player2;
	private boolean multiplayer;
	private Scanner sin;

	/*
	 * *** Constructeurs
	 */
	public Game() {
		this.multiplayer = false;
	}
	public Game(boolean multi) {
		this.multiplayer = multi;
	}

	public Game init() {
		if (!loadSave()) {


			Board board1 = new Board();
			Board board2 = new Board();

			if(!multiplayer){
				System.out.println("Bienvenu dans le mode: Joueur Contre IA");
				List<AbstractShip> ships1 = Game.createDefaultShips();
				List<AbstractShip> ships2 = Game.createDefaultShips();
				this.player1 = new Player(board1, board2, ships1);
				this.player2 = new PlayerAI(board2, board1, ships2);
				board1.print();
				System.out.println("Veuillez placer vos bateaux sur la grille");
				this.player1.putShips();
				this.player2.putShips();
				System.out.println("Fin des placements, début de la partie");

			}else{
				System.out.println("Bienvenu dans le mode: Joueur Contre Joueur");
				List<AbstractShip> ships1 = Game.createDefaultShips();
				List<AbstractShip> ships2 = Game.createDefaultShips();
				this.player1 = new Player(board1, board2, ships1);
				this.player2 = new Player(board2, board1, ships2);
				System.out.println("Joueur 1: Veuillez placer vos bateaux sur la grille");
				board1.print();
				this.player1.putShips();
				System.out.println("Joueur 2: Veuillez placer vos bateaux sur la grille");
				board2.print();
				this.player2.putShips();
				System.out.println("Fin des placements, début de la partie");
			}
		

		}
		return this;
	}

	/*
	 * *** Méthodes
	 */
	public void run() {
		Coords coords = new Coords();
		Board b1 = player1.getBoard();
		Board b2 = player2.getBoard();
		Hit hit;

		// main loop
		if(!multiplayer){
			b1.print();
		}
		boolean done;
		do {
			System.out.println("Au tour du Joueur 1: ");
			if(multiplayer){
				b1.print();
			}
			hit = player1.sendHit(coords); // TODO player1 send a hit
			Boolean strike = hit != Hit.MISS; // TODO set this hit on his board (b1)
			b1.setHit(strike, coords);
			done = updateScore();
			sleep(500);
			System.out.println(makeHitMessage(false /* outgoing hit */, coords, hit));
			b1.print();
			// save();
			if (!done && !strike) {
				do {
					if(multiplayer){
						System.out.println("Au tour du Joueur 2: ");
						b2.print();
					}else{
						System.out.println("Au tour de l'IA: ");
						sleep(1000);
					}
					hit = player2.sendHit(coords); // TODO player2 send a hit.
					strike = hit != Hit.MISS;
					if(multiplayer){
						b2.setHit(strike, coords);
						b2.print();
					}
					sleep(500);
					System.out.println(makeHitMessage(true /* incoming hit */, coords, hit));
					if (strike && !multiplayer) {
						b1.print();
					}
					done = updateScore();

					if (!done) {
//						save();
					}
				} while (strike && !done);
			}
		} while (!done);

		SAVE_FILE.delete();
		System.out.println(String.format("joueur %d gagne", player1.isLose() ? 2 : 1));
		//sin.close();
	}

	private void save() {
//		try {
//			// TODO bonus 2 : uncomment
//			// if (!SAVE_FILE.exists()) {
//			// SAVE_FILE.getAbsoluteFile().getParentFile().mkdirs();
//			// }
//
//			// TODO bonus 2 : serialize players
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	private boolean loadSave() {
//		if (SAVE_FILE.exists()) {
//			try {
//				// TODO bonus 2 : deserialize players
//
//				return true;
//			} catch (IOException | ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
		return false;
	}

	private boolean updateScore() {
		for (Player player : new Player[] { player1, player2 }) {
			int destroyed = 0;
			for (AbstractShip ship : player.getShips()) {
				if (ship.isSunk()) {
					destroyed++;
				}
			}

			player.setDestroyedCount(destroyed);
			player.setLose(destroyed == player.getShips().length);
			if (player.isLose()) {
				return true;
			}
		}
		return false;
	}

	private String makeHitMessage(boolean incoming, Coords coords, Hit hit) {
		String msg;
		ColorUtil.Color color = ColorUtil.Color.RESET;
		switch (hit) {
		case MISS:
			msg = hit.toString();
			break;
		case STRIKE:
			msg = hit.toString();
			color = ColorUtil.Color.RED;
			break;
		default:
			msg = hit.toString() + " coulé";
			color = ColorUtil.Color.RED;
		}
		msg = String.format("%s Frappe en %c%d : %s", incoming ? "<=" : "=>", ((char) ('A' + coords.getX())),
				(coords.getY()), msg);
		return ColorUtil.colorize(msg, color);
	}

	private static List<AbstractShip> createDefaultShips() {
		return Arrays.asList(new AbstractShip[] { new Destroyer(), new Submarine(), new Submarine(), new BattleShip(),
				new Carrier() });
	}

	private static void sleep(int ms) {
		try {
		  Thread.sleep(ms);
		} catch (InterruptedException e) {
		  e.printStackTrace();
		}
	  }
}
