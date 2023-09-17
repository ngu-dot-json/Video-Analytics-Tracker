package ytt.app.cpsc233demo3.videoTracking;

import ytt.app.cpsc233demo3.Main;
import ytt.app.cpsc233demo3.categoryComparators.CompareByASCII;
import ytt.app.cpsc233demo3.categoryComparators.CompareByTotalTime;
import ytt.app.cpsc233demo3.categoryComparators.CompareByTotalVideos;
import ytt.app.cpsc233demo3.MainController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * CPSC 233 W22 GROUP PROJECT
 *
 * @author Jason Ngu & Brian Tran
 * Date: April 01st 2022
 * Course: CPSC 233 W22
 * UCIDs (Jason Ngu: 30145770) & (Brian Tran: 30064686)
 * Instructor: Jonathan Hudson
 * TA: (Jason Ngu: Tejash Shrestha) & (Brian Tran: Abdelghani Guerbas)
 * <p>
 * Description: The following is the Category.java used to keep the Categoty object (and in turn, Video object) information
 * stored and accessible in addition to its specific getter, setter and calculation functions. It is called on and used throughout
 * the mainController.java in order to access all of its stored data to output to the GUI. Most of the "magic" can be found
 * within this .java, where the calculations, organization and output of the data can be found. There are two main types of
 * functions that can be found within here; both relating to another. the first is the individual calculation function for the
 * specific function that is called when the user wishes to do something (such as output the top watched category by video count).
 * This function simply returns that essential piece of data when called. Then there is the String output function that relates
 * to that function; which adds in all off the user output information to make the data much more readable and understandable.
 * <p>
 * There are also functions within that are created to simplify code; aid in Unit testing, and make the overall user
 * experience better (in addition to making the code easier to read and parse through)
 */


public class Category {

    public static ArrayList<String> allCategoriesString = new ArrayList<>();
    public static ArrayList<Category> watchedCategories = new ArrayList<Category>();
    protected static int totalWatchTime = 0;
    protected static int totalVideoCount = 0;
    protected static int totalWatchedCategoryCount = 0;
    public static Video topVideoOfAllTime = null;
    public static int numComp = 0;

    private String name;
    private ArrayList<Video> contains;
    private int videoCount;
    private int catWatchTime;
    private Video topVideo = null;
    private Boolean watched;



    /**
     * constructor for category
     * @param name o category
     */
    public Category(String name) {

        this.name = name;
        this.contains = new ArrayList<Video>();
        this.catWatchTime = 0;
        this.videoCount = 0;
        this.watched = false;
        allCategoriesString.add(this.name);
    }



    /**
     * adds a video to object adding it to watchedvideo arraylist
     * @param video
     */
    public void addVideo(Video video) {
        this.contains.add(video);
        this.catWatchTime += video.getVideoLength();
        this.videoCount += 1;

        totalWatchTime += video.getVideoLength();
        totalVideoCount += 1;

        if (!watched) {
            this.watched = true;
            totalWatchedCategoryCount += 1;
            watchedCategories.add(this);
        }

        if (topVideo == null) {
            topVideo = video;
        } else if (topVideo.getVideoLength() < video.getVideoLength()) {
            topVideo = video;
        }
        if (topVideoOfAllTime == null) {
            topVideoOfAllTime = video;
        } else if (video.getVideoLength() > topVideoOfAllTime.getVideoLength()) {
            topVideoOfAllTime = video;
        }
    }

    /**
     * gives access to a copy of the videos
     * @return copy of videos in category
     */
    public ArrayList<Video> getContents() {
        ArrayList<Video> contents = new ArrayList<>();

        for (Video video : this.contains) {
            contents.add(video);
        }
        return contents;
    }

    /**
     * string representation of a category
     * @return name of category and displays the contents(videos inside of category)
     */
    @Override
    public String toString() {
        String catString = this.name;
        catString+="{";
        for(int vidNum =0;vidNum<this.contains.size();vidNum++){
            catString+=this.contains.get(vidNum).toString();
            if(vidNum!=this.contains.size()-1){
                catString+=", ";
            }
        }
        catString+="}";
        return catString;
    }

    /**
     * class function used to return the total watched videos in for the specific category in question
     *
     * @return the integer value of how many videos have been watched for the specific category
     */
    public int getVideoCount() {
        return this.videoCount;
    }

