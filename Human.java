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
public class Human extends Player {
	
	public Human(int posx, int posy, int index, SurvivalGame game) {
		super(80, 2, posx, posy, index, game);
		
		this.myString = 'H' + Integer.toString(index);
		this.equipment = new Rifle(this);
		
	}

	public void teleport() {
		super.teleport();
        if(this.equipment instanceof Rifle)
            ((Rifle)this.equipment).enhance();
        else if(this.equipment instanceof Wand)
            ((Wand)this.equipment).enhance();
	}
	
	public void distance(int posx, int posy)
	{
		
	}
	
	@Override
    public void increaseHealth(int h){
        if (this.health <= 0){
            this.myString = "H" + Integer.toString(this.index);
            System.out.format("%s revived",this.myString);
        }
        super.increaseHealth(h);
    }
    @Override
	public void askForMove() {
        if(this.equipment instanceof Rifle){
            // TODO Auto-generated method stub
            System.out.println(String.format("You are a human (H%d) using Rifle. (Range %d, Ammo #: %d, Damage per shot: %d)", this.index,
                                            ((Weapon)this.equipment).getRange(),((Rifle)this.equipment).getAmmo(),
                                             ((Weapon)this.equipment).getEffect() ));
        }
        if(this.equipment instanceof Wand){
            System.out.println(String.format("You are a human (H%d) using Wand. (Range %d, amount per heal: %d)", this.index,
                                             ((Wand)this.equipment).getRange(),                                             ((Wand)this.equipment).getEffect() ));
        }
		

		super.askForMove();
		
	}

}
