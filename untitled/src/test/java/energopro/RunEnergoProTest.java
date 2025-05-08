package energopro;

public class RunEnergoProTest {
    public static void main(String[] args) {
        System.out.println("Starting test...");
        EnergoProContactTest test = new EnergoProContactTest();
        try {
            // Initialize the test
            test.setUp();
            
            // Run the test method
            System.out.println("Running checkPhoneNumberSelenium test...");
            test.checkPhoneNumberSelenium();
            
            // Clean up
            test.tearDown();
            
            System.out.println("Test completed successfully!");
        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
