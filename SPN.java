/*  
    Title:      SPN.java
    Name:       Dylan Kapustka (Dlk190000)
    Instructor: Professor Ozbirn
    Course:     CS 4348.001 - S21
    Date:       05/01/2021

    Description: SPN class implements SPN algorithm
*/

import java.util.ArrayList;

public class SPN
{
    
    //Main algorithm
    public void mySchedule(ArrayList<myJob> list)
    {
        System.out.println("SPN"); //Print algorithm name for graph

       int time = 0;
       myJob nextJob;

       //Copy list
       ArrayList<myJob> newList = new ArrayList<>();
       for(myJob job: list)
       {
           newList.add(new myJob(job));
       }

       int index;
       while(!(newList.isEmpty()))
       {
           nextJob = min(newList,time);

           //Get index
           index = 0;
           for(int i = 0; i < list.size(); i++)
           {
               if(list.get(i).getName().equals(nextJob.getName()))
               {
                   index = i;
               }
           }

           list.get(index).setSpaceCount(time);
           time += nextJob.getDuration();
       }

        for(myJob job: list)
        {
            job.printMatrix();
        }

    }

    //Helper function to find min
    private myJob min(ArrayList<myJob> listCopy, int time)
    {
        myJob selected = null;
        int index = 0;
        int min = 1000;
        for(int i = 0; i < listCopy.size(); i++)
        {
            if(listCopy.get(i).getArrivalTime() <= time)
            {
                if(listCopy.get(i).getDuration() <= min)
                {
                    min = listCopy.get(i).getDuration();
                    index = i;
                    selected = listCopy.get(i);
                    selected.setSpaceCount(time);
                }
            }
        }
        listCopy.remove(index);
        return selected;
    }


}