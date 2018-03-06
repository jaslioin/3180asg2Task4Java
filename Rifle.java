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
public class Rifle extends Weapon {
	private static final int RIFLE_RANGE = 4;
	private static final int RIFLE_INIT_DAMAGE = 10;

	private static final int AMMO_LIMIT = 6;

	//
	private static final int AMMO_RECHARGE = 3;

	private int ammo;

	public Rifle(Player owner) {
		super(RIFLE_RANGE, RIFLE_INIT_DAMAGE, owner);
		// TODO Auto-generated constructor stub
		this.ammo = AMMO_LIMIT;
	}

	public void enhance() {
		// recharge
		this.ammo = Math.min(AMMO_LIMIT, this.ammo + AMMO_RECHARGE);

	}

	@Override
	public void action(int posx, int posy) {
		// TODO Auto-generated method stub
		System.out.println("You are using rifle attacking " + posx + " " + posy + ".");

		System.out.println("Type how many ammos you want to use.");

		int ammoToUse = SurvivalGame.reader.nextInt();

		if (ammoToUse > this.ammo) {
			System.out.println("You don't have that ammos.");
			return;
		} 

		if (this.owner.pos.distance(posx, posy) <= this.range) {
			// search for all targets with target coordinates.
			Player player = owner.game.getPlayer(posx, posy);
			if(player != null)
			{
                if(player.getName().charAt(0) == this.owner.getName().charAt(0) && (int)(player.getName().charAt(1))<58 && (int)(player.getName().charAt(0))>47){
                    System.out.println("You cannot attack your same race");
                }else if (player.getName().charAt(1) == this.owner.getName().charAt(0)){
                    System.out.println("You cannot attack your same race");
                }else{
                    player.decreaseHealth(this.effect * ammoToUse);
                    ammo -= ammoToUse;
                }
			}
		} else
			System.out.println("Out of reach.");

	}

	public int getAmmo() {
		return this.ammo;
	}

}
