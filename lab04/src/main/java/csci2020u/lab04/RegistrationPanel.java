package csci2020u.lab04;

import java.util.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class RegistrationPanel 
{
    public RegistrationPanel(Pos alignment, double hGap, double vGap, Insets gridInset,
                                List<String> labels, List<InputTypes> inputTypes)
    {
        //automatically creates our gridpane when we craft the object
        CreateRegistrationGridPane(alignment, hGap, vGap, gridInset, labels, inputTypes);
    }

    //Creates the registration grid pane
	//with the exception of the text fields
	public GridPane CreateRegistrationGridPane(Pos alignment, double hGap, double vGap, Insets gridInset,
                                                List<String> labels, List<InputTypes> inputTypes)
	{
		//Creates a gridpane
		_gridPane = new GridPane();
		//Sets the alignment to center left
		_gridPane.setAlignment(alignment);
		//Sets up a gap between columns
        _gridPane.setHgap(hGap);
        //Sets up a gap between rows
        _gridPane.setVgap(vGap);
        
        SetUpLabels(gridInset, labels);
        SetUpFields(gridInset, labels, inputTypes);
        SetUpButton(gridInset, labels.size());

        //Returns out set up gridpane
        return _gridPane;
	}

    public void SetUpLabels(Insets gridInset, List<String> labels)
    {
        //Create our labels with a loop
        for (int i = 0; i < labels.size(); i++)
        {
            Label temp = new Label(labels.get(i));
            _labels.add(temp);

            _gridPane.add(temp, 0, i);
            GridPane.setMargin(temp, gridInset);
        }
    }

    public void SetUpFields(Insets gridInset, List<String> labels, List<InputTypes> inputTypes)
	{
        //Sets up grid inset for our children
        for (int i = 0; i < inputTypes.size(); i++)
        {
            //Uses the enum found in InputTypes
            switch(inputTypes.get(i))
            {
                case TEXT_FIELD:
                 //Sets up text field
                TextField temp = new TextField();
                temp.setPromptText(labels.get(i));
                _textFields.add(temp);

                _gridPane.add(temp, 1, i);
                GridPane.setMargin(temp, gridInset);
                break;
                case PASSWORD:
                //Sets up text field
                PasswordField temp2 = new PasswordField();
                temp2.setPromptText(labels.get(i));
                _textFields.add(temp2);

                _gridPane.add(temp2, 1, i);
                GridPane.setMargin(temp2, gridInset);
                break;
                case PHONE_NUMBER:
                //Create text field and format it here
                PhoneTextField temp3 = new PhoneTextField();
                temp3.setPromptText(labels.get(i));
                _textFields.add(temp3);
                
                _gridPane.add(temp3, 1, i);
                GridPane.setMargin(temp3, gridInset);
                break;
                case DATE_PICKER:
                 //Sets up text field
                DatePicker temp4 = new DatePicker();
                _datePickers.add(temp4);

                _gridPane.add(temp4, 1, i);
                GridPane.setMargin(temp4, gridInset);
                break;
                default:
                //Does nothing
                break;
            }
        }
	}

    public void SetUpButton(Insets gridInset, int bottomOfList)
	{	
		//Creates our button
        _registerButton = new Button("Register");
        _registerButton.setMinSize(80, 40);

        //Sets handler for register button
        _registerButton.setOnAction(value -> {
            HandleRegisterButton();
        });
        
        //Set up our button
        _gridPane.add(_registerButton, 1, bottomOfList);
        GridPane.setMargin(_registerButton, gridInset);
	}

    //Handles our register button
	//Does everything the register button should do
	private void HandleRegisterButton()
	{
		//Prints out all fields
        for (int i = 0; i < _textFields.size(); i++)
        {
            System.out.println(_textFields.get(i).getText());
        }
        for (int i = 0; i < _datePickers.size(); i++)
        {
            System.out.println(_datePickers.get(i).getValue());
        }
	}

    //Getters
    //Gets the gridpane
    public GridPane GetGridPane()
    {
        return _gridPane;
    }
    
    //Gets our button
    public Button GetButton()
    {
        return _registerButton;
    }

    //Gets the labels list
    public List<Label> GetLabels()
    {
        return _labels;
    }

    //Gets an individual label
    public Label GetLabel(int index)
    {
        return _labels.get(index);
    }

    //Gets the text fields list
    public List<TextField> GetTextFields()
    {
        return _textFields;
    }

    //Gets an individual text field
    public TextField GetTextField(int index)
    {
        return _textFields.get(index);
    }

    //Gets the date picker list
    public List<DatePicker> GetDatePickers()
    {
        return _datePickers;
    }

    //Gets an individual date picker
    public DatePicker GetDatePicker(int index)
    {
        return _datePickers.get(index);
    }


    //Our gridpane
    private GridPane _gridPane;
    //Our register button
    private Button _registerButton;

    //List of label references
    private List<Label> _labels = new ArrayList<>();
    //List of text field references
    private List<TextField> _textFields = new ArrayList<>();
    //List of date picker references
    private List<DatePicker> _datePickers = new ArrayList<>();

}
