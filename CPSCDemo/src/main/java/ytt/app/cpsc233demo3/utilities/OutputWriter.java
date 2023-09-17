package ytt.app.cpsc233demo3.utilities;

import ytt.app.cpsc233demo3.videoTracking.Category;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputWriter {

    /**
     * Function used to output all the stored video and category data in the program to the output.txt csv file.
     *
     */
    public static String outputFunction(ArrayList<Category> categoryArrayList,File file) {

        String status ="";
        int numCategories = 0;
        int numVideos = 0;

        try {
            FileWriter file_writer = new FileWriter(file);
            BufferedWriter buffered_writer = new BufferedWriter(file_writer);

            for (int i = 0; i < categoryArrayList.size(); i++) { // for condition to add all the categories to the output file

                numCategories += 1; // iterating on number of categories we have added to the system
                if (i != categoryArrayList.size() - 1) { // if condition for when the data point is not the last category in the program, thus adding a category
                    buffered_writer.write(categoryArrayList.get(i).getName() + ",");
                } else { // else condition for when the data point is the last category in the program, thus switching to a new line
                    buffered_writer.write(categoryArrayList.get(i).getName() + "\n");
                }
            }

            for (int i2 = 0; i2 < categoryArrayList.size(); i2++) { // for condition to add all the data point
                for (int j = 0; j < categoryArrayList.get(i2).getVideoCount(); j++) {
                    numVideos += 1;
                    if (j != categoryArrayList.get(i2).getVideoCount() - 1) { // if condition for when the data point is not the last data point in the videoarray, thus adding a comma
                        buffered_writer.write(categoryArrayList.get(i2).getContents().get(j).getName() + ",");
                        buffered_writer.write(categoryArrayList.get(i2).getContents().get(j).getVideoLength() + ",");
                    } else { // else for when the data point is the last in the videoArray, thus switching to a new line
                        buffered_writer.write(categoryArrayList.get(i2).getContents().get(j).getName() + ",");
                        buffered_writer.write(categoryArrayList.get(i2).getContents().get(j).getVideoLength() + "\n");
                    }
                }
            }
            buffered_writer.flush(); // flushing the written data in the output.txt before closing the bufferedWriter
            buffered_writer.close(); // closing the bufferedWriter


            status=("Success! " + numCategories + " categories and " + numVideos + " videos have been outputted to the output.txt file. To view the file, please exit the program in the main menu.");

        } catch (IOException e) { // catching an IOException error for
            status=("Error: Unable to access file to write to! Returning to main menu.");
        }
        return status;
    }
}
