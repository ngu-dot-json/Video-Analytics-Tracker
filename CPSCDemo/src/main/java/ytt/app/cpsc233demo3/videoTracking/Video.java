package ytt.app.cpsc233demo3.videoTracking;

import ytt.app.cpsc233demo3.MainController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CPSC 233 W22 GROUP PROJECT
 *
 * @author Jason Ngu & Brian Tran
 * Date: April 01st 2022
 * UCIDs (Jason Ngu: 30145770) & (Brian Tran: 30064686)
 * Instructor: Jonathan Hudson
 * TA: (Jason Ngu: Tejash Shrestha) & (Brian Tran: Abdelghani Guerbas)
 *
 * Description: The following is the Video.java class file used to keep the Video object information stored and accessible;
 * in addition to the specific getter and setter functions needed to add the videos to the system. Is very bare bones compared
 * to the Category.java as it is very much reliant on the Category.java class in order for the data to be used in any useful way;
 * however is still essential to the Category.java as it allows for more detailed storage of data points for specific videos in
 * OOP form for ease of use in the program.
 */


public class Video {

    private String name;
    private int length;
    private Category category;
    
    public Video(String name, int length) {
        this.name = name;
        this.length = length;
        this.category = null;
    }

    /**
     * function used to set the category of a video
     * @param category the category we wish to set the video to
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * function used to return the name of a specific video
     * @return the string value of the name of a video
     */
    public String getName(){
        return this.name;
    }

    /**
     * function used to return the video length of a specific video
     * @return the integer value of the minute length of a watched video
     */
    public int getVideoLength() {
        return this.length;
    }

    /**
     * function used to return the Category of a specific video
     * @return the specific category of a watched video
     */
    public Category getCategory(){
        return this.category;
    }

    /**
     * overrided toString function to return more accurate and specific string data
     * @return altered toString print information
     */
    @Override
    public String toString(){
        String video = this.name+": "+this.length+" min";
        return video;
    }


    /**
     * Function used to print out the string text to output to the sideMenuTextArea when the user selects the addVideo button in the main menu
     * @return the organized string value to print to the sideMenuTextArea on the GUI
     */
    public static String addVideoTextFunction(){
        int totalCategoryCount = MainController.categoryArrayList.size();
        String returnValue = ""; // initialization of the string returnValue to iterate upon and return later
        returnValue += "* ADD A NEW VIDEO *\n\n";

        returnValue += "Currently there are \"" + totalCategoryCount + "\" unique categories stored \nwithin the system.\n";

        if (totalCategoryCount > 0){ // if condition when there is at least one category in the system; printing such categories out to the user

            returnValue += "These categories are as follows: " + "\n\n";
            returnValue += Category.printTotalCategories(); // calling the category function to print out the total functions stored in the system
            returnValue += "\nIn the input box box below please input the length of \nvideo, in addition to selecting what category the video \nbelongs to.";

        } else if (totalCategoryCount == 0){ // else condition for when there does not exist any categories stored in the system
            returnValue += "\nPlease add at least one category into the system \nin order to continue!";
        }
        return returnValue; // returning the returnValue to be printed out in the subMenuTextArea
    }

    /**
     * Function used to add a video the system; taking in thte
     * @param videoName the string value of the name of the video inputted by the user
     * @param videoLength the integer value of the number of minutes of the watched video
     * @param intChosenCategory the selected category the user wishes to add the video to
     * @return a string print value to be returned to the mainController status bar on if the video ahs been successfully added in
     */
    public static String addVideoFunction(String videoName, int videoLength, int intChosenCategory) {

        Video addVideo = new Video(videoName, videoLength); // creating the new Video object using the videName and videoLength

        Category chosenCategory = MainController.categoryArrayList.get(intChosenCategory);
        String categoryString = chosenCategory.getName(); // obtaining the category to set the video to

        addVideo.setCategory(chosenCategory); // setting the video the selected category
        chosenCategory.addVideo(addVideo); // adding the video to the selected category

        return "Success! the inputted " + videoLength + " minute long video has been added to the category \"" + categoryString + "\"";
    }

}