/*
 # CSCI3180 Principles of Programming Languages
 # --- Declaration ---
 # I declare that the assignment here submitted is original except for source
 # material explicitly acknowledged. I also acknowledge that I am aware of
 # University policy and regulations on honesty in academic work, and of the
 # disciplinary guidelines and procedures applicable to breaches of such policy and regulations, as contained in the website
 # http://www.cuhk.edu.hk/policy/academichonesty/
 # Assignment 2
 # Name : Li Ho Yin
 #Student ID : 1155077785
 #Email Addr : hyli6@cse.cuhk.edu.hk
 */
import java.util.Random;

public class Obstacle {
	private Pos pos;
	int index;
	private SurvivalGame game;
	
	public Obstacle(int posx, int posy, int index, SurvivalGame game) {
		// TODO Auto-generated constructor stub
		pos = new Pos(posx, posy);
		this.index = index;
		this.game = game;
	}

	public Pos getPos() {
		return pos;
	}

	
	public void teleport() {
		Random rand;
		rand = new Random();
		// distributed at different sides
		int randx = rand.nextInt(game.D);
		int randy = game.D - randx - 1;
		while (game.positionOccupied(randx, randy)) {
			randx = rand.nextInt(game.D);
			randy = game.D - randx - 1;
		}
		pos.setPos(randx, randy);
	}
}
