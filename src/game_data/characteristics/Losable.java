package game_data.characteristics;

import game_data.characteristics.characteristic_annotations.CharacteristicAnnotation;

/**
 * @author austingartside
 * potentially there will be some common "lose" action that will activate for all characteristics of this type
 * which is why it is a super class for now despite doing nothing
 */
@CharacteristicAnnotation(name = "Losable")
public class Losable{

	public Losable(){
		//literally do nothing
	}
}
