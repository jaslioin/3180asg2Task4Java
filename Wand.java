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
public class Wand {
	protected final int WAND_RANGE = 5;
	protected int effect = 5;
	protected Player owner;
	
	protected Wand(Player owner) {
        this.owner = owner;
	}
	
    public void action(int posx, int posy){
        System.out.println("You are using wand healing "+posx+" "+posy);
        if (owner.pos.distance(posx,posy) <= this.WAND_RANGE){
            Player player = owner.game.getPlayer(posx,posy);
            if (player != null){
                if(player.getName().charAt(0) == this.owner.getName().charAt(0) && (int)(player.getName().charAt(1))<58 && (int)(player.getName().charAt(0))>47)
                    player.increaseHealth(this.effect);
                else if (player.getName().charAt(1) == this.owner.getName().charAt(0))
                    player.increaseHealth(this.effect);
                else
                    System.out.println("Not the same race!");
            }
        }else
            System.out.println("Out of reach!");
    }
    public void enhance(){
        this.effect += 5;
    }

	public int getEffect() {
		return this.effect;
	}

	public int getRange() {
		return this.WAND_RANGE;
	}
}
