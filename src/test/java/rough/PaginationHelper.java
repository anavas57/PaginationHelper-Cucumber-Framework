package rough;

/**
 * PaginationHelper - This class supports pagination operation over a given data set.
 * @author Antonio Navas
 * @param <I>
 */
public class PaginationHelper<I> {
    private Object[] itemsDataSet;  // This collection holds the data set
    private int itemsPerPage = 0;

    /**
     * PaginationHelper - Public constructor used to create an instance of PaginationHelper
     * @param itemsDataSet  Data set for the pagination.
     * @param itemsPerPage  Maximum number of Items per page.
     */
    public PaginationHelper(Object[] itemsDataSet, int itemsPerPage) {
        this.itemsDataSet = itemsDataSet;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * pagesCount - This method returns the number of pages which the set creates
     * @return page count
     */
    public int pagesCount() {
        if (itemsDataSet == null || itemsDataSet.length == 0 || itemsPerPage <= 0) {
            return 0;
        } else if (itemsDataSet.length < itemsPerPage) {
            return 1;}
        else {
            int division = itemsDataSet.length / itemsPerPage;
            int remainder = itemsDataSet.length % itemsPerPage;
            if (remainder == 0) {
                return division;
            } else {
                return division + 1;
            }
        }
    }

    /**
     * itemsCount - This method returns the total number of items in the given data set.
     * @return total item count
     */
    public int itemsCount() {
        if (itemsDataSet == null) {
            return 0;
        } else {
            return itemsDataSet.length;
        }
    }
    /**
     * pageItemCount -    This method returns the number of items in a given page.
     *                    Page numbers start from 0.
     * @param pageNumber  Current page number.
     * @return
     */
    public int pageItemsCount(int pageNumber) {
        int pagesCount = this.pagesCount();

        if (pageNumber < 0 || pagesCount <= pageNumber || pagesCount == 0) {
            return -1;
        } else {

            if (pagesCount - 1 == pageNumber) {
                // Last page
                int remainder = itemsDataSet.length % itemsPerPage;
                if (remainder == 0) {
                    return itemsPerPage;
                } else {
                    return remainder;
                }
            } else {
                return itemsPerPage;
            }
        }
    }

    /**
     * pageIndex - This method returns the page number of a given item in the data set
     * @param itemIndex Item index in the data set
     * @return Page index where the item resides
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || this.itemsCount() <= itemIndex || this.pagesCount() == 0) {
            return -1;
        } else {
            int itemsCount = itemIndex + 1;
            int pageIndex = itemsCount / itemsPerPage;
            int itemsRemaining = itemsCount % itemsPerPage;

            if (itemsCount <= itemsPerPage) {
                return 0;
            } else if (itemsRemaining == 0) {
                return pageIndex - 1;
            } else {
                return pageIndex;
            }
        }
    }

    public static void main(String args[]) {
        Object[] itemsDataSet = new Object[] {'a','b','c','d','e','f'};

        PaginationHelper<Character> helper = new PaginationHelper(itemsDataSet, 4);
        System.out.println(helper.pagesCount()); //should == 2
        System.out.println(helper.itemsCount()); //should == 6
        System.out.println(helper.pageItemsCount(0)); //should == 4
        System.out.println(helper.pageItemsCount(1)); // last page - should == 2
        System.out.println(helper.pageItemsCount(2)); // should == -1 since the page is invalid

        // pageIndex takes an item index and returns the page that it belongs on
        System.out.println(helper.pageIndex(5)); //should == 1 (zero based index)
        System.out.println(helper.pageIndex(2)); //should == 0
        System.out.println(helper.pageIndex(20)); //should == -1
        System.out.println(helper.pageIndex(-10)); //should == -1
    }
}
