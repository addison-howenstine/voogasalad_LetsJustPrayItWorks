package states;

import game_engine.SpritePhysics;

public class Physics implements State{

	SpritePhysics myPhysics;
	
	public Physics(SpritePhysics aSpritePhysics){
		myPhysics = aSpritePhysics;
	}
	
	public SpritePhysics getPhysics(){
		return myPhysics;
	}
	
	@Override
	public State copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateState() {
		// TODO Auto-generated method stub
		
	}

}
