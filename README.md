\# 🤖 Selenium TestNG Automation Framework



\[!\[Tests](https://img.shields.io/badge/Tests-9%2F9%20Passing-brightgreen)]()

\[!\[Java](https://img.shields.io/badge/Java-11-orange)]()

\[!\[Selenium](https://img.shields.io/badge/Selenium-4.11.0-blue)]()

\[!\[TestNG](https://img.shields.io/badge/TestNG-7.8.0-red)]()



A professional \*\*test automation framework\*\* built using 

\*\*Selenium WebDriver + TestNG + Page Object Model (POM)\*\* design pattern.

Developed by \*\*Jangapally Krishna Vamshi\*\* as part of a QA automation portfolio.



\---



\## 📋 Project Overview



This framework automates testing of \[DemoQA](https://demoqa.com) web application

covering multiple UI components with real browser automation.



\### ✅ Test Results

\- \*\*Total Tests:\*\* 9

\- \*\*Passed:\*\* 9

\- \*\*Failed:\*\* 0

\- \*\*Pass Rate:\*\* 100%



\---



\## 🛠️ Tech Stack



| Technology | Version | Purpose |

|-----------|---------|---------|

| Java | 11 | Programming Language |

| Selenium WebDriver | 4.11.0 | Browser Automation |

| TestNG | 7.8.0 | Test Framework |

| WebDriverManager | 5.6.3 | Driver Management |

| Maven | 3.x | Build Tool |

| Page Object Model | - | Design Pattern |



\---



\## 📁 Project Structure



SeleniumAutomation/



├── src/test/java/



│   ├── com.krishna.ecommerce.pages/



│   │   ├── TextBoxPage.java



│   │   ├── CheckBoxPage.java



│   │   └── RadioButtonPage.java



│   ├── com.krishna.ecommerce.tests/



│   │   ├── TextBoxTest.java



│   │   ├── CheckBoxTest.java



│   │   └── RadioButtonTest.java



│   └── com.krishna.ecommerce.utils/



│       ├── BasePage.java



│       └── BaseTest.java



├── screenshots/



│   └── ecommerce/ (auto-captured on failure)



├── testng-ecommerce.xml



└── pom.xml

---



\## 🚀 How to Run



\### Prerequisites

\- Java 11 or higher

\- Maven 3.x

\- Chrome Browser



\### Clone the repository

```bash

git clone https://github.com/krishnavamshijangapally-afk/SeleniumAutomation.git

cd SeleniumAutomation

```



\### Run all tests

```bash

mvn test -DsuiteXmlFile=testng-ecommerce.xml

```



\### Run specific test class

```bash

mvn test -Dtest=TextBoxTest

```



\---



\## 🧪 Test Cases



\### 1. TextBox Tests (3 test cases)

| Test | Description | Status |

|------|-------------|--------|

| testTextBoxPageTitle | Verify page loads correctly | ✅ PASS |

| testFillTextBox | Fill and submit form automatically | ✅ PASS |

| testOutputNameCorrect | Verify submitted data displays correctly | ✅ PASS |



\### 2. CheckBox Tests (3 test cases)

| Test | Description | Status |

|------|-------------|--------|

| testCheckBoxPageOpens | Verify checkbox page loads | ✅ PASS |

| testCheckBoxURLCorrect | Verify correct URL navigation | ✅ PASS |

| testCheckBoxPageBodyLoaded | Verify page content loads | ✅ PASS |



\### 3. RadioButton Tests (3 test cases)

| Test | Description | Status |

|------|-------------|--------|

| testRadioButtonPageOpens | Verify radio button page loads | ✅ PASS |

| testSelectYesRadioButton | Select Yes and verify result | ✅ PASS |

| testSelectImpressiveRadioButton | Select Impressive and verify | ✅ PASS |



\---



\## 🏗️ Framework Features



\- ✅ \*\*Page Object Model (POM)\*\* — clean separation of page elements and tests

\- ✅ \*\*BasePage\*\* — reusable methods (click, type, wait) for all pages

\- ✅ \*\*BaseTest\*\* — common browser setup and teardown

\- ✅ \*\*Auto Screenshots\*\* — captures screenshot automatically on test failure

\- ✅ \*\*WebDriverManager\*\* — automatic ChromeDriver management

\- ✅ \*\*TestNG Annotations\*\* — @BeforeClass, @Test, @AfterClass, @AfterMethod

\- ✅ \*\*Explicit Waits\*\* — WebDriverWait for reliable element detection

\- ✅ \*\*testng.xml Suite\*\* — run all tests with single command



\---



\## 📸 Screenshots



Screenshots are automatically captured on test failure and saved to:

screenshots/ecommerce/<testName>\_<timestamp>.png

---



\## 👨‍💻 Author



\*\*Jangapally Krishna Vamshi\*\*

\- 📧 krishnavamshijangapally@gmail.com

\- 📍 Hyderabad, Telangana, India

\- 🔗 \[LinkedIn](https://linkedin.com/in/krishna-vamshi-jangapally-159351362)

\- 🎓 B.Tech Computer Science — Ellenki College of Engineering



\### Certifications

\- Generative AI Mastermind — Outskill (2026)

\- Full Stack Java Development — ExcelR (2026)

\- Advanced AI/ML — SAP Code Unnati (2025)



\---



\## 📄 License



This project is open source and available for learning purposes.

