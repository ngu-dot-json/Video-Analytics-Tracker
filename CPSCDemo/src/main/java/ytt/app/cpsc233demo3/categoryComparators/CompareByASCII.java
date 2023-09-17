package ytt.app.cpsc233demo3.categoryComparators;

import ytt.app.cpsc233demo3.videoTracking.Category;

import java.util.Comparator;

public class CompareByASCII implements Comparator<Category> {
    @Override
    public int compare(Category cat1, Category cat2) {
        int result = cat1.getName().compareTo(cat2.getName());
        if (result != 0) {
            return result;
        }
        return 0;
    }
}