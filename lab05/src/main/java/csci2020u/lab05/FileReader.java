package csci2020u.lab05;

import java.io.*;
import java.util.*;

/////****Delimiter Information****\\\\\
// abc…    Letters
// 123…    Digits
// \d      Any Digit
// \D      Any Non-digit character
// .       Any Character
// \.      Period
// [abc]   Only a, b, or c
// [^abc]  Not a, b, nor c
// [a-z]   Characters a to z
// [0-9]   Numbers 0 to 9
// \w      Any Alphanumeric character
// \W      Any Non-alphanumeric character
// {m}     m Repetitions
// {m,n}   m to n Repetitions
// *       Zero or more repetitions
// +       One or more repetitions
// ?       Optional character
// \s      Any Whitespace
// \S      Any Non-whitespace character
// ^…$     Starts and ends
// (…)     Capture Group
// (a(bc)) Capture Sub-group
// (.*)    Capture all
// (ab|cd) Matches ab or cd


public class FileReader 
{
    public FileReader(String fileName, int dataInLine, List<TypeFormats> format, String delimiter) 
    {
        try 
        {
            // Loads in file
            File fileToScan = new File(fileName);

            // Creates a scanner with our loaded file
            Scanner scanner = new Scanner(fileToScan);

            // Check if there's an empty delimiter so we can set it to just whitespace
            if (!(delimiter.equals("") || delimiter.equals(" "))) 
            {
                scanner.useDelimiter(delimiter);
            }


            //Starts at -1
            int lineNum = -1;

            // Keeps going through the file while it has a next line
            while (scanner.hasNextLine()) 
            {
                lineNum++;

                //Makes sure that every line after the first one, it proceeds to next line
                if (lineNum != 0)
                {
                    scanner.nextLine();
                }

                _dataRead.put(lineNum, new ArrayList<>());

                // Loops through and gets the data in the line
                for (int i = 0; i < dataInLine; i++) 
                {
                    if (scanner.hasNext()) 
                    {

                        switch (format.get(i)) 
                        {
                            // Gets float
                            case FLOAT:
                                _dataRead.get(lineNum).add(String.valueOf(scanner.nextFloat()));
                                break;
                            // Gets int
                            case INT:
                                _dataRead.get(lineNum).add(String.valueOf(scanner.nextInt()));
                                break;
                            // Gets double
                            case DOUBLE:
                                _dataRead.get(lineNum).add(String.valueOf(scanner.nextDouble()));
                                break;
                            // Gets word
                            case STRING:
                                _dataRead.get(lineNum).add(scanner.next());
                                break;
                            default:

                                break;
                        }
                    }
                }
                
            }

            _numLines = lineNum;

            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("There was an issue with your file.");
            e.printStackTrace();
        }
    }
    
    //Get the number of lines
    public int GetNumLines()
    {
        return _numLines;
    }

    //Get the data read
    public Map<Integer, List<String>> GetDataRead()
    {
        return _dataRead;
    }

    protected int _numLines;
    protected Map<Integer, List<String>> _dataRead = new TreeMap<>();
}
