
package com.automation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class DataBankPage {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public DataBankPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ==================== LOCATORS ====================

    // Step 3 - Click and verify DATA BANK
    private final String dataBankButtonXpath = "//android.view.View[@content-desc=\"DATA BANK\"]";
    private final String dataBankHeadingXpath = "//android.view.View[@content-desc=\"DATA BANK\"]";

    // Test Case 1 - Specific Steps
    private final String packagesAndPricingXpath = "//XCUIElementTypeStaticText[@name=\"PACKAGES & PRICING\"]";
    private final String continueButtonXpath = "//XCUIElementTypeButton[@name=\"CONTINUE\"]";
    private final String checkboxXpath = "//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]";

    // Test Case 1 - Checkout Flow Steps (8-32)
    private final String bagPageXpath = "//XCUIElementTypeStaticText[@name=\"BAG\"]";
    private final String essentialEpigeneticsDropdownXpath = "//XCUIElementTypeImage[@name=\"Essential Epigenetics\"]";
    private final String proceedToCheckoutButtonXpath = "//XCUIElementTypeButton[@name=\"PROCEED TO CHECKOUT\"]";
    private final String checkoutPageXpath = "//XCUIElementTypeStaticText[@name=\"CHECKOUT\"]";
    private final String deliveryAddressXpath = "//XCUIElementTypeStaticText[@name=\"Delivery Address\"]";
    private final String nameFieldXpath = "//XCUIElementTypeTextField[@value=\"John Doe\"]";
    private final String confirmButtonXpath = "//XCUIElementTypeButton[@name=\"CONFIRM\"]";
    private final String genderDropdownXpath = "//XCUIElementTypeButton[@name=\"Gender\"]";
    private final String maleButtonXpath = "//XCUIElementTypeButton[@name=\"Male\"]";
    private final String countryCodeXpath = "//XCUIElementTypeStaticText[@name=\"🇦🇫 +93\"]";
    private final String countrySearchFieldXpath = "//XCUIElementTypeTextField";
    private final String phoneNumberFieldXpath = "//XCUIElementTypeTextField[@name=\"Phone Number\"]";
    private final String addressFieldXpath = "//XCUIElementTypeTextField[@name=\"Address *\"]";
    private final String cityFieldXpath = "//XCUIElementTypeTextField[@name=\"City *\"]";
    private final String countryDropdownXpath = "//XCUIElementTypeButton[@name=\"India\"]";
    private final String indiaButtonXpath = "//XCUIElementTypeButton[@name=\"India\"]";
    private final String postalCodeFieldXpath = "//XCUIElementTypeTextField[@name=\"Postal Code *\"]";
    private final String saveAddressButtonXpath = "//XCUIElementTypeButton[@name=\"SAVE ADDRESS\"]";
    private final String errorDialogXpath = "//XCUIElementTypeStaticText[@name=\"FIX THE FOLLOWING ERRORS\"]";

    private final String shippingMethodXpath = "//XCUIElementTypeStaticText[@name=\"Shipping Method\"]";
    private final String proceedToPaymentButtonXpath = "//XCUIElementTypeButton[@name=\"PROCEED TO PAYMENT\"]";
    private final String closeSheetXpath = "//XCUIElementTypeButton[@name=\"UIButton.Close\"]";
    private final String paymentErrorDialogXpath = "//XCUIElementTypeStaticText[@name=\"PAYMENT ERROR\"]";
    private final String paymentErrorMessageXpath = "//XCUIElementTypeStaticText[@name=\"Please try again later.\"]";
    private final String retryPaymentButtonXpath = "//XCUIElementTypeStaticText[@name=\"Retry Payment\"]";
    private final String paymentPageButtonXpath = "//XCUIElementTypeButton[@name=\"pay_with_link_button\"]";

    // Test Case 2 - Specific Steps
    private final String uploadDataXpath = "//XCUIElementTypeStaticText[@name=\"UPLOAD DATA\"]";
    private final String uploadReportButtonXpath = "//XCUIElementTypeButton[@name=\"UPLOAD REPORT\"]";
    // iOS XPaths for upload failed dialog and message
    private final String uploadFailedDialogXpath = "//XCUIElementTypeStaticText[@name=\"UPLOAD FAILED\"]";
    private final String uploadFailedMessageXpath = "//XCUIElementTypeStaticText[@name=\"Wrong file type chosen. Only allowed type is pdf.\"]";
    private final String okButtonXpath = "//XCUIElementTypeButton[@name=\"OK\"]";
    private final String uploadSuccessfulDialogXpath = "//XCUIElementTypeStaticText[@name=\"UPLOAD SUCCESSFUL\"]";
    private final String uploadSuccessMessageXpath = "//XCUIElementTypeStaticText[@name=\"Your document has been successfully uploaded.\"]";
    private final String removeButtonXpath = "//XCUIElementTypeApplication[@name=\"AB Chopra\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeImage[2]";
    private final String areYouSureDialogXpath = "//XCUIElementTypeStaticText[@name=\"ARE YOU SURE?\"]";
    private final String yesButtonXpath = "//XCUIElementTypeButton[@name=\"YES\"]";
    private final String deleteSuccessfulDialogXpath = "//XCUIElementTypeStaticText[@name=\"DELETE SUCCESSFUL\"]";
    private final String deleteSuccessMessageXpath = "//XCUIElementTypeStaticText[@name=\"Your report has been successfully removed.\"]";

    // Test Case 3 - Specific Steps
    private final String devicesXpath = "//XCUIElementTypeStaticText[@name=\"DEVICES\"]";
    private final String linkDeviceButtonXpath = "//XCUIElementTypeButton[@name=\"LINK DEVICE\"]";
    private final String ultrahumanButtonXpath = "//XCUIElementTypeStaticText[@name=\"ULTRAHUMAN\"]";
    private final String connectWithUltrahumanDialogXpath = "//XCUIElementTypeStaticText[@name=\"CONNECT WITH ULTRAHUMAN\"]";
    private final String emailFieldXpath = "//XCUIElementTypeTextField[@name=\"Ultrahuman Email\"]";
    private final String scrollViewXpath = "//XCUIElementTypeScrollView";
    private final String verifyButtonXpath = "//XCUIElementTypeButton[@name=\"VERIFY\"]";
    private final String invalidEmailDialogXpath = "//XCUIElementTypeStaticText[@name=\"INVALID EMAIL ID\"]";
    private final String deviceLinkedDialogXpath = "//XCUIElementTypeStaticText[@name=\"DEVICE LINKED\"]";
    private final String deviceLinkedMessageXpath = "//XCUIElementTypeStaticText[@name=\"Your device has been successfully linked.\"]";

    // Test Case 4 - Specific Steps
    // Test Case 4 - Step 4: Click REPORTS
    private final String reportsXpath = "//XCUIElementTypeStaticText[@name=\"REPORTS\"]";
    // Step 5: Click BLOOD REPORT and verify page
    private final String bloodReportXpath = "//XCUIElementTypeStaticText[@name=\"BLOOD REPORT\"]";
    // Step 16: Click DNA REPORT and verify page
    private final String dnaReportXpath = "//XCUIElementTypeStaticText[@name=\"DNA REPORT\"]";
    // Step 20: Click DEVICE REPORT and verify page
    private final String deviceReportXpath = "//XCUIElementTypeStaticText[@name=\"DEVICE REPORT\"]";
    // Step 6: Priority filters
    private final String highPriorityButtonXpath = "//XCUIElementTypeStaticText[@name=\"HIGH PRIORITY\"]";
    private final String mediumPriorityButtonXpath = "//XCUIElementTypeStaticText[@name=\"MEDIUM PRIORITY\"]";
    private final String lowPriorityButtonXpath = "//XCUIElementTypeStaticText[@name=\"LOW PRIORITY\"]";
    // Step 7: RENAL dropdown
    private final String renalDropdownXpath = "//XCUIElementTypeImage[@name=\"RENAL\"]";
    // Step 8: Creatinine High Priority
    private final String creatinineHighPriorityXpath = "//XCUIElementTypeImage[@name=\"CREATININE High Priority\"]";
    // Step 9: Bun Medium Priority
    private final String bunMediumPriorityXpath = "//XCUIElementTypeImage[@name=\"BUN Medium Priority\"]";
    // Step 10: Bun/creatinine Low Priority
    private final String bunCreatinineLowPriorityXpath = "//XCUIElementTypeImage[@name=\"BUN/CREATININE Low Priority\"]";
    // Step 12: Priority items for deselect
    private final String bunSimpleXpath = "//XCUIElementTypeImage[@name=\"BUN\"]";
    private final String creatinineSimpleXpath = "//XCUIElementTypeImage[@name=\"CREATININE\"]";
    private final String bunCreatinineSimpleXpath = "//XCUIElementTypeImage[@name=\"BUN/CREATININE\"]";
    private final String egfrMediumPriorityXpath = "//XCUIElementTypeImage[@name=\"EGFR Medium Priority\"]";
    private final String egfrSimpleXpath = "//XCUIElementTypeImage[@name=\"EGFR\"]";
    // Step 13: Swipe up once
    private final String swipeUpScrollViewXpath = "//XCUIElementTypeApplication[@name=\"AB Chopra\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeScrollView";
    // Step 14: Click back button once
    private final String backButtonXpath = "//XCUIElementTypeButton";
    // Step 15, 19: Click REPORTS again (reuse reportsXpath)
    // Step 17: PURCHASE button
    private final String purchaseButtonXpath = "//XCUIElementTypeButton[@name=\"PURCHASE\"]";
    // Step 17: PACKAGES & PRICING page
    private final String packagesAndPricingPageXpath = "//XCUIElementTypeStaticText[@name=\"PACKAGES & PRICING\"]";
    // Step 18: Click back button twice
    private final String backButtonTwiceXpath = "//XCUIElementTypeApplication[@name=\"AB Chopra\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton";
    // Step 6-13: All other XPaths for priority and verification updated as above.

    // ==================== COMMON STEP 3 ====================

    /**
     * COMMON STEP 3 FOR ALL 4 TEST CASES:
     * Click "DATA BANK" and verify it's displayed
     */
    public void clickAndVerifyDataBank() {
        try {
            // Click DATA BANK button
            WebElement dataBankButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(dataBankButtonXpath)));
            dataBankButton.click();
            System.out.println("✓ Step 3: Clicked 'DATA BANK' button");

            // Verify DATA BANK heading is displayed
            WebElement dataBankHeading = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(dataBankHeadingXpath)));

            if (dataBankHeading.isDisplayed()) {
                System.out.println("✓ Step 3: Verified 'DATA BANK' heading is displayed");
            } else {
                throw new RuntimeException("DATA BANK heading is not displayed");
            }

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to navigate to/verify Data Bank in Step 3", e);
        }
    }

    // ==================== TEST CASE 1 SPECIFIC METHODS ====================

    /**
     * TEST CASE 1 - STEP 4:
     * Click "PACKAGES & PRICING"
     */
    public void clickPackagesAndPricing() {
        try {
            WebElement packagesAndPricing = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(packagesAndPricingXpath)));
            packagesAndPricing.click();
            System.out.println("✓ Step 4: Clicked 'PACKAGES & PRICING'");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click PACKAGES & PRICING in Step 4", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 5 & 7:
     * Click "CONTINUE" button
     */
    public void clickContinueButton() {
        try {
            WebElement continueButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(continueButtonXpath)));
            continueButton.click();
            System.out.println("✓ Clicked 'CONTINUE' button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click CONTINUE button", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 6:
     * Click the checkbox
     */
    public void clickCheckbox() {
        try {
            WebElement checkbox = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(checkboxXpath)));
            checkbox.click();
            System.out.println("✓ Step 6: Clicked checkbox");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click checkbox in Step 6", e);
        }
    }

    // ==================== TEST CASE 2 SPECIFIC METHODS ====================

    /**
     * TEST CASE 2 - STEP 4:
     * Click "UPLOAD DATA"
     */
    public void clickUploadData() {
        try {
            WebElement uploadData = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(uploadDataXpath)));
            uploadData.click();
            System.out.println("✓ Step 4: Clicked 'UPLOAD DATA'");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click UPLOAD DATA in Step 4", e);
        }
    }

    /**
     * TEST CASE 2 - STEP 5:
     * Click "UPLOAD REPORT" button
     */
    public void clickUploadReportButton() {
        try {
            WebElement uploadReportButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(uploadReportButtonXpath)));
            uploadReportButton.click();
            System.out.println("✓ Step 5: Clicked 'UPLOAD REPORT' button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click UPLOAD REPORT button in Step 5", e);
        }
    }

    /**
     * TEST CASE 2 - STEP 8:
     * Upload wrong format file (JPG instead of PDF)
     * Uses Android file picker to select the file
     */
    public void uploadWrongFormatFile() {
        try {
            // Wait for file picker to open
            Thread.sleep(3000);

            System.out.println("✓ Step 8: Navigating Android file picker to select JPG file");

            // Click on the menu/hamburger icon to show storage options (if needed)
            try {
                WebElement menuButton = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//android.widget.ImageButton[@content-desc='Show roots']")));
                menuButton.click();
                Thread.sleep(1000);
                System.out.println("  - Opened storage menu");
            } catch (Exception e) {
                System.out.println("  - Storage menu already open or not needed");
            }

            // Select "Internal storage" or device name
            try {
                WebElement internalStorage = wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                        "//android.widget.TextView[contains(@text, 'Internal') or contains(@text, '24116RNC1I')]")));
                internalStorage.click();
                Thread.sleep(1000);
                System.out.println("  - Selected Internal storage");
            } catch (Exception e) {
                System.out.println("  - Already in Internal storage");
            }

            // Navigate to Download folder
            WebElement downloadFolder = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Download']")));
            downloadFolder.click();
            Thread.sleep(1000);
            System.out.println("  - Opened Download folder");

            // Click Download folder again to navigate deeper
            WebElement downloadFolderAgain = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Download']")));
            downloadFolderAgain.click();
            Thread.sleep(1000);
            System.out.println("  - Opened Download folder again");

            // Select the JPEG file
            WebElement jpegFile = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//android.widget.TextView[contains(@text, 'images.jpeg') or @text='images.jpeg']")));
            jpegFile.click();
            Thread.sleep(1000);
            System.out.println(
                    "✓ Step 8: Selected JPEG file - images.jpeg from Download folder");

        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during file upload in Step 8", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to navigate file picker or select file in Step 8", e);
        }
    }

    /**
     * TEST CASE 2 - STEP 9:
     * Validate UPLOAD FAILED dialog is shown and capture error message
     * 
     * @return The error message displayed in the dialog
     */
    public String validateUploadFailedDialog() {
        try {
            // Verify UPLOAD FAILED dialog is displayed
            WebElement uploadFailedDialog = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(uploadFailedDialogXpath)));

            if (uploadFailedDialog.isDisplayed()) {
                System.out.println("✓ Step 9: UPLOAD FAILED dialog is displayed");
            } else {
                throw new RuntimeException("UPLOAD FAILED dialog is not displayed");
            }

            // Capture the error message
            WebElement errorMessage = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(uploadFailedMessageXpath)));

            String message = errorMessage.getAttribute("content-desc");
            System.out.println("✓ Step 9: Error message captured: " + message);
            return message;

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to validate UPLOAD FAILED dialog in Step 9", e);
        }
    }

    /**
     * TEST CASE 2 - STEP 10 & 15:
     * Click OK button (used after both failed and successful upload dialogs)
     */
    public void clickOkButton() {
        try {
            WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='OK']")));
            okButton.click();
            System.out.println("✓ Clicked 'OK' button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click OK button", e);
        }
    }

    /**
     * TEST CASE 2 - STEP 12:
     * Upload correct format file (PDF)
     * Navigates through file picker to select PM0140.pdf from Download folder
     */
    public void uploadCorrectFormatFile() {
        try {
            // Wait for iOS Files picker to open
            Thread.sleep(2000);
            System.out.println("✓ Step 12: iOS Files picker opened");

            // 1. Detect and tap "iCloud Drive" or tap "Browse" then "iCloud Drive"
            boolean iCloudTapped = false;
            try {
                WebElement iCloud = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeCell' AND (label CONTAINS 'iCloud Drive' OR name CONTAINS 'iCloud Drive')")));
                iCloud.click();
                System.out.println("✓ Step 12: Tapped 'iCloud Drive'");
                iCloudTapped = true;
            } catch (TimeoutException e) {
                // Try tapping Browse, then iCloud Drive
                try {
                    WebElement browse = wait.until(ExpectedConditions.elementToBeClickable(
                        MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND (label CONTAINS 'Browse' OR name CONTAINS 'Browse')")));
                    browse.click();
                    System.out.println("✓ Step 12: Tapped 'Browse'");
                    Thread.sleep(1000);
                    WebElement iCloud = wait.until(ExpectedConditions.elementToBeClickable(
                        MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeCell' AND (label CONTAINS 'iCloud Drive' OR name CONTAINS 'iCloud Drive')")));
                    iCloud.click();
                    System.out.println("✓ Step 12: Tapped 'iCloud Drive' after Browse");
                    iCloudTapped = true;
                } catch (TimeoutException | InterruptedException e2) {
                    throw new RuntimeException("Could not find 'iCloud Drive' or 'Browse' in Files picker", e2);
                }
            }

            // 2. Open the "Appium" folder (label CONTAINS, no scrolling)
            try {
                WebElement appiumFolder = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeCell' AND (label CONTAINS 'Appium' OR name CONTAINS 'Appium')")));
                appiumFolder.click();
                System.out.println("✓ Step 12: Opened 'Appium' folder");
            } catch (TimeoutException e) {
                throw new RuntimeException("Appium folder not found in iCloud Drive", e);
            }

            // 3. Select the PDF file containing 'PM0140' (case-insensitive, no scrolling)
            try {
                WebElement pdfFile = wait.until(ExpectedConditions.elementToBeClickable(
                    MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeCell' AND ((label CONTAINS[c] 'PM0140') OR (name CONTAINS[c] 'PM0140'))")));
                pdfFile.click();
                System.out.println("✓ Step 12: Selected file containing 'PM0140'");
            } catch (TimeoutException e) {
                throw new RuntimeException("File containing 'PM0140' not found in Appium folder", e);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during iOS file picker step 12", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to select PM0140.pdf in iOS file picker step 12", e);
        }
    }

    /**
     * TEST CASE 2 - STEP 13 & 14:
     * Validate UPLOAD SUCCESSFUL dialog is shown and capture success message
     * 
     * @return The success message displayed in the dialog
     */
    public String validateUploadSuccessfulDialog() {
        try {
            // Wait for UPLOAD SUCCESSFUL dialog (exact xpath)
            WebElement uploadSuccessDialog = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='UPLOAD SUCCESSFUL']")));
            if (uploadSuccessDialog.isDisplayed()) {
                System.out.println("✓ Step 13: UPLOAD SUCCESSFUL dialog is displayed");
            } else {
                throw new RuntimeException("UPLOAD SUCCESSFUL dialog is not displayed");
            }
            // Capture the success message (exact xpath)
            WebElement successMessage = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='Your document has been successfully uploaded.']")));
            String message = successMessage.getText();
            System.out.println("✓ Step 14: Success message captured: " + message);
            return message;
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to validate UPLOAD SUCCESSFUL dialog in Step 13/14", e);
        }
    }

    /**
     * TEST CASE 2 - STEP 16:
     * Click remove button and verify "ARE YOU SURE?" dialog is displayed
     */
    public void clickRemoveAndVerifyAreYouSureDialog() {
        try {
            // Click remove button (exact xpath)
            WebElement removeButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeApplication[@name='AB Chopra']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeImage[2]")));
            removeButton.click();
            System.out.println("✓ Step 16: Clicked remove button");
            // Verify ARE YOU SURE? dialog is displayed (exact xpath)
            WebElement areYouSureDialog = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='ARE YOU SURE?']")));
            if (areYouSureDialog.isDisplayed()) {
                System.out.println("✓ Step 16: ARE YOU SURE? dialog is displayed");
            } else {
                throw new RuntimeException("ARE YOU SURE? dialog is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click remove button or verify ARE YOU SURE? dialog in Step 16", e);
        }
    }

    /**
     * TEST CASE 2 - STEP 17:
     * Click YES button and verify DELETE SUCCESSFUL dialog is displayed
     */
    public void clickYesAndVerifyDeleteSuccessfulDialog() {
        try {
            // Click YES button (exact xpath)
            WebElement yesButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name='YES']")));
            yesButton.click();
            System.out.println("✓ Step 17: Clicked YES button");
            // Verify DELETE SUCCESSFUL dialog is displayed (exact xpath)
            WebElement deleteSuccessDialog = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='DELETE SUCCESSFUL']")));
            if (deleteSuccessDialog.isDisplayed()) {
                System.out.println("✓ Step 17: DELETE SUCCESSFUL dialog is displayed");
            } else {
                throw new RuntimeException("DELETE SUCCESSFUL dialog is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click YES button or verify DELETE SUCCESSFUL dialog in Step 17", e);
        }
    }

    /**
     * TEST CASE 2 - STEP 18:
     * Capture the delete success message at runtime
     * 
     * @return The delete success message displayed in the dialog
     */
    public String captureDeleteSuccessMessage() {
        try {
            // Capture the success message (exact xpath)
            WebElement successMessage = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name='Your report has been successfully removed.']")));
            String message = successMessage.getText();
            System.out.println("✓ Step 18: Delete success message captured: " + message);
            return message;
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to capture delete success message in Step 18", e);
        }
    }

    // ==================== TEST CASE 3 SPECIFIC METHODS ====================

    /**
     * TEST CASE 3 - STEP 4:
     * Click "DEVICES"
     */
    public void clickDevices() {
        try {
            WebElement devices = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(devicesXpath)));
            devices.click();
            System.out.println("✓ Step 4: Clicked 'DEVICES'");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click DEVICES in Step 4", e);
        }
    }

    /**
     * TEST CASE 3 - STEP 5 (also used in Step 14):
     * Click "LINK DEVICE" button
     */
    public void clickLinkDeviceButton() {
        try {
            WebElement linkDeviceButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(linkDeviceButtonXpath)));
            linkDeviceButton.click();
            System.out.println("✓ Clicked 'LINK DEVICE' button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click LINK DEVICE button", e);
        }
    }

    /**
     * TEST CASE 3 - NEW STEP 6:
     * Click "ULTRAHUMAN" button
     */
    public void clickUltrahumanButton() {
        try {
            WebElement ultrahumanButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(ultrahumanButtonXpath)));
            ultrahumanButton.click();
            System.out.println("✓ Clicked 'ULTRAHUMAN' button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click ULTRAHUMAN button", e);
        }
    }

    /**
     * TEST CASE 3 - STEP 8:
     * Verify "CONNECT WITH ULTRAHUMAN" dialog is displayed
     */
    public void verifyConnectWithUltrahumanDialog() {
        try {
            WebElement dialog = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(connectWithUltrahumanDialogXpath)));

            if (dialog.isDisplayed()) {
                System.out.println("✓ Step 8: CONNECT WITH ULTRAHUMAN dialog is displayed");
            } else {
                throw new RuntimeException("CONNECT WITH ULTRAHUMAN dialog is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to verify CONNECT WITH ULTRAHUMAN dialog in Step 8", e);
        }
    }

    /**
     * TEST CASE 3 - STEP 9:
     * Enter invalid email in the email field
     * 
     * @param email The invalid email to enter
     */
    public void enterInvalidEmail(String email) {
        try {
            // Click, clear, and send keys to email field
            WebElement emailField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(emailFieldXpath)));
            emailField.click();
            emailField.clear();
            emailField.sendKeys(email);
            System.out.println("✓ Step 9: Entered invalid email: " + email);

            // Click on ScrollView to dismiss keyboard
            WebElement scrollView = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(scrollViewXpath)));
            scrollView.click();
            System.out.println("✓ Step 9: Clicked ScrollView");

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to enter invalid email in Step 9", e);
        }
    }

    /**
     * TEST CASE 3 - STEP 18:
     * Enter valid email in the email field
     * 
     * @param email The valid email to enter
     */
    public void enterValidEmail(String email) {
        try {
            // Click, clear, and send keys to email field
            WebElement emailField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(emailFieldXpath)));
            emailField.click();
            emailField.clear();
            emailField.sendKeys(email);
            System.out.println("✓ Step 18: Entered valid email: " + email);

            // Click on ScrollView to dismiss keyboard
            WebElement scrollView = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(scrollViewXpath)));
            scrollView.click();
            System.out.println("✓ Step 18: Clicked ScrollView");

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to enter valid email in Step 18", e);
        }
    }

    /**
     * TEST CASE 3 - STEP 10 & 19:
     * Click "VERIFY" button
     */
    public void clickVerifyButton() {
        try {
            WebElement verifyButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(verifyButtonXpath)));
            verifyButton.click();
            System.out.println("✓ Clicked 'VERIFY' button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click VERIFY button", e);
        }
    }

    /**
     * TEST CASE 3 - STEP 11 & 12:
     * Validate INVALID EMAIL ID dialog is shown and capture error message
     * 
     * @return The error message displayed in the dialog
     */
    public String validateInvalidEmailDialog() {
        try {
            // Verify INVALID EMAIL ID dialog is displayed
            WebElement invalidEmailDialog = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(invalidEmailDialogXpath)));

            if (invalidEmailDialog.isDisplayed()) {
                System.out.println("✓ Step 11: INVALID EMAIL ID dialog is displayed");
            } else {
                throw new RuntimeException("INVALID EMAIL ID dialog is not displayed");
            }

            // Capture the error message (the dialog itself contains the message)
            String message = invalidEmailDialog.getAttribute("content-desc");
            System.out.println("✓ Step 12: Error message captured: " + message);
            return message;

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to validate INVALID EMAIL ID dialog in Step 11/12", e);
        }
    }

    /**
     * TEST CASE 3 - STEP 20 & 21:
     * Validate DEVICE LINKED dialog is shown and capture success message
     * 
     * @return The success message displayed in the dialog
     */
    public String validateDeviceLinkedDialog() {
        try {
            // Verify DEVICE LINKED dialog is displayed
            WebElement deviceLinkedDialog = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(deviceLinkedDialogXpath)));

            if (deviceLinkedDialog.isDisplayed()) {
                System.out.println("✓ Step 20: DEVICE LINKED dialog is displayed");
            } else {
                throw new RuntimeException("DEVICE LINKED dialog is not displayed");
            }

            // Capture the success message
            WebElement successMessage = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(deviceLinkedMessageXpath)));

            String message = successMessage.getAttribute("content-desc");
            System.out.println("✓ Step 21: Success message captured: " + message);
            return message;

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to validate DEVICE LINKED dialog in Step 20/21", e);
        }
    }

    // ==================== TEST CASE 4 SPECIFIC METHODS ====================

    /**
     * TEST CASE 4 - STEP 4, 8, 12:
     * Click "REPORTS"
     */
    public void clickReports() {
        try {
            WebElement reports = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(reportsXpath)));
            reports.click();
            System.out.println("✓ Clicked 'REPORTS'");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click REPORTS", e);
        }
    }

    /**
     * TEST CASE 4 - STEP 5:
     * Click "BLOOD REPORT" and verify page is displayed
     */
    public void clickAndVerifyBloodReport() {
        try {
            // Click BLOOD REPORT
            WebElement bloodReport = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(bloodReportXpath)));
            bloodReport.click();
            System.out.println("✓ Step 5: Clicked 'BLOOD REPORT'");

            // Verify BLOOD REPORT page is displayed
            WebElement bloodReportPage = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(bloodReportXpath)));

            if (bloodReportPage.isDisplayed()) {
                System.out.println("✓ Step 5: Verified 'BLOOD REPORT' page is displayed");
            } else {
                throw new RuntimeException("BLOOD REPORT page is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click/verify BLOOD REPORT in Step 5", e);
        }
    }

    /**
     * TEST CASE 4 - STEP 9:
     * Click "DNA REPORT" and verify page is displayed
     */
    public void clickAndVerifyDnaReport() {
        try {
            // Click DNA REPORT
            WebElement dnaReport = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(dnaReportXpath)));
            dnaReport.click();
            System.out.println("✓ Step 9: Clicked 'DNA REPORT'");

            // Verify DNA REPORT page is displayed
            WebElement dnaReportPage = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(dnaReportXpath)));

            if (dnaReportPage.isDisplayed()) {
                System.out.println("✓ Step 9: Verified 'DNA REPORT' page is displayed");
            } else {
                throw new RuntimeException("DNA REPORT page is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click/verify DNA REPORT in Step 9", e);
        }
    }

    /**
     * TEST CASE 4 - STEP 13:
     * Click "DEVICE REPORT" and verify page is displayed
     */
    public void clickAndVerifyDeviceReport() {
        try {
            // Click DEVICE REPORT
            WebElement deviceReport = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(deviceReportXpath)));
            deviceReport.click();
            System.out.println("✓ Step 13: Clicked 'DEVICE REPORT'");

            // Verify DEVICE REPORT page is displayed
            WebElement deviceReportPage = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(deviceReportXpath)));

            if (deviceReportPage.isDisplayed()) {
                System.out.println("✓ Step 13: Verified 'DEVICE REPORT' page is displayed");
            } else {
                throw new RuntimeException("DEVICE REPORT page is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click/verify DEVICE REPORT in Step 13", e);
        }
    }

    /**
     * TEST CASE 4 - STEP 6:
     * Click "UPLOAD REPORT" button and verify UPLOAD DATA page is displayed
     */
    public void clickUploadReportAndVerifyUploadDataPage() {
        try {
            // Click UPLOAD REPORT button
            WebElement uploadReportButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"UPLOAD REPORT\"]")));
            uploadReportButton.click();
            System.out.println("✓ Step 6: Clicked 'UPLOAD REPORT' button");

            // Verify UPLOAD DATA page is displayed
            WebElement uploadDataPage = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"UPLOAD DATA\"]")));

            if (uploadDataPage.isDisplayed()) {
                System.out.println("✓ Step 6: Verified 'UPLOAD DATA' page is displayed");
            } else {
                throw new RuntimeException("UPLOAD DATA page is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click UPLOAD REPORT or verify UPLOAD DATA page in Step 6", e);
        }
    }

    /**
     * TEST CASE 4 - STEP 10:
     * Click "EPIGENETIC MAPPING" button and verify PACKAGES & PRICING page is
     * displayed
     */
    public void clickEpigeneticMappingAndVerifyPackagesPage() {
        try {
            // Click EPIGENETIC MAPPING button
            WebElement epigeneticMappingButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"EPIGENETIC MAPPING\"]")));
            epigeneticMappingButton.click();
            System.out.println("✓ Step 10: Clicked 'EPIGENETIC MAPPING' button");

            // Verify PACKAGES & PRICING page is displayed
            WebElement packagesPage = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"PACKAGES & PRICING\"]")));

            if (packagesPage.isDisplayed()) {
                System.out.println("✓ Step 10: Verified 'PACKAGES & PRICING' page is displayed");
            } else {
                throw new RuntimeException("PACKAGES & PRICING page is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException(
                    "Failed to click EPIGENETIC MAPPING or verify PACKAGES & PRICING page in Step 10", e);
        }
    }

    /**
     * TEST CASE 4 - STEP 7, 11, 14:
     * Click back button (can be called multiple times)
     */
    public void clickBackButton() {
        try {
            WebElement backButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(backButtonXpath)));
            backButton.click();
            System.out.println("✓ Clicked back button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click back button", e);
        }
    }

    /**
     * TEST CASE 4 - STEP 7, 11, 14:
     * Click back button twice
     */
    public void clickBackButtonTwice() {
        try {
            // First click
            WebElement backButton1 = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(backButtonXpath)));
            backButton1.click();
            System.out.println("✓ Clicked back button (1st time)");

            Thread.sleep(500); // Small delay between clicks

            // Second click
            WebElement backButton2 = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(backButtonXpath)));
            backButton2.click();
            System.out.println("✓ Clicked back button (2nd time)");

        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during back button clicks", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click back button twice", e);
        }
    }

    /**
     * TEST CASE 4 - NEW STEP 6:
     * Click HIGH PRIORITY filter button
     */
    public void clickHighPriority() {
        try {
            WebElement highPriority = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(highPriorityButtonXpath)));
            highPriority.click();
            System.out.println("✓ Clicked 'HIGH PRIORITY' filter");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click HIGH PRIORITY filter", e);
        }
    }

    /**
     * TEST CASE 4 - NEW STEP 6:
     * Click MEDIUM PRIORITY filter button
     */
    public void clickMediumPriority() {
        try {
            WebElement mediumPriority = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(mediumPriorityButtonXpath)));
            mediumPriority.click();
            System.out.println("✓ Clicked 'MEDIUM PRIORITY' filter");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click MEDIUM PRIORITY filter", e);
        }
    }

    /**
     * TEST CASE 4 - NEW STEP 6:
     * Click LOW PRIORITY filter button
     */
    public void clickLowPriority() {
        try {
            WebElement lowPriority = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(lowPriorityButtonXpath)));
            lowPriority.click();
            System.out.println("✓ Clicked 'LOW PRIORITY' filter");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click LOW PRIORITY filter", e);
        }
    }

    /**
     * TEST CASE 4 - NEW STEP 7:
     * Click RENAL dropdown
     */
    public void clickRenalDropdown() {
        try {
            WebElement renalDropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(renalDropdownXpath)));
            renalDropdown.click();
            System.out.println("✓ Clicked 'RENAL' dropdown");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click RENAL dropdown", e);
        }
    }

    /**
     * TEST CASE 4 - NEW STEP 8:
     * Click HIGH PRIORITY filter and verify Creatinine High Priority is shown
     */
    public void clickHighPriorityAndVerifyCreatinine() {
        try {
            // Click HIGH PRIORITY filter
            WebElement highPriority = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(highPriorityButtonXpath)));
            highPriority.click();
            System.out.println("✓ Clicked 'HIGH PRIORITY' filter");

            // Wait for UI to update after filter click
            Thread.sleep(1000);

            // Find any XCUIElementTypeImage with name or label containing 'CREATININE' and 'High Priority'
            List<WebElement> images = driver.findElements(By.xpath("//XCUIElementTypeImage"));
            boolean found = false;
            for (WebElement el : images) {
                String name = el.getAttribute("name");
                String label = el.getAttribute("label");
                if ((name != null && name.replace("\\n", " ").toLowerCase().contains("creatinine") && name.toLowerCase().contains("high priority")) ||
                    (label != null && label.replace("\\n", " ").toLowerCase().contains("creatinine") && label.toLowerCase().contains("high priority"))) {
                    System.out.println("[FOUND] XCUIElementTypeImage with name: '" + name + "', label: '" + label + "'");
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new RuntimeException("No XCUIElementTypeImage found with 'CREATININE' and 'High Priority' in name or label after clicking HIGH PRIORITY");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click HIGH PRIORITY", e);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during HIGH PRIORITY verification", e);
        }
    }

    /**
     * TEST CASE 4 - NEW STEP 9:
     * Click MEDIUM PRIORITY filter and verify Bun Medium Priority is shown
     */
    public void clickMediumPriorityAndVerifyBun() {
        try {
            // Click MEDIUM PRIORITY filter
            WebElement mediumPriority = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(mediumPriorityButtonXpath)));
            mediumPriority.click();
            System.out.println("✓ Clicked 'MEDIUM PRIORITY' filter");

            // Wait for UI to update after filter click
            Thread.sleep(1000);

            // Try to find element by name or label with newline
            String bunMediumPriorityXpathNewline = "//XCUIElementTypeImage[contains(@name, 'BUN') and contains(@name, 'Medium Priority')]";
            List<WebElement> candidates = driver.findElements(By.xpath(bunMediumPriorityXpathNewline));
            WebElement bunMediumPriority = null;
            for (WebElement el : candidates) {
                String name = el.getAttribute("name");
                String label = el.getAttribute("label");
                if ((name != null && name.replaceAll("\\s+"," ").trim().equalsIgnoreCase("BUN Medium Priority")) ||
                    (label != null && label.replaceAll("\\s+"," ").trim().equalsIgnoreCase("BUN Medium Priority"))) {
                    bunMediumPriority = el;
                    break;
                }
            }
            if (bunMediumPriority != null && bunMediumPriority.isDisplayed()) {
                System.out.println("✓ Verified 'Bun Medium Priority' is displayed");
            } else {
                throw new RuntimeException("Bun Medium Priority is not displayed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during MEDIUM PRIORITY verification", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click MEDIUM PRIORITY or verify Bun Medium Priority", e);
        }
    }

    /**
     * TEST CASE 4 - NEW STEP 10:
     * Click LOW PRIORITY filter and verify Bun/creatinine Low Priority is shown
     */
    public void clickLowPriorityAndVerifyBunCreatinine() {
        try {
            // Click LOW PRIORITY filter
            WebElement lowPriority = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(lowPriorityButtonXpath)));
            lowPriority.click();
            System.out.println("✓ Clicked 'LOW PRIORITY' filter");

            // Wait for UI to update after filter click
            Thread.sleep(1000);

            // Try to find element by name or label with newline
            String bunCreatinineLowPriorityXpathNewline = "//XCUIElementTypeImage[contains(@name, 'BUN/CREATININE') and contains(@name, 'Low Priority')]";
            List<WebElement> candidates = driver.findElements(By.xpath(bunCreatinineLowPriorityXpathNewline));
            WebElement bunCreatinineLowPriority = null;
            for (WebElement el : candidates) {
                String name = el.getAttribute("name");
                String label = el.getAttribute("label");
                if ((name != null && name.replaceAll("\\s+"," ").trim().equalsIgnoreCase("BUN/CREATININE Low Priority")) ||
                    (label != null && label.replaceAll("\\s+"," ").trim().equalsIgnoreCase("BUN/CREATININE Low Priority"))) {
                    bunCreatinineLowPriority = el;
                    break;
                }
            }
            if (bunCreatinineLowPriority != null && bunCreatinineLowPriority.isDisplayed()) {
                System.out.println("✓ Verified 'Bun/creatinine Low Priority' is displayed");
            } else {
                throw new RuntimeException("Bun/creatinine Low Priority is not displayed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during LOW PRIORITY verification", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click LOW PRIORITY or verify Bun/creatinine Low Priority", e);
        }
    }

    /**
     * TEST CASE 4 - NEW STEP 12:
     * Click priority items twice to deselect them
     */
    public void clickPriorityItemsTwice() {
        try {
            // Helper to robustly click by name/label only (no xpath)
            java.util.function.Consumer<String> clickByNameOnly = (name) -> {
                try {
                    WebElement el = null;
                    String imgXpath = "//XCUIElementTypeImage";
                    for (WebElement candidate : driver.findElements(By.xpath(imgXpath))) {
                        String n = candidate.getAttribute("name");
                        String l = candidate.getAttribute("label");
                        if ((n != null && n.replaceAll("\\s+"," ").trim().equalsIgnoreCase(name)) ||
                            (l != null && l.replaceAll("\\s+"," ").trim().equalsIgnoreCase(name))) {
                            el = candidate;
                            break;
                        }
                    }
                    if (el == null) throw new RuntimeException("Element not found: " + name);
                    el.click();
                    System.out.println("✓ Clicked '" + name + "'");
                } catch (Exception e) {
                    throw new RuntimeException("Failed to click '" + name + "'", e);
                }
            };

            // 1st: Bun Medium Priority, then Bun
            clickByNameOnly.accept("BUN Medium Priority");
            Thread.sleep(1000);
            clickByNameOnly.accept("BUN");
            Thread.sleep(1000);

            // 2nd: Creatinine High Priority, then Creatinine
            clickByNameOnly.accept("CREATININE High Priority");
            Thread.sleep(1000);
            clickByNameOnly.accept("CREATININE");
            Thread.sleep(1000);

            // 3rd: Bun/creatinine Low Priority, then Bun/creatinine
            clickByNameOnly.accept("BUN/CREATININE Low Priority");
            Thread.sleep(1000);
            clickByNameOnly.accept("BUN/CREATININE");
            Thread.sleep(1000);

            // 4th: Egfr Medium Priority, then Egfr
            clickByNameOnly.accept("EGFR Medium Priority");
            Thread.sleep(1000);
            clickByNameOnly.accept("EGFR");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during priority items clicks", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click priority items twice", e);
        }
    }

    /**
     * TEST CASE 4 - NEW STEP 13:
     * Swipe up once to scroll the view
     */
    public void swipeUpOnce() {
        try {
            // Get screen dimensions
            int height = driver.manage().window().getSize().getHeight();
            int width = driver.manage().window().getSize().getWidth();

            // Calculate swipe coordinates (swipe from bottom to top, middle of screen)
            int startX = width / 2;
            int startY = (int) (height * 0.8); // Start at 80% of screen height
            int endY = (int) (height * 0.2); // End at 20% of screen height

            // Perform swipe using W3C Actions
            org.openqa.selenium.interactions.PointerInput finger = new org.openqa.selenium.interactions.PointerInput(
                    org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
            org.openqa.selenium.interactions.Sequence swipe = new org.openqa.selenium.interactions.Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(java.time.Duration.ofMillis(0),
                    org.openqa.selenium.interactions.PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(
                    finger.createPointerDown(org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(java.time.Duration.ofMillis(1000),
                    org.openqa.selenium.interactions.PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(
                    finger.createPointerUp(org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(java.util.Arrays.asList(swipe));
            System.out.println("✓ Swiped up once");

        } catch (Exception e) {
            throw new RuntimeException("Failed to swipe up", e);
        }
    }

    // ==================== TEST CASE 1 - CHECKOUT FLOW METHODS (STEPS 8-32)
    // ====================

    /**
     * TEST CASE 1 - STEP 8:
     * Verify BAG page is displayed
     */
    public void verifyBagPage() {
        try {
            WebElement bagPage = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(bagPageXpath)));

            if (bagPage.isDisplayed()) {
                System.out.println("✓ Step 8: BAG page is displayed");
            } else {
                throw new RuntimeException("BAG page is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to verify BAG page in Step 8", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 9:
     * Click Essential Epigenetics dropdown
     */
    public void clickEssentialEpigeneticsDropdown() {
        try {
            WebElement dropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(essentialEpigeneticsDropdownXpath)));
            dropdown.click();
            System.out.println("✓ Step 9: Clicked Essential Epigenetics dropdown");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click Essential Epigenetics dropdown in Step 9", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 10:
     * Click PROCEED TO CHECKOUT button
     */
    public void clickProceedToCheckoutButton() {
        try {
            WebElement proceedButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(proceedToCheckoutButtonXpath)));
            proceedButton.click();
            System.out.println("✓ Step 10: Clicked PROCEED TO CHECKOUT button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click PROCEED TO CHECKOUT button in Step 10", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 11:
     * Verify CHECKOUT page and Delivery Address are displayed
     */
    public void verifyCheckoutPage() {
        try {
            // Verify CHECKOUT page
            WebElement checkoutPage = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(checkoutPageXpath)));

            if (checkoutPage.isDisplayed()) {
                System.out.println("✓ Step 11: CHECKOUT page is displayed");
            } else {
                throw new RuntimeException("CHECKOUT page is not displayed");
            }

            // Verify Delivery Address
            WebElement deliveryAddress = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(deliveryAddressXpath)));

            if (deliveryAddress.isDisplayed()) {
                System.out.println("✓ Step 11: Delivery Address is displayed");
            } else {
                throw new RuntimeException("Delivery Address is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to verify CHECKOUT page in Step 11", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 12:
     * Click name field and fill with "Kathir"
     */
    public void fillNameField(String name) {
        try {
            WebElement nameField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(nameFieldXpath)));
            nameField.click();
            nameField.clear();
            nameField.sendKeys(name);
            System.out.println("✓ Step 12: Filled name field with: " + name);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to fill name field in Step 12", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 13 (First attempt with wrong DOB):
     * Click DOB field and set date using seekbars (swipe down once on each)
     */
    /**
     * TEST CASE 1 - STEP 13 (First attempt with wrong DOB):
     * Click DOB field and set date using robust swipe actions
     */
    public void fillDOBFieldWrong() {
        try {
            clickDateOfBirth();
            performDateSelection();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fill DOB field in Step 13", e);
        }
    }

    /**
     * Click the Date of Birth field (Text-independent locator)
     * Requirement: Always click the same element regardless of empty or filled
     * state.
     */
    /**
     * Click the Date of Birth field for STEP 13 (Wrong DOB)
     * Requirement: Uses the existing instance-based locator which is working.
     */
    public void clickDateOfBirth() {
        try {
            System.out.println("Step 13: Clicking DOB field using iOS XPath selector...");
            hideKeyboard();
            Thread.sleep(1000);

            // Use iOS locator from README: //XCUIElementTypeOther[@name="dd/mm/yyyy"]
            WebElement dobField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//XCUIElementTypeOther[@name='dd/mm/yyyy']")));
            dobField.click();
            System.out.println("✓ Step 13: DOB field clicked (iOS XPath)");

        } catch (Exception e) {
            throw new RuntimeException("CRITICAL: Failed Step 13 DOB click (iOS): " + e.getMessage(), e);
        }
    }

    /**
     * Click the Date of Birth field for STEP 22 (Correct DOB) using dynamic bounds.
     * Requirement: Step 22 fails with locators when populated.
     * This method locates the element by class+clickable+enabled, retrieves its
     * bounds,
     * calculates the center, and performs a tap. It is resolution-independent.
     */
    public void clickDobFieldDynamic() {
        int maxAttempts = 2;
        boolean success = false;
        Exception lastException = null;

        for (int i = 1; i <= maxAttempts; i++) {
            try {
                System.out.println("Step 22: Attempt " + i + " to click DOB field via dynamic bounds...");
                hideKeyboard();
                Thread.sleep(1500);

                // Locate clickable Views. DOB is typically the main clickable View in this
                // context.
                // We avoid text/index/fixed coordinates as requested.
                // Using UIAutomator to find clickable and enabled Views.
                List<WebElement> clickableViews = driver.findElements(AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.view.View\").clickable(true).enabled(true)"));

                if (clickableViews.isEmpty()) {
                    throw new RuntimeException("No clickable android.view.View found for DOB");
                }

                // In Step 22, the DOB field is a prominent clickable View.
                // If multiple exist, we target the one likely to be the input field.
                // For robustness across devices, we pick the one that has valid dimensions.
                WebElement dobField = null;
                for (WebElement v : clickableViews) {
                    String b = v.getAttribute("bounds");
                    if (b != null && b.contains("][")) {
                        dobField = v; // Found potential field
                        break;
                    }
                }

                if (dobField == null)
                    throw new RuntimeException("Could not identify DOB field from clickable views");

                // 2-3. Retrieve bounds dynamically and calculate center
                String bounds = dobField.getAttribute("bounds");
                Pattern p = Pattern.compile("\\[(\\d+),(\\d+)\\]\\[(\\d+),(\\d+)\\]");
                Matcher m = p.matcher(bounds);
                if (!m.find())
                    throw new RuntimeException("Failed to parse bounds: " + bounds);

                int x1 = Integer.parseInt(m.group(1));
                int y1 = Integer.parseInt(m.group(2));
                int x2 = Integer.parseInt(m.group(3));
                int y2 = Integer.parseInt(m.group(4));

                int centerX = (x1 + x2) / 2;
                int centerY = (y1 + y2) / 2;

                // 4. Perform tap using W3C Actions on calculated center
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence tap = new Sequence(finger, 1);
                tap.addAction(
                        finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
                tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(Collections.singletonList(tap));

                System.out.println("✓ Step 22: DOB field tapped via Dynamic Bounds " + bounds + " at (" + centerX + ", "
                        + centerY + ")");
                success = true;
                break;
            } catch (Exception e) {
                lastException = e;
                System.out.println("⚠ Attempt " + i + " failed: " + e.getMessage());
            }
        }

        if (!success) {
            throw new RuntimeException(
                    "CRITICAL: DOB field could not be clicked via dynamic bounds after " + maxAttempts + " attempts",
                    lastException);
        }
    }

    /**
     * ✅ PERFORM DATE SELECTION (SWIPE ACTIONS)
     * Swipes down on Day, Month, and Year SeekBars and clicks Confirm
     * Uses position-based XPath to work with any date (future-proof)
     */
    public void performDateSelection() {
        try {
            Thread.sleep(1000); // Wait for date picker to appear
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Dynamically find all visible date pickers (XCUIElementTypeOther with traits Adjustable)
            List<WebElement> pickers = driver.findElements(By.xpath("//XCUIElementTypeOther[contains(@traits,'Adjustable')]"));
            if (pickers.isEmpty()) {
                // Fallback: try all visible XCUIElementTypeOther with enabled=true and height > 100
                pickers = driver.findElements(By.xpath("//XCUIElementTypeOther[@enabled='true' and @visible='true' and @height>100]"));
            }
            int idx = 1;
            for (WebElement picker : pickers) {
                try {
                    swipeDown(picker);
                    Thread.sleep(500); // Wait for swipe animation
                    System.out.println("Successfully swiped date picker " + idx);
                } catch (Exception e) {
                    System.out.println("Could not swipe date picker at position: " + idx);
                }
                idx++;
            }

            // Click CONFIRM button (iOS)
            try {
                WebElement confirmBtn = shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//XCUIElementTypeButton[@name='CONFIRM']")));
                confirmBtn.click();
                System.out.println("Clicked CONFIRM button on date picker");
            } catch (Exception e) {
                System.out.println("CONFIRM button not found on date picker");
            }

        } catch (Exception e) {
            System.out.println("Error in performDateSelection: " + e.getMessage());
        }
    }

    /**
     * Helper method to swipe down on an element using W3C Actions
     */
    private void swipeDown(WebElement element) {
        try {
            int centerX = element.getRect().getX() + (element.getRect().getWidth() / 2);
            int startY = element.getRect().getY() + (element.getRect().getHeight() / 2);
            int endY = startY + 200; // Standard swipe

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(
                    finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));
        } catch (Exception e) {
            System.err.println("Swipe down failed: " + e.getMessage());
        }
    }

    /**
     * Helper method to swipe down on an element quickly
     */
    private void fastSwipe(WebElement element) {
        try {
            int centerX = element.getRect().getX() + (element.getRect().getWidth() / 2);
            int startY = element.getRect().getY() + (element.getRect().getHeight() / 2);
            int endY = startY + 300; // Longer swipe for speed

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(
                    finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));
        } catch (Exception e) {
            System.err.println("Fast swipe failed: " + e.getMessage());
        }
    }

    /**
     * Helper method to Tap on an element using W3C Actions (Force Click)
     */

    /**
     * Scroll Page Up (Finger Bottom -> Top)
     * Moves content UP, so we see content BELOW.
     */
    public void scrollPageUp() {
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int centerX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        performScroll(centerX, startY, endY);
    }

    /**
     * Scroll Page Down (Finger Top -> Bottom)
     * Moves content DOWN, so we see content ABOVE.
     */
    public void scrollPageDown() {
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int centerX = size.width / 2;
        int startY = (int) (size.height * 0.2);
        int endY = (int) (size.height * 0.8);
        performScroll(centerX, startY, endY);
    }

    private void performScroll(int centerX, int startY, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), centerX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    /**
     * TEST CASE 1 - STEP 13 (Gender selection):
     * Click gender dropdown and select Male
     */
    public void selectGender() {
        try {
            System.out.println("Step 13: Selecting gender...");
            hideKeyboard();
            Thread.sleep(1000);

            boolean genderClicked = false;
            try {
                WebElement genderElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//XCUIElementTypeButton[@name='Gender']")));
                genderElement.click();
                System.out.println("✓ Step 13: Gender button clicked (iOS)");
                Thread.sleep(500);
                genderClicked = true;
            } catch (Exception e) {
                System.out.println("Gender button not found, will click Male directly...");
            }

            if (genderClicked) {
                // Only click Male once if Gender was present
                WebElement maleButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//XCUIElementTypeButton[@name='Male']")));
                maleButton.click();
                System.out.println("✓ Step 13: Gender selection completed (Male, iOS)");
            } else {
                // If Gender not present, click Male twice
                WebElement maleButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//XCUIElementTypeButton[@name='Male']")));
                maleButton.click();
                System.out.println("✓ Step 13: Male option clicked (iOS)");
                WebElement maleButtonAgain = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//XCUIElementTypeButton[@name='Male']")));
                maleButtonAgain.click();
                System.out.println("✓ Step 13.1: Male option clicked again (iOS)");
            }

        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().contains("Gender selection failed")) {
                throw new RuntimeException(e.getMessage());
            }
            throw new RuntimeException("Failed to select gender in Step 13: " + e.getMessage(), e);
        }
    }

    /**
     * TEST CASE 1 - STEP 14:
     * Click country code, search for India, and select it
     */
    public void selectCountryCode() {
        long t0 = System.currentTimeMillis();
        try {
            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Step 14: Selecting country code (iOS, robust)");
            // 1. Click current country code (🇦🇫 +93), handle possible newline in name/label/value
            WebElement codeDropdown = null;
            String[] attrs = {"name", "label", "value"};
            boolean found = false;
            for (String attr : attrs) {
                try {
                    codeDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//XCUIElementTypeStaticText[contains(@" + attr + ", '🇦🇫') and contains(@" + attr + ", '+93')]")));
                    found = true;
                    System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Found country code by " + attr);
                    break;
                } catch (Exception e) {
                    // Try next attribute
                }
            }
            if (!found) {
                try {
                    List<WebElement> staticTexts = driver.findElements(By.className("XCUIElementTypeStaticText"));
                    for (WebElement el : staticTexts) {
                        String n = el.getAttribute("name");
                        String l = el.getAttribute("label");
                        String v = el.getAttribute("value");
                        if ((n != null && n.contains("🇦🇫") && n.contains("+93")) ||
                            (l != null && l.contains("🇦🇫") && l.contains("+93")) ||
                            (v != null && v.contains("🇦🇫") && v.contains("+93"))) {
                            codeDropdown = el;
                            found = true;
                            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Found country code by scan");
                            break;
                        }
                    }
                } catch (Exception e) {}
            }
            if (!found || codeDropdown == null) {
                System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Country code element (🇦🇫 +93) not found");
                throw new RuntimeException("Country code element (🇦🇫 +93) not found by any method");
            }
            codeDropdown.click();
            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Clicked country code dropdown");
            Thread.sleep(1200);

            // 2. Click search bar (XCUIElementTypeTextField)
            WebElement searchBar = null;
            try {
                searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeTextField")));
            } catch (Exception e) {
                searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.className("XCUIElementTypeTextField")));
            }
            searchBar.click();
            searchBar.clear();
            searchBar.sendKeys("India");
            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Typed 'India' in search bar");
            Thread.sleep(1500);

            // 3. Select India +91 (robust: handle newlines, case, partial match)
            WebElement indiaBtn = null;
            boolean indiaFound = false;
            String[] indiaAttrs = {"name", "label"};
            for (String attr : indiaAttrs) {
                try {
                    indiaBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//XCUIElementTypeButton[contains(translate(@" + attr + ", '\\n', ''), 'India') and contains(translate(@" + attr + ", '\\n', ''), '+91')]")));
                    indiaFound = true;
                    System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Found India +91 button by " + attr);
                    break;
                } catch (Exception e) {}
            }
            if (!indiaFound) {
                try {
                    List<WebElement> buttons = driver.findElements(By.className("XCUIElementTypeButton"));
                    for (WebElement btn : buttons) {
                        String n = btn.getAttribute("name");
                        String l = btn.getAttribute("label");
                        String check = (n != null ? n : "") + " " + (l != null ? l : "");
                        check = check.replace("\n", " ").toLowerCase();
                        if (check.contains("india") && check.contains("+91")) {
                            indiaBtn = btn;
                            indiaFound = true;
                            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Found India +91 button by scan");
                            break;
                        }
                    }
                } catch (Exception e) {}
            }
            if (!indiaFound || indiaBtn == null) {
                System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] India (+91) button not found");
                throw new RuntimeException("India (+91) button not found by any method");
            }
            indiaBtn.click();
            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Clicked India (+91) Button");
            Thread.sleep(1200);
        } catch (Exception e) {
            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] ERROR: " + e.getMessage());
            throw new RuntimeException("Failed to select country code (India +91): " + e.getMessage(), e);
        }
    }

    /**
     * TEST CASE 1 - STEP 15:
     * Click phone number field, fill it, and hide keyboard
     */
    public void fillPhoneNumber(String phoneNumber) {
        long t0 = System.currentTimeMillis();
        try {
            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Step 15: Filling phone number");
            WebElement phoneField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(phoneNumberFieldXpath)));
            phoneField.click();
            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Clicked phone number field");
            phoneField.clear();
            phoneField.sendKeys(phoneNumber);
            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] Filled phone number: " + phoneNumber);

            // Hide keyboard and log result
            try {
                hideKeyboard();
                System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] hideKeyboard() called after phone number");
            } catch (Exception e) {
                System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] hideKeyboard() failed: " + e.getMessage());
            }

        } catch (TimeoutException e) {
            System.out.println("[T=" + (System.currentTimeMillis()-t0) + "] ERROR: Failed to fill phone number");
            throw new RuntimeException("Failed to fill phone number in Step 15", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 16:
     * Click address field, fill it, and hide keyboard
     */
    public void fillAddress(String address) {
        try {
            WebElement addressField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(addressFieldXpath)));
            addressField.click();
            addressField.clear();
            addressField.sendKeys(address);
            System.out.println("✓ Step 16: Filled address: " + address);

            // Hide keyboard
            hideKeyboard();

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to fill address in Step 16", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 17:
     * Click city field, fill it, and hide keyboard
     */
    public void fillCity(String city) {
        try {
            WebElement cityField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(cityFieldXpath)));
            cityField.click();
            cityField.clear();
            cityField.sendKeys(city);
            System.out.println("✓ Step 17: Filled city: " + city);

            // Hide keyboard
            hideKeyboard();

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to fill city in Step 17", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 18:
     * Click country dropdown and select India
     */
    public void selectCountry() {
        try {
            // Click country dropdown
            WebElement countryDropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(countryDropdownXpath)));
            countryDropdown.click();
            System.out.println("✓ Step 18: Clicked country dropdown");

            Thread.sleep(500);

            // Click India button
            WebElement indiaButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(indiaButtonXpath)));
            indiaButton.click();
            System.out.println("✓ Step 18: Selected India");

        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during country selection in Step 18", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to select country in Step 18", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 19:
     * Click postal code field, fill with wrong code, and hide keyboard
     */
    public void fillPostalCodeWrong(String postalCode) {
        try {
            WebElement postalField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(postalCodeFieldXpath)));
            postalField.click();
            postalField.clear();
            postalField.sendKeys(postalCode);
            System.out.println("✓ Step 19: Filled postal code (wrong): " + postalCode);

            // Hide keyboard
            hideKeyboard();

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to fill postal code in Step 19", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 20:
     * Click SAVE ADDRESS button
     */
    public void clickSaveAddressButton() {
        try {
            WebElement saveButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(saveAddressButtonXpath)));
            saveButton.click();
            System.out.println("✓ Step 20: Clicked SAVE ADDRESS button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click SAVE ADDRESS button in Step 20", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 21:
     * Verify error dialog "FIX THE FOLLOWING ERRORS" is displayed
     */
    public void verifyErrorDialog() {
        try {
            WebElement errorDialog = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(errorDialogXpath)));

            if (errorDialog.isDisplayed()) {
                System.out.println("✓ Step 21: Error dialog 'FIX THE FOLLOWING ERRORS' is displayed");
            } else {
                throw new RuntimeException("Error dialog is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to verify error dialog in Step 21", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 22 (Corrected DOB):
     * Click DOB field and set correct date (swipe to year 2000)
     */

    public void fillDOBFieldCorrect() {
        try {
            // ✅ STEP 22: Click DOB field using DYNAMIC BOUNDS (Device Independent)
            clickDobFieldDynamic();
            System.out.println("✓ Step 22: Clicked DOB field via Dynamic Bounds");

            Thread.sleep(1500); // Wait for date picker

            // Use index-based locators for stability
            String daySeekBarXpath = "(//android.widget.SeekBar)[1]";
            String monthSeekBarXpath = "(//android.widget.SeekBar)[2]";
            String yearSeekBarXpath = "(//android.widget.SeekBar)[3]";

            // Swipe once on day and month
            WebElement daySeekBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(daySeekBarXpath)));
            swipeDown(daySeekBar);
            Thread.sleep(500);

            WebElement monthSeekBar = wait
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(monthSeekBarXpath)));
            swipeDown(monthSeekBar);
            Thread.sleep(500);

            // ✅ STEP 22: Robust Dynamic Year selection (< 2005)
            boolean found = false;
            int maxAttempts = 40;
            int attempts = 0;

            System.out.println("Step 22: Searching for any year < 2005...");
            while (!found && attempts < maxAttempts) {
                // Read all visible seekbar/numeric elements
                List<WebElement> scrollElements = driver.findElements(By.className("android.widget.SeekBar"));

                for (WebElement el : scrollElements) {
                    String desc = el.getAttribute("content-desc");
                    if (desc != null && desc.matches("\\d{4}")) { // Check if it's a 4-digit year
                        try {
                            int yearValue = Integer.parseInt(desc);
                            if (yearValue < 2005) {
                                found = true;
                                el.click();
                                System.out.println("✓ Step 22: Found and selected year " + yearValue);
                                break;
                            }
                        } catch (NumberFormatException e) {
                            // Not a year
                        }
                    }
                }

                if (found)
                    break;

                // If not found, fast swipe only on the Year SeekBar (index 3)
                WebElement yearSeekBar = wait
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(yearSeekBarXpath)));
                fastSwipe(yearSeekBar);
                attempts++;
                Thread.sleep(200);
            }

            if (!found) {
                throw new RuntimeException("CRITICAL: No year below 2005 found in DOB picker");
            }

            Thread.sleep(500);

            // Click CONFIRM button
            WebElement confirmBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(confirmButtonXpath)));
            confirmBtn.click();
            System.out.println("✓ Step 22: Clicked CONFIRM button");

        } catch (Exception e) {
            throw new RuntimeException("CRITICAL: Failed to fill correct DOB in Step 22: " + e.getMessage(), e);
        }
    }

    /**
     * TEST CASE 1 - STEP 23:
     * Click phone number field, clear it, fill with correct number, and hide
     * keyboard
     */
    public void fillPhoneNumberCorrect(String phoneNumber) {
        try {
            WebElement phoneField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(phoneNumberFieldXpath)));
            phoneField.click();
            phoneField.clear();
            phoneField.sendKeys(phoneNumber);
            System.out.println("✓ Step 23: Filled correct phone number: " + phoneNumber);

            // Hide keyboard
            hideKeyboard();

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to fill correct phone number in Step 23", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 24:
     * Click postal code field, clear it, fill with correct code, and hide keyboard
     */
    public void fillPostalCodeCorrect(String postalCode) {
        try {
            WebElement postalField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(postalCodeFieldXpath)));
            postalField.click();
            postalField.clear();
            postalField.sendKeys(postalCode);
            System.out.println("✓ Step 24: Filled correct postal code: " + postalCode);

            // Hide keyboard
            hideKeyboard();

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to fill correct postal code in Step 24", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 26:
     * Verify Shipping Method is displayed
     */
    public void verifyShippingMethod() {
        try {
            WebElement shippingMethod = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(shippingMethodXpath)));

            if (shippingMethod.isDisplayed()) {
                System.out.println("✓ Step 26: Shipping Method is displayed");
            } else {
                throw new RuntimeException("Shipping Method is not displayed");
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to verify Shipping Method in Step 26", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 27:
     * Click PROCEED TO PAYMENT button and wait 9 seconds
     */
    public void clickProceedToPaymentButton() {
        try {
            WebElement proceedButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(proceedToPaymentButtonXpath)));
            proceedButton.click();
            System.out.println("✓ Step 27: Clicked PROCEED TO PAYMENT button");

            // Wait 9 seconds
            Thread.sleep(9000);
            System.out.println("✓ Step 27: Waited 9 seconds");

        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during payment button click in Step 27", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click PROCEED TO PAYMENT button in Step 27", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 29:
     * Click Close sheet
     */
    public void clickCloseSheet() {
        try {
            WebElement closeSheet = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(closeSheetXpath)));
            closeSheet.click();
            System.out.println("✓ Step 29: Clicked Close sheet");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click Close sheet in Step 29", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 30:
     * Verify payment error dialog and get error message
     * 
     * @return The payment error message
     */
    public String verifyPaymentErrorAndGetMessage() {
        try {
            // Try to find PAYMENT ERROR dialog by XPath first
            WebElement paymentErrorDialog = null;
            try {
                paymentErrorDialog = wait.until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(paymentErrorDialogXpath)));
            } catch (TimeoutException e) {
                // Fallback: try by name if XPath fails
                java.util.List<WebElement> elemsByName = driver.findElements(By.name("PAYMENT ERROR"));
                if (!elemsByName.isEmpty()) {
                    paymentErrorDialog = elemsByName.get(0);
                } else {
                    throw new RuntimeException("PAYMENT ERROR dialog not found by XPath or name");
                }
            }

            if (paymentErrorDialog.isDisplayed()) {
                System.out.println("✓ Step 30: PAYMENT ERROR dialog is displayed");
            } else {
                throw new RuntimeException("PAYMENT ERROR dialog is not displayed");
            }

            // Get error message by name instead of XPath
            WebElement errorMessage = null;
            java.util.List<WebElement> elemsByName = driver.findElements(By.name("Please try again later."));
            if (!elemsByName.isEmpty()) {
                errorMessage = elemsByName.get(0);
            } else {
                throw new RuntimeException("Payment error message 'Please try again later.' not found by name");
            }
            String message = errorMessage.getText();
            System.out.println("✓ Step 30: Payment error message captured: " + message);
            return message;

        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to verify payment error or get message in Step 30", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 31:
     * Click OK button
     */
    public void clickOKButton() {
        try {
            WebElement okButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(okButtonXpath)));
            okButton.click();
            System.out.println("✓ Step 31: Clicked OK button");
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click OK button in Step 31", e);
        }
    }

    /**
     * TEST CASE 1 - STEP 32:
     * Click Retry Payment button, wait 9 seconds, and verify payment page
     */
    public void clickRetryPaymentAndVerify() {
        try {
            // Click Retry Payment button
            WebElement retryButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath(retryPaymentButtonXpath)));
            retryButton.click();
            System.out.println("✓ Step 32: Clicked Retry Payment button");

            // Wait 9 seconds
            Thread.sleep(9000);
            System.out.println("✓ Step 32: Waited 9 seconds");

            // Verify payment page is displayed
            WebElement paymentPageButton = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(paymentPageButtonXpath)));

            if (paymentPageButton.isDisplayed()) {
                System.out.println("✓ Step 32: Payment page is displayed");
            } else {
                throw new RuntimeException("Payment page is not displayed");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted during retry payment in Step 32", e);
        } catch (TimeoutException e) {
            throw new RuntimeException("Failed to click Retry Payment or verify payment page in Step 32", e);
        }
    }

    // ==================== HELPER METHODS ====================

    /**
     * Helper method to hide keyboard
     */
    private void hideKeyboard() {
        try {
            ((io.appium.java_client.android.AndroidDriver) driver).hideKeyboard();
            System.out.println("  ✓ Keyboard hidden");
        } catch (Exception e) {
            System.out.println("  ⚠ Keyboard already hidden or not present");
        }
    }

    /**
     * Helper method to swipe down on a seekbar element
     */

    /**
     * Verify if Data Bank page is currently displayed
     * 
     * @return true if Data Bank heading is visible, false otherwise
     */
    public boolean isDataBankPageDisplayed() {
        try {
            WebElement dataBankHeading = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(dataBankHeadingXpath)));
            return dataBankHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if already on Data Bank page by looking for REPORTS tab
     * This is more reliable than checking for DATA BANK heading when already inside
     * the section
     * 
     * @return true if REPORTS tab is visible (indicating we're on Data Bank page),
     *         false otherwise
     */
    public boolean isAlreadyOnDataBankPage() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement reportsTab = shortWait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(reportsXpath)));
            return reportsTab.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get the Data Bank heading text for verification
     * 
     * @return Content description of the Data Bank heading
     */
    public String getDataBankHeadingText() {
        try {
            WebElement dataBankHeading = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(dataBankHeadingXpath)));
            return dataBankHeading.getAttribute("content-desc");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Get validation message from success/error dialog
     * Replaces newlines with spaces for easier assertion
     */
    public String getValidationMessage() {
        try {
            // Robust locator using contains(@content-desc)
            // Using a strictly general locator as requested by user to catch ANY validation
            // message causing the dialog
            WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(
                            "//android.view.View[contains(@content-desc, 'Invalid') or contains(@content-desc, 'at least')]")));

            String rawMessage = messageElement.getAttribute("content-desc");
            if (rawMessage == null)
                return null;

            // "Replace \n with space OR validate each message separately"
            // Replacing \n with space as per user instruction
            return rawMessage.replace("\n", " ").trim();

        } catch (Exception e) {
            System.out.println("Validation message not found: " + e.getMessage());
            return null;
        }
    }
}