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
