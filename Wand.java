public class Wand {
	protected final int WAND_RANGE = 5;
	protected int effect = 10;
	protected Player owner;
	
	protected Wand(Player owner) {
        this.owner = owner;
	}
	
    public void action(int posx, int posy){
        System.out.println("You are using wand healing "+posx+" "+posy);
        if (owner.pos.distance(posx,posy) <= this.WAND_RANGE){
            Player player = owner.game.getPlayer(posx,posy);
            if (player != null){
                if (player.getName().charAt(0) == this.owner.getName().charAt(0))
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
