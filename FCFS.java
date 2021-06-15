/*  
    Title:      FCFS.java
    Name:       Dylan Kapustka (Dlk190000)
    Instructor: Professor Ozbirn
    Course:     CS 4348.001 - S21
    Date:       05/01/2021

    Description: FCFS class implements FCFS algorithm
*/

import java.util.ArrayList;

public class FCFS
{

    //Main algorithm
    public void mySchedule(ArrayList<myJob> list)
    {
        System.out.println("FCFS"); //Print algorithm name for graph
        myJob copy;
        int time = 0;

         //Copy list
         ArrayList<myJob> newList = new ArrayList<>();
         for(myJob job: list)
         {
             newList.add(new myJob(job));
         }

       while(!(newList.isEmpty()))
        {
            copy = max(newList);
            copy.setSpaceCount(time);
            copy.printMatrix();
            time += copy.getDuration();
        }
    }

    //Helper function to find max
    public myJob max(ArrayList<myJob> list)
    {
        myJob selected = null;
        int max = 10000;
        int index = 0;

        for(int i = 0; i < list.size(); i++)
        {
            if(max >= list.get(i).getArrivalTime())
            {
                index = i;
                max = list.get(i).getArrivalTime();
                selected = list.get(i);
            }
        }

        list.remove(index);

        return selected;
    }
}