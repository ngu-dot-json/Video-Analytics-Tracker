# YouTube Video Tracker V1.0

---
Course: CPSC 233 W22  
Authors: Jason Ngu & Brian Tran  
UCIDs: 30145770 & 30064686  
Instructor: Jonathan Hudson     
TA: Tejash Shrestha & Abdelghani Guerbas   
Date: April 15th 2022

---
**[00] .zip File Contents**

The .zip file containing all of the CPSC 233 W22 Project data and information contains the following files:

* Complete project source code (all the data found inside the CPSCW22ProjectCode folder)
* README.md (the file you are currently accessing)
* CPSC233WINTER22.jar (The .jar file used to run the program in the cmd or terminal)
* "YTT click to run (EDIT FIRST)" (Alternative way to run the program; look at [02.3] for more information)
* "sketchUML" (the sketch UML created for how we planned on executing our GUI program)
* "mainUML.jpg" (the main UML of how the project is structured and how data is passed around)
* "categoryUML.jpg" (the UML Structure for how the Category class works)
* "videoUML.jpg" (the UML structure for how the Video class works)
* "readerUML.jpg" (the UML structure for how the inputReader class works)
* "writerUML.jpg" (the UML structure for how the outputWriter class works)


---
**[01] Introduction and Setup:**

The following is our Final Project code for CPSC 233 W22; to create a JavaFX event-driven object-oriented GUI
program that tracks an individuals watched YouTube (and any video content really), which stores watched videos by the
category and watch time of it. From this; the user can access many specific data outputs that will return to them
information about their watching habits; top watched categories; and other information such as that.

---
**[02.1] Running the program via CMD or Terminal without direct file input:**

To run the program through the cmd or terminal without inputting a file to be read; please input the following:

    java --module-path ">insertPathForJavaFX18LibraryFilesHere<" --add-modules javafx.controls,javafx.fxml -jar CPSC233WINTER22.jar

As can be read from the code above; one should input the direct pathname for their "lib" folder (library folder) containing their JavaFX files in order for the code to run (this path should be within double parenthesis). Doing this should allow the .jar to run without issue, allowing the program to run as it should; for the user to access the created GUI for the MvH program.

An example input to run the program with an inputted JavaFX18 (through the macOS operating system) would look like the following:

    java --module-path "/Users/jasonngu/Downloads/javafx-sdk-18/lib" --add-modules javafx.controls,javafx.fxml -jar CPSC233WINTER22.jar
---
**[02.2] Running the program via CMD or Terminal with direct file input:**

To run the program through the cmd or terminal with the input a file to be read; please do the following:

    java --module-path ">insertPathForJavaFX18LibraryFilesHere<" --add-modules javafx.controls,javafx.fxml -jar CPSC233WINTER22.jar ">insertPathForInput.csvFileHere<"

As can be read from the code above; the input would be the exact same as running without an input file; except that we add the absolute path for the input file at the end of it. An example of such in action (in the macOS operating system) would look like the following:

    java --module-path "/Users/jasonngu/Downloads/javafx-sdk-18/lib" --add-modules javafx.controls,javafx.fxml -jar CPSC233WINTER22.jar /Users/jasonngu/IdeaProjects/CPSCDemo/my_ytt_data2.csv

---
**[02.3] Alternative Run Method**

Alternatively; one can also alter the "YTT click to run (EDIT FIRST).bat" file found in "out/artifacts/CPSC233WINTER22/YTT click to run (EDIT FIRST).bat", changing the default absolute path location listed inside with their own path to their JavaFX18 Library. Following the completion of such, they can then run their program without issue. By default, the YTT click to run (EDIT FIRST).bat file contains the following:

    java --module-path ">insert your javafx path<" --add-modules javafx.controls,javafx.fxml -jar CPSC233WINTER22.jar >insert valid .csv file path here<

But altered with the example user data (through the macOS operating system) would look like the following:

    java --module-path "/Users/jasonngu/Downloads/javafx-sdk-18/lib" --add-modules javafx.controls,javafx.fxml -jar CPSC233WINTER22.jar /Users/jasonngu/IdeaProjects/CPSCDemo/my_ytt_data2.csv

(Note: if the user does not have a specific .csv file to load in with the starting of the program, they can simply just disregard the final point wherein they input the path for their .csv)

With such completed; the user can now simply just double click on the .bat to run the program.

---
**[03] How to Use The Program:**

Following the completion of the listed steps in [01] and [02.x], the user can begin inputting data values into the program in order to
obtain the program calculated outputs about their watching habits.

1) To begin; please enter at least one Video Category to add Videos into. This can be achieved by first pressing the "Add Category" button in the leftmost subPane "InputMenu". (Any categories that already exist in the system will not be added in; however the system is case sensitive so "TestCategory1" is not the same as "testCategory1")
2) With such completed; the user may not enter in video data into the system. To complete such; please select the "Add Watched Video" button to continue. Following such, the user will be prompted to enter the name of the video; length of the video and the category they wish to add the video into. These inputs must be valid in order for the video to be successfully added into the system and category; with a failure to do such only resulting in an error in the status bar; reporting what issue the user is having and where to fix it.
3) Finally, with such complete; the user can now use the data outputs should they so wish.

---
**[04] Output Function Information**

[01] "Total Minutes Watched" - Is a function which calculates and returns the total minutes of all the videos watched in the system; regardless of category. Does not require any additional user interaction beyond the pressing of the button to function.

[02] "Total Videos Watched" - Is a function which calculates and returns the total number of videos watched and stored in the system; regardless of category. Does not require any additional user interaction beyond the pressing of the button to function.

[03] "Longest Video Watched" - Is a function which finds and returns the longest video watched stored in the system; listing its name and watch time. Does not require any additional user interaction beyond the pressing of the button to function.

[04] "Watch Time for Category" - Is a function which finds and retuns the total watch time for a specific category stored in the system. Does require additional user interaction in the form of selecting which category stored in the system that they wish to check for (via the drop down menu that will be enabled in the button click for this function)

[05] "Top 5 Watch Time" - Is a function which finds and returns the Top 5 most watched categories in the system by watch time. Is not forever stuck in a Top 5; as the function works in such a way that it can return anywhere from a Top 1 to a Top 5 depending on how many categories that have stored videos inside of them exist in the program. Does not require any additional user interaction beyond the pressing of the button to function.

[06] "Top 5 Video Count" - Is a function which finds and returns the Top 5 most watched categories in the system by video count. Is not forever stuck in a Top 5; as the function works in such a way that it can return anywhere from a Top 1 to a Top 5 depending on how many categories that have stored videos inside of them exist in the program. Does not require any additional user interaction beyond the pressing of the button to function.

[07] "Top Watch Time" - Is a function which finds and returns the top most watched category in the system by watch time. Does not require any additional user interaction beyond the pressing of the button to function.

[08] "Top Video Count" - Is a function which finds and returns the top most watched category in the system by video count. Does not require any additional user interaction beyond the pressing of the button to function.

[09] "List of Categories" - Is a function which returns the number and list of total stored and total watched categories in the system. Does not require any additional user interaction beyond the pressing of the button to function.

[10] "Print All" - Is a function which calls on all previous above output functions at once in order for the user to see all the possible outputs generated by the program from their inputted data. Does not require ay additional user interaction beyond the pressing of the button to function.

---
**[4] How to set up shortcut**

[1] right-click on your desktop go down to where it says new and select shortcut

[2] paste in the path to the bat file found in: "out/artifacts/CPSC233WINTER22/YTT click to run (EDIT FIRST).bat"

[3] right-click on your newly made shortcut, click properties a new window will popup

[4] click on change icon, and use the youtube icon found in the git repo