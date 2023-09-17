package ytt.app.cpsc233demo3;

import org.junit.jupiter.api.Test;
import ytt.app.cpsc233demo3.videoTracking.Category;
import ytt.app.cpsc233demo3.videoTracking.Video;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


/**
 * CPSC 233 W22 GROUP PROJECT
 *
 * @author Jason Ngu & Brian Tran
 * Date: April 01st 2022
 * Course: CPSC 233 W22
 * UCIDs (Jason Ngu: 30145770) & (Brian Tran: 30064686)
 * Instructor: Jonathan Hudson
 * TA: (Jason Ngu: Tejash Shrestha) & (Brian Tran: Abdelghani Guerbas)
 *
 * java description: the following is the MainTest.java used to JUnit test the functions created throughout the code and classes
 */

class MainTest {

    /**
     * Test created to check if the Category class function "getVideoCount" works when there are no videos in a category
     */
    @Test
    void categoryVideoCountTest01_1Cat0Vid() {

        Category testCategory1 = new Category("testCategory1");

        int expectedValue = 0;
        int actualValue = testCategory1.getVideoCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "getVideoCount" works when there are 1 video in a category
     */
    @Test
    void categoryVideoCountTest02_1Cat1Vid() {

        Category testCategory1 = new Category("testCategory1");
        Video testVideo = new Video("testVideo", 10);
        testCategory1.addVideo(testVideo);

        int expectedValue = 1;
        int actualValue = testCategory1.getVideoCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "getVideoCount" works when there are two categories, each of
     * which have different numbers of videos stored inside them (the one we are checking should have 2)
     */
    @Test
    void categoryVideoCountTest03_2Cat3Vid() {

        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);

        testCategory1.addVideo(testVideo1);
        testCategory1.addVideo(testVideo2);
        testCategory2.addVideo(testVideo3);

        int expectedValue = 2;
        int actualValue = testCategory1.getVideoCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "getVideoCount" works when there are two categories, each of
     * which have different numbers of videos stored inside them (the one we are checking should have 0)
     */
    @Test
    void categoryVideoCountTest04_2Cat3Vid() {

        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);

        testCategory2.addVideo(testVideo1);
        testCategory2.addVideo(testVideo2);
        testCategory2.addVideo(testVideo3);

        int expectedValue = 0;
        int actualValue = testCategory1.getVideoCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "getCatWatchTime" works when there are no videos in a category
     */
    @Test
    void categoryVideoWatchTime01_1Cat0Vid() {

        Category testCategory1 = new Category("testCategory1");

        int expectedValue = 0;
        int actualValue = testCategory1.getCatWatchTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "getCatWatchTime" works when there are 1 video in a category
     * which has a total watch time of 10 minutes
     */
    @Test
    void categoryWatchTest02_1Cat1Vid() {

        Category testCategory1 = new Category("testCategory1");
        Video testVideo = new Video("testVideo", 10);
        testCategory1.addVideo(testVideo);

        int expectedValue = 10;
        int actualValue = testCategory1.getCatWatchTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "getCatWatchTime" works when there are two categories, each of
     * which have different numbers of videos stored inside them (the one we are checking should have 25 minutes stored)
     */
    @Test
    void categoryWatchTimeTest03_2Cat3Vid() {

        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 15);
        Video testVideo3 = new Video("testVideo3", 30);

        testCategory1.addVideo(testVideo1);
        testCategory1.addVideo(testVideo2);
        testCategory2.addVideo(testVideo3);

        int expectedValue = 25;
        int actualValue = testCategory1.getCatWatchTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "getCatWatchTime" works when there are two categories, each of
     * which have different numbers of videos stored inside them (the one we are checking should have 0 videos for length 0)
     */
    @Test
    void categoryWatchTimeTest04_2Cat3Vid() {

        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);

        testCategory2.addVideo(testVideo1);
        testCategory2.addVideo(testVideo2);
        testCategory2.addVideo(testVideo3);

        int expectedValue = 0;
        int actualValue = testCategory1.getCatWatchTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to see if the "getName()" function works when there is one category stored
     */
    @Test
    void categoryGetNameTest01_1Cat() {
        Category testCategory1 = new Category("testCategory1");

        String expectedValue = "testCategory1";
        String actualValue = testCategory1.getName();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to see if the "getName()" function works when there is two categories stored
     */
    @Test
    void categoryGetNameTest01_2Cat() {
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");

        String expectedValue = "testCategory1";
        String actualValue = testCategory1.getName();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to see if the "getName()" function works when there is three categories stored
     */
    @Test
    void categoryGetNameTest01_3Cat() {
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Category testCategory3 = new Category("testCategory3");

        String expectedValue = "testCategory2";
        String actualValue = testCategory2.getName();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "totalWatchTime" works when there are no videos in the system
     */
    @Test
    void categoryTotalWatchTimeTest01_0Mins() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");

        int expectedValue = 0;
        int actualValue = Category.getTotalWatchTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "totalWatchTime" works when there are 1 video in a category
     * which has a total watch time of 10 minutes
     */
    @Test
    void categoryTotalWatchTimeTest02_10Mins() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Video testVideo = new Video("testVideo", 10);
        testCategory1.addVideo(testVideo);

        int expectedValue = 10;
        int actualValue = Category.getTotalWatchTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "totalWatchTime" works when there are two categories, with 55
     * minutes of content watched split between them
     */
    @Test
    void categoryTotalWatchTimeTest03_55Mins() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 15);
        Video testVideo3 = new Video("testVideo3", 30);

        testCategory1.addVideo(testVideo1);
        testCategory1.addVideo(testVideo2);
        testCategory2.addVideo(testVideo3);

        int expectedValue = 55;
        int actualValue = Category.getTotalWatchTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "totalWatchTime" works when there are four categories, each of
     * which have videos stored in them to make a total of 100 minutes of watch time
     */
    @Test
    void categoryTotalWatchTimeTest04_100Mins() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Category testCategory3 = new Category("testCategory3");
        Category testCategory4 = new Category("testCategory4");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);
        Video testVideo4 = new Video("testVideo4", 40);

        testCategory1.addVideo(testVideo1);
        testCategory2.addVideo(testVideo2);
        testCategory3.addVideo(testVideo3);
        testCategory4.addVideo(testVideo4);

        int expectedValue = 100;
        int actualValue = Category.getTotalWatchTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "totalWatchTime" works when there are no videos in the system
     */
    @Test
    void categoryTotalWatchTimeTest01_0Video() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");

        int expectedValue = 0;
        int actualValue = Category.getTotalVideoCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "totalVideoCount" works when there is one category, with a
     * total of one video stored inside
     */
    @Test
    void categoryTotalVideoCountTest02_1Video() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Video testVideo1 = new Video("testVideo1", 10);

        testCategory1.addVideo(testVideo1);

        int expectedValue = 1;
        int actualValue = Category.getTotalVideoCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "totalVideoCount" works when there are two categories, with a
     * total of three videos stored inside
     */
    @Test
    void categoryTotalVideoCountTest03_3Videos() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 15);
        Video testVideo3 = new Video("testVideo3", 30);

        testCategory1.addVideo(testVideo1);
        testCategory1.addVideo(testVideo2);
        testCategory2.addVideo(testVideo3);

        int expectedValue = 3;
        int actualValue = Category.getTotalVideoCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "totalVideoCount" works when there are four categories, with
     * a total of 10 videos stored inside
     */
    @Test
    void categoryTotalVideoCountTest04_10Videos() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Category testCategory3 = new Category("testCategory3");
        Category testCategory4 = new Category("testCategory4");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);
        Video testVideo4 = new Video("testVideo4", 40);
        Video testVideo5 = new Video("testVideo5", 50);
        Video testVideo6 = new Video("testVideo6", 60);
        Video testVideo7 = new Video("testVideo7", 30);
        Video testVideo8 = new Video("testVideo8", 40);
        Video testVideo9 = new Video("testVideo9", 50);
        Video testVideo10 = new Video("testVideo10", 60);

        testCategory1.addVideo(testVideo1);
        testCategory2.addVideo(testVideo2);
        testCategory3.addVideo(testVideo3);
        testCategory4.addVideo(testVideo4);
        testCategory2.addVideo(testVideo5);
        testCategory1.addVideo(testVideo6);
        testCategory3.addVideo(testVideo7);
        testCategory3.addVideo(testVideo8);
        testCategory4.addVideo(testVideo9);
        testCategory1.addVideo(testVideo10);

        int expectedValue = 10;
        int actualValue = Category.getTotalVideoCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "topVideoOfAllTime" works when there are no videos in the system
     */
    @Test
    void categoryTopVideoTest01_0Video() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");

        Video actualValue = Category.getTopVideoOfAllTime();

        assertEquals(null, actualValue);
    }

    /**
     * Test created to check if the Category class function "topVideoOfAllTime" works when there is one category, with a
     * total of one video stored inside
     */
    @Test
    void categoryTopVideoTest02_1Video() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Video testVideo = new Video("testVideo", 10);
        testCategory1.addVideo(testVideo);

        Video actualValue = Category.getTopVideoOfAllTime();

        assertEquals(testVideo, actualValue);
    }

    /**
     * Test created to check if the Category class function "topVideoOfAllTime" works when there are two categories, with a
     * total of three videos stored inside
     */
    @Test
    void categoryTopVideoTest03_0Video() {

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 15);
        Video expectedValue = new Video("testVideo3", 30);

        testCategory1.addVideo(testVideo1);
        testCategory1.addVideo(testVideo2);
        testCategory2.addVideo(expectedValue);

        Video actualValue = Category.getTopVideoOfAllTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to check if the Category class function "topVideoOfAllTime" works when there are four categories, with
     * a total of 10 videos stored inside
     */
    @Test
    void categoryTopVideoTest04_10Video(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Category testCategory3 = new Category("testCategory3");
        Category testCategory4 = new Category("testCategory4");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);
        Video testVideo4 = new Video("testVideo4", 40);
        Video testVideo5 = new Video("testVideo5", 50);
        Video testVideo6 = new Video("testVideo6", 60);
        Video testVideo7 = new Video("testVideo7", 30);
        Video testVideo8 = new Video("testVideo8", 40);
        Video testVideo9 = new Video("testVideo9", 50);
        Video expectedValue = new Video("testVideo10", 100);

        testCategory1.addVideo(testVideo1);
        testCategory2.addVideo(testVideo2);
        testCategory3.addVideo(testVideo3);
        testCategory4.addVideo(testVideo4);
        testCategory2.addVideo(testVideo5);
        testCategory1.addVideo(testVideo6);
        testCategory3.addVideo(testVideo7);
        testCategory3.addVideo(testVideo8);
        testCategory4.addVideo(testVideo9);
        testCategory1.addVideo(expectedValue);

        Video actualValue = Category.getTopVideoOfAllTime();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the category object is able to store the number of categories in the system correctly - specifically
     * when there are 0 stored categories in the system currently
     */
    @Test
    void categoryCountTest01_0Cat(){

        Category.testingConditionStart();
        int expectedValue = 0;
        int actualValue = Category.getTotalCategoryCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the category object is able to store the number of categories in the system correctly - specifically
     * when there are 1 stored categories in the system currently
     */
    @Test
    void categoryCountTest02_1Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");

        int expectedValue = 1;
        int actualValue = Category.getTotalCategoryCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the category object is able to store the number of categories in the system correctly - specifically
     * when there are 2 stored categories in the system currently
     */
    @Test
    void categoryCountTest03_2Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");

        int expectedValue = 2;
        int actualValue = Category.getTotalCategoryCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the category object is able to store the number of categories in the system correctly - specifically
     * when there are 10 stored categories in the system currently
     */
    @Test
    void categoryCountTest04_10Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Category testCategory3 = new Category("testCategory3");
        Category testCategory4 = new Category("testCategory4");
        Category testCategory5 = new Category("testCategory5");
        Category testCategory6 = new Category("testCategory6");
        Category testCategory7 = new Category("testCategory7");
        Category testCategory8 = new Category("testCategory8");
        Category testCategory9 = new Category("testCategory9");
        Category testCategory10 = new Category("testCategory10");

        int expectedValue = 10;
        int actualValue = Category.getTotalCategoryCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the category object is able to store the number of categories in the system correctly - specifically
     * when there are 0 stored categories and thus 0 watched categories in the system currently
     */
    @Test
    void watchedCategoryCountTest01_0of0Cat(){

        Category.testingConditionStart();
        int expectedValue = 0;
        int actualValue = Category.getTotalWatchedCategoryCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the category object is able to store the number of categories in the system correctly - specifically
     * when there are 1 stored categories and 0 watched categories in the system currently
     */
    @Test
    void watchedCategoryCountTest02_0of1Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category.testingConditionStart();
        int expectedValue = 0;
        int actualValue = Category.getTotalWatchedCategoryCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the category object is able to store the number of categories in the system correctly - specifically
     * when there are 1 stored categories and 0 watched categories in the system currently
     */
    @Test
    void watchedCategoryCountTest03_2of2Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");

        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);

        testCategory1.addVideo(testVideo1);
        testCategory2.addVideo(testVideo2);

        int expectedValue = 2;
        int actualValue = Category.getTotalWatchedCategoryCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the category object is able to store the number of categories in the system correctly - specifically
     * when there are 5 stored categories and 3 watched categories in the system currently
     */
    @Test
    void watchedCategoryCountTest04_3of5Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Category testCategory3 = new Category("testCategory3");
        Category testCategory4 = new Category("testCategory4");
        Category testCategory5 = new Category("testCategory5");

        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);

        testCategory1.addVideo(testVideo1);
        testCategory2.addVideo(testVideo2);
        testCategory3.addVideo(testVideo3);

        int expectedValue = 3;
        int actualValue = Category.getTotalWatchedCategoryCount();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the video.getName() function does indeed return the correct name for a video
     * specifically when there is only 1 video in the system
     */
    @Test
    void videoGetNameTest01_1Video(){
        Video testVideo1 = new Video("testVideo1", 10);

        String expectedValue = "testVideo1";
        String actualValue = testVideo1.getName();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the video.getName() function does indeed return the correct name for a video
     * specifically when there is 2 videos in the system
     */
    @Test
    void videoGetNameTest02_2Videos(){
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);

        String expectedValue = "testVideo2";
        String actualValue = testVideo2.getName();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the video.getName() function does indeed return the correct name for a video
     * specifically when there is 10 videos in the system
     */
    @Test
    void videoGetNameTest03_10Videos(){
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);
        Video testVideo4 = new Video("testVideo4", 40);
        Video testVideo5 = new Video("testVideo5", 50);
        Video testVideo6 = new Video("testVideo6", 60);
        Video testVideo7 = new Video("testVideo7", 70);
        Video testVideo8 = new Video("testVideo8", 80);
        Video testVideo9 = new Video("testVideo9", 90);
        Video testVideo10 = new Video("testVideo10", 100);

        String expectedValue = "testVideo7";
        String actualValue = testVideo7.getName();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the video.getLength() function does indeed return the correct length for a video
     * specifically when there is only 1 video in the system
     */
    @Test
    void videoGetLengthTest01_1Video(){
        Video testVideo1 = new Video("testVideo1", 10);

        int expectedValue = 10;
        int actualValue = testVideo1.getVideoLength();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the video.getLength() function does indeed return the correct length for a video
     * specifically when there is 2 videos in the system
     */
    @Test
    void videoGetLengthTest02_2Videos(){
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);

        int expectedValue = 20;
        int actualValue = testVideo2.getVideoLength();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to check if the video.getLength() function does indeed return the correct length for a video
     * specifically when there is 10 videos in the system
     */
    @Test
    void videoGetLengthTest03_10Videos(){
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);
        Video testVideo4 = new Video("testVideo4", 40);
        Video testVideo5 = new Video("testVideo5", 50);
        Video testVideo6 = new Video("testVideo6", 60);
        Video testVideo7 = new Video("testVideo7", 70);
        Video testVideo8 = new Video("testVideo8", 80);
        Video testVideo9 = new Video("testVideo9", 90);
        Video testVideo10 = new Video("testVideo10", 100);

        int expectedValue = 70;
        int actualValue = testVideo7.getVideoLength();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to see if the video.getCategory() function does indeed return the correct Category for a video
     * specifically when there is 1 category and 1 video in the system
     */
    @Test
    void videoGetCategoryTest01_1Cat1Vid(){
        Category testCategory1 = new Category("testCategory1");
        Video testVideo1 = new Video("testVideo1", 10);
        testCategory1.addVideo(testVideo1);
        testVideo1.setCategory(testCategory1);

        Category expectedValue = testCategory1;
        Category actualValue = testVideo1.getCategory();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * test created to see if the video.getCategory() function does indeed return the correct Category for a video
     * specifically when there are 2 categories and 1 video in the system
     */
    @Test
    void videoGetCategoryTest02_2Cat1Vid(){
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Video testVideo1 = new Video("testVideo1", 10);
        testCategory1.addVideo(testVideo1);
        testVideo1.setCategory(testCategory2);

        Category expectedValue = testCategory2;
        Category actualValue = testVideo1.getCategory();

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to test if the top5Category function works for when there is only when category in the system
     */
    @Test
    void top5CatVideoCountTest01_1Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Video testVideo1 = new Video("testVideo1", 10);
        testCategory1.addVideo(testVideo1);
        testVideo1.setCategory(testCategory1);

        String expectedValue = "[testCategory1{testVideo1: 10 min}]";
        String actualValue = Arrays.toString(Category.top5VideoCount());

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to test if the top5Category function works for when there is two categories in the system, with the second
     * category being the one with more watch time than the first
     */
    @Test
    void top5CatVideoTest02_2Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 20);
        testCategory1.addVideo(testVideo1);
        testVideo1.setCategory(testCategory1);
        testCategory2.addVideo(testVideo2);
        testVideo2.setCategory(testCategory2);
        testCategory2.addVideo(testVideo3);
        testVideo3.setCategory(testCategory2);

        String expectedValue = "[testCategory2{testVideo2: 20 min, testVideo3: 20 min}, testCategory1{testVideo1: 10 min}]";
        String actualValue = Arrays.toString(Category.top5VideoCount());

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to test if the top5Category function works for when there is three categories in the system, with the second
     * category being the one with more watch time than the first, and the third has no videos stored inside
     */
    @Test
    void top5CatVideoTest03_3Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Category testCategory3 = new Category("testCategory3");
        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);
        testCategory1.addVideo(testVideo1);
        testVideo1.setCategory(testCategory1);
        testCategory2.addVideo(testVideo2);
        testVideo2.setCategory(testCategory2);
        testCategory2.addVideo(testVideo3);
        testVideo3.setCategory(testCategory2);

        String expectedValue = "[testCategory2{testVideo2: 20 min, testVideo3: 30 min}, testCategory1{testVideo1: 10 min}]";
        String actualValue = Arrays.toString(Category.top5VideoCount());

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to test if the top5Category function works for when there is five categories in the system
     */
    @Test
    void top5CatVideoTest04_5Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Category testCategory3 = new Category("testCategory3");
        Category testCategory4 = new Category("testCategory4");
        Category testCategory5 = new Category("testCategory5");

        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);
        Video testVideo4 = new Video("testVideo4", 40);
        Video testVideo5 = new Video("testVideo5", 50);

        testCategory1.addVideo(testVideo1);
        testVideo1.setCategory(testCategory1);
        testCategory2.addVideo(testVideo2);
        testVideo2.setCategory(testCategory2);
        testCategory2.addVideo(testVideo3);
        testVideo3.setCategory(testCategory2);
        testCategory4.addVideo(testVideo4);
        testVideo4.setCategory(testCategory4);
        testCategory5.addVideo(testVideo5);
        testVideo5.setCategory(testCategory5);

        String expectedValue = "[testCategory2{testVideo2: 20 min, testVideo3: 30 min}, testCategory1{testVideo1: 10 min}, testCategory4{testVideo4: 40 min}, testCategory5{testVideo5: 50 min}]";
        String actualValue = Arrays.toString(Category.top5VideoCount());

        assertEquals(expectedValue, actualValue);
    }

    /**
     * Test created to test if the top5Category function works for when there is seven categories in the system, sorting by
     * the top 5
     */
    @Test
    void top5CatVideoTest05_7Cat(){

        Category.testingConditionStart();
        Category testCategory1 = new Category("testCategory1");
        Category testCategory2 = new Category("testCategory2");
        Category testCategory3 = new Category("testCategory3");
        Category testCategory4 = new Category("testCategory4");
        Category testCategory5 = new Category("testCategory5");
        Category testCategory6 = new Category("testCategory6");
        Category testCategory7 = new Category("testCategory7");



        Video testVideo1 = new Video("testVideo1", 10);
        Video testVideo2 = new Video("testVideo2", 20);
        Video testVideo3 = new Video("testVideo3", 30);
        Video testVideo4 = new Video("testVideo4", 40);
        Video testVideo5 = new Video("testVideo5", 50);
        Video testVideo6 = new Video("testVideo4", 40);
        Video testVideo7 = new Video("testVideo5", 50);
        Video testVideo8 = new Video("testVideo4", 40);
        Video testVideo9 = new Video("testVideo5", 50);

        testCategory1.addVideo(testVideo1);
        testVideo1.setCategory(testCategory1);
        testCategory2.addVideo(testVideo2);
        testVideo2.setCategory(testCategory2);
        testCategory2.addVideo(testVideo3);
        testVideo3.setCategory(testCategory2);
        testCategory4.addVideo(testVideo4);
        testVideo4.setCategory(testCategory4);
        testCategory5.addVideo(testVideo5);
        testVideo5.setCategory(testCategory5);
        testCategory6.addVideo(testVideo6);
        testVideo6.setCategory(testCategory6);
        testCategory7.addVideo(testVideo7);
        testVideo7.setCategory(testCategory7);
        testCategory6.addVideo(testVideo8);
        testVideo8.setCategory(testCategory6);
        testCategory4.addVideo(testVideo9);
        testVideo9.setCategory(testCategory4);

        String expectedValue = "[testCategory2{testVideo2: 20 min, testVideo3: 30 min}, testCategory4{testVideo4: 40 min, testVideo5: 50 min}, testCategory6{testVideo4: 40 min, testVideo4: 40 min}, testCategory1{testVideo1: 10 min}, testCategory5{testVideo5: 50 min}]";
        String actualValue = Arrays.toString(Category.top5VideoCount());

        assertEquals(expectedValue, actualValue);
    }



}