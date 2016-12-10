/*
 * Authors: Alex + Austin
 * 
 */

package game_data.characteristics;

import java.util.Map;

import game_data.Sprite;
import game_data.characteristics.characteristic_annotations.NameAnnotation;
import game_data.characteristics.characteristic_annotations.ParameterAnnotation;
import game_data.characteristics.characteristic_annotations.ViewableMethodOutput;
import game_data.sprites.Player;
import game_engine.actions.Action;
import game_engine.actions.Break;
import javafx.geometry.Side;

@NameAnnotation(name = "Breakable")
public class Breakable implements Characteristic{

	private boolean breakableNorth;
	private boolean breakableSouth;
	private boolean breakableEast;
	private boolean breakableWest;
	private int myDurability;
	private Action myAction;
	private Sprite mySprite;
	
	@ParameterAnnotation(parameters = {"Breaks on Top", "Breaks on Bottom", "Breaks on Left", "Breaks on Right", "Durability", "Sprite"})
	public Breakable(boolean north, boolean south, boolean east, boolean west, int durability, Sprite aSprite){
		breakableNorth = north;
		breakableSouth = south;
		breakableEast = east;
		breakableWest = west;
		myDurability = durability;
		mySprite = aSprite;
	}
	
	public void setDurability(int durability){
		myDurability = durability;
	}
	
	@ViewableMethodOutput(description = "Durability", type=int.class)
	public int getDurability() {
		return myDurability;
	}
	
	@Override
	public void execute(Map<Sprite, Side> myCollisionMap){
		for(Sprite collidedSprite:myCollisionMap.keySet()){
			if(breaksAtDirection(myCollisionMap.get(collidedSprite)) && collidedSprite instanceof Player){
//				System.out.println("SIDE HIT: "+myCollisionMap.get(collidedSprite));
				if(isBroken()) {
					myAction = new Break(mySprite, collidedSprite);
					myAction.act();
				}
			}
		}
	}
	
	private boolean isBroken() {
		myDurability--;
		return myDurability<=0;
	}
	
	private boolean breaksAtDirection(Side aDirection) {
		if(aDirection == Side.TOP) {
			return breakableNorth;
		} else if(aDirection == Side.BOTTOM) {
			return breakableSouth;
		} else if(aDirection == Side.RIGHT) {
			return breakableEast;
		} else if(aDirection == Side.LEFT) {
			return breakableWest;
		} 
		return false;
	}

	@Override
	public Characteristic copy() {
		return new Breakable(breakableNorth, breakableSouth, breakableEast, breakableWest, myDurability, mySprite);
	}

	@ViewableMethodOutput(description="Breaks on Top", type=boolean.class)
	public boolean breaksOnTop(){
		return breaksAtDirection(Side.TOP);
	}
	
	@ViewableMethodOutput(description="Breaks on Left", type=boolean.class)
	public boolean breaksOnLeft(){
		return breaksAtDirection(Side.LEFT);
	}
	
	@ViewableMethodOutput(description="Breaks on Bottom", type=boolean.class)
	public boolean breaksOnBottom(){
		return breaksAtDirection(Side.BOTTOM);
	}
	
	@ViewableMethodOutput(description="Breaks on Right", type=boolean.class)
	public boolean breaksOnRight(){
		return breaksAtDirection(Side.RIGHT);
	}
}
