# Banking Automation Testing Project 🏦✅

Automated testing project for a sample banking web application, designed to validate key user flows such as registration, account management, fund transfer, and profile updates.

---

## 📌 Project Name:
**Banking Automation Testing**

---

## 🌐 Application Under Test:
A sample banking website (Parabank-style).

---

## 🧪 Tools & Technologies Used:

- **Java 17**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **POM Design Pattern (Page Object Model)**
- **JavaFaker** (for generating dynamic test data)
- **Allure Reports** (for test reporting)
- **WebDriverManager** (for managing browser drivers)

---

## 📁 Project Structure:

├── main
│ └── java
│ ├── Pages # All Page Object classes
│ ├── Utiles # Faker, Screenshot, Helpers
│ └── PageBase # Shared Base class
├── test
│ └── java
│ └── TestCases # All Test Classes

---

## ✅ Implemented Test Scenarios:

1. **User Registration**  
   - Generate user data using JavaFaker  
   - Fill the registration form  
   - Assert success message

2. **Check Accounts Overview**  
   - Validate account balance, account ID, total  
   - Store account ID for later use

3 **Create New Account**  
   - Open new account with dynamic dropdown selection  
   - Assert success and get new account ID

4. **Fund Transfer**  
   - Transfer funds between accounts  
   - Assert success message and correct amount transferred

5. **Update Contact Info**  
   - Update user address/phone  
   - Assert confirmation message appears
   - Assert Username that next to Welcome changed

---

## 📸 Reporting:

- Integrated with **Allure Reports** for rich visual test reports  
- Screenshots captured automatically on test failure

---

## 👤 Author: Sayed Salah Eldin - Senior Automation Test Engingeer

---

## 📝 How to Run:

```bash
# Clean and execute tests with Maven
mvn clean test

# Generate Allure report (if integrated)
allure serve allure-results




