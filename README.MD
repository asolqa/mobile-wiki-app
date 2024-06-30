# Mobile test automation project for [Wikipedia App ](https://github.com/wikimedia/apps-android-wikipedia/)

---


<img src="./media/wikipedia_logo.png"/></a>

---


## Content:

- <a href="#tools">Tools and technologies</a>
- <a href="#facts">Project features</a>
- <a href="#scenarios">Test scenarios</a>
- <a href="#cli">Launch from the CLI</a>
- <a href="#jenkins">CI/CD with Jenkins</a>
- <a href="#allure">Allure reporting</a>
- <a href="#allure-testops">Integration with Allure TestOps</a>
- <a href="#jira">Integration with JIRA</a>
- <a href="#telegram">Bot notifications in Telegram</a>


<a id="tools"></a>
## Tools and technologies
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="./media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="./media/logo/java.svg" width="50" height="50"  alt="Java"/></a>   
<a href="https://appium.io/docs/en/latest/"><img src="media/logo/Appium.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://developer.android.com/"><img src="media/logo/AndroidStudio.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://www.browserstack.com/home"><img src="media/logo/Browserstack.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="./media/logo/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="./media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="./media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="./media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="./media/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="./media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="./media/logo/JIRA.svg" width="50" height="50"  alt="Jira"/></a>
</p>

<a id="facts"></a>
## Project features
* `Page object` pattern 
* Config with `Owner` library
* Test cases as a documentation with `Allure TestOps`
* Launch all or separate tests from TMS directly
* `JIRA` integration
* Telegram notifications

<a id="scenarios"></a>
## Test Scenarios
* [x] Wiki onboarding walkthrough test
* [x] Search for data test
* [x] Search and open an article test


<a id="cli"></a>
## <img alt="cli" height="25" src="./media/logo/run.png" width="25"> Launch from the CLI

Local launch:

```bash  
./gradlew clean test -Ddriver.class.name=driver.LocalDriver
```
>Be sure you have installed all needed  pre-requisites/dependencies as `Android Studio`, `node.js`, `Appuim` locally according to [instruction](https://autotest.how/appium-setup-for-local-android-tutorial-md)

Remote launch:
```bash  
./gradlew clean test -Ddriver.class.name=driver.BrowserstackDriver
```
>Browserstack requires unique user credentials. Also download the latest version of app 
>and upload it to the browserstack before test execution. Get the unique app id and set in the configuration file.

All configurations are described in the `local_runner.properties`, `browser_stack_runner.properties`, `runner.properties` 
and `credentials.properties` files. If needed configurations could be changed in those files.

<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="./media/logo/Jenkins.svg" width="25"/></a><a name="CI/CD with Jenkins"></a>CI/CD with [Jenkins](https://jenkins.autotests.cloud/job/26-asolqa-wiki-mobile/)</a>
<img alt="Jenkins" src="./media/reports/Jenkins.png"> 

### Jenkins job

- `COMMENT` parameter (by default @asolqa is tagged)

After the build is done the test results are available in `Allure`, `Allure TestOps` and `JIRA`

<a id="allure"></a>
## <img alt="Allure" height="25" src="./media/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [reporting](https://jenkins.autotests.cloud/job/26-asolqa-wiki-mobile/allure/)</a>
<img alt="Allure" src="./media/reports/AllureReportExample.png"> 

`Allure` report includes logged test steps, attached page source and video for remote execution:

<img alt="Allure2" src="./media/reports/AllureReportExample2.png">


<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="./media/logo/AllureTestOps.svg" width="25"/></a> Integration with <a target="_blank" href="https://allure.autotests.cloud/project/4314/dashboards">Allure TestOps</a>

`Allure TestOps` processes tests as a documentation and allows to launch them directly from TMS. 

Here all test cases execution results are available. 

Dashboard contains test runs statistics:
<img alt="Dashboard" src="./media/reports/Dashboard.png">

All test cases:
<img alt="Cases1" src="./media/reports/TestOpsAutomated.png">

To execute tests from TestOps move to <a target="_blank" href="https://allure.autotests.cloud/project/4314/jobs">Jobs</a> and submit the launch:
<img alt="Launch" src="./media/reports/LaunchJob1.png">


Launches:
<img alt="Launch" src="./media/reports/Launches.png">



<a id="jira"></a>
## <img alt="Allure" height="25" src="./media/logo/JIRA.svg" width="25"/></a> Integration with <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1287">Jira</a>

`Jira` has information about all related test cases, their statuses and launches results from `Allure TestOps`:

<img alt="JIRA" src="./media/reports/JIRA.png">

<a id="telegram"></a>
## <img alt="Allure" height="25" src="./media/logo/Telegram.svg" width="25"/></a> Bot notifications in Telegram
After every build Telegram bot sends notification with `Allure` report:
<img alt="Bot" src="./media/reports/Telegram_screen.png"> 

<a id="video"></a>
## <img alt="Selenoid" height="25" src="./media/logo/Browserstack.svg" width="25"/></a> Examples of test execution
<img alt="Video" src="./media/video/WikiOnboarding.gif"> 
<img alt="Video" src="./media/video/LombokTestVideo.gif"> 







