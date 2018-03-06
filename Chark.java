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
public class Chark extends Player {

	public Chark(int posx, int posy, int index, SurvivalGame game) {
		super(100, 4, posx, posy, index, game);

		this.myString = "C" + Integer.toString(index);
		this.equipment = new Axe(this);

	}

	public void teleport() {
		
		super.teleport();		
        if(this.equipment instanceof Axe)
            ((Axe) this.equipment).enhance();
        else if(this.equipment instanceof Wand)
            ((Wand)this.equipment).enhance();
	}
    @Override
    public void increaseHealth(int h){
        if (this.health <=0){
            this.myString = "C" + Integer.toString(this.index);
            System.out.format("%s revived\n", this.myString);
        }
        super.increaseHealth(h);
    }
	@Override
	public void askForMove() {
        if(this.equipment instanceof Axe){
            // TODO Auto-generated method stub
            System.out.println(String.format("You are a Chark (C%d) using Axe. (Range: %d, Damage: %d)",this.index,
                                             ((Weapon)this.equipment).getRange(), ((Weapon)this.equipment).getEffect()));
        }
        if(this.equipment instanceof Wand){
            System.out.println(String.format("You are a Chark (C%d) using Wand. (Range: %d, amount per heal: %d)",this.index,
                                             ((Wand)this.equipment).getRange(), ((Wand)this.equipment).getEffect()));
        }
		
		super.askForMove();
		
	}
}
