package csci2020u.lab05;

import java.util.*;

public class StudentRecordReader extends FileReader 
{
    //FileReader specific to Student Records
    public StudentRecordReader(String fileName, int dataInLine, List<TypeFormats> format, String delimiter)
    {
        //Calls the FileReader constructor
        super(fileName, dataInLine, format, delimiter);

        //Format for student records file is
        //Student ID        : String - Slot 0
        //Assignment Grade  : Float  - Slot 1
        //Midterm Grade     : Float  - Slot 2
        //Final Exam Grade  : Float  - Slot 3
        for (int i = 0; i < _numLines; i++)
        {
            //Get the list of data for this line
            List<String> studentInfo = _dataRead.get(i);
            //Create a new student record with the student info list
            _studentRecords.add(new StudentRecord(studentInfo.get(0), Float.parseFloat(studentInfo.get(1)), 
                                                    Float.parseFloat(studentInfo.get(2)), Float.parseFloat(studentInfo.get(3))));
        }
    }

    //Gets number of student records stored
    public int GetNumStudentRecords()
    {
        return _studentRecords.size();
    }

    //Gets the list of student records
    public List<StudentRecord> GetStudentRecords()
    {
        return _studentRecords;
    }

    //Gets the individual student record at index
    public StudentRecord GetStudentRecord(int index)
    {
        return _studentRecords.get(index);
    }

    private List<StudentRecord> _studentRecords = new ArrayList<>();
}
