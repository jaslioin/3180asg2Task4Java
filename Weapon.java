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
public abstract class Weapon {
	protected final int range;
	protected int effect;
	protected Player owner;
	
	protected Weapon(int range, int damage, Player owner) {
		this.range = range;
		this.effect = damage;
		this.owner = owner;
	}
	
	abstract public void action(int posx, int posy);
	abstract public void enhance();

	public int getEffect() {
		return this.effect;
	}

	public int getRange() {
		return this.range;
	}
}
