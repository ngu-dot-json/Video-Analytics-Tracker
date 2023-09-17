package ytt.app.cpsc233demo3.categoryComparators;

import ytt.app.cpsc233demo3.videoTracking.Category;

import java.util.Comparator;

public class CompareByTotalVideos implements Comparator<Category> {
     //comparable compares number of videos then compares name then reverses for descending order
    @Override
    public int compare(Category cat1, Category cat2) {
        if (cat1.getVideoCount() > 0 & cat2.getVideoCount() > 0) {
            int result = Integer.compare(cat1.getVideoCount(), cat2.getVideoCount());
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