    /**
     * class function used to return the total watch time for the videos in the specific category in question
     *
     * @return the integer value of how many minutes have been watched for the specific category
     */
    public int getCatWatchTime() {
        return this.catWatchTime;
    }

    /**
     * class function used to return the string value of the name for the specific category in question
     *
     * @return the string value for the name of the specific category
     */
    public String getName() {
        return this.name;
    }

    /**
     * function used to return the total watch time for all categories stored in the system combined
     *
     * @return the int value of the total watch time in minutes
     */
    public static int getTotalWatchTime() {
        return totalWatchTime;
    }

    /**
     * function used to return the total videos watched for all categories stored in the system combined
     *
     * @return the int value of the total video count
     */
    public static int getTotalVideoCount() {
        return totalVideoCount;
    }

    /**
     * function used to return the total number of categories stored in the system
     *
     * @return the integer value of the total number of categories
     */
    public static int getTotalCategoryCount() {
        return MainController.categoryArrayList.size();
    }

    /**
     * function used to return the total number of watched categories stored in the system
     *
     * @return the integer value of the total number of watched categories
     */
    public static int getTotalWatchedCategoryCount() {
        return totalWatchedCategoryCount;
    }

    /**
     * function used to return the video with the longest video length stored in the system
     *
     * @return the specific video object that has the longest watch time
     */
    public static Video getTopVideoOfAllTime() {
        return topVideoOfAllTime;
    }

    /**
     * function created to be used in code testing in order to clear the system of any stored data that may interfere
     * in JUnit testing; resetting all tracked data points back to their original values.
     */
    public static void testingConditionStart() {

        allCategoriesString = new ArrayList<>();
        watchedCategories = new ArrayList<Category>();
        totalWatchTime = 0;
        totalVideoCount = 0;
        totalWatchedCategoryCount = 0;
        topVideoOfAllTime = null;
    }

    /**
     * function used to return the category that has the most watch time of them all
     *
     * @return the category with the most total watch time
     */
    public static Category topCategoryWatchTime() {

        Collections.sort(watchedCategories, new CompareByTotalTime());
        Category returnCategory = watchedCategories.get(0);
        return returnCategory; // returning the returnCategory to be used in another function
    }

    /**
     * function used to return the category that has the highest number of individual videos stored inside
     *
     * @return the category with the most videos stored inside
     */
    public static Category topCategoryVideoCount() {

        Collections.sort(watchedCategories, new CompareByTotalVideos());
        Category returnCategory = watchedCategories.get(0);
        return returnCategory; // returning the returnCategory to be used in another function
    }

    /**
     * Function used to return the top5 categories based on video watch time
     *
     * @return a category array containing the top 5 categories by watch time
     */
    public static Category[] top5WatchTime() {

        int arraySize = 1;

        if (totalWatchedCategoryCount > 0) {
            if (totalWatchedCategoryCount > 5) {

                arraySize = 5;
                numComp = 5;

            } else {
                arraySize = totalWatchedCategoryCount;
                numComp = totalWatchedCategoryCount;
            }
        }

        Category[] top5Array = new Category[arraySize];

        Collections.sort(watchedCategories, new CompareByTotalTime());


        for (int i = 0; i < numComp; i++) {
            top5Array[i] = watchedCategories.get(i);
        }

        return top5Array;
    }

    /**
     * Function used to return the top5 categories based on video count
     *
     * @return a category array containing the top 5 categories by video count
     */
    public static Category[] top5VideoCount() {

        int arraySize = 1;

        if (totalWatchedCategoryCount > 0) {
            if (totalWatchedCategoryCount > 5) {

                arraySize = 5;
                numComp = 5;

            } else {
                arraySize = totalWatchedCategoryCount;
                numComp = totalWatchedCategoryCount;
            }
        }

        Category[] top5Array = new Category[arraySize];

        Collections.sort(watchedCategories, new CompareByTotalVideos());

        for (int i = 0; i < numComp; i++) {
            top5Array[i] = watchedCategories.get(i);
        }

        return top5Array;
    }

    /**
     * repeatedly used function to print out all the categories stored in the system in an organized way for the GUI
     *
     * @return an organized string of all the categories in the system
     */
    public static String printTotalCategories() {

        String returnString = ""; // creation of returnString string to be returned later
        int totalCategoryCount = getTotalCategoryCount();
        for (int i = 0; i < totalCategoryCount; i++) { //for loop, looping through all the stored categories, to add them into the returnString
            returnString += "\"" + allCategoriesString.get(i) + "\"\n";
        }
        return returnString; // returning the returnString to be used in other functions
    }

