package csci2020u.lab04;

import java.util.regex.Pattern;

import javafx.scene.control.TextField;

//Custom phone text field class
//Inspired by the implementation found here: https://stackoverflow.com/questions/35308219/how-to-format-a-text-field-javafx
//Just used to figure out how to set up a listener for changing
//Inspired by here to check format using Pattern object: https://stackoverflow.com/questions/18259644/how-to-check-if-a-string-matches-a-specific-format
public class PhoneTextField extends TextField
{
    private Pattern phoneNumber;

    //Creates empty text field and focuses lsitener 
    public PhoneTextField()
    {
        super();
        setText("000-000-0000");

        phoneNumber = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");

        //Adds listener to check when focus lost
        focusedProperty().addListener((o, oldV, newV) -> OnChanged(newV));
    }

    private void OnChanged(boolean focus)
    {
        //if the text field isn't in focus.
        if (!focus)
        {
            //If the validation returns false (the field doesn't match)
            if (!Validate())
            {
                //Reset the text to the default
                setText("000-000-0000");
                selectAll();
            }
        }
    }

    public boolean Validate() 
    {
        //Uses our compiled regex pattern to check if our text matches phone number format
        return phoneNumber.matcher(getText()).matches();
    }
}
