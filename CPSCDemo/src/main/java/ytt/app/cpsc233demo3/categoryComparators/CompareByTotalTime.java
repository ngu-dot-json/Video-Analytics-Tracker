package ytt.app.cpsc233demo3.categoryComparators;

import ytt.app.cpsc233demo3.videoTracking.Category;

import java.util.Comparator;

public class CompareByTotalTime implements Comparator<Category> {
    @Override
    public int compare(Category cat1, Category cat2) { // compares by total min checks if there are vids first and then reverses so its in descending order
        if (cat1.getCatWatchTime() > 0 & cat2.getCatWatchTime() > 0) {
            int result = Integer.compare(cat1.getCatWatchTime(), cat2.getCatWatchTime());
            if (result != 0) {
                return -result;
            }
            result = cat1.getName().compareTo(cat2.getName());
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
