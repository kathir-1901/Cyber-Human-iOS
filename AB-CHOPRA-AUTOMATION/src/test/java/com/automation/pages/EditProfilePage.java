package com.automation.pages;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput;
import java.util.Collections;
// Removed duplicate import

public class EditProfilePage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public EditProfilePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators (iOS XPath)
    private final String editProfileHeadingXpath = "//XCUIElementTypeStaticText[@name='EDIT PROFILE']";
    private final String nameFieldXpath = "(//XCUIElementTypeTextField)[1]";
    private final String emailFieldXpath = "(//XCUIElementTypeTextField)[2]";
    private final String dateOfBirthFieldXpath = "//XCUIElementTypeOther[@name='Date of birth']";
    private final String genderButtonXpath = "//XCUIElementTypeButton[@name='Gender']";
    private final String phoneNumberFieldXpath = "//XCUIElementTypeTextField[@name='Phone Number']";
    private final String countryCodeXpath = "//XCUIElementTypeStaticText[@name='🇦🇫 +93']";
    private final String saveChangesButtonXpath = "//XCUIElementTypeButton[@name='SAVE CHANGES']";
    private final String changePasswordButtonXpath = "//XCUIElementTypeButton[@name='CHANGE PASSWORD']";

    public void enterName(String name) {
        try {
            WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nameFieldXpath)));
            nameField.click();
            nameField.clear();
            nameField.sendKeys(name);
            hideKeyboard();
        } catch (TimeoutException e) {
            throw new RuntimeException("Name field not found on Edit Profile page", e);
        }
    }

    public void enterEmail(String email) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailFieldXpath)));
            emailField.click();
            emailField.clear();
            emailField.sendKeys(email);
            hideKeyboard();
        } catch (TimeoutException e) {
            throw new RuntimeException("Email field not found on Edit Profile page", e);
        }
    }

    public void enterPhoneNumber(String phoneNumber) {
        try {
            WebElement phoneField = null;
            try {
                phoneField = driver.findElement(By.id("0A010000-0000-0000-7B0A-000000000000"));
            } catch (Exception e0) {
                try {
                    phoneField = driver.findElement(io.appium.java_client.MobileBy.AccessibilityId("Phone Number"));
                } catch (Exception e1) {
                    try {
                        phoneField = driver.findElement(io.appium.java_client.MobileBy.iOSClassChain("**/XCUIElementTypeTextField[`name == 'Phone Number'`]") );
                    } catch (Exception e2) {
                        try {
                            phoneField = driver.findElement(io.appium.java_client.MobileBy.iOSNsPredicateString("name == 'Phone Number'"));
                        } catch (Exception e3) {
                            try {
                                phoneField = driver.findElement(By.xpath("//XCUIElementTypeTextField[@name='Phone Number']"));
                            } catch (Exception e4) {
                                throw new RuntimeException("Phone Number field not found on Edit Profile page after all locator attempts", e4);
                            }
                        }
                    }
                }
            }
            phoneField.click();
            phoneField.clear();
            phoneField.sendKeys(phoneNumber);
            hideKeyboard();
        } catch (Exception e) {
            throw new RuntimeException("Phone Number field not found on Edit Profile page after all locator attempts", e);
        }
    }

    public void clickDateOfBirth() {
        try {
            hideKeyboard();
            Thread.sleep(500);
            WebElement dobField = driver.findElement(
                io.appium.java_client.MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeOther' AND value CONTAINS '/'")
            );
            dobField.click();
            System.out.println("Clicked Date of Birth using iOSNsPredicateString.");
        } catch (Exception e) {
            try {
                WebElement dobFallback = driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Date of birth']"));
                dobFallback.click();
                System.out.println("Clicked Date of Birth using fallback XPath.");
            } catch (Exception e2) {
                throw new RuntimeException("Date of Birth field not found using iOSNsPredicateString or fallback XPath", e2);
            }
        }
    }

    private void swipeDown(WebElement element) {
        int centerX = element.getRect().getX() + (element.getRect().getWidth() / 2);
        int startY = element.getRect().getY() + (element.getRect().getHeight() / 2);
        int endY = startY + 200;
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
    }

    /**
     * Helper method to Tap on an element using W3C Actions (Force Click)
     */
    private void tapElement(WebElement element) {
        int centerX = element.getRect().getX() + (element.getRect().getWidth() / 2);
        int centerY = element.getRect().getY() + (element.getRect().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(tap));
    }

    /**
     * Click the Gender dropdown button
     * Includes robust fallback
     */
    public void clickGender() {
        try {
            WebElement genderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(genderButtonXpath)));
            genderBtn.click();
            System.out.println("Clicked Gender button using main XPath.");
        } catch (Exception e1) {
            // Fallback: Click Male button if Gender not found
            try {
                WebElement maleBtn = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Male']"));
                maleBtn.click();
                System.out.println("Gender button not found, clicked Male button using XPath.");
            } catch (Exception e2) {
                throw new RuntimeException("Gender button not found on Edit Profile page after retry, and Male button also not found.", e2);
            }
        }
    }

    /**
     * Select gender from dropdown
     * 
     * @param gender Gender option (e.g., "Male", "Female", "Other")
     */
    public void selectGender(String gender) {
        try {
            Thread.sleep(1000);
            WebElement genderOption = null;
            try {
                genderOption = driver.findElement(io.appium.java_client.MobileBy.AccessibilityId(gender));
            } catch (Exception e1) {
                try {
                    genderOption = driver.findElement(io.appium.java_client.MobileBy.iOSClassChain("**/XCUIElementTypeButton[`name == '" + gender + "'`]"));
                } catch (Exception e2) {
                    try {
                        genderOption = driver.findElement(io.appium.java_client.MobileBy.iOSNsPredicateString("name == '" + gender + "'"));
                    } catch (Exception e3) {
                        try {
                            genderOption = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='" + gender + "']"));
                        } catch (Exception e4) {
                            System.out.println("Could not select gender: " + gender + " - " + e4.getMessage());
                        }
                    }
                }
            }
            if (genderOption != null) {
                genderOption.click();
            }
        } catch (Exception e) {
            System.out.println("Could not select gender: " + gender + " - " + e.getMessage());
        }
    }

    /**
     * Click the Country Code dropdown
     * Includes robust fallback
     */
    public void clickCountryCode() {
        try {
            // Find the first country code element whose name contains '+'
            WebElement countryCode = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//XCUIElementTypeStaticText[contains(@name, '+')]")));
            countryCode.click();
            System.out.println("Clicked Country Code using contains(+) XPath: " + countryCode.getAttribute("name"));
        } catch (Exception e) {
            throw new RuntimeException("Country Code dropdown with '+' not found on Edit Profile page", e);
        }
    }

    /**
     * Select country from country code dropdown
     * Scroll until finding the country using W3C actions
     * 
     * @param country Country name (e.g., "Belarus")
     */
    public void selectCountry(String country) {
        try {
            Thread.sleep(1000); // Wait for dropdown list to fully load
            int maxSwipes = 20;
            boolean found = false;
            for (int i = 0; i < maxSwipes; i++) {
                try {
                    WebElement countryOption = driver.findElement(
                        io.appium.java_client.MobileBy.iOSNsPredicateString("name CONTAINS '" + country + "'")
                    );
                    if (countryOption != null && countryOption.isDisplayed() && countryOption.isEnabled()) {
                        tapElement(countryOption);
                        found = true;
                        break;
                    }
                } catch (Exception e) {
                    // Not found, will swipe up
                }
                // Strong full-screen swipe up (85% to 15%)
                org.openqa.selenium.Dimension size = driver.manage().window().getSize();
                int centerX = size.width / 2;
                int startY = (int) (size.height * 0.85);
                int endY = (int) (size.height * 0.15);

                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1);

                swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), centerX, endY));
                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Collections.singletonList(swipe));
                Thread.sleep(700);
            }
            if (!found) {
                System.out.println("Could not find country: " + country + " after swiping " + maxSwipes + " times.");
            }
        } catch (Exception e) {
            System.out.println("Error selecting country: " + country + " - " + e.getMessage());
        }
    }

    /**
     * Helper method to swipe up (scroll down)
     */
    private void swipeUp() {
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int centerX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), centerX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    /**
     * Click the SAVE CHANGES button
     */
    public void clickSaveChanges() {
        try {
            WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(saveChangesButtonXpath)));
            saveBtn.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("SAVE CHANGES button not found on Edit Profile page", e);
        }
    }

    /**
     * Click the CHANGE PASSWORD button
     */
    public void clickChangePassword() {
        try {
            WebElement changePassBtn = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(changePasswordButtonXpath)));
            changePassBtn.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("CHANGE PASSWORD button not found on Edit Profile page", e);
        }
    }

    /**
     * Check if Edit Profile page is displayed
     */
    public boolean isEditProfilePageDisplayed() {
        try {
            WebElement heading = wait
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(editProfileHeadingXpath)));
            return heading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * RUNTIME-BASED VALIDATION DETECTION (NO HARDCODED MESSAGES)
     * 
     * Checks at runtime if ANY validation element is visible:
     * - Alert Dialog (Top Priority)
     * - Validation message via name attribute (XCUIElementTypeOther)
     * - Static text error messages
     * - Success messages
     * 
     * @return true if ANY validation is detected, false if NONE found
     */
    public boolean isAnyValidationVisible() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Check -1: Success Popup (User requested to treat success as pass)
        try {
            WebElement successPopup = shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//XCUIElementTypeStaticText[@name='Your profile has been updated']")));
            if (successPopup.isDisplayed()) {
                return true;
            }
        } catch (Exception ignored) {
        }

        // Check 0: Alert Dialog (Highest Priority)
        try {
            WebElement alert = shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//XCUIElementTypeAlert")));
            if (alert.isDisplayed()) {
                return true;
            }
        } catch (Exception ignored) {
        }

        // Check 1: Validation message via name attribute with error keywords
        try {
            WebElement validationView = shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(
                            "//XCUIElementTypeOther[@name and (contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'invalid') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'error') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'required') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'please') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'must') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cannot'))]\"")));
            String name = validationView.getAttribute("name");
            if (name != null && !name.trim().isEmpty()) {
                return true;
            }
        } catch (Exception ignored) {
        }

        // Check 2: StaticText with error keywords
        try {
            WebElement errorKeyword = shortWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//XCUIElementTypeStaticText[" +
                            "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'invalid') or "
                            +
                            "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'error') or "
                            +
                            "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'required') or "
                            +
                            "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'please')]")));
            String text = errorKeyword.getAttribute("name");
            if (text != null && !text.trim().isEmpty()) {
                return true;
            }
        } catch (Exception ignored) {
        }

        // No validation detected
        return false;
    }

    /**
     * GET ACTUAL RUNTIME VALIDATION MESSAGE
     * 
     * Captures the actual validation message displayed by the app at runtime.
     * 
     * Priority order for message capture:
     * 1. Alert message
     * 2. Validation message from name attribute (XCUIElementTypeOther)
     * 3. StaticText with error keywords
     * 4. Success message
     * 
     * @return The actual validation message text, or null if no validation found
     */
    public String getValidationMessage() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Priority -1: Success Popup (robust, checks name/label/value, case-insensitive, trims)
        try {
            java.util.List<WebElement> staticTexts = driver.findElements(By.className("XCUIElementTypeStaticText"));
            for (WebElement el : staticTexts) {
                String name = (el.getAttribute("name") != null) ? el.getAttribute("name").trim() : "";
                String label = (el.getAttribute("label") != null) ? el.getAttribute("label").trim() : "";
                String value = (el.getAttribute("value") != null) ? el.getAttribute("value").trim() : "";
                if (el.isDisplayed() && (
                        name.equalsIgnoreCase("Your profile has been updated.") ||
                        label.equalsIgnoreCase("Your profile has been updated.") ||
                        value.equalsIgnoreCase("Your profile has been updated."))) {
                    return "Your profile has been updated.";
                }
            }
        } catch (Exception e) {
            System.out.println("[DEBUG] Error while searching for static text success message: " + e.getMessage());
        }

        // Priority 0: Alert message
        try {
            WebElement alert = shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//XCUIElementTypeAlert")));
            if (alert.isDisplayed()) {
                String alertText = alert.getText();
                if (alertText != null && !alertText.trim().isEmpty()) {
                    return alertText;
                }
            }
        } catch (Exception ignored) {
        }

        // Priority 1: Validation message via name attribute with error keywords
        try {
            WebElement validationView = shortWait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(
                            "//XCUIElementTypeOther[@name and (contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'invalid') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'error') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'required') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'please') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'must') or "
                                    +
                                    "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cannot'))]")));
            String name = validationView.getAttribute("name");
            if (name != null && !name.trim().isEmpty()) {
                return name;
            }
        } catch (Exception ignored) {
        }

        // Priority 2: StaticText with error keywords
        try {
            WebElement errorKeyword = shortWait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//XCUIElementTypeStaticText[" +
                            "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'invalid') or "
                            +
                            "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'error') or "
                            +
                            "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'required') or "
                            +
                            "contains(translate(@name, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'please')]")));
            String text = errorKeyword.getAttribute("name");
            if (text != null && !text.trim().isEmpty()) {
                return text;
            }
        } catch (Exception ignored) {
        }

        // Debug: Log all static texts if nothing found
        try {
            java.util.List<WebElement> staticTexts = driver.findElements(By.className("XCUIElementTypeStaticText"));
            System.out.println("[DEBUG] All visible static texts on page:");
            for (WebElement el : staticTexts) {
                if (el.isDisplayed()) {
                    System.out.println("[DEBUG] name: '" + el.getAttribute("name") + "', label: '" + el.getAttribute("label") + "', value: '" + el.getAttribute("value") + "'");
                }
            }
        } catch (Exception e) {
            System.out.println("[DEBUG] Error while logging static texts: " + e.getMessage());
        }

        // No validation message found
        return null;
    }

    /**
     * Helper to hide keyboard safely
     */
    public void hideKeyboard() {
        try {
            if (driver instanceof io.appium.java_client.ios.IOSDriver) {
                ((io.appium.java_client.ios.IOSDriver) driver).hideKeyboard();
            }
        } catch (Exception ignored) {
        }
    }

    /**
     * PERFORM DATE SELECTION (SWIPE ACTIONS)
     * Swipes down on Day, Month, and Year wheels and clicks Confirm
     * Uses position-based XPath to work with any date (future-proof)
     */
    public void performDateSelection() {
        try {
            Thread.sleep(1000); // Wait for date picker to appear
            // Find all custom picker wheels
            java.util.List<WebElement> pickerWheels = driver.findElements(By.xpath("//XCUIElementTypeOther[@enabled='true' and @visible='true' and @traits='Adjustable']"));
            if (pickerWheels.size() < 3) {
                throw new RuntimeException("Expected at least 3 picker wheels, found: " + pickerWheels.size());
            }
            // For Date, Month, Year wheels
            for (int i = 0; i < 3; i++) {
                WebElement wheel = pickerWheels.get(i);
                // Calculate swipe coordinates
                int x = wheel.getRect().getX() + (wheel.getRect().getWidth() / 2);
                int startY = wheel.getRect().getY() + (int)(wheel.getRect().getHeight() * 0.2);
                int endY = wheel.getRect().getY() + (int)(wheel.getRect().getHeight() * 0.8);
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1);
                swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), x, endY));
                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                driver.perform(Collections.singletonList(swipe));
                Thread.sleep(500); // Small delay between swipes
            }
            // Click CONFIRM button after all swipes
            try {
                WebElement confirmBtn = driver.findElement(By.xpath("//XCUIElementTypeButton[@name='CONFIRM']"));
                confirmBtn.click();
                Thread.sleep(300); // Optional: small delay after confirm
            } catch (Exception ce) {
                System.out.println("CONFIRM button not found or not clickable: " + ce.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error in performDateSelection: " + e.getMessage());
        }
    }
}