    /**
     * repeatedly used function to print out all the watched categories stored in the system in an organized way for the GUI
     *
     * @return an organized string of all the watched categories in the system
     */
    public static String printWatchedCategories() {

        String returnString = ""; // creation of returnString string to be returned later

        Collections.sort(watchedCategories, new CompareByASCII());

        for (int i = 0; i < totalWatchedCategoryCount; i++) { // for-loop looping through all the watched categories, to add them into the returnString
            returnString += "\"" + watchedCategories.get(i).getName() + "\"\n";
        }
        return returnString; // returning the returnString to be used in other functions
    }

    /**
     * function used to print out commonly reused code in the program; all packaged in one function in order to save space
     * and clean up the code. specifically prints out the number and list of categories stored in the system, in addition
     * to the number and list of watched categories in the system
     *
     * @return an organized string value to return to the function using it to add to its returnString
     */
    public static String commonCategoryOutput() {

        String returnString = ""; // creation of returnString string to be returned later
        int totalCategoryCount = getTotalCategoryCount();
        if (totalCategoryCount == 0) { // if condition for when there are no categories in the system to output
            returnString += "There are currently 0 categories in the system! \nPlease add a category for more print information!";

        } else { // else condition for when there exists at least one category in the system
            returnString += "Currently there are: " + totalCategoryCount + " unique categories stored within the system.\n";
            returnString += "These categories are as follows: \n\n";
            returnString += printTotalCategories(); // calling the function to print out all the stored categories in the system

            if (totalWatchedCategoryCount == 0) { // if condition for when there does not exist any watched categories in the system
                returnString += "\nNone of these categories, however, have any watched video information \nstored inside!";

            } else if (totalCategoryCount > totalWatchedCategoryCount) { // else if there contains at least one watched category; but there is at least one category that does not contain a watched video
                returnString += "\nOf these " + totalCategoryCount + ", " + totalWatchedCategoryCount + " have stored videos inside. \nThese categories are as follows:\n\n";
                returnString += printWatchedCategories(); // calling the function to print out all the watched categories in the system

            } else { // else condition for when all categories in the system contain at least one video inside
                returnString += "\nAll of these categories have at least one unique video stored inside!";
            }

        }
        return returnString; // returning the returnString to the main function
    }

    /**
     * function that returns the necessary information to the controller to add to the mainText textArea; specifically for
     * when the user presses the "Add a new category".
     *
     * @return an organized string value to set as the mainText textArea in the GUI
     */
    public static String addCategoryTextFunction() {

        String returnValue = ""; // creation of returnValue string to be returned later

        returnValue += "* INPUT: ADD A NEW VIDEO CATEGORY *\n\n";
        int totalCategoryCount = getTotalCategoryCount();
        returnValue += "Currently there are: \"" + totalCategoryCount + "\" unique categories stored \nwithin the system.\n";

        if (totalCategoryCount > 0) { // if condition for when the system has more than one function stored inside; listing them out for the user to know
            returnValue += "These categories are as follows: \n\n";
            returnValue += printTotalCategories(); // calling the function to print out all the stored categories
        }

        returnValue += "\nIn the text box below; please enter the new \ncategory you wish to add to the system \n(case sensitive).";

        return returnValue; // returning the returnValue to be printed in the mainTextArea in the GUI
    }

    /**
     * function called when the user presses the "add category" button in the sub menu to add an inputted string by the user as a new
     * category (if the input is valid and is not already in the system
     *
     * @param inputCategory the string inputted in the textArea by the user in the sub menu
     * @return a returnString value to be put into the statusBar in the bottom of the program informing them if the category has been
     * added in successfully or not
     */
    public static String addCategoryFunction(String inputCategory) {
        String returnValue = ""; // creation of returnValue string to be returned later

        if (allCategoriesString.contains(inputCategory)) { // if condition for when the category already exists in the system; thus not adding it again
            returnValue = "Error: The inputted category already exists within the system, and thus has not been added. Please try again.";

        } else if (inputCategory.length() == 0) { // else if for when there has been no category added in the system
            returnValue = "Error: No user input has been detected, and thus no new category has been added.";

        } else { // else condition adding the new category name into the system

            MainController.categoryArrayList.add(new Category(inputCategory));

            returnValue = "The new category \"" + inputCategory + "\" has been added successfully to the list of categories!.";
        }

        return returnValue; // returning the string for print out in the status bar
    }

