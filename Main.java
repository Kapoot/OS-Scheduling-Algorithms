/*  
    Title:      Main.java
    Name:       Dylan Kapustka (Dlk190000)
    Instructor: Professor Ozbirn
    Course:     CS 4348.001 - S21
    Date:       05/01/2021

    Description: Main class handles reading and parsing input file. Creates a new instance of each algorithm
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){

        //Check arguments
        if (args.length != 1) {
            System.out.println("Error Incorrect Arguments");
            System.exit(0);
        }

        //Declare job variables
        ArrayList<myJob> jobList = new ArrayList<>();
        String currJob;

        //Read file
        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //Parse file and add jobs to job list
            while((currJob = bufferedReader.readLine()) != null)
            {
                String[] parseLine = currJob.split("\t",3);
                jobList.add(new myJob(parseLine[0], Integer.parseInt(parseLine[1]), Integer.parseInt(parseLine[2])));
            }
        }
        //Error handling
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to open file");
        }
        catch (IOException e)
        {
            System.out.println("Error reading file");
        }

        //Create new instance of each scheduling algorithm, passing in job list
        FCFS FCFS_scheduler = new FCFS();
        FCFS_scheduler.mySchedule(jobList);

        SPN SPN_scheduler = new SPN();
        SPN_scheduler.mySchedule(jobList);

        HRRN HRRN_scheduler = new HRRN();
        HRRN_scheduler.mySchedule(jobList);

    }
}