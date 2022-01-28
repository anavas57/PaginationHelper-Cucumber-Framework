package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Pagination_Page;

public class PageNavigationSteps {
    private final Pagination_Page pagination = new Pagination_Page();

    /**
     * Scenario: User knows the number of pages which the set creates
     */
    @Given("the user wants to know the number of pages which the set creates")
    public void the_user_wants_to_know_the_number_of_pages_which_the_set_creates() {
        System.out.println("\r\n" +"Given the user wants to know the number of pages which the set creates");
    }

    @When("the user enters the dataset")
    public void the_user_enters_the_dataset() {
        System.out.println("When the user enters the dataset");
    }

    @When("the user provides the items per page")
    public void the_user_provides_the_items_per_page() {
        System.out.println("When the user provides the items per page");
    }

    @Then("the user gets to know the number of pages which the set creates")
    public void the_user_gets_to_know_the_number_of_pages_which_the_set_creates() {
        System.out.println("Then the user gets to know the number of pages which the set creates");
        pagination.pagesCount();
    }

    /**
     * Scenario: User knows the number of items in a given dataset
     */
    @Given("the user wants to know the number of items in a given dataset")
    public void the_user_wants_to_know_the_number_of_items_in_a_given_dataset() {
        System.out.println("\r\n" +"Given the user wants to know the number of items in a given dataset");
    }

    @Then("the user gets to know the number of items in a given dataset")
    public void the_user_gets_to_know_the_number_of_items_in_a_given_dataset() {
        System.out.println("Then the user gets to know the number of items in a given dataset");
        pagination.itemsCount();
    }

    /**
     * Scenario: User knows the number of items in a given page
     */
    @Given("the user wants to know the number of items in a given page")
    public void the_user_wants_to_know_the_number_of_items_in_a_given_page() {
        System.out.println("\r\n" +"Given the user gets to know the number of items in a given page");
    }

    @When("the user enters the page number")
    public void the_user_enters_the_page_number() {
        System.out.println("When the user enters the page number");
    }

    @Then("the user gets to know the number of items in a given page")
    public void the_user_gets_to_know_the_number_of_items_in_a_given_page() {
        System.out.println("Then the user gets to know the number of items in a given page");
        pagination.pageItemsCount();
    }

    /**
     * Scenario: User can find the page number of a given item in the dataset
     */
    @Given("the user wants to find the page number where the item is shown")
    public void the_user_wants_to_find_the_page_number_where_the_item_is_shown() {
        System.out.println("\r\n" +"Given the user wants to find the page number where the item is shown");
    }

    @When("the user enters the item")
    public void the_user_enters_the_item() {
        System.out.println("When the user enters the item");
    }

    @Then("the user can find the page number where the item is shown")
    public void the_user_can_find_the_page_number_where_the_item_is_shown() {
        System.out.println("Then the user can find the page number where the item is shown");
        pagination.pageIndex();
    }

    /**
     * Scenario Outline: User cannot find a non-existing page number
     */
    @Given("the user wants to find a non existing page number")
    public void the_user_wants_to_find_a_non_existing_page_number() {
        System.out.println("\r\n" +"Given the user wants to find a non existing page number");
    }

    @When("the user enters the page number {int}")
    public void the_user_enters_the_page_number(Integer int1) {
        System.out.println("When the user enters the page number " + int1);
    }

    @Then("the user cannot find the page number {int}")
    public void the_user_cannot_find_the_page_number(Integer int2) {
        System.out.println("Then the user cannot find the page number" + int2);
        try {
            pagination.pageOutOfIndex(int2);
        } catch(Exception e) {
            System.out.println("Then the user see the following exception: " + e);
        }
    }
}
