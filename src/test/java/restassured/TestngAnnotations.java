package restassured;


import org.testng.annotations.*;

public class TestngAnnotations {

    int cardid = 0;

    @BeforeSuite()
    public void beforeSuite() {
        System.out.println("@BeforeSuite - Setting up test suite configuration");
        // Example: Initialize database connections
        // Example: Set up test data for entire suite
        // Example: Start servers required for tests
    }

    /**
     * Runs once after all tests in the suite have run
     */
    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite - Cleaning up test suite resources");
        // Example: Close database connections
        // Example: Clean up test data
        // Example: Shut down servers
    }

    /**
     * Runs before any test method belonging to the classes inside the <test> tag is run
     */
    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest - Setting up test-specific configuration");
        // Example: Initialize test-specific resources
        // Example: Prepare test environment
    }

    /**
     * Runs after all the test methods belonging to the classes inside the <test> tag have run
     */
    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest - Cleaning up test-specific resources");
        // Example: Close test-specific resources
        // Example: Generate test reports
    }

    /**
     * Runs before any test method belonging to the specified group(s) is run
     */
    @BeforeGroups(groups = {"regression", "smoke"})
    public void beforeGroups() {
        System.out.println("@BeforeGroups - Setting up group-specific test data");
        // Example: Prepare test data specific to regression or smoke tests
        // Example: Configure environment for specific test groups
    }

    /**
     * Runs after all the test methods belonging to the specified group(s) have run
     */
    @AfterGroups(groups = {"regression", "smoke"})
    public void afterGroups() {
        System.out.println("@AfterGroups - Cleaning up group-specific test data");
        // Example: Delete test data specific to regression or smoke tests
        // Example: Generate group-specific reports
    }

    /**
     * Runs once before any test method in the current class is run
     */
    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass - Setting up class-level resources");
        // Example: Initialize common resources for all tests in class
        // Example: Set up mock objects used by multiple tests
    }

    /**
     * Runs once after all the test methods in the current class have been run
     */
    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass - Cleaning up class-level resources");
        // Example: Release resources used by the class
        // Example: Close file handles
    }

    /**
     * Runs before each test method
     */
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod - Setting up method-level prerequisites");
        // Example: Initialize test-specific variables
        // Example: Set up method-level preconditions
        // Example: Start timers for performance testing
    }

    /**
     * Runs after each test method
     */
    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod - Cleaning up after method execution");
        // Example: Reset test-specific variables
        // Example: Log test results
        // Example: Take screenshots on failure
    }

    /**
     * Example test method with group assignments
     */
    @Test(groups = {"smoke"})
    public void smokeTest() {
        System.out.println("Running smoke test");
        // Test logic here
    }
    @Test(groups = {"smoke"})
    public void smokeTest1() {
        System.out.println("Running smoke test1");
        // Test logic here
    }
    /**
     * Example test method with group assignments
     */
    @Test(groups = {"regression"})
    public void regressionTest() {
        System.out.println("Running regression test");
        // Test logic here
    }

    /**
     * Example test method with priority and timeout
     */
    @Test(priority = 1, timeOut = 5000)
    public void highPriorityTest() {
        System.out.println("Running high priority test");
        // Test logic here
    }

    /**
     * Example test method that depends on another test
     */
    @Test(dependsOnMethods = {"highPriorityTest"})
    public void dependentTest() {
        System.out.println("Running dependent test");
        // This test will only run if highPriorityTest passes
    }
}