    /**
     * function used to create the string output for the mainTextArea for when the user selects the longest watched video button in the GUI.
     *
     * @return a string value to be printed out in the mainTextArea in the GUI
     */
    public static String longestVideoFunction() {
        String returnValue = "";// initialization of returnValue to be iterated upon below

        returnValue += "* OUTPUT: LONGEST WATCHED VIDEO *\n\n";

        if (topVideoOfAllTime == null) { // if condition for when there are no videos in the system
            returnValue += "There are currently no videos stored in the program! Please add at least \none video into the system and try again!";

        } else { // else condition for when there exists at least one video in the system
            returnValue += "Of all inputted values in the system; the longest video watched by the user \nwas \"" + topVideoOfAllTime.getName() + "\" which was " + topVideoOfAllTime.getVideoLength() + " minute(s) long!";
        }

        return returnValue; // returning the returnValue to the main function to be added to the GUI
    }

    /**
     * function used to create the string output for the mainTextArea for when the user selects the total watch time button in the GUI.
     *
     * @return a string value to be printed out in the mainTextArea in the GUI
     */
    public static String totalWatchTimeFunction() {

        String returnValue = "";// initialization of returnValue to be iterated upon below

        returnValue += "* OUTPUT: TOTAL WATCH TIME *\n\n";
        returnValue += "Of all inputted values in the system; \nthe user has watched a total " + totalWatchTime + " minute(s) of content!";

        return returnValue; // returning the returnValue to the main function to be added to the GUI
    }

    /**
     * function used to create the string output for the mainTextArea for when the user selects the total videos function in the GUI
     *
     * @return an organized string value to be printed out to the mainTextArea in the GUI
     */
    public static String totalVideosFunction() {

        String returnValue = "";// initialization of returnValue to be iterated upon below

        returnValue += "* OUTPUT: TOTAL NUMBER OF VIDEOS WATCHED *\n\n";
        returnValue += "Of all inputted values in the system; \nthe user has watched a total of " + totalVideoCount + " video(s)!";

        return returnValue; // returning the returnValue to the main function to be added to the GUI
    }

    /**
     * function used to create the text print out for the first step of the watch time for a specific category function; informing the user
     * what it is they are to do in order to continue on with what they wish to do
     *
     * @return the string value to be printed out the sideMenuTextArea
     */
    public static String specificWatchTimeTextFunction() {

        String returnValue = ""; // initialization of returnValue to be iterated upon and returned later
        returnValue += "* TOTAL WATCH TIME FOR A SPECIFIC CATEGORY *\n\n";
        int totalCategoryCount = getTotalCategoryCount();
        if (totalCategoryCount == 0) {
            returnValue += "There are currently 0 categories in the system! \nPlease add a category for more print information!";

        } else {
            returnValue += "Currently there are: " + totalCategoryCount + " unique categories stored \nwithin the system.";
            returnValue += "These categories are as follows: " + "\n\n";
            returnValue += printTotalCategories(); // calling the function to print out the total stored categories in the system
        }
        returnValue += "\nPlease input the integer for the category \nthat you wish to get it's total watch time.\n";

        return returnValue; // returning the returnValue to be printed out in the sideMenuTextArea

    }

    /**
     * Function used to create the string value of the total watch time for a specific category to be returned to the mainTextArea in the GUI
     *
     * @param inputCategory the integer value of the specific category that the user wishes to check the watch time of
     * @return the string value to be printed out in the GUI in the mainTextArea
     */
    public static String specificWatchTimeFunction(int inputCategory) {

        String returnValue = ""; // initialization of returnValue to be iterated upon and returned later
        returnValue += "* OUTPUT: WATCH TIME FOR SPECIFIC CATEGORY *\n\n";
        returnValue += "For the selected category, the user has consumed " + MainController.categoryArrayList.get(inputCategory).getCatWatchTime() + " minute(s) of content!";

        return returnValue; // returning the returnValue to be printed out in the mainTextArea

    }

    /**
     * function used to create a string value for print out to the mainMenuTextArea for when the user selects the top category watch time function
     *
     * @return an organized string value to add to the mainMenuTextArea to show on the GUI
     */
    public static String topCategoryWatchTimeFunction() {

        String returnString = ""; // initialization of returnValue to be iterated upon and returned later

        returnString += "* OUTPUT: TOP CATEGORY BY WATCH TIME *\n\n";
        returnString += commonCategoryOutput(); // calling the common output function to print out the stored categories and watched categories

        if (totalWatchedCategoryCount > 0) { // if condition for when there exists more than one watched category in the system; thus allowing the function to run
            returnString += "\nOf these, your most watched category by watch time is: \n\"" + topCategoryWatchTime().getName() + "\" with " + topCategoryWatchTime().getCatWatchTime() + " minute(s) watched!";
        }

        return returnString; // returning the returnValue to be printed out in the mainTextArea
    }

    /**
     * function used to create a string value for print out to the mainMenuTextArea for when the user selects the top category video count function
     *
     * @return an organized string value to add to the mainMenuTextArea to show on the GUI
     */
    public static String topCategoryVideoCountFunction() {

        String returnString = ""; // initialization of returnValue to be iterated upon and returned later

        returnString += "* OUTPUT: TOP CATEGORY BY VIDEO COUNT *\n\n";
        returnString += commonCategoryOutput(); // calling the common output function to print out the stored categories and watched categories

        if (totalWatchedCategoryCount > 0) { // if condition for when there exists more than one watched category in the system; thus allowing the function to run
            returnString += "\nOf these, your most watched category by video count is: \n\"" + topCategoryVideoCount().getName() + "\" with " + topCategoryVideoCount().getVideoCount() + " video(s) watched!";
        }

        return returnString; // returning the returnValue to be printed out in the mainTextArea
    }

    /**
     * function used to print out the main menu string information about the top 5 categories for watch time
     *
     * @return the string output to be printed to the mainTextArea
     */
    public static String top5WatchTimeFunction() {
        String mainMenuText = " * OUTPUT: TOP 5 CATEGORIES BY WATCH TIME *\n\n";
        int totalCategoryCount = getTotalCategoryCount();
        int catCount = MainController.categoryArrayList.size();
        if (catCount == 0) { // if condition for when there are no categories in the system to choose form
            mainMenuText += "There are currently 0 categories in the system! \nPlease add a category for more print information!";

        } else {
            mainMenuText += "Currently there are: " + totalCategoryCount + " unique categories stored within the system.\n";
            mainMenuText += "These categories are as follows: " + "\n\n";
            mainMenuText += printTotalCategories(); // calling the function to print out the total stored categories in the system

            if (totalWatchedCategoryCount == 0) { // if condition for when there does not exist any watched categories in the system
                mainMenuText += "\nNone of these categories, however, have any watched video information \nstored inside!";

            } else if (totalCategoryCount > totalWatchedCategoryCount) { // else if there contains at least one watched category; but there is at least one category that does not contain a watched video
                mainMenuText += "\nOf these " + totalCategoryCount + ", " + totalWatchedCategoryCount + " have stored videos inside. \nThese categories are as follows:\n\n";
                mainMenuText += printWatchedCategories(); // calling the function to print out all the watched categories in the system

            } else { // else condition for when all categories in the system contain at least one video inside
                mainMenuText += "\nAll of these categories have at least one unique video stored inside!";
            }

            if (totalWatchedCategoryCount >= 5) {
                mainMenuText += "\nThese categories; sorted in the Top 5 most watched in terms of watch time\nare as follows: \n";
            }
            if (totalWatchedCategoryCount < 5) {
                mainMenuText += "\nSince there are not at least 5 categories with stored data information; \nwe cannot proceed with the Top 5 watched categories by watch time.\n";
                if (totalWatchedCategoryCount > 0) {
                    mainMenuText += "\nHowever, we can still sort these categories in a Top " + totalWatchedCategoryCount + ", \nwith such being as follows: \n";
                } else if (totalWatchedCategoryCount == 0) {
                    mainMenuText += "As such, no possible alternative can be printed out!";
                }
            }
            if (totalWatchedCategoryCount > 0) {
                mainMenuText += top5WatchtimeString();
            }
        }
        return mainMenuText;
    }

    /**
     * @return string value of categories in place
     */
    public static String top5WatchtimeString() {
        String returnString = "";
        Category[] top5Array = top5WatchTime();
        for (int place = 0; place < numComp; place++) {
            int addValue = place + 1;
            returnString += "\n" + addValue + " | " + top5Array[place].getName() + " with " + top5Array[place].getCatWatchTime() + " minute(s)";
        }
        return returnString;
    }

    /**
     * returns context text and places the categories in a top5 list
     *
     * @return
     */
    public static String top5VideoCountFunction() {
        String mainMenuText = "* OUTPUT: TOP 5 CATEGORIES BY VIDEO COUNT *\n\n";
        int catCount = MainController.categoryArrayList.size();
        if (catCount == 0) { // if condition for when there are no categories in the system to choose form
            mainMenuText += "There are currently 0 categories in the system! \nPlease add a category for more print information!";

        } else {
            mainMenuText += "Currently there are: " + catCount + " unique categories stored within the system.\n";
            mainMenuText += "These categories are as follows: " + "\n\n";
            mainMenuText += printTotalCategories(); // calling the function to print out the total stored categories in the system

            if (totalWatchedCategoryCount == 0) { // if condition for when there does not exist any watched categories in the system
                mainMenuText += "\nNone of these categories, however, have any watched video information \nstored inside!";

            } else if (catCount > totalWatchedCategoryCount) { // else if there contains at least one watched category; but there is at least one category that does not contain a watched video
                mainMenuText += "\nOf these " + catCount + ", " + totalWatchedCategoryCount + " have stored videos inside. \nThese categories are as follows:\n\n";
                mainMenuText += printWatchedCategories(); // calling the function to print out all the watched categories in the system

            } else { // else condition for when all categories in the system contain at least one video inside
                mainMenuText += "\nAll of these categories have at least one unique video stored inside!\n";
            }

            if (totalWatchedCategoryCount >= 5) {
                mainMenuText += "\nThese categories; sorted in the Top 5 most watched in terms of video count\nare as follows: \n";
            }
            if (totalWatchedCategoryCount < 5) {
                mainMenuText += "\nSince there are not at least 5 categories with stored data information; \nwe cannot proceed with the Top 5 Most Watched Categories by Video Count.\n";
                if (totalWatchedCategoryCount > 0) {
                    mainMenuText += "\nHowever, we can still sort these categories in a Top " + totalWatchedCategoryCount + ", \nwith such being as follows: \n";
                } else if (totalWatchedCategoryCount == 0) {
                    mainMenuText += "\nAs such, no possible alternative can be printed out!";
                }
            }
            if (totalWatchedCategoryCount > 0) {
                mainMenuText += top5VideoCountString();

            }

        }
        return mainMenuText;
    }

    /**
     * @return string place list of categories out of watched categories
     */
    public static String top5VideoCountString() {
        String returnString = "";

        Category[] top5Array = top5VideoCount();
        for (int place = 0; place < numComp; place++) {
            int addValue = place + 1;
            returnString += "\n" + addValue + " | " + top5Array[place].getName() + " with " + top5Array[place].getVideoCount() + " videos";
        }
        return returnString;
    }

    /**
     * function used to create a returnString to be printed out to the mainTextArea of the GUI for when the user selects the List of Categories button
     *
     * @return the organized string value to be returned and printed to the mainTextArea of the GUI
     */
    public static String numListCatFunction() {

        String returnString = "* NUMBER AND LIST OF STORED CATEGORIES *\n\n"; // creation of the returnString value
        returnString += commonCategoryOutput(); // calling the common print function to print the number and list of stored and watched categories in the system

        return returnString; // returning the returnString to be printed to the mainTextArea of the GUI
    }

    /**
     * function used to create a string value to return to the GUI that runs through all the possible data outputs at once for the user
     * in addition to the printout of the way the data is stored without being restricted and printed out in an organized way
     *
     * @return an organized string value that contains all other function data print outs
     */
    public static String printAllFunction() {
        String mainMenuText = "* OUTPUT: PRINT ALL *\n";

        mainMenuText += totalWatchTimeFunction();
        mainMenuText += "\n" + totalVideosFunction() + "\n";
        mainMenuText += "\n" + longestVideoFunction() + "\n";
        mainMenuText += "\n" + top5WatchTimeFunction() + "\n";
        mainMenuText += "\n" + top5VideoCountFunction() + "\n";
        mainMenuText += "\n" + topCategoryWatchTimeFunction() + "\n";
        mainMenuText += "\n" + topCategoryVideoCountFunction() + "\n";

        mainMenuText += "\n* UNALTERED DATA *\n\n";

        mainMenuText += "Unrestricted and altered; our arrayList containing all the\ncategories and its videos looks like the following: \n\n";

        mainMenuText += MainController.categoryArrayList;

        mainMenuText += "\n\nIn addition; our arrayList containing all the\nwatched categories and its videos looks like the following: \n\n";

        mainMenuText += watchedCategories;

        return mainMenuText;
    }
}