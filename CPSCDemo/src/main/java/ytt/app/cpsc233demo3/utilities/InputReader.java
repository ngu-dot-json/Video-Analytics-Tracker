package ytt.app.cpsc233demo3.utilities;

import ytt.app.cpsc233demo3.MainController;
import ytt.app.cpsc233demo3.videoTracking.Category;
import ytt.app.cpsc233demo3.videoTracking.Video;

import java.io.*;
import java.util.ArrayList;

public class InputReader {
    // function used to read the input file and extract its data
    public static String readInput(ArrayList<Category> categoryArrayList, File inputFile) {
        String returnValue ="";
        try {
            FileReader file_reader = new FileReader(inputFile); // creation of a fileReader
            BufferedReader buffered_reader = new BufferedReader(file_reader); // creation of a bufferedReader from the fileReader

            String inputCategories = buffered_reader.readLine();

            if (inputCategories != null) { // if condition for when the input file does indeed have data inside to extract data

                String[] inputCatSplit = inputCategories.split(",");
                int numInputCategories = inputCatSplit.length;
                int numVideos = 0;

                for (int i = 0; i < numInputCategories; i++) { // for loop to add all the stored categories into the program
                    categoryArrayList.add(new Category(inputCatSplit[i]));

                    String inputVideos = buffered_reader.readLine();
                    if (inputVideos != null) { // if condition for when there are video data points to input into the program
                        String[] inputVideosSplit = inputVideos.split(",");

                        for (int j = 0; j < inputVideosSplit.length-1; j++) { // for loop inputting video data into program
                            String videoName = inputVideosSplit[j];
                            int intVideoLength = Integer.parseInt(inputVideosSplit[j+1]);
                            categoryArrayList.get(i).addVideo(new Video(videoName,intVideoLength));
                            numVideos += 1;
                            j+=1;
                        }
                    }
                }
                returnValue=("Success! " + numInputCategories + " categories, and " + numVideos + " videos have been imported into the program! Continuing to main menu.");
            } else { // else condition for when there is no data in program
                returnValue=("Error: The inputted .csv file \"" + inputFile + "\" does not contain any data! Continuing to main menu without any data import.");
            }

        } catch (FileNotFoundException e) { // catching error when inputted file does not exist
            returnValue=("Error: The inputted .csv file \"" + inputFile + "\" does not exist! Continuing to main menu without any data import.");

        } catch (IOException e) { // catching error when the inputted file does not contain readable information
            returnValue=("Error: The inputted .csv file \"" + inputFile + "\" cannot be parsed! Continuing to main menu without data import.");
        }

        return returnValue;
    }
}
