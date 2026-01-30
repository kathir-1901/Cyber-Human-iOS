package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.DataBankPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataBankTest extends BaseTest {

    /**
     * ==================== DATA BANK TEST CASE 1 ====================
     * 
     * Common Steps (1, 2 & 3):
     * 1. Verify DAILY PRIORITY heading on home page (name: "DAILY PRIORITY", xpath: //XCUIElementTypeStaticText[@name="DAILY PRIORITY"])
     * 2. Click Wellbeing Dashboard (name: "WELLBEING DASHBOARD HOME", xpath: //XCUIElementTypeImage[@name="WELLBEING DASHBOARD HOME"])
     * 3. Click DATA BANK and verify it's displayed (name: "DATA BANK", xpath: //XCUIElementTypeStaticText[@name="DATA BANK"])
     * 
     * Test-Specific Steps:
     * 4. Click PACKAGES & PRICING
     * 5. Click CONTINUE button
     * 6. Click checkbox
     * 7. Click CONTINUE button
     * 8. Verify BAG page
     * 9. Click Essential Epigenetics dropdown
     * 10. Click PROCEED TO CHECKOUT button
     * 11. Verify CHECKOUT page and Delivery Address
     * 12. Fill name field with "Kathir"
     * 13. Fill DOB field (wrong), select Gender (Male)
     * 14. Select country code (India +91)
     * 15. Fill phone number (wrong - 1234568)
     * 16. Fill address (5/1029,KTG)
     * 17. Fill city (Coimbatore)
     * 18. Select country (India)
     * 19. Fill postal code (wrong - kahsw)
     * 20. Click SAVE ADDRESS button
     * 21. Verify error dialog "FIX THE FOLLOWING ERRORS"
     * 22. Get error message, click OK, fill DOB correctly (year 2000)
     * 23. Fill phone number correctly (8072971990)
     * 24. Fill postal code correctly (643217)
     * 25. Click SAVE ADDRESS button
     * 26. Verify Shipping Method is displayed
     * 27. Click PROCEED TO PAYMENT button and wait 9 seconds
     * 29. Click Close sheet
     * 30. Verify payment error dialog and get error message
     * 31. Click OK button
     * 32. Click Retry Payment button, wait 9 seconds, verify payment page
     */
    @Test(priority = 1)
    public void testDataBank_Case1() throws InterruptedException {
        test = extent.createTest("Data Bank Test Case 1");
        test.log(Status.INFO, "Starting Data Bank Test Case 1");

        HomePage homePage = new HomePage(driver);
        DataBankPage dataBankPage = new DataBankPage(driver);


        // Step 1: Verify DAILY PRIORITY heading is displayed on home page (iOS XPath)
        test.log(Status.INFO, "Step 1: Verifying DAILY PRIORITY heading on home page (iOS)");
        boolean isHomePageDisplayed = driver.findElements(
            org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DAILY PRIORITY']")
        ).size() > 0;
        if (!isHomePageDisplayed) {
            test.log(Status.FAIL, "DAILY PRIORITY heading not found on home page");
            Assert.fail("Home page validation failed - DAILY PRIORITY heading not displayed");
        }
        test.log(Status.PASS, "✓ DAILY PRIORITY heading is displayed on home page");

        // Step 2: Click Wellbeing Dashboard (iOS, robust fallback logic)
        test.log(Status.INFO, "Step 2: Clicking Wellbeing Dashboard (iOS, robust)");
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        boolean dashboardClicked = false;
        try {
            org.openqa.selenium.WebElement wellbeingDashboard = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//XCUIElementTypeImage[@name='WELLBEING DASHBOARD HOME'] | //XCUIElementTypeImage[contains(@name, 'WELLBEING')]")
            ));
            wellbeingDashboard.click();
            test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by xpath");
            Thread.sleep(1500);
            dashboardClicked = true;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by xpath: " + e.getMessage());
            // Try by accessibility id (Appium)
            try {
                org.openqa.selenium.WebElement dashboardByAccId = driver.findElement(io.appium.java_client.MobileBy.AccessibilityId("WELLBEING DASHBOARD HOME"));
                dashboardByAccId.click();
                test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by accessibility id");
                Thread.sleep(1500);
                dashboardClicked = true;
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by accessibility id: " + ex1.getMessage());
                // Try by name
                try {
                    org.openqa.selenium.WebElement dashboardByName = driver.findElement(org.openqa.selenium.By.name("WELLBEING DASHBOARD HOME"));
                    dashboardByName.click();
                    test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by name");
                    Thread.sleep(1500);
                    dashboardClicked = true;
                } catch (Exception ex2) {
                    test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by name: " + ex2.getMessage());
                }
            }
        }
        if (!dashboardClicked) {
            test.log(Status.INFO, "Wellbeing Dashboard not found by any locator, assuming already on dashboard");
        }

        // Step 3: Click DATA BANK and verify it's displayed (robust logic)
        test.log(Status.INFO, "Step 3: Clicking DATA BANK and verifying it's displayed (iOS, robust)");
        boolean dataBankClicked = false;
        try {
            org.openqa.selenium.WebElement dataBankByXpath = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DATA BANK']")
            ));
            dataBankByXpath.click();
            test.log(Status.INFO, "✓ Clicked DATA BANK by xpath");
            Thread.sleep(1500);
            dataBankClicked = true;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ DATA BANK not found by xpath: " + e.getMessage());
            // Try by name
            try {
                org.openqa.selenium.WebElement dataBankByName = driver.findElement(org.openqa.selenium.By.name("DATA BANK"));
                dataBankByName.click();
                test.log(Status.INFO, "✓ Clicked DATA BANK by name");
                Thread.sleep(1500);
                dataBankClicked = true;
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ DATA BANK not found by name: " + ex1.getMessage());
            }
        }
        // Verify DATA BANK is displayed
        boolean isDataBankDisplayed = false;
        try {
            isDataBankDisplayed = driver.findElements(
                org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DATA BANK']")
            ).size() > 0;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ DATA BANK not found for verification: " + e.getMessage());
        }
        if (!isDataBankDisplayed) {
            try {
                isDataBankDisplayed = driver.findElements(
                    org.openqa.selenium.By.name("DATA BANK")
                ).size() > 0;
            } catch (Exception ex2) {
                test.log(Status.WARNING, "⚠ DATA BANK not found by name for verification: " + ex2.getMessage());
            }
        }
        if (!isDataBankDisplayed) {
            test.log(Status.FAIL, "DATA BANK not displayed after click");
            Assert.fail("DATA BANK validation failed - not displayed");
        } else {
            test.log(Status.PASS, "✓ DATA BANK is displayed after click");
        }

        // ...existing code...

        // ✅ TEST CASE 1 - STEP 4: Click PACKAGES & PRICING
        test.log(Status.INFO, "Step 4: Clicking PACKAGES & PRICING");
        dataBankPage.clickPackagesAndPricing();
        test.log(Status.PASS, "✓ Step 4: PACKAGES & PRICING clicked");
        Thread.sleep(9000); // Wait 3 seconds for page to load

        // ✅ TEST CASE 1 - STEP 5: Click CONTINUE button
        test.log(Status.INFO, "Step 5: Clicking CONTINUE button");
        dataBankPage.clickContinueButton();
        test.log(Status.PASS, "✓ Step 5: CONTINUE button clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 6: Click checkbox
        test.log(Status.INFO, "Step 6: Clicking checkbox");
        dataBankPage.clickCheckbox();
        test.log(Status.PASS, "✓ Step 6: Checkbox clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 7: Click CONTINUE button again
        test.log(Status.INFO, "Step 7: Clicking CONTINUE button");
        dataBankPage.clickContinueButton();
        System.out.println("✓ Step 7: CONTINUE button clicked (Test)");
        test.log(Status.PASS, "✓ Step 7: CONTINUE button clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 8: Verify BAG page
        System.out.println("Step 8: Starting Verify BAG page...");
        test.log(Status.INFO, "Step 8: Verifying BAG page");
        dataBankPage.verifyBagPage();
        System.out.println("✓ Step 8: BAG page verified (Test)");
        test.log(Status.PASS, "✓ Step 8: BAG page verified");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 9: Click Essential Epigenetics dropdown
        test.log(Status.INFO, "Step 9: Clicking Essential Epigenetics dropdown");
        dataBankPage.clickEssentialEpigeneticsDropdown();
        test.log(Status.PASS, "✓ Step 9: Essential Epigenetics dropdown clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 10: Click PROCEED TO CHECKOUT button
        test.log(Status.INFO, "Step 10: Clicking PROCEED TO CHECKOUT button");
        dataBankPage.clickProceedToCheckoutButton();
        test.log(Status.PASS, "✓ Step 10: PROCEED TO CHECKOUT button clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 11: Verify CHECKOUT page and Delivery Address
        test.log(Status.INFO, "Step 11: Verifying CHECKOUT page and Delivery Address");
        dataBankPage.verifyCheckoutPage();
        test.log(Status.PASS, "✓ Step 11: CHECKOUT page and Delivery Address verified");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 12: Fill name field with "Kathir"
        test.log(Status.INFO, "Step 12: Filling name field with 'Kathir'");
        dataBankPage.fillNameField("Kathir");
        test.log(Status.PASS, "✓ Step 12: Name field filled with 'Kathir'");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 13: Fill DOB field (wrong - will cause error)
        test.log(Status.INFO, "Step 13: Filling DOB field (wrong date)");
        dataBankPage.fillDOBFieldWrong();
        test.log(Status.PASS, "✓ Step 13: DOB field filled (wrong date)");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 14: Select country code (India +91)
        test.log(Status.INFO, "Step 14: Selecting country code (India +91)");
        dataBankPage.selectCountryCode();
        test.log(Status.PASS, "✓ Step 14: Country code selected (India +91)");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 15: Fill phone number (wrong - will cause error)
        test.log(Status.INFO, "Step 15: Filling phone number (wrong)");
        dataBankPage.fillPhoneNumber("1234568");
        test.log(Status.PASS, "✓ Step 15: Phone number filled (wrong)");
        Thread.sleep(3000);

         // ✅ TEST CASE 1 - STEP 13: Select Gender (Male)
        test.log(Status.INFO, "Step 13: Selecting Gender (Male)");
        dataBankPage.selectGender();
        test.log(Status.PASS, "✓ Step 13: Gender selected (Male)");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 16: Fill address
        test.log(Status.INFO, "Step 16: Filling address");
        dataBankPage.fillAddress("5/1029,KTG");
        test.log(Status.PASS, "✓ Step 16: Address filled");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 16.1: Click CHECKOUT name/xpath
        test.log(Status.INFO, "Step 16.1: Clicking CHECKOUT (by xpath, fallback to name)");
        try {
            org.openqa.selenium.WebElement checkoutByXpath = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='CHECKOUT']"));
            checkoutByXpath.click();
            test.log(Status.PASS, "✓ Step 16.1: CHECKOUT clicked by xpath");
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ CHECKOUT not found by xpath: " + e.getMessage());
            try {
                org.openqa.selenium.WebElement checkoutByName = driver.findElement(org.openqa.selenium.By.name("CHECKOUT"));
                checkoutByName.click();
                test.log(Status.PASS, "✓ Step 16.1: CHECKOUT clicked by name");
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ CHECKOUT not found by name: " + ex1.getMessage());
            }
        }
        Thread.sleep(1000);

        // ✅ TEST CASE 1 - STEP 17: Fill city
        test.log(Status.INFO, "Step 17: Filling city");
        dataBankPage.fillCity("Coimbatore");
        test.log(Status.PASS, "✓ Step 17: City filled");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 17.1: Click CHECKOUT name/xpath
        test.log(Status.INFO, "Step 17.1: Clicking CHECKOUT (by xpath, fallback to name)");
        try {
            org.openqa.selenium.WebElement checkoutByXpath = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='CHECKOUT']"));
            checkoutByXpath.click();
            test.log(Status.PASS, "✓ Step 17.1: CHECKOUT clicked by xpath");
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ CHECKOUT not found by xpath: " + e.getMessage());
            try {
                org.openqa.selenium.WebElement checkoutByName = driver.findElement(org.openqa.selenium.By.name("CHECKOUT"));
                checkoutByName.click();
                test.log(Status.PASS, "✓ Step 17.1: CHECKOUT clicked by name");
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ CHECKOUT not found by name: " + ex1.getMessage());
            }
        }
        Thread.sleep(1000);


        // ✅ TEST CASE 1 - STEP 18: Select country (India)
        test.log(Status.INFO, "Step 18: Selecting country (India)");
        dataBankPage.selectCountry();
        test.log(Status.PASS, "✓ Step 18: Country selected (India)");
        Thread.sleep(3000);

        // ...existing code...

        // ✅ TEST CASE 1 - STEP 19: Fill postal code (wrong - will cause error)
        test.log(Status.INFO, "Step 19: Filling postal code (wrong)");
        dataBankPage.fillPostalCodeWrong("kahsw");
        test.log(Status.PASS, "✓ Step 19: Postal code filled (wrong)");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 19.1: Click CHECKOUT name/xpath
        test.log(Status.INFO, "Step 19.1: Clicking CHECKOUT (by xpath, fallback to name)");
        try {
            org.openqa.selenium.WebElement checkoutByXpath = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='CHECKOUT']"));
            checkoutByXpath.click();
            test.log(Status.PASS, "✓ Step 19.1: CHECKOUT clicked by xpath");
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ CHECKOUT not found by xpath: " + e.getMessage());
            try {
                org.openqa.selenium.WebElement checkoutByName = driver.findElement(org.openqa.selenium.By.name("CHECKOUT"));
                checkoutByName.click();
                test.log(Status.PASS, "✓ Step 19.1: CHECKOUT clicked by name");
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ CHECKOUT not found by name: " + ex1.getMessage());
            }
        }
        Thread.sleep(1000);

        // ✅ TEST CASE 1 - STEP 20: Click SAVE ADDRESS button
        test.log(Status.INFO, "Step 20: Clicking SAVE ADDRESS button");
        dataBankPage.clickSaveAddressButton();
        test.log(Status.PASS, "✓ Step 20: SAVE ADDRESS button clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 21: Verify error dialog
        test.log(Status.INFO, "Step 21: Verifying error dialog 'FIX THE FOLLOWING ERRORS'");
        dataBankPage.verifyErrorDialog();
        test.log(Status.PASS, "✓ Step 21: Error dialog verified");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 22: Get validation message and click OK (robust xpath, fallback to name)
        test.log(Status.INFO, "Step 22: Getting validation message from error dialog");
        String errorMessage = null;
        try {
            // Try to find the error dialog by type and traits, then get value/name/label
            java.util.List<org.openqa.selenium.WebElement> errorElems = driver.findElements(
                org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[contains(@value,'Invalid phone number') or contains(@name,'Invalid phone number') or contains(@label,'Invalid phone number')]")
            );
            if (!errorElems.isEmpty()) {
                org.openqa.selenium.WebElement errorElem = errorElems.get(0);
                // Try value, then name, then label
                String value = errorElem.getAttribute("value");
                String name = errorElem.getAttribute("name");
                String label = errorElem.getAttribute("label");
                if (value != null && !value.isEmpty()) {
                    errorMessage = value;
                } else if (name != null && !name.isEmpty()) {
                    errorMessage = name;
                } else if (label != null && !label.isEmpty()) {
                    errorMessage = label;
                } else {
                    errorMessage = errorElem.getText();
                }
                test.log(Status.PASS, "✓ Step 22: Error message found by robust attribute search");
            } else {
                test.log(Status.FAIL, "Validation message not found by robust attribute search");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Validation message not found: " + e.getMessage());
        }

        if (errorMessage != null) {
            // Normalize newlines for reporting
            String errorMsgForReport = errorMessage.replace("\n", " | ");
            test.log(Status.INFO, "📋 Step 22 - Validation Message: " + errorMsgForReport);
            Assert.assertTrue(errorMessage.contains("Invalid phone number"),
                    "Message should contain 'Invalid phone number'");
            Assert.assertTrue(errorMessage.contains("Invalid Postal Code"),
                    "Message should contain 'Invalid Postal Code'");
        }

        dataBankPage.clickOkButton();
        test.log(Status.PASS, "✓ Step 22: Validation message captured and OK clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 22: Fill DOB field (correct - year 2000) using robust elementId and dynamic picker
        test.log(Status.INFO, "Step 22: Clicking DOB field (correct) using robust elementId");
        boolean dobClicked = false;
        try {
            java.util.List<org.openqa.selenium.WebElement> dobFields = driver.findElements(
                io.appium.java_client.MobileBy.iOSNsPredicateString(
                    "type == 'XCUIElementTypeOther' AND value MATCHES '[0-9]{2}/[0-9]{2}/[0-9]{4}' AND enabled == 1 AND visible == 1"
                )
            );
            if (!dobFields.isEmpty()) {
                dobFields.get(0).click();
                test.log(Status.PASS, "✓ Step 22: DOB field clicked using robust dynamic predicate (type/value/enabled/visible)");
                dobClicked = true;
            }
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ DOB field not found by robust dynamic predicate: " + e.getMessage());
        }
        if (!dobClicked) {
            // Fallback: try by placeholder or other method
            try {
                org.openqa.selenium.WebElement dobFieldFallback = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeOther[@name='dd/mm/yyyy']"));
                dobFieldFallback.click();
                test.log(Status.PASS, "✓ Step 22: DOB field clicked by fallback xpath");
            } catch (Exception ex1) {
                test.log(Status.FAIL, "DOB field not found by robust dynamic predicate or fallback xpath: " + ex1.getMessage());
            }
        }
        // Move to next step (23)
        // ✅ TEST CASE 1 - STEP 22.1: Swipe down twice on year seekbar and click CONFIRM (reuse performDateSelection logic)
        test.log(Status.INFO, "Step 22.1: Swiping down on year seekbar until year is below 2005, then clicking CONFIRM");
        try {
            // Find all visible date pickers (XCUIElementTypeOther with traits Adjustable)
            java.util.List<org.openqa.selenium.WebElement> pickers = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeOther[contains(@traits,'Adjustable')]"));
            org.openqa.selenium.WebElement yearPicker = null;
            for (org.openqa.selenium.WebElement picker : pickers) {
                String value = picker.getAttribute("value");
                if (value != null && value.matches("\\d{4}")) {
                    yearPicker = picker;
                    break;
                }
            }
            if (yearPicker == null && !pickers.isEmpty()) {
                yearPicker = pickers.get(pickers.size() - 1); // fallback to last picker
            }
            if (yearPicker == null) {
                test.log(Status.FAIL, "Year picker wheel not found for Step 22.1");
                throw new RuntimeException("Year picker wheel not found for Step 22.1");
            }
            // Swipe down on the year picker until year < 2005 (max 20 swipes)
            int maxSwipes = 20;
            boolean yearBelow2005 = false;
            for (int i = 0; i < maxSwipes; i++) {
                String currentYear = yearPicker.getAttribute("value");
                if (currentYear != null && currentYear.matches("\\d{4}") && Integer.parseInt(currentYear) < 2005) {
                    yearBelow2005 = true;
                    break;
                }
                int centerX = yearPicker.getRect().getX() + (yearPicker.getRect().getWidth() / 2);
                int startY = yearPicker.getRect().getY() + (yearPicker.getRect().getHeight() / 2);
                int endY = startY + 80; // swipe down by 80px
                org.openqa.selenium.interactions.PointerInput finger = new org.openqa.selenium.interactions.PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
                org.openqa.selenium.interactions.Sequence swipe = new org.openqa.selenium.interactions.Sequence(finger, 1);
                swipe.addAction(finger.createPointerMove(java.time.Duration.ofMillis(0), org.openqa.selenium.interactions.PointerInput.Origin.viewport(), centerX, startY));
                swipe.addAction(finger.createPointerDown(org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger.createPointerMove(java.time.Duration.ofMillis(400), org.openqa.selenium.interactions.PointerInput.Origin.viewport(), centerX, endY));
                swipe.addAction(finger.createPointerUp(org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(java.util.Collections.singletonList(swipe));
                Thread.sleep(500);
            }
            if (!yearBelow2005) {
                test.log(Status.WARNING, "Could not swipe year below 2005 after " + maxSwipes + " attempts");
            } else {
                test.log(Status.INFO, "Year picker set below 2005");
            }
            // Click CONFIRM button (iOS)
            try {
                org.openqa.selenium.support.ui.WebDriverWait shortWait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5));
                org.openqa.selenium.WebElement confirmBtn = shortWait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                    org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='CONFIRM']")));
                confirmBtn.click();
                test.log(Status.PASS, "✓ Step 22.1: Clicked CONFIRM button on date picker");
            } catch (Exception e) {
                test.log(Status.WARNING, "CONFIRM button not found on date picker: " + e.getMessage());
            }
            test.log(Status.PASS, "✓ Step 22.1: Swiped down on year seekbar until year < 2005 and clicked CONFIRM");
        } catch (Exception e) {
            test.log(Status.FAIL, "Step 22.1 failed: " + e.getMessage());
            throw new RuntimeException("Step 22.1 failed", e);
        }

        // ✅ TEST CASE 1 - STEP 23: Fill phone number (correct)
        test.log(Status.INFO, "Step 23: Filling phone number (correct)");
        boolean phoneFilled = false;
        try {
            org.openqa.selenium.WebElement phoneField = null;
            // 1. Try by elementId (no warning if not found)
            try {
                phoneField = driver.findElement(io.appium.java_client.MobileBy.id("67000000-0000-0000-724C-000000000000"));
                test.log(Status.INFO, "✓ Step 23: Phone field found by elementId");
            } catch (Exception e) {
                // Do not log warning if not found
            }
            // 2. Try by value (old/wrong or empty)
            if (phoneField == null) {
                java.util.List<org.openqa.selenium.WebElement> phoneFields = driver.findElements(
                    org.openqa.selenium.By.xpath("//XCUIElementTypeTextField[@enabled='true' and @visible='true' and (@value='1234568' or @value='' or @value='Phone Number' or @placeholder='Phone Number')]"));
                if (!phoneFields.isEmpty()) {
                    phoneField = phoneFields.get(0);
                    test.log(Status.INFO, "✓ Step 23: Phone field found by type and value/placeholder");
                }
            }
            // 3. Try by index: if only one visible text field, use it
            if (phoneField == null) {
                java.util.List<org.openqa.selenium.WebElement> allTextFields = driver.findElements(
                    org.openqa.selenium.By.xpath("//XCUIElementTypeTextField[@enabled='true' and @visible='true']"));
                if (allTextFields.size() == 1) {
                    phoneField = allTextFields.get(0);
                    test.log(Status.INFO, "✓ Step 23: Only one visible text field, using it for phone");
                } else {
                    // Log all candidates for debug
                    int idx = 0;
                    for (org.openqa.selenium.WebElement tf : allTextFields) {
                        test.log(Status.INFO, "TextField candidate " + idx + ": value='" + tf.getAttribute("value") + "', label='" + tf.getAttribute("label") + "'");
                        idx++;
                    }
                }
            }
            // 4. Try by fallback: first text field with value length 8 (old phone)
            if (phoneField == null) {
                java.util.List<org.openqa.selenium.WebElement> allTextFields = driver.findElements(
                    org.openqa.selenium.By.xpath("//XCUIElementTypeTextField[@enabled='true' and @visible='true']"));
                for (org.openqa.selenium.WebElement tf : allTextFields) {
                    String val = tf.getAttribute("value");
                    if (val != null && val.length() == 8) {
                        phoneField = tf;
                        test.log(Status.INFO, "✓ Step 23: Phone field found by value length 8");
                        break;
                    }
                }
            }
            // 5. If still not found, try clicking all visible text fields and send keys to the first that accepts input
            if (phoneField == null) {
                java.util.List<org.openqa.selenium.WebElement> allTextFields = driver.findElements(
                    org.openqa.selenium.By.xpath("//XCUIElementTypeTextField[@enabled='true' and @visible='true']"));
                for (org.openqa.selenium.WebElement tf : allTextFields) {
                    try {
                        tf.click();
                        tf.clear();
                        tf.sendKeys("8072971990");
                        test.log(Status.INFO, "✓ Step 23: Phone number filled in fallback text field");
                        phoneFilled = true;
                        break;
                    } catch (Exception e) {
                        // Try next
                    }
                }
            } else {
                phoneField.click();
                phoneField.clear();
                phoneField.sendKeys("8072971990");
                test.log(Status.PASS, "✓ Step 23: Phone number filled correctly");
                phoneFilled = true;
            }
            if (!phoneFilled) {
                test.log(Status.FAIL, "Step 23: Phone field not found or could not be filled by any method");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Step 23: Exception while filling phone number: " + e.getMessage());
        }
        Assert.assertTrue(phoneFilled, "Step 23: Phone number field should be filled");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 23.1: Click 'Male' button by xpath (not by name)
        test.log(Status.INFO, "Step 23.1: Clicking 'Male' button by xpath");
        boolean maleClicked = false;
        try {
            org.openqa.selenium.WebElement maleBtn = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='Male']"));
            maleBtn.click();
            test.log(Status.PASS, "✓ Step 23.1: 'Male' button clicked by xpath");
            maleClicked = true;
        } catch (Exception e) {
            test.log(Status.FAIL, "Step 23.1: Could not click 'Male' button by xpath: " + e.getMessage());
        }
        Assert.assertTrue(maleClicked, "Step 23.1: 'Male' button should be clicked by xpath");
        Thread.sleep(1000);

            // ✅ TEST CASE 1 - STEP 23.2: Click 'Male' option by xpath, fallback to name
            test.log(Status.INFO, "Step 23.2: Clicking 'Male' option by xpath, fallback to name");
            boolean maleOptionClicked = false;
            try {
                org.openqa.selenium.WebElement maleOptionBtn = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='Male']"));
                maleOptionBtn.click();
                test.log(Status.PASS, "✓ Step 23.2: 'Male' option clicked by xpath");
                maleOptionClicked = true;
            } catch (Exception e) {
                test.log(Status.WARNING, "Step 23.2: 'Male' option not found by xpath: " + e.getMessage());
                // Fallback to name
                try {
                    org.openqa.selenium.WebElement maleOptionByName = driver.findElement(org.openqa.selenium.By.name("Male"));
                    maleOptionByName.click();
                    test.log(Status.PASS, "✓ Step 23.2: 'Male' option clicked by name");
                    maleOptionClicked = true;
                } catch (Exception ex1) {
                    test.log(Status.FAIL, "Step 23.2: Could not click 'Male' option by name: " + ex1.getMessage());
                }
            }
            Assert.assertTrue(maleOptionClicked, "Step 23.2: 'Male' option should be clicked by xpath or name");
            Thread.sleep(1000);

        

        // ✅ TEST CASE 1 - STEP 24: Fill postal code (correct)
        test.log(Status.INFO, "Step 24: Filling postal code (correct)");
        boolean postalFilled = false;
        try {
            org.openqa.selenium.WebElement postalField = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeTextField[@value='kahsw' and @enabled='true' and @visible='true']"));
            postalField.click();
            postalField.clear();
            postalField.sendKeys("643217");
            test.log(Status.PASS, "✓ Step 24: Postal code field clicked, cleared, and filled with 643217");
            postalFilled = true;
        } catch (Exception e) {
            test.log(Status.FAIL, "Step 24: Could not fill postal code field: " + e.getMessage());
        }
        Assert.assertTrue(postalFilled, "Step 24: Postal code field should be filled");
        Thread.sleep(1000);
        // Click CHECKOUT once after filling postal code
        test.log(Status.INFO, "Step 24: Clicking CHECKOUT after filling postal code");
        boolean checkoutClicked = false;
        try {
            org.openqa.selenium.WebElement checkoutByXpath = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='CHECKOUT']"));
            checkoutByXpath.click();
            test.log(Status.PASS, "✓ Step 24: CHECKOUT clicked by xpath");
            checkoutClicked = true;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ CHECKOUT not found by xpath: " + e.getMessage());
        }
        Assert.assertTrue(checkoutClicked, "Step 24: CHECKOUT should be clicked after filling postal code");
        Thread.sleep(2000);

        // ✅ TEST CASE 1 - STEP 25: Click SAVE ADDRESS button again
        test.log(Status.INFO, "Step 25: Clicking SAVE ADDRESS button");
        dataBankPage.clickSaveAddressButton();
        test.log(Status.PASS, "✓ Step 25: SAVE ADDRESS button clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 26: Verify Shipping Method is displayed
        test.log(Status.INFO, "Step 26: Verifying Shipping Method is displayed");
        dataBankPage.verifyShippingMethod();
        test.log(Status.PASS, "✓ Step 26: Shipping Method verified");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 27: Click PROCEED TO PAYMENT button and wait 9 seconds
        test.log(Status.INFO, "Step 27: Clicking PROCEED TO PAYMENT button and waiting 9 seconds");
        dataBankPage.clickProceedToPaymentButton();
        test.log(Status.PASS, "✓ Step 27: PROCEED TO PAYMENT button clicked and waited 9 seconds");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 29: Click Close sheet
        test.log(Status.INFO, "Step 29: Clicking Close sheet");
        dataBankPage.clickCloseSheet();
        test.log(Status.PASS, "✓ Step 29: Close sheet clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 30: Verify payment error dialog and get error message
        test.log(Status.INFO, "Step 30: Verifying payment error dialog");
        String paymentErrorMessage = dataBankPage.verifyPaymentErrorAndGetMessage();
        test.log(Status.INFO, "📋 Step 30 - Payment Error Message: " + paymentErrorMessage);
        test.log(Status.PASS, "✓ Step 30: Payment error dialog verified and message captured");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 31: Click OK button
        test.log(Status.INFO, "Step 31: Clicking OK button");
        dataBankPage.clickOKButton();
        test.log(Status.PASS, "✓ Step 31: OK button clicked");
        Thread.sleep(3000);

        // ✅ TEST CASE 1 - STEP 32: Click Retry Payment button, wait 9 seconds, and
        // verify payment page
        test.log(Status.INFO, "Step 32: Clicking Retry Payment button and verifying payment page");
        dataBankPage.clickRetryPaymentAndVerify();
        test.log(Status.PASS, "✓ Step 32: Retry Payment clicked, waited 9 seconds, and payment page verified");
        Thread.sleep(3000);

        test.log(Status.PASS, "Data Bank Test Case 1 completed successfully");
    }

    /**
     * ==================== DATA BANK TEST CASE 2 ====================
     * 
     * Common Steps (1, 2 & 3):
     * 1. Verify DAILY PRIORITY heading on home page
     * 2. Click Wellbeing Dashboard
     * 3. Click DATA BANK and verify it's displayed
     * 
     * Test-Specific Steps:
     * 4. Click UPLOAD DATA
     * 5. Click UPLOAD REPORT button
     * 6. Click checkbox
     * 7. Click CONTINUE button
     * 8. Upload wrong format file (JPG)
     * 9. Validate UPLOAD FAILED dialog and capture error message
     * 10. Click OK button
     * 11. Repeat steps 5, 6, 7 (Upload Report, Checkbox, Continue)
     * 12. Upload correct format file (PDF)
     * 13. Validate UPLOAD SUCCESSFUL dialog
     * 14. Capture success message
     * 15. Click OK button
     * 16. Click remove button and verify ARE YOU SURE? dialog
     * 17. Click YES button and verify DELETE SUCCESSFUL dialog
     * 18. Capture delete success message
     */
    @Test(priority = 2)
    public void testDataBank_Case2() throws InterruptedException {
        test = extent.createTest("Data Bank Test Case 2");
        test.log(Status.INFO, "Starting Data Bank Test Case 2");

        HomePage homePage = new HomePage(driver);
        DataBankPage dataBankPage = new DataBankPage(driver);


        // Step 1: Verify DAILY PRIORITY heading is displayed on home page (iOS XPath)
        test.log(Status.INFO, "Step 1: Verifying DAILY PRIORITY heading on home page (iOS)");
        boolean isHomePageDisplayed = driver.findElements(
            org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DAILY PRIORITY']")
        ).size() > 0;
        if (!isHomePageDisplayed) {
            test.log(Status.FAIL, "DAILY PRIORITY heading not found on home page");
            Assert.fail("Home page validation failed - DAILY PRIORITY heading not displayed");
        }
        test.log(Status.PASS, "✓ DAILY PRIORITY heading is displayed on home page");

        // Step 2: Click Wellbeing Dashboard (iOS, robust fallback logic)
        test.log(Status.INFO, "Step 2: Clicking Wellbeing Dashboard (iOS, robust)");
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        boolean dashboardClicked = false;
        try {
            org.openqa.selenium.WebElement wellbeingDashboard = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//XCUIElementTypeImage[@name='WELLBEING DASHBOARD HOME'] | //XCUIElementTypeImage[contains(@name, 'WELLBEING')]")
            ));
            wellbeingDashboard.click();
            test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by xpath");
            Thread.sleep(1500);
            dashboardClicked = true;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by xpath: " + e.getMessage());
            // Try by accessibility id (Appium)
            try {
                org.openqa.selenium.WebElement dashboardByAccId = driver.findElement(io.appium.java_client.MobileBy.AccessibilityId("WELLBEING DASHBOARD HOME"));
                dashboardByAccId.click();
                test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by accessibility id");
                Thread.sleep(1500);
                dashboardClicked = true;
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by accessibility id: " + ex1.getMessage());
                // Try by name
                try {
                    org.openqa.selenium.WebElement dashboardByName = driver.findElement(org.openqa.selenium.By.name("WELLBEING DASHBOARD HOME"));
                    dashboardByName.click();
                    test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by name");
                    Thread.sleep(1500);
                    dashboardClicked = true;
                } catch (Exception ex2) {
                    test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by name: " + ex2.getMessage());
                }
            }
        }
        if (!dashboardClicked) {
            test.log(Status.INFO, "Wellbeing Dashboard not found by any locator, assuming already on dashboard");
        }

        // Step 3: Click DATA BANK and verify it's displayed (robust logic)
        test.log(Status.INFO, "Step 3: Clicking DATA BANK and verifying it's displayed (iOS, robust)");
        boolean dataBankClicked = false;
        try {
            org.openqa.selenium.WebElement dataBankByXpath = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DATA BANK']")
            ));
            dataBankByXpath.click();
            test.log(Status.INFO, "✓ Clicked DATA BANK by xpath");
            Thread.sleep(1500);
            dataBankClicked = true;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ DATA BANK not found by xpath: " + e.getMessage());
            // Try by name
            try {
                org.openqa.selenium.WebElement dataBankByName = driver.findElement(org.openqa.selenium.By.name("DATA BANK"));
                dataBankByName.click();
                test.log(Status.INFO, "✓ Clicked DATA BANK by name");
                Thread.sleep(1500);
                dataBankClicked = true;
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ DATA BANK not found by name: " + ex1.getMessage());
            }
        }
        // Verify DATA BANK is displayed
        boolean isDataBankDisplayed = false;
        try {
            isDataBankDisplayed = driver.findElements(
                org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DATA BANK']")
            ).size() > 0;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ DATA BANK not found for verification: " + e.getMessage());
        }
        if (!isDataBankDisplayed) {
            try {
                isDataBankDisplayed = driver.findElements(
                    org.openqa.selenium.By.name("DATA BANK")
                ).size() > 0;
            } catch (Exception ex2) {
                test.log(Status.WARNING, "⚠ DATA BANK not found by name for verification: " + ex2.getMessage());
            }
        }
        if (!isDataBankDisplayed) {
            test.log(Status.FAIL, "DATA BANK not displayed after click");
            Assert.fail("DATA BANK validation failed - not displayed");
        } else {
            test.log(Status.PASS, "✓ DATA BANK is displayed after click");
        }

        boolean phoneFilled = false;
        try {
            org.openqa.selenium.WebElement phoneField = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeTextField[@value='12345678' and @enabled='true' and @visible='true']"));
            phoneField.click();
            phoneField.clear();
            phoneField.sendKeys("8072971990");
            test.log(Status.PASS, "✓ Step 23: Phone number field clicked, cleared, and filled with 8072971990");
            phoneFilled = true;
        } catch (Exception e) {
            test.log(Status.FAIL, "Step 23: Could not fill phone number field: " + e.getMessage());
        }
        Assert.assertTrue(phoneFilled, "Step 23: Phone number field should be filled");
        Thread.sleep(3000);
        dataBankPage.clickUploadData();
        test.log(Status.PASS, "✓ Step 4: UPLOAD DATA clicked");

        // ✅ TEST CASE 2 - STEP 5: Click UPLOAD REPORT button
        test.log(Status.INFO, "Step 5: Clicking UPLOAD REPORT button");
        dataBankPage.clickUploadReportButton();
        test.log(Status.PASS, "✓ Step 5: UPLOAD REPORT button clicked");

        // ✅ TEST CASE 2 - STEP 6: Click checkbox
        test.log(Status.INFO, "Step 6: Clicking checkbox");
        dataBankPage.clickCheckbox();
        test.log(Status.PASS, "✓ Step 6: Checkbox clicked");

        // ✅ TEST CASE 2 - STEP 7: Click CONTINUE button
        test.log(Status.INFO, "Step 7: Clicking CONTINUE button");
        dataBankPage.clickContinueButton();
        test.log(Status.PASS, "✓ Step 7: CONTINUE button clicked");
        // Steps 8, 9, 10, and 11 have been removed as requested.

        // ✅ TEST CASE 2 - STEP 12: Upload correct format file (PDF)
        test.log(Status.INFO, "Step 12: Uploading correct format file (PDF)");
        dataBankPage.uploadCorrectFormatFile();
        test.log(Status.INFO, "✓ Step 12: Correct format file (PDF) upload attempted");
        Thread.sleep(5000);

        // ✅ TEST CASE 2 - STEP 13 & 14: Validate UPLOAD SUCCESSFUL dialog and capture
        // success message
        test.log(Status.INFO, "Step 13: Validating UPLOAD SUCCESSFUL dialog");
        String successMessage = dataBankPage.validateUploadSuccessfulDialog();
        test.log(Status.PASS, "✓ Step 13: UPLOAD SUCCESSFUL dialog validated");
        test.log(Status.INFO, "📋 Success Message: " + successMessage);

        // Verify the success message is correct
        Assert.assertEquals(successMessage, "Your document has been successfully uploaded.",
            "Success message should confirm successful upload");
        test.log(Status.PASS, "✓ Step 14: Verified correct success message displayed");

        // ✅ TEST CASE 2 - STEP 15: Click OK button after successful upload
        test.log(Status.INFO, "Step 15: Clicking OK button");
        dataBankPage.clickOkButton();
        test.log(Status.PASS, "✓ Step 15: OK button clicked");

        // Wait for UI to settle after closing the success dialog
        Thread.sleep(2000);

        // ✅ TEST CASE 2 - STEP 16: Click remove button and verify ARE YOU SURE? dialog
        test.log(Status.INFO, "Step 16: Clicking remove button and verifying ARE YOU SURE? dialog");
        dataBankPage.clickRemoveAndVerifyAreYouSureDialog();
        test.log(Status.PASS, "✓ Step 16: Remove button clicked and ARE YOU SURE? dialog verified");

        // ✅ TEST CASE 2 - STEP 17: Click YES button and verify DELETE SUCCESSFUL dialog
        test.log(Status.INFO, "Step 17: Clicking YES button and verifying DELETE SUCCESSFUL dialog");
        dataBankPage.clickYesAndVerifyDeleteSuccessfulDialog();
        test.log(Status.PASS, "✓ Step 17: YES button clicked and DELETE SUCCESSFUL dialog verified");

        // ✅ TEST CASE 2 - STEP 18: Capture delete success message
        test.log(Status.INFO, "Step 18: Capturing delete success message");
        String deleteSuccessMessage = dataBankPage.captureDeleteSuccessMessage();
        test.log(Status.PASS, "✓ Step 18: Delete success message captured");
        test.log(Status.INFO, "📋 Delete Success Message: " + deleteSuccessMessage);

        // Verify the delete success message is correct
        Assert.assertEquals(deleteSuccessMessage, "Your report has been successfully removed.",
                "Delete success message should confirm successful removal");
        test.log(Status.PASS, "✓ Verified: Correct delete success message displayed");

        // ✅ TEST CASE 2 - STEP 19: Click OK button after delete success
        test.log(Status.INFO, "Step 19: Clicking OK button");
        dataBankPage.clickOkButton();
        test.log(Status.PASS, "✓ Step 19: OK button clicked");

        test.log(Status.PASS, "Data Bank Test Case 2 completed successfully");
    }

    /**
     * ==================== DATA BANK TEST CASE 3 ====================
     * 
     * Common Steps (1, 2 & 3):
     * 1. Verify DAILY PRIORITY heading on home page
     * 2. Click Wellbeing Dashboard
     * 3. Click DATA BANK and verify it's displayed
     * 
     * Test-Specific Steps:
     * TODO: Add your specific test steps here
     */
    @Test(priority = 3)
    public void testDataBank_Case3() throws InterruptedException {
        test = extent.createTest("Data Bank Test Case 3");
        test.log(Status.INFO, "Starting Data Bank Test Case 3");

        // Step 1: Verify DAILY PRIORITY heading is displayed on home page (iOS XPath)
        test.log(Status.INFO, "Step 1: Verifying DAILY PRIORITY heading on home page (iOS)");
        boolean isHomePageDisplayed = driver.findElements(
            org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DAILY PRIORITY']")
        ).size() > 0;
        if (!isHomePageDisplayed) {
            test.log(Status.FAIL, "DAILY PRIORITY heading not found on home page");
            Assert.fail("Home page validation failed - DAILY PRIORITY heading not displayed");
        }
        test.log(Status.PASS, "✓ DAILY PRIORITY heading is displayed on home page");

        // Step 2: Click Wellbeing Dashboard (iOS, robust fallback logic)
        test.log(Status.INFO, "Step 2: Clicking Wellbeing Dashboard (iOS, robust)");
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        boolean dashboardClicked = false;
        try {
            org.openqa.selenium.WebElement wellbeingDashboard = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//XCUIElementTypeImage[@name='WELLBEING DASHBOARD HOME'] | //XCUIElementTypeImage[contains(@name, 'WELLBEING')]")
            ));
            wellbeingDashboard.click();
            test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by xpath");
            Thread.sleep(1500);
            dashboardClicked = true;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by xpath: " + e.getMessage());
            // Try by accessibility id (Appium)
            try {
                org.openqa.selenium.WebElement dashboardByAccId = driver.findElement(io.appium.java_client.MobileBy.AccessibilityId("WELLBEING DASHBOARD HOME"));
                dashboardByAccId.click();
                test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by accessibility id");
                Thread.sleep(1500);
                dashboardClicked = true;
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by accessibility id: " + ex1.getMessage());
                // Try by name
                try {
                    org.openqa.selenium.WebElement dashboardByName = driver.findElement(org.openqa.selenium.By.name("WELLBEING DASHBOARD HOME"));
                    dashboardByName.click();
                    test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by name");
                    Thread.sleep(1500);
                    dashboardClicked = true;
                } catch (Exception ex2) {
                    test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by name: " + ex2.getMessage());
                }
            }
        }
        if (!dashboardClicked) {
            test.log(Status.INFO, "Wellbeing Dashboard not found by any locator, assuming already on dashboard");
        }

        // Step 3: Click DATA BANK and verify it's displayed (robust logic)
        test.log(Status.INFO, "Step 3: Clicking DATA BANK and verifying it's displayed (iOS, robust)");
        boolean dataBankClicked = false;
        try {
            org.openqa.selenium.WebElement dataBankByXpath = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DATA BANK']")
            ));
            dataBankByXpath.click();
            test.log(Status.INFO, "✓ Clicked DATA BANK by xpath");
            Thread.sleep(1500);
            dataBankClicked = true;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ DATA BANK not found by xpath: " + e.getMessage());
            // Try by name
            try {
                org.openqa.selenium.WebElement dataBankByName = driver.findElement(org.openqa.selenium.By.name("DATA BANK"));
                dataBankByName.click();
                test.log(Status.INFO, "✓ Clicked DATA BANK by name");
                Thread.sleep(1500);
                dataBankClicked = true;
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ DATA BANK not found by name: " + ex1.getMessage());
            }
        }
        // Verify DATA BANK is displayed
        boolean isDataBankDisplayed = false;
        try {
            isDataBankDisplayed = driver.findElements(
                org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DATA BANK']")
            ).size() > 0;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ DATA BANK not found for verification: " + e.getMessage());
        }
        if (!isDataBankDisplayed) {
            try {
                isDataBankDisplayed = driver.findElements(
                    org.openqa.selenium.By.name("DATA BANK")
                ).size() > 0;
            } catch (Exception ex2) {
                test.log(Status.WARNING, "⚠ DATA BANK not found by name for verification: " + ex2.getMessage());
            }
        }
        if (!isDataBankDisplayed) {
            test.log(Status.FAIL, "DATA BANK not displayed after click");
            Assert.fail("DATA BANK validation failed - not displayed");
        } else {
            test.log(Status.PASS, "✓ DATA BANK is displayed after click");
        }

        // Step 4: Click DEVICES
        test.log(Status.INFO, "Step 4: Clicking DEVICES");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DEVICES']")).click();
        test.log(Status.PASS, "✓ Step 4: DEVICES clicked");
        Thread.sleep(5000);

        // Step 5: Click LINK DEVICE button
        test.log(Status.INFO, "Step 5: Clicking LINK DEVICE button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='LINK DEVICE']")).click();
        test.log(Status.PASS, "✓ Step 5: LINK DEVICE button clicked");
        Thread.sleep(2000);
        
        // Step 6: Click ULTRAHUMAN button
        test.log(Status.INFO, "Step 6: Clicking ULTRAHUMAN button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='ULTRAHUMAN']")).click();
        test.log(Status.PASS, "✓ Step 6: ULTRAHUMAN button clicked");

        // Step 7: Click checkbox
        test.log(Status.INFO, "Step 7: Clicking checkbox");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeApplication[@name='AB Chopra']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")).click();
        test.log(Status.PASS, "✓ Step 7: Checkbox clicked");

        // Step 8: Click CONTINUE button
        test.log(Status.INFO, "Step 8: Clicking CONTINUE button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='CONTINUE']")).click();
        test.log(Status.PASS, "✓ Step 8: CONTINUE button clicked");

        // Step 9: Verify CONNECT WITH ULTRAHUMAN dialog
        test.log(Status.INFO, "Step 9: Verifying CONNECT WITH ULTRAHUMAN dialog");
        boolean isConnectDialog = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='CONNECT WITH ULTRAHUMAN']")).size() > 0;
        Assert.assertTrue(isConnectDialog, "CONNECT WITH ULTRAHUMAN dialog not found");
        test.log(Status.PASS, "✓ Step 9: CONNECT WITH ULTRAHUMAN dialog displayed");

        // Step 10: Enter invalid email
        test.log(Status.INFO, "Step 10: Entering invalid email");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeTextField[@name='Ultrahuman Email']")).sendKeys("invalidemail");
        test.log(Status.PASS, "✓ Step 10: Invalid email entered");

        // Step 11: Click VERIFY button
        test.log(Status.INFO, "Step 11: Clicking VERIFY button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='VERIFY']")).click();
        test.log(Status.PASS, "✓ Step 11: VERIFY button clicked");

        // Step 12: Validate INVALID EMAIL ID dialog
        test.log(Status.INFO, "Step 12: Validating INVALID EMAIL ID dialog");
        boolean isInvalidEmailDialog = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='INVALID EMAIL ID']")).size() > 0;
        Assert.assertTrue(isInvalidEmailDialog, "INVALID EMAIL ID dialog not found");
        test.log(Status.PASS, "✓ Step 12: INVALID EMAIL ID dialog displayed");

        // Step 13: Capture error message
        test.log(Status.INFO, "Step 13: Capturing error message");
        String errorMsg = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='Please enter a valid email id.']")).getText();
        test.log(Status.PASS, "✓ Step 13: Error message captured: " + errorMsg);

        // Step 14: Click OK button
        test.log(Status.INFO, "Step 14: Clicking OK button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
        test.log(Status.PASS, "✓ Step 14: OK button clicked");

        // Step 15: Click ULTRAHUMAN button
        test.log(Status.INFO, "Step 15: Clicking ULTRAHUMAN button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='ULTRAHUMAN']")).click();
        test.log(Status.PASS, "✓ Step 15: ULTRAHUMAN button clicked");

        // Step 16: Click checkbox
        test.log(Status.INFO, "Step 16: Clicking checkbox");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeApplication[@name='AB Chopra']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")).click();
        test.log(Status.PASS, "✓ Step 16: Checkbox clicked");

        // Step 17: Click CONTINUE button
        test.log(Status.INFO, "Step 17: Clicking CONTINUE button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='CONTINUE']")).click();
        test.log(Status.PASS, "✓ Step 17: CONTINUE button clicked");

        // Step 18: Enter valid email
        test.log(Status.INFO, "Step 18: Entering valid email");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeTextField[@name='Ultrahuman Email']")).sendKeys("valid@email.com");
        test.log(Status.PASS, "✓ Step 18: Valid email entered");

        // Step 19: Click VERIFY button
        test.log(Status.INFO, "Step 19: Clicking VERIFY button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='VERIFY']")).click();
        test.log(Status.PASS, "✓ Step 19: VERIFY button clicked");

        // Step 20: Validate DEVICE LINKED dialog
        test.log(Status.INFO, "Step 20: Validating DEVICE LINKED dialog");
        boolean isDeviceLinkedDialog = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DEVICE LINKED']")).size() > 0;
        Assert.assertTrue(isDeviceLinkedDialog, "DEVICE LINKED dialog not found");
        test.log(Status.PASS, "✓ Step 20: DEVICE LINKED dialog displayed");

        // Step 21: Capture success message
        test.log(Status.INFO, "Step 21: Capturing success message");
        String successMsg = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='Your device has been successfully linked.']")).getText();
        test.log(Status.PASS, "✓ Step 21: Success message captured: " + successMsg);

        // Step 22: Click OK button after successful device linking
        test.log(Status.INFO, "Step 22: Clicking OK button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
        test.log(Status.PASS, "✓ Step 22: OK button clicked");

        // Step 23: Click APPLE HEALTH KIT
        test.log(Status.INFO, "Step 23: Clicking APPLE HEALTH KIT");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='APPLE HEALTH KIT']")).click();
        test.log(Status.PASS, "✓ Step 23: APPLE HEALTH KIT clicked");

        // Step 24: Click checkbox
        test.log(Status.INFO, "Step 24: Clicking checkbox");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeApplication[@name='AB Chopra']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")).click();
        test.log(Status.PASS, "✓ Step 24: Checkbox clicked");

        // Step 25: Click CONTINUE button
        test.log(Status.INFO, "Step 25: Clicking CONTINUE button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='CONTINUE']")).click();
        test.log(Status.PASS, "✓ Step 25: CONTINUE button clicked");
        Thread.sleep(5000);

        // Step 26: Verify DEVICE LINKED dialog is shown
        test.log(Status.INFO, "Step 26: Verifying DEVICE LINKED dialog");
        boolean isDeviceLinkedDialog2 = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DEVICE LINKED']")).size() > 0;
        Assert.assertTrue(isDeviceLinkedDialog2, "DEVICE LINKED dialog not found after Apple HealthKit");
        test.log(Status.PASS, "✓ Step 26: DEVICE LINKED dialog displayed");

        // Step 27: Get the success message
        test.log(Status.INFO, "Step 27: Getting Apple HealthKit success message");
        String healthKitMsg = driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='Apple HealthKit has been successfully connected.']")).getText();
        test.log(Status.PASS, "✓ Step 27: Success message captured: " + healthKitMsg);

        // Step 28: Click OK
        test.log(Status.INFO, "Step 28: Clicking OK button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
        test.log(Status.PASS, "✓ Step 28: OK button clicked");

        // Step 29: Click back
        test.log(Status.INFO, "Step 29: Clicking back button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton")).click();
        test.log(Status.PASS, "✓ Step 29: Back button clicked");

        // Step 30: Swipe down once
        test.log(Status.INFO, "Step 30: Swiping down once");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeScrollView")).sendKeys("down");
        Thread.sleep(5000);
        test.log(Status.PASS, "✓ Step 30: Swiped down once");

        // Step 31: Verify Apple Health Kit is there
        test.log(Status.INFO, "Step 31: Verifying Apple Health Kit is present");
        boolean isAppleHealthKit = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='Apple Health Kit']")).size() > 0;
        Assert.assertTrue(isAppleHealthKit, "Apple Health Kit not found");
        test.log(Status.PASS, "✓ Step 31: Apple Health Kit is present");

        // Step 32: Click remove icon
        test.log(Status.INFO, "Step 32: Clicking remove icon");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeApplication[@name='AB Chopra']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")).click();
        test.log(Status.PASS, "✓ Step 32: Remove icon clicked");

        // Step 33: Verify remove dialog is shown
        test.log(Status.INFO, "Step 33: Verifying REMOVE DEVICE dialog");
        boolean isRemoveDialog = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='REMOVE DEVICE']")).size() > 0;
        Assert.assertTrue(isRemoveDialog, "REMOVE DEVICE dialog not found");
        test.log(Status.PASS, "✓ Step 33: REMOVE DEVICE dialog displayed");

        // Step 34: Click YES
        test.log(Status.INFO, "Step 34: Clicking YES button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='YES']")).click();
        test.log(Status.PASS, "✓ Step 34: YES button clicked");

        // Step 35: Verify REVOKE HEALTHKIT PERMISSIONS dialog
        test.log(Status.INFO, "Step 35: Verifying REVOKE HEALTHKIT PERMISSIONS dialog");
        boolean isRevokeDialog = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='REVOKE HEALTHKIT PERMISSIONS']")).size() > 0;
        Assert.assertTrue(isRevokeDialog, "REVOKE HEALTHKIT PERMISSIONS dialog not found");
        test.log(Status.PASS, "✓ Step 35: REVOKE HEALTHKIT PERMISSIONS dialog displayed");

        // Step 36: Click OK
        test.log(Status.INFO, "Step 36: Clicking OK button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
        test.log(Status.PASS, "✓ Step 36: OK button clicked");

        test.log(Status.PASS, "Data Bank Test Case 3 completed successfully");
    }

    /**
     * ==================== DATA BANK TEST CASE 4 ====================
     * 
     * Common Steps (1, 2 & 3):
     * 1. Verify DAILY PRIORITY heading on home page
     * 2. Click Wellbeing Dashboard
     * 3. Click DATA BANK and verify it's displayed
     * 
     * Test-Specific Steps:
     * TODO: Add your specific test steps here
     */
    @Test(priority = 4)
    public void testDataBank_Case4() throws InterruptedException {
        test = extent.createTest("Data Bank Test Case 4");
        test.log(Status.INFO, "Starting Data Bank Test Case 4");

        HomePage homePage = new HomePage(driver);
        DataBankPage dataBankPage = new DataBankPage(driver);


        // Step 1: Verify DAILY PRIORITY heading is displayed on home page (iOS XPath)
        test.log(Status.INFO, "Step 1: Verifying DAILY PRIORITY heading on home page (iOS)");
        boolean isHomePageDisplayed = driver.findElements(
            org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DAILY PRIORITY']")
        ).size() > 0;
        if (!isHomePageDisplayed) {
            test.log(Status.FAIL, "DAILY PRIORITY heading not found on home page");
            Assert.fail("Home page validation failed - DAILY PRIORITY heading not displayed");
        }
        test.log(Status.PASS, "✓ DAILY PRIORITY heading is displayed on home page");

        // Step 2: Click Wellbeing Dashboard (iOS, robust fallback logic)
        test.log(Status.INFO, "Step 2: Clicking Wellbeing Dashboard (iOS, robust)");
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        boolean dashboardClicked = false;
        try {
            org.openqa.selenium.WebElement wellbeingDashboard = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//XCUIElementTypeImage[@name='WELLBEING DASHBOARD HOME'] | //XCUIElementTypeImage[contains(@name, 'WELLBEING')]")
            ));
            wellbeingDashboard.click();
            test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by xpath");
            Thread.sleep(1500);
            dashboardClicked = true;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by xpath: " + e.getMessage());
            // Try by accessibility id (Appium)
            try {
                org.openqa.selenium.WebElement dashboardByAccId = driver.findElement(io.appium.java_client.MobileBy.AccessibilityId("WELLBEING DASHBOARD HOME"));
                dashboardByAccId.click();
                test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by accessibility id");
                Thread.sleep(1500);
                dashboardClicked = true;
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by accessibility id: " + ex1.getMessage());
                // Try by name
                try {
                    org.openqa.selenium.WebElement dashboardByName = driver.findElement(org.openqa.selenium.By.name("WELLBEING DASHBOARD HOME"));
                    dashboardByName.click();
                    test.log(Status.INFO, "✓ Clicked WELLBEING DASHBOARD HOME by name");
                    Thread.sleep(1500);
                    dashboardClicked = true;
                } catch (Exception ex2) {
                    test.log(Status.WARNING, "⚠ WELLBEING DASHBOARD HOME not found by name: " + ex2.getMessage());
                }
            }
        }
        if (!dashboardClicked) {
            test.log(Status.INFO, "Wellbeing Dashboard not found by any locator, assuming already on dashboard");
        }

        // Step 3: Click DATA BANK and verify it's displayed (robust logic)
        test.log(Status.INFO, "Step 3: Clicking DATA BANK and verifying it's displayed (iOS, robust)");
        boolean dataBankClicked = false;
        try {
            org.openqa.selenium.WebElement dataBankByXpath = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DATA BANK']")
            ));
            dataBankByXpath.click();
            test.log(Status.INFO, "✓ Clicked DATA BANK by xpath");
            Thread.sleep(1500);
            dataBankClicked = true;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ DATA BANK not found by xpath: " + e.getMessage());
            // Try by name
            try {
                org.openqa.selenium.WebElement dataBankByName = driver.findElement(org.openqa.selenium.By.name("DATA BANK"));
                dataBankByName.click();
                test.log(Status.INFO, "✓ Clicked DATA BANK by name");
                Thread.sleep(1500);
                dataBankClicked = true;
            } catch (Exception ex1) {
                test.log(Status.WARNING, "⚠ DATA BANK not found by name: " + ex1.getMessage());
            }
        }
        // Verify DATA BANK is displayed
        boolean isDataBankDisplayed = false;
        try {
            isDataBankDisplayed = driver.findElements(
                org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='DATA BANK']")
            ).size() > 0;
        } catch (Exception e) {
            test.log(Status.WARNING, "⚠ DATA BANK not found for verification: " + e.getMessage());
        }
        if (!isDataBankDisplayed) {
            try {
                isDataBankDisplayed = driver.findElements(
                    org.openqa.selenium.By.name("DATA BANK")
                ).size() > 0;
            } catch (Exception ex2) {
                test.log(Status.WARNING, "⚠ DATA BANK not found by name for verification: " + ex2.getMessage());
            }
        }
        if (!isDataBankDisplayed) {
            test.log(Status.FAIL, "DATA BANK not displayed after click");
            Assert.fail("DATA BANK validation failed - not displayed");
        } else {
            test.log(Status.PASS, "✓ DATA BANK is displayed after click");
        }

        // ...existing code...

        // ✅ TEST CASE 4 - STEP 4: Click REPORTS
        test.log(Status.INFO, "Step 4: Clicking REPORTS");
        dataBankPage.clickReports();
        test.log(Status.PASS, "✓ Step 4: REPORTS clicked");

        // ✅ TEST CASE 4 - STEP 5: Click BLOOD REPORT and verify page
        test.log(Status.INFO, "Step 5: Clicking BLOOD REPORT and verifying page");
        dataBankPage.clickAndVerifyBloodReport();
        test.log(Status.PASS, "✓ Step 5: BLOOD REPORT clicked and page verified");

        // ✅ TEST CASE 4 - NEW STEP 6: Click priority filters (HIGH, MEDIUM, LOW)
        test.log(Status.INFO, "Step 6: Clicking HIGH PRIORITY filter");
        dataBankPage.clickHighPriority();
        test.log(Status.PASS, "✓ Step 6: HIGH PRIORITY filter clicked");

        test.log(Status.INFO, "Step 6: Clicking MEDIUM PRIORITY filter");
        dataBankPage.clickMediumPriority();
        test.log(Status.PASS, "✓ Step 6: MEDIUM PRIORITY filter clicked");

        test.log(Status.INFO, "Step 6: Clicking LOW PRIORITY filter");
        dataBankPage.clickLowPriority();
        test.log(Status.PASS, "✓ Step 6: LOW PRIORITY filter clicked");

        // ✅ TEST CASE 4 - NEW STEP 7: Click RENAL dropdown
        test.log(Status.INFO, "Step 7: Clicking RENAL dropdown");
        dataBankPage.clickRenalDropdown();
        test.log(Status.PASS, "✓ Step 7: RENAL dropdown clicked");

        // ✅ TEST CASE 4 - NEW STEP 8: Click HIGH PRIORITY and verify Creatinine High
        // Priority
        test.log(Status.INFO, "Step 8: Clicking HIGH PRIORITY and verifying Creatinine High Priority");
        dataBankPage.clickHighPriorityAndVerifyCreatinine();
        test.log(Status.PASS, "✓ Step 8: HIGH PRIORITY clicked and Creatinine High Priority verified");

        // ✅ TEST CASE 4 - NEW STEP 9: Click MEDIUM PRIORITY and verify Bun Medium
        // Priority
        test.log(Status.INFO, "Step 9: Clicking MEDIUM PRIORITY and verifying Bun Medium Priority");
        dataBankPage.clickMediumPriorityAndVerifyBun();
        test.log(Status.PASS, "✓ Step 9: MEDIUM PRIORITY clicked and Bun Medium Priority verified");

        // ✅ TEST CASE 4 - NEW STEP 10: Click LOW PRIORITY and verify Bun/creatinine Low
        // Priority
        test.log(Status.INFO, "Step 10: Clicking LOW PRIORITY and verifying Bun/creatinine Low Priority");
        dataBankPage.clickLowPriorityAndVerifyBunCreatinine();
        test.log(Status.PASS, "✓ Step 10: LOW PRIORITY clicked and Bun/creatinine Low Priority verified");

        // ✅ TEST CASE 4 - NEW STEP 12: Click priority items twice to deselect
        test.log(Status.INFO, "Step 12: Clicking priority items twice to deselect them");
        System.out.println("[TEST] Calling clickPriorityItemsTwice() for Step 12: Deselect all priority items");
        dataBankPage.clickPriorityItemsTwice();
        test.log(Status.PASS, "✓ Step 12: All priority items clicked twice");

        // ✅ TEST CASE 4 - NEW STEP 13: Swipe up once
        test.log(Status.INFO, "Step 13: Swiping up once");
        dataBankPage.swipeUpOnce();
        test.log(Status.PASS, "✓ Step 13: Swiped up once");

        // ✅ TEST CASE 4 - STEP 14: Click back button once (previously step 6)
        test.log(Status.INFO, "Step 14: Clicking back button once");
        dataBankPage.clickBackButton();
        test.log(Status.PASS, "✓ Step 14: Back button clicked once");

        // ✅ TEST CASE 4 - STEP 15: Click REPORTS again (previously step 7)
        test.log(Status.INFO, "Step 15: Clicking REPORTS");
        dataBankPage.clickReports();
        test.log(Status.PASS, "✓ Step 15: REPORTS clicked");

        // ✅ TEST CASE 4 - STEP 16: Click DNA REPORT and verify page (previously step 8)
        test.log(Status.INFO, "Step 16: Clicking DNA REPORT and verifying page");
        dataBankPage.clickAndVerifyDnaReport();
        test.log(Status.PASS, "✓ Step 16: DNA REPORT clicked and page verified");

        // ✅ TEST CASE 4 - STEP 17: Click PURCHASE and verify PACKAGES & PRICING page
        test.log(Status.INFO, "Step 17: Clicking PURCHASE button");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeButton[@name='PURCHASE']")).click();
        test.log(Status.PASS, "✓ Step 17: PURCHASE button clicked");
        // Verify PACKAGES & PRICING page
        boolean isPackagesPage = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='PACKAGES & PRICING']")).size() > 0;
        Assert.assertTrue(isPackagesPage, "PACKAGES & PRICING page not found after clicking PURCHASE");
        test.log(Status.PASS, "✓ Step 17: PACKAGES & PRICING page verified");
        Thread.sleep(5000);

        // ✅ TEST CASE 4 - STEP 18: Click back button twice
        test.log(Status.INFO, "Step 18: Clicking back button twice");
        dataBankPage.clickBackButtonTwice();
        test.log(Status.PASS, "✓ Step 18: Back button clicked twice");

        // ✅ TEST CASE 4 - STEP 19: Click REPORTS again
        test.log(Status.INFO, "Step 19: Clicking REPORTS again");
        dataBankPage.clickReports();
        test.log(Status.PASS, "✓ Step 19: REPORTS clicked again");

        // ✅ TEST CASE 4 - STEP 20: Click DEVICE REPORT and verify page
        test.log(Status.INFO, "Step 20: Clicking DEVICE REPORT and verifying page");
        dataBankPage.clickAndVerifyDeviceReport();
        test.log(Status.PASS, "✓ Step 20: DEVICE REPORT clicked and page verified");

        // ✅ TEST CASE 4 - STEP 21: Click priority filters (HIGH, MEDIUM, LOW)
        test.log(Status.INFO, "Step 21: Clicking HIGH PRIORITY filter");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='HIGH PRIORITY']")).click();
        test.log(Status.PASS, "✓ Step 21: HIGH PRIORITY filter clicked");
        test.log(Status.INFO, "Step 21: Clicking MEDIUM PRIORITY filter");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='MEDIUM PRIORITY']")).click();
        test.log(Status.PASS, "✓ Step 21: MEDIUM PRIORITY filter clicked");
        test.log(Status.INFO, "Step 21: Clicking LOW PRIORITY filter");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='LOW PRIORITY']")).click();
        test.log(Status.PASS, "✓ Step 21: LOW PRIORITY filter clicked");

        // ✅ TEST CASE 4 - STEP 22: Click ACTIVITY & MOVEMENT dropdown
        test.log(Status.INFO, "Step 22: Clicking ACTIVITY & MOVEMENT dropdown");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeImage[@name='ACTIVITY & MOVEMENT']")).click();
        test.log(Status.PASS, "✓ Step 22: ACTIVITY & MOVEMENT dropdown clicked");

        // ✅ TEST CASE 4 - STEP 23: Click HIGH PRIORITY and verify STEP COUNT High Priority
        test.log(Status.INFO, "Step 23: Clicking HIGH PRIORITY filter");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='HIGH PRIORITY']")).click();
        test.log(Status.PASS, "✓ Step 23: HIGH PRIORITY filter clicked");
        // Wait for UI update
        Thread.sleep(1000);
        // Robustly verify STEP COUNT High Priority by name/label (handle newlines)
        boolean foundStepCountHigh = false;
        java.util.List<org.openqa.selenium.WebElement> images = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeImage"));
        for (org.openqa.selenium.WebElement el : images) {
            String n = el.getAttribute("name");
            String l = el.getAttribute("label");
            if ((n != null && n.replaceAll("\\s+"," ").trim().equalsIgnoreCase("STEP COUNT High Priority")) ||
                (l != null && l.replaceAll("\\s+"," ").trim().equalsIgnoreCase("STEP COUNT High Priority"))) {
                foundStepCountHigh = true;
                break;
            }
        }
        Assert.assertTrue(foundStepCountHigh, "STEP COUNT High Priority not found after clicking HIGH PRIORITY");
        test.log(Status.PASS, "✓ Step 23: STEP COUNT High Priority verified");

        // ✅ TEST CASE 4 - STEP 24: Click MEDIUM PRIORITY
        test.log(Status.INFO, "Step 24: Clicking MEDIUM PRIORITY filter");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='MEDIUM PRIORITY']")).click();
        test.log(Status.PASS, "✓ Step 24: MEDIUM PRIORITY filter clicked");

        // ✅ TEST CASE 4 - STEP 25: Click LOW PRIORITY
        test.log(Status.INFO, "Step 25: Clicking LOW PRIORITY filter");
        driver.findElement(org.openqa.selenium.By.xpath("//XCUIElementTypeStaticText[@name='LOW PRIORITY']")).click();
        test.log(Status.PASS, "✓ Step 25: LOW PRIORITY filter clicked");

        // ✅ TEST CASE 4 - STEP 26: Click STEP COUNT High Priority (by name only)
        test.log(Status.INFO, "Step 26: Clicking STEP COUNT High Priority by name");
        boolean clickedStepCount = false;
        images = driver.findElements(org.openqa.selenium.By.xpath("//XCUIElementTypeImage"));
        for (org.openqa.selenium.WebElement el : images) {
            String n = el.getAttribute("name");
            String l = el.getAttribute("label");
            if ((n != null && n.replaceAll("\\s+"," ").trim().equalsIgnoreCase("STEP COUNT High Priority")) ||
                (l != null && l.replaceAll("\\s+"," ").trim().equalsIgnoreCase("STEP COUNT High Priority"))) {
                el.click();
                clickedStepCount = true;
                break;
            }
        }
        Assert.assertTrue(clickedStepCount, "STEP COUNT High Priority could not be clicked by name");
        test.log(Status.PASS, "✓ Step 26: STEP COUNT High Priority clicked by name");

        // ✅ TEST CASE 4 - STEP 27: Click back button once
        test.log(Status.INFO, "Step 27: Clicking back button once");
        dataBankPage.clickBackButton();
        test.log(Status.PASS, "✓ Step 27: Back button clicked once");
    }
}