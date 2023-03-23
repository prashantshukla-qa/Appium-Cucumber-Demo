# Appium-Cucumber-Demo
This repositories contains the basic demo of facebook automation using Appium

There are three test in the demo:
1. [InstallAndUninstallFacebookTest.java](src/test/java/com/qualitest/lava/InstallAndUninstallFacebookTest.java) : this is written in using TestNG
1. [MakeCallAndSmsTest.java](src/test/java/com/qualitest/lava/MakeCallAndSmsTest.java) : This is also written in TestNG
1. [Facebook Login Test](src/test/resources/features/login-datadriven.feature) : which is written in cucumber

To run the test use following command

```
$> mvn clean test -Dtest=_TestName_
```
## Tests Covered

### InstallAndUninstallFacebookTest.java
Pre-Requisite: A device with facebook app installed

Tests:
1. Uninstall Facebook from google playstore
1. Install Facebook from google playstore

### MakeCallAndSmsTest.java
Tests:
1. testImeiNumbers : Get IMEI numbers and validate
1. testCallWithoutNetwork : Make a call without sim and verify error message
1. testNotifications : Open notification panel and print all the notification headers

### Facebook Login Test

Tests:
1. Login to facebook using incorrect credentials
1. Login to facebook using correct credentials (WIP)
