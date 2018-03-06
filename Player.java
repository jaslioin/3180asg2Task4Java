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

public abstract class Player {
	private int MOBILITY;
	protected Pos pos;
	protected int health;
	//protected Weapon equipment;
    public Object equipment;
	protected int index;
	protected String myString;
	protected SurvivalGame game;
    int HEALTH_CAP;
	public Player(int healthCap, int mob, int posx, int posy, int index, SurvivalGame game) {

		this.MOBILITY = mob;
		this.health = healthCap;
        this.HEALTH_CAP = healthCap;
		this.pos = new Pos(posx, posy);
		this.index = index;
		this.game = game;
	}

	public Pos getPos() {
		return pos;
	}

	public void teleport() {

		Random rand;
		rand = new Random();
		int randx = rand.nextInt(game.D);
		int randy = rand.nextInt(game.D);
		while (game.positionOccupied(randx, randy)) {
			randx = rand.nextInt(game.D);
			randy = rand.nextInt(game.D);
		}
		pos.setPos(randx, randy);
	}

	public void increaseHealth(int h) {
		this.health += h;
        if(this.health > this.HEALTH_CAP){
            System.out.println( "reached health cap!");
            this.health = this.HEALTH_CAP;
        }
	}

	public void decreaseHealth(int h) {
		this.health -= h;
		if (this.health <= 0)
			this.myString = "C" + this.myString.charAt(0);
	}

	public String getName() {
		return myString;
	}

	public void askForMove() {
		// Print general information
		System.out.println("Your health is " + health
				+ String.format(". Your position is (%d,%d). Your mobility is %d.", pos.getX(), pos.getY(), this.MOBILITY));

		System.out.println("You now have following options: ");
		System.out.println("1. Move");
		System.out.println("2. Action");
		System.out.println("3. End tne turn");

		int a = SurvivalGame.reader.nextInt();

		if (a == 1) {
			System.out.println("Specify your target position (Input 'x y').");
			int posx = SurvivalGame.reader.nextInt(), posy = SurvivalGame.reader.nextInt();
			if (pos.distance(posx, posy) > this.MOBILITY) {
				System.out.println("Beyond your reach. Staying still.");
			} else if (game.positionOccupied(posx, posy)) {
				System.out.println("Position occupied. Cannot move there.");
			} else {
				this.pos.setPos(posx, posy);
				game.printBoard();
				System.out.println("You can now \n1.Action\n2.End the turn");
				if (SurvivalGame.reader.nextInt() == 1) {
					System.out.println("Input position to act. (Input 'x y')");
					int attx = SurvivalGame.reader.nextInt(), atty = SurvivalGame.reader.nextInt();
                    if(this.equipment instanceof Weapon)
                        ((Weapon)this.equipment).action(attx, atty);
                    else if (this.equipment instanceof Wand)
                        ((Wand)this.equipment).action(attx,atty);
				}
			}
		} else if (a == 2) {
			System.out.println("Input position to act.");
			int attx = SurvivalGame.reader.nextInt(), atty = SurvivalGame.reader.nextInt();
			if(this.equipment instanceof Weapon)
                ((Weapon)this.equipment).action(attx, atty);
            else if (this.equipment instanceof Wand)
                ((Wand)this.equipment).action(attx,atty);
                
		} else if (a == 3) {
			return;
		}
	}

}
