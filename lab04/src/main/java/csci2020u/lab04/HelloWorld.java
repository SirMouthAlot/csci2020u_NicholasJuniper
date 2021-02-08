package csci2020u.lab04;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.*;


public class HelloWorld extends Application
{	
	@Override
	public void start(Stage stage) throws Exception {
		Insets gridInset = new Insets(0.0, 0.0, 0.0, 30.0);

		//List of Labels
		List<String> labels = new ArrayList<>();
		labels.add("Username:");
		labels.add("Password:");
		labels.add("Full name:");
		labels.add("E-Mail:");
		labels.add("Phone #:");
		labels.add("Date of Birth:");

		//List of input types
		List<InputTypes> inputTypes = new ArrayList<>();
		inputTypes.add(InputTypes.TEXT_FIELD);
		inputTypes.add(InputTypes.PASSWORD);
		inputTypes.add(InputTypes.TEXT_FIELD);
		inputTypes.add(InputTypes.TEXT_FIELD);
		inputTypes.add(InputTypes.PHONE_NUMBER);
		inputTypes.add(InputTypes.DATE_PICKER);

		//Creates our RegistrationPanel
        RegistrationPanel registration = new RegistrationPanel(Pos.TOP_LEFT, 10, 10, gridInset, labels, inputTypes);

        Scene scene = new Scene(registration.GetGridPane(), 640, 480);
   
        stage.setTitle("Lab 04 Solution");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setMinWidth(400);
        stage.setMinHeight(300);
        stage.show();
    }
	
	public static void main(String[] args)
	{
		launch();
	}
}