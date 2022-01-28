package hooks;

import org.junit.After;
import org.junit.Before;

public class Hooks {
    @Before
    public void BeforeSteps() {
         /* What you can perform here:
         Starting a WebDriver
         Setting up DB connections
         Setting up test data
         Setting up browser cookies
         Navigating to certain page
         or anything before the test
         */
    }

    @After
    public void AfterSteps() {
         /* What you can perform here:
         Close WebDriver
         Cleaning database
         Close DB connections
         or anything after the test
         */
    }
}
