/*  
    Title:      HRRN.java
    Name:       Dylan Kapustka (Dlk190000)
    Instructor: Professor Ozbirn
    Course:     CS 4348.001 - S21
    Date:       05/01/2021

    Description: HRRN class implements HRRN algorithm
*/

import java.util.ArrayList;

public class HRRN
{
  
    //Main algorithm
    public void mySchedule(ArrayList<myJob> list)
    {
        System.out.println("HRRN"); //Print algorithm name for graph

        //Copy list
        ArrayList<myJob> newList = new ArrayList<>();
        for(myJob job: list)
        {
            newList.add(new myJob(job));
        }

        int time = 0;
        while(!(newList.isEmpty()))
        {
            myJob selected = max(newList,time);

            //Get index
            int index = 0;
            for(int i = 0; i < list.size(); i++)
            {
                if(list.get(i).getName().equals(selected.getName()))
                {
                    index = i;
                }
            }

            list.get(index).setSpaceCount(time);
            time += selected.getDuration();
        }


        for(myJob job: list)
        {
            job.printMatrix();
        }
    }

    //Helper function to find max
    private myJob max(ArrayList<myJob> listCopy, int time)
    {
        double MinR = 0.0;
        myJob selected = null;

        //set up wait list
        ArrayList<myJob> jobWaitList = new ArrayList<>();

        for(myJob currentJob: listCopy)
        {
            if(currentJob.getArrivalTime() <= time)
            {
                jobWaitList.add(new myJob(currentJob));
            }
        }


        int waitTime;
        int serviceTime;
        for(myJob currentJob: jobWaitList)
        {
            waitTime = time - currentJob.getArrivalTime();
            serviceTime = currentJob.getDuration();
            double R = (waitTime + serviceTime)/serviceTime;
            if(R >= MinR)
            {
                selected = new myJob(currentJob);
                MinR = R;
            }
        }

       //Get index
       int index = 0;
       for(int i = 0; i < listCopy.size(); i++)
       {
           if(listCopy.get(i).getName().equals(selected.getName()))
           {
               index = i;
           }
       }

        listCopy.remove(index);
        return selected;
    }
   

    
}