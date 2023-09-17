package ytt.app.cpsc233demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import ytt.app.cpsc233demo3.utilities.InputReader;
import ytt.app.cpsc233demo3.utilities.OutputWriter;
import ytt.app.cpsc233demo3.videoTracking.Category;
import ytt.app.cpsc233demo3.videoTracking.Video;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * CPSC 233 W22 GROUP PROJECT
 *
 * @author Jason Ngu & Brian Tran
 * Date: April 15th 2022
 * Course: CPSC 233 W22
 * UCIDs (Jason Ngu: 30145770) & (Brian Tran: 30064686)
 * Instructor: Jonathan Hudson
 * TA: (Jason Ngu: Tejash Shrestha) & (Brian Tran: Abdelghani Guerbas)
 *
 * Description: the following is the mainCotrnoller.java used to control the FXML and Scenebuilder GUI elements
 * from the Main.fxml file in the code. Is the meat and potatoes and allows for the entire GUI to work (for all the menu
 * output selection options; user input options; help information options and more)
 */


public class MainController {

    int DISABLE_ALL = 0;
    int ADD_CATEGORY = 1;
    int ADD_VIDEO = 2;
    int SELECT_CATEGORY = 3;
    int catCount = 0;
    public static ArrayList<Category> categoryArrayList = new ArrayList<>();
    public static String[] args;

    int videoCategory;
    Boolean launchCode = false;
    Boolean chooseVideoCategory = false;
    Boolean chooseSpecificCategory = false;
    Boolean loadCategories = true;

    @FXML
    private TextField videoNameTF;

    @FXML
    private TextField videoLengthTF;

    @FXML
    private ComboBox<String> addVideoCategoryCB;

    @FXML
    private ComboBox<String> watchTimeCB;

    @FXML
    private Label leftStatus;

    @FXML
    private TextArea mainTextArea;

    @FXML
    private TextField categoryNameTF;

    @FXML
    private Button subAddCategoryButton;

    @FXML
    private Button subAddVideoButton;

    @FXML
    private Button subCheckWatchtimeButton;

    @FXML
    private TextArea subTextArea;

    void statusSuccess(String string){
        leftStatus.setTextFill(Color.GREEN);
        leftStatus.setText(string);
    }

    void statusFail(String string){
        leftStatus.setTextFill(Color.RED);
        leftStatus.setText(string);
    }

    /**
     * function used to add the read file categories into the menu drop downs on the right hand side
     */
    @FXML
    void loadCategoryFunction(){
        if (loadCategories == true){
            loadCategories = false;
            if (watchTimeCB.getItems().size() == 0){
                for (int i = 0; i < categoryArrayList.size(); i++){
                    watchTimeCB.getItems().add(categoryArrayList.get(i).getName());
                    addVideoCategoryCB.getItems().add(categoryArrayList.get(i).getName());
                }
            }
        }
    }


    public static String launchArgs(){
        String status = "";
        if(args.length ==1){
            File inputFile = new File(args[0]);
            InputReader.readInput(MainController.categoryArrayList, inputFile);
            status = "file loaded";
        } else if (args.length > 1){
            status ="Error! Too many arguments inputted. Continuing to the main program without data import.";
        } else {
            status="No args inputted. Continuing to the main program without data input.";
        }
        return status;
    }

    // *** file functions ***


    /**
     * saves categories and video's as a file .CSV file that can be loaded in later
     * @param click
     * @throws IOException
     */
    @FXML
    void saveFileChooser(ActionEvent click) throws IOException {
        FileChooser fc = new FileChooser(); // choose a file
        FileChooser.ExtensionFilter filetype = new FileChooser.ExtensionFilter("Coma separated value file","*.csv"); // default save .CSV
        fc.getExtensionFilters().add(filetype);
        fc.setInitialFileName("my_ytt_data"); // default file name
        File file = fc.showSaveDialog(null);
        if(file != null){
            OutputWriter.outputFunction(categoryArrayList, file); //  uses output writer to save
            statusSuccess(file.getName() + " saved successfully!");
        }
    }

    /**
     * loads in categories and videos from a .CSV file
     * @param click
     */
    @FXML
    void loadFile(ActionEvent click){
        Alert loadWarning = new Alert(Alert.AlertType.WARNING, """
                are you sure you want to load these settings?
                doing so will overwrite the current categories and videos
                """,ButtonType.OK,ButtonType.CANCEL );

        FileChooser fc = new FileChooser(); // choose file to load from
        File selectedFile = fc.showOpenDialog(null);
        Optional<ButtonType> result = loadWarning.showAndWait();
        if(result.get() == ButtonType.OK) {
            Category.watchedCategories.clear();
            Category.allCategoriesString.clear();
            categoryArrayList.clear();
            watchTimeCB.getItems().clear();
            addVideoCategoryCB.getItems().clear();
            if (selectedFile != null) {
                if (selectedFile.toString().endsWith(".csv")) { // only accepts .csv files
                    InputReader.readInput(categoryArrayList, selectedFile);
                    for (int i = 0; i < categoryArrayList.size(); i++) {
                        watchTimeCB.getItems().add(categoryArrayList.get(i).getName());
                        addVideoCategoryCB.getItems().add(categoryArrayList.get(i).getName());
                    }
                    mainTextArea.setText(categoryArrayList.size() + " categories loaded successfully!");
                    statusSuccess(selectedFile.getName() + " was successfully loaded in!");
                } else {
                    statusFail(selectedFile.getName() + " is an invalid File type please load in a .csv file");
                }
            }
        }
    }


    /**
     * Simple FXMl to exit the program when the user presses the "EXIT" button in file
     */
    @FXML
    void menuQuitAction() {
        System.exit(0); // exiting the program without returning an error
    }

    /**
     * FXML called when the About YTT is pressed on in the Help menu in the top, informing the user about the code,
     * its version, creators and all of those goodies youd expect to see
     */
    @FXML
    void menuAboutAction() {
        Alert aboutMenu = new Alert(Alert.AlertType.INFORMATION, """
                CPSC 233 W22 Group Project:
                Youtube Video Tracker V1.0
                            
                By: Jason Ngu & Brian Tran
                UCIDs: 30145770 & 30064686
                Course: CPSC 233 W22 L02
                Instructor: Jonathan Hudson
                TAs: Tejash Shrestha (T09) & Abdelghani Guerbas (T02)
                            
                This is GUI java software used to track the users watched YouTube videos.
                """); // creation of a new information alert to be shown, showing all the required info
        aboutMenu.show(); // showing the above created alert
    }

    /**
     * Function used to enable and or disable the three sub menus on the right
     * @param enableChoice the specific sub menu that we wish to enable
     */
    @FXML
    void subMenuEnablerDisabler(int enableChoice){

        //  disabling the sub text area
        subTextArea.setDisable(true);

        // disabling all the GUI elements for add category
        categoryNameTF.setDisable(true);

        subAddCategoryButton.setDisable(true);

        // disabling all the GUI elements for add video
        videoLengthTF.setDisable(true);
        videoNameTF.setDisable(true);
        subAddVideoButton.setDisable(true);
        addVideoCategoryCB.setDisable(true);

        // disabling all the GUI elements for watch time for a specific category
        watchTimeCB.setDisable(true);
        subCheckWatchtimeButton.setDisable(true);

        if (enableChoice == ADD_CATEGORY){ // if condition to re-enable the add category code and the subTextArea
            subTextArea.setDisable(false);
            categoryNameTF.setDisable(false);
            subAddCategoryButton.setDisable(false);

        } else if (enableChoice == ADD_VIDEO) { // else if condition to re-enable the add video code and the subText area
            subTextArea.setDisable(false);
            videoNameTF.setDisable(false);
            videoLengthTF.setDisable(false);
            subAddVideoButton.setDisable(false);
            addVideoCategoryCB.setDisable(false);

        } else if (enableChoice == SELECT_CATEGORY) { // else if condition to re-enable the select category code and subtext area
            subTextArea.setDisable(false);
            subCheckWatchtimeButton.setDisable(false);
            watchTimeCB.setDisable(false);
        }
    }

    /**
     * FXML function used to clear both output menus; called on every function beforehand to clean up the GUI for
     * greater usability
     */
    @FXML
    void clearMenuBoards(){
        mainTextArea.setText(""); // clearing the main output board
        subTextArea.setText(""); // clearing the sub output board
        subMenuEnablerDisabler(DISABLE_ALL); // calling the function to disable all the side input values
    }

    /**
     * FXML called when the add category button is pressed, in order to enable the required subMenus and print the required
     * sub menu text for the user to continue and actually add a new category into the system
     */
    @FXML
    void setAddCategoryButtonOnClick(){
        clearMenuBoards(); // clearing all previous printouts and enabling to for ease of use
        subMenuEnablerDisabler(ADD_CATEGORY); // calling the function to enable the add category button and textArea
        String sideMenuString = Category.addCategoryTextFunction(); // obtaining the string to print out about adding a category to the system
        subTextArea.setText(sideMenuString); // printing the string to the subMenu on the side for the user to see
    }

    /**
     * FXML called when the user presses the submenu add category function; taking in the inputted string by the user
     * to check it and then add to the system
     */
    @FXML
    void setSubAddCategoryButtonOnClick(){

        clearMenuBoards(); // clearing all previous printouts and enablings to for ease of use
        String statusString = ""; // creation of statusString for later use

        String inputCategory = categoryNameTF.getText(); // getting the inputCategory by the user to add to the system
        statusString += Category.addCategoryFunction(inputCategory); // adding the inputCategory to the system
        if(statusString.startsWith("E")){
            statusFail(statusString); // printing out the status update on whether the added category was successful or not
        }
        else {
            statusSuccess(statusString);
        }

        if (statusString.charAt(0) != "E".charAt(0)){ // if condition for when the category add was successful
            catCount += 1; // adding to the catCount value for use below
            addVideoCategoryCB.getItems().add(inputCategory);
            watchTimeCB.getItems().add(inputCategory);
        }
    }

    /**
     * FXML for enabling the subMenu inputs for the user to use when they select the Add new video button
     */
    @FXML
    void setAddNewVideoButtonOnClick(){
        clearMenuBoards(); // clearing all previous printouts and enablings to for ease of use
        String sideMenuString = ""; // creation of sideMenuString to be used later
        subMenuEnablerDisabler(ADD_VIDEO); // calling the function to enable the addVideo subMenu buttons
        sideMenuString = Video.addVideoTextFunction(); // obtaining print information to print to the side menu
        subTextArea.setText(sideMenuString); // updating the subTextArea with the print information about the add video function
    }



    /**
     * FXML for adding a new video length to a specific category inputted; can only be accessed when the main Add Watched
     * Video button has been clicked and selected; thus enabling the buttons of this to be iterated on (this code is called
     * when the sub addVideo button in the subInput menu is pressed)
     */
    @FXML
    void setSubAddVideoButtonOnClick() {

        String statusString = ""; // initialization of statusString to be used later


        if (videoNameTF.getText().length() > 0) {
            String videoName = videoNameTF.getText();

            try { // try block to see if the inputted value for the video length can be parsed as an integer
                int inputVideoLength = Integer.parseInt(videoLengthTF.getText()); // parsing an integer
                if (addVideoCategoryCB.getValue()!="") { // if condition checking if there has been a category selected from the dropDown yet
                    for(int i =0;i<MainController.categoryArrayList.size();i++) {
                        if(MainController.categoryArrayList.get(i).getName().equals(addVideoCategoryCB.getValue())) {
                            videoCategory = i;
                        }
                    }
                    statusString += Video.addVideoFunction(videoName, inputVideoLength, videoCategory); // adding the video length to the selected category
                    subMenuEnablerDisabler(DISABLE_ALL);

                }
                else { // else condition for when there has not been a category selected for the video to be added to
                    statusString += "Error: No input category has been selected!"; // setting the leftStatus text to reflect the error
                    chooseVideoCategory = false; // disabling the boolean of having selected a category
                    leftStatus.setTextFill(Color.RED);
                }
                leftStatus.setText(statusString);

            } catch (NumberFormatException e) {
                statusString += "Error: The inputted video length cannot be parsed as an integer!";
                leftStatus.setTextFill(Color.RED);
                leftStatus.setText(statusString); // setting the leftStatus text below to reflect the error
                chooseVideoCategory = false; // disabling the boolean of having selected a category
            }
        }
    }


    /**
     * sets main text to category output on click
     */
    @FXML
    void top5VideoCountOnClick(){
        clearMenuBoards();
        mainTextArea.setText(Category.top5VideoCountFunction());
        statusSuccess("Function: \"Top 5 Categories by Video Count\" loaded successfully!");
    }

    /**
     * sets main text to top 5 watch time output on click
     */
    @FXML
    void  top5WatchTimeOnClick(){
        clearMenuBoards();
        mainTextArea.setText(Category.top5WatchTimeFunction());
        statusSuccess("Function: \"Top 5 Categories by Watch Time\" loaded successfully!");
    }

    @FXML
    void setPrintAllButtonOnClick(){
        clearMenuBoards();
        mainTextArea.setText(Category.printAllFunction());
        statusSuccess("Function: \"Print All Outputs\" loaded successfully!");

    }


//COMPLETED

    /**
     * FXMl function for when the user selects the button to output the longest video watched that is stored in the system
     */
    @FXML
    void longestVideoWatchedButtonOnClick(){

        clearMenuBoards(); // clean up the output textAreas for new code to be added without issues
        String mainMenuString = Category.longestVideoFunction(); // obtaining the data
        mainTextArea.setText(mainMenuString);
    }

    /**
     * FXML for when the user selects the button to output the number and list of categories currently stored in
     * the system
     */
    @FXML
    void setListCategoriesButtonOnClick(){

        clearMenuBoards(); // clean up the output textAreas for new code to be added without issues
        String mainMenuString = Category.numListCatFunction(); // obtaining the data
        mainTextArea.setText(mainMenuString);
        statusSuccess("Function: \"Number and List of Categories\" loaded successfully!");
    }

    /**
     * FXML function used to call the video getter that gets the total number of videos stored in the system
     */
    @FXML
    void totalVideosWatchedButtonOnClick(){

        clearMenuBoards(); // clean up the output textAreas for new code to be added without issues
        String mainString = "";
        mainString += Category.totalVideosFunction(); // calling the function that gets the total number of videos watched
        mainTextArea.setText(mainString); // printing the obtained data from the above function to the main text area
        statusSuccess("Function: \"Total Videos Watched\" loaded successfully!");

    }

    /**
     * FXML function used to call the Video getter that gets the total watch time of all videos stored.
     */
    @FXML
    void totalMinsWatchedButtonOnClick(){

        clearMenuBoards(); // clean up the output textAreas for new code to be added without issues
        String mainString = "";
        mainString += Category.totalWatchTimeFunction(); // calling the function that gets the total watchtime
        mainTextArea.setText(mainString); // printing the data to the main text area from the above function
        statusSuccess("Function: \"Total Minutes Watched\" loaded successfully!");

    }

    /**
     * FXML used to enable the specific category watch time inputs for the user to continue on with such an output
     */
    @FXML
    void setWatchtimeCategoryButtonOnClick(){
        clearMenuBoards(); // clearing all previous printouts and enablings to for ease of use
        String sideMenuString = ""; // creation of sideMenUString for use later
        subMenuEnablerDisabler(SELECT_CATEGORY); // calling function to enable the select category inputs

        sideMenuString = Category.specificWatchTimeTextFunction(); // obtaining of string outputs about the chosen category
        subTextArea.setText(sideMenuString); // printing the obtained outputs
        statusSuccess("Function: \"Watch Time for Specific Category\" loaded successfully!");

    }

    /**
     * FXML function called when the user has selected a category they wish to check the watch time for. Is called when
     * the user presses the "Check Watch Time!" button
     */
    @FXML
    void setSubCheckWatchtimeButtonOnClick(){

        String mainMenuString = ""; // initialization of mainMenuString to be used later
        String statusString = ""; // initialization of statusString to be used later

        if (watchTimeCB.getValue()!="") { // if condition checking if there has been a category selected from the dropDown yet
            for (int i = 0; i < MainController.categoryArrayList.size(); i++) {
                if (MainController.categoryArrayList.get(i).getName().equals(watchTimeCB.getValue())) {
                    videoCategory = i;
                }
            }
            mainMenuString += Category.specificWatchTimeFunction(videoCategory); // adding the video length to the selected category
            mainTextArea.setText(mainMenuString); // setting the mainMenu text to the obtained string information from the function
        }else { // else condition for when there has not been a category selected for the video to be added to
            statusString += "Error: No input category has been selected!"; // setting the leftStatus t®ext to reflect the error
            chooseSpecificCategory = false; // disabling the boolean of having selected a category
            leftStatus.setTextFill(Color.RED);
            leftStatus.setText(statusString); // setting the leftStatus to equal the error code from above
        }

    }

    /**
     * sets main text to top count output on click
     */
    @FXML
    void topVideoCountOnClick(){
        clearMenuBoards(); // clean up the output textAreas for new code to be added without issues
        mainTextArea.setText(Category.topCategoryVideoCountFunction()); // updating the mainMenuArea with the function in question
        statusSuccess("Function: \"Top Category by Video Count\" loaded successfully!");

    }

    /**
     * sets main text to top text output on click
     */
    @FXML
    void topWatchTimeOnClick(){
        clearMenuBoards(); // clean up the output textAreas for new code to be added without issues
        mainTextArea.setText(Category.topCategoryWatchTimeFunction()); // updating the mainMenuArea with the function in question
        statusSuccess("Function: \"Top Category by Watch Time\" loaded successfully!");

    }
}