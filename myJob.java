/*  
    Title:      myJob.java
    Name:       Dylan Kapustka (Dlk190000)
    Instructor: Professor Ozbirn
    Course:     CS 4348.001 - S21
    Date:       05/01/2021

    Description: myJob object class handling job data and printing the output
*/


public class myJob
{
    private String name; //name of job
    private int arrivalTime; //arrival of job
    private int duration; //duration ofjob
    private int spaceCount; //tracks amount of spacing for graph
   
    //Constructor
    myJob(myJob selected)
    {
        name = selected.name;
        arrivalTime = selected.arrivalTime;
        duration = selected.duration;
        spaceCount = selected.spaceCount;
    }
   
    myJob(String n, int arrTime, int durationTime)
    {
        name = n;
        arrivalTime = arrTime;
        duration = durationTime;
    }
   
    public void setSpaceCount(int num)
    {
        spaceCount = num;
    }
   
    //Returns name of job
    public String getName()
    {
        return name;
    }

    //Returns arrival time
    public int getArrivalTime()
    {
        return arrivalTime;
    }
   
    //Returns Duration
    public int getDuration()
    {
        return duration;
    }
   
    //Prints graph
    public void printMatrix()
    {
        System.out.print(name); //Prints name of job (e.g. 'A', 'B', etc.)

        //Creates proper spacing
        for(int i = 0; i <= spaceCount; i++)
        {
            System.out.print(" ");
        }

        //Fills slots with 'X'
        for(int j = 0; j < duration; j++)
        {
            System.out.print("X");
        }

        System.out.println(); //New line for next job
    }
   
}