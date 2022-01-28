package pageObjects;

import utilities.PaginationHelper;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Pagination_Page - Contains the methods using the Pagination Helper
 */
public class Pagination_Page {
    Object[] itemsDataSet = new Object[] {'a','b','c','d','e','f'};
    private int itemsPerPage = 4;
    private final PaginationHelper paginationHelper = new PaginationHelper(itemsDataSet, itemsPerPage);

    /**
     * pagesCount - Returns the number of pages which the set creates
     */
    public void pagesCount() {
        paginationHelper.pagesCount();
        assertEquals(2, paginationHelper.pagesCount());
        System.out.println("The number of pages which the set creates is " + paginationHelper.pagesCount()); //should == 2
    }

    /**
     * itemsCount - Returns the total number of items in the given dataset
     */
    public void itemsCount() {
        paginationHelper.itemsCount();
        assertEquals(6, paginationHelper.itemsCount());
        System.out.println("The total number of items in the given dataset is " + paginationHelper.itemsCount()); //should == 6
    }

    /**
     * pageItemsCount - Returns the number of items in a given page
     */
    public void pageItemsCount() {
        Integer pages = paginationHelper.pagesCount();
        for (int i = 0; i < pages; i++) {
            paginationHelper.pageItemsCount(i);
            if(i==0) {
                assertEquals(4, paginationHelper.pageItemsCount(i));
            } else if (i==1) {
                assertEquals(2, paginationHelper.pageItemsCount(i));
            }
            System.out.println("Number of items in page " + (i+1) + " is " + paginationHelper.pageItemsCount(i));
        }
    }

    /**
     * pageIndex - Returns the page where a given item can be found
     */
    public void pageIndex() {
        Integer datasetLenght = itemsDataSet.length;
        for (int i = 0; i < datasetLenght; i++) {
            paginationHelper.pageIndex(i);
            switch (i + 1) {
                case 1:
                case 2:
                case 3:
                case 4:
                    assertEquals(1, (paginationHelper.pageIndex(i) + 1));
                    break;
                case 5:
                case 6:
                    assertEquals(2, (paginationHelper.pageIndex(i) + 1));
                    break;
            }
            System.out.println("Item " + (i + 1) + " '" + itemsDataSet[i] + "' can be found in page " + (paginationHelper.pageIndex(i) + 1));
        }
    }

    /**
     * pageOutOfIndex - Returns a page out of index exception
     * @param index
     */
    public void pageOutOfIndex(int index) {
        paginationHelper.pageIndex(index);
        System.out.println("Item " + (index + 1) + " '" + itemsDataSet[index] + "' cannot be found in page " + (paginationHelper.pageIndex(index) + 1));
    }
}
