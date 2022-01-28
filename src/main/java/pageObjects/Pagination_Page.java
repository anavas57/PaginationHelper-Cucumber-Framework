package pageObjects;

import utilities.PaginationHelper;

public class Pagination_Page {
    Object[] itemsDataSet = new Object[] {'a','b','c','d','e','f'};
    private int itemsPerPage = 4;
    private final PaginationHelper paginationHelper = new PaginationHelper(itemsDataSet, itemsPerPage);

    public void pagesCount() {
        paginationHelper.pagesCount();
        System.out.println("The number of pages which the set creates is " + paginationHelper.pagesCount()); //should == 2
    }

    public void itemsCount() {
        paginationHelper.itemsCount();
        System.out.println("The total number of items in the given data set is " + paginationHelper.itemsCount()); //should == 6
    }

    public void pageItemsCount() {
        Integer pages = paginationHelper.pagesCount();
        for (int i = 0; i < pages; i++) {
            paginationHelper.pageItemsCount(i);
            System.out.println("Number of items in page " + (i+1) + " is " + paginationHelper.pageItemsCount(i));
        }
    }

    public void pageIndex() {
        Integer datasetLenght = itemsDataSet.length;
        for (int i = 0; i < datasetLenght; i++) {
            paginationHelper.pageIndex(i);
            System.out.println("Item " + (i + 1) + " '" + itemsDataSet[i] + "' can be found in page " + (paginationHelper.pageIndex(i) + 1));
        }
    }

    public void pageOutOfIndex(int index) {
        paginationHelper.pageIndex(index);
        System.out.println("Item " + (index + 1) + " '" + itemsDataSet[index] + "' cannot be found in page " + (paginationHelper.pageIndex(index) + 1));
    }
}
