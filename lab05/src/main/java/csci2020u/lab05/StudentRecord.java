package csci2020u.lab05;

import javafx.beans.property.*;

public final class StudentRecord 
{
    //Static grade calculator
    public static final GradeCalculator s_gradeCalculator = new GradeCalculator(0.2f, 0.3f, 0.5f);

    public StudentRecord(String sID, float aGrade, float mGrade, float eGrade)
    {
        //Set the record values
        studentId = new SimpleStringProperty(sID);
        assignmentGrade = new SimpleFloatProperty(aGrade);
        midtermGrade = new SimpleFloatProperty(mGrade);
        examGrade = new SimpleFloatProperty(eGrade);

        //Calculate final grade
        finalGrade = new SimpleFloatProperty(s_gradeCalculator.GetFinalGrade(aGrade, mGrade, eGrade));
        //Calculate the final letter grade
        letterGrade = new SimpleStringProperty(s_gradeCalculator.GetLetterGrade(finalGrade.floatValue()));
    }

    public String getStudentId()
    {
        return studentId.get();
    }

    public void setStudentId(String sID)
    {
        studentId.set(sID);
    }

    public Float getAssignmentGrade()
    {
        return assignmentGrade.get();
    }

    public void setAssignmentGrade(Float aGrade)
    {
        assignmentGrade.set(aGrade);
    }

    public Float getMidtermGrade()
    {
        return midtermGrade.get();
    }

    public void setMidtermGrade(Float mGrade)
    {
        midtermGrade.set(mGrade);
    }

    public Float getExamGrade()
    {
        return examGrade.get();
    }

    public void setExamGrade(Float eGrade)
    {
        examGrade.set(eGrade);
    }

    public Float getFinalGrade()
    {
        return finalGrade.get();
    }

    public void setFinalGrade(Float fGrade)
    {
        finalGrade.set(fGrade);
    }

    public String getLetterGrade()
    {
        return letterGrade.get();
    }

    public void setLetterGrade(String lGrade)
    {
        letterGrade.set(lGrade);
    }

    //Stores student record information
    //Public for easy access
    //Properties for use with table
    private final SimpleStringProperty studentId;
    private final SimpleFloatProperty assignmentGrade;
    private final SimpleFloatProperty midtermGrade;
    private final SimpleFloatProperty examGrade;
    private final SimpleFloatProperty finalGrade;
    private final SimpleStringProperty letterGrade;
}
