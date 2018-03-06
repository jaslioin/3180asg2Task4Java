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
public class Axe extends Weapon {
	private static final int AXE_RANGE = 1;
	private static final int AXE_INIT_DAMAGE = 40;

	public Axe(Player owner) {
		super(AXE_RANGE, AXE_INIT_DAMAGE, owner);

	}

	public void enhance() {
		this.effect += 10;
	}

	@Override
	public void action(int posx, int posy) {
		// TODO Auto-generated method stub
		System.out.println("You are using axe attacking " + posx + " " + posy + ".");

		if (this.owner.pos.distance(posx, posy)  <= this.range) {
			// search for all targets with target coordinates.
			Player player = owner.game.getPlayer(posx, posy);

			if(player != null ) 
			{
                if(player.getName().charAt(0) == this.owner.getName().charAt(0) && (int)(player.getName().charAt(1))<58 && (int)(player.getName().charAt(0))>47){
                    System.out.println("You cannot attack your same race");
                }
                else if (player.getName().charAt(1) == this.owner.getName().charAt(0))
                    System.out.println("You cannot attack your same race");
                else
                    player.decreaseHealth(this.effect);
			}
		} else {
			System.out.println("Out of reach.");
		}

	}

}
