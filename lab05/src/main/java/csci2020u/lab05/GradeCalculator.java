package csci2020u.lab05;

public final class GradeCalculator 
{
    //Create a grade calculator instance that will just automatically calculate final grade using weights
    public GradeCalculator(float assignmentWeight, float midtermWeight, float examWeight)
    {
        //Weight setup
        _assignmentWeight = assignmentWeight;
        _midtermWeight = midtermWeight;
        _examWeight = examWeight;
    }

    public float GetFinalGrade(float assignmentGrade, float midtermGrade, float examGrade)
    {
        float assignmentWeighted = assignmentGrade * _assignmentWeight;
        float midtermWeighted = midtermGrade * _midtermWeight;
        float examWeighted = examGrade * _examWeight;

        return assignmentWeighted + midtermWeighted + examWeighted;
    }

    public String GetLetterGrade(float finalGrade)
    {
        //Invalid grade returns -
        String returnVal = "-";

        //Could write a class using maps to index but not worth it if this is the only lab that uses letter grades
        if (finalGrade <= 49.5 && finalGrade >= 0.0)
        {                                                   //////////////////////////////
            returnVal = "F";                                ///  0%  /// 49.5% ///  F  ///
        }                                                   //////////////////////////////
        else if (finalGrade <= 59.5 && finalGrade > 49.5)   //////////////////////////////
        {                                                   //////////////////////////////
            returnVal = "D";                                ///49.5% /// 59.5% ///  D  ///
        }                                                   //////////////////////////////
        else if (finalGrade <= 69.5 && finalGrade > 59.5)   //////////////////////////////
        {                                                   //////////////////////////////
            returnVal = "C";                                ///59.5% /// 69.5% ///  C  ///
        }                                                   //////////////////////////////
        else if (finalGrade <= 79.5 && finalGrade > 69.5)   //////////////////////////////
        {                                                   //////////////////////////////
            returnVal = "B";                                ///69.5% /// 79.5% ///  B  ///
        }                                                   //////////////////////////////
        else if (finalGrade <= 100.0 && finalGrade > 79.5)  //////////////////////////////
        {                                                   //////////////////////////////
            returnVal = "A";                                ///79.5% /// 100% ///   A  ///
        }                                                   //////////////////////////////

        //Returns out grade
        return returnVal;
    }

    public String GetLetterGrade(float assignmentGrade, float midtermGrade, float examGrade)
    {
        //Calls the letter grade function with our final grade
        return GetLetterGrade(GetFinalGrade(assignmentGrade, midtermGrade, examGrade));
    }


    private float _assignmentWeight;
    private float _midtermWeight;
    private float _examWeight;
}
