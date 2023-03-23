# Appium-Cucumber-Demo
This repositories contains the basic demo of facebook automation using Appium

There are three test in the demo:
1. [InstallAndUninstallFacebookTest.java](src/test/java/com/qualitest/lava/InstallAndUninstallFacebookTest.java) : this is written in using TestNG
1. [MakeCallAndSmsTest.java](src/test/java/com/qualitest/lava/MakeCallAndSmsTest.java) : This is also written in TestNG
1. [Facebook Login Test](src/test/resources/features/login-datadriven.feature) : which is written in cucumber

To run the test use following command

```
$> mvn clean test -Dtest=_TestName_
