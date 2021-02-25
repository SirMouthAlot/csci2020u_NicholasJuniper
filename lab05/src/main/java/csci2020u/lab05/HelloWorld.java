package csci2020u.lab05;

import java.util.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class HelloWorld extends Application
{	
	@Override
	public void start(Stage stage) throws Exception 
	{
		//Background pane for other objects to resize to
		Pane pane = new Pane();

		//Creates formatted list for student record reading
		List<TypeFormats> format = List.of(TypeFormats.INT, TypeFormats.FLOAT, TypeFormats.FLOAT, TypeFormats.FLOAT);
		StudentRecordReader recordReader = new StudentRecordReader("TestStudents.txt", 4, format, "");

		//Easy Table View Setup
		List<String> columnNames = List.of("SID", "Assignments", "Midterm", "Final Exam", "Final Mark", "Letter Grade");
		List<TypeFormats> columnFormats = List.of(TypeFormats.STRING, TypeFormats.STRING, TypeFormats.STRING, 
													TypeFormats.STRING, TypeFormats.STRING, TypeFormats.STRING);
		List<String> dataPropertyNames = List.of("studentId", "assignmentGrade", "midtermGrade", 
													"examGrade", "finalGrade", "letterGrade");

		//Creates an easy table view, with columns named as above with the types as above that resizes by itself
		EasyTableView<StudentRecord> studentTableView = new EasyTableView<>(columnNames, columnFormats, recordReader.GetStudentRecords(),
																				dataPropertyNames, true);

		//Makes it so the table resizes with the background pane
		studentTableView.GetTable().prefWidthProperty().bind(pane.widthProperty());
		studentTableView.GetTable().prefHeightProperty().bind(pane.heightProperty());

		//Add table as a child of pane
		pane.getChildren().add(studentTableView.GetTable());

		//Root child is the pane so we can resize everything
        Scene scene = new Scene(pane, 640, 480);

		//Window name
        stage.setTitle("Lab 05 Solution");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
	
	public static void main(String[] args)
	{
		launch();
	}
}