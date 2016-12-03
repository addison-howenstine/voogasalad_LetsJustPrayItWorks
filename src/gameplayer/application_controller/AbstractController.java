package gameplayer.application_controller;

import gameplayer.front_end.application_scene.IDisplay;
import gameplayer.front_end.gui_generator.GUIGenerator;
import javafx.stage.Stage;

public abstract class AbstractController {

	public static final int SCENE_SIZE = 1000;
	protected Stage myStage;
	protected GUIGenerator myGUIGenerator = new GUIGenerator();
	
	public AbstractController(){
	}
	
	protected void resetStage(IDisplay aScene){
		myStage.close();
		myStage.setScene(aScene.init());
		myStage.show();
	}
}