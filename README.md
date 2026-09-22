# 🔗 Advanced REST API Automation Framework — RestAssured + Java

A professional-grade REST API testing framework built with **RestAssured**, **Java**, **TestNG** and **Extent Reports**, featuring Data-Driven Testing, Page Object Model, JSON Schema Validation and automated report generation.

---

## 📊 Live Test Report

🔗 [View Live Test Report](https://hammadasif-997.github.io/RestAssuredApiTesting/reports/Test-Report-2024.08.29.20.46.04.html)

---

## 🚀 APIs Tested

| API | Base URL | Type |
|---|---|---|
| ReqRes API | https://reqres.in | User Management REST API |
| GoRest API | https://gorest.co.in/public/v2 | Public REST API |

---

## 🛠️ Tech Stack

| Tool | Purpose |
|---|---|
| Java | Programming language |
| RestAssured | API test automation library |
| TestNG | Test execution & assertions |
| Maven | Dependency management |
| Extent Reports | Beautiful HTML test reports |
| Java Faker | Random test data generation |
| Apache POI | Excel data reading (DDT) |
| JSON Schema Validator | Schema validation |
| Jackson | JSON file comparison |
| Hamcrest | Assertion library |

---

## 📁 Project Structure

```
├── src/test/java/api/
│   ├── endpoints/
│   │   ├── Routes.java              # API endpoint constants
│   │   ├── UserEndPoints.java       # User CRUD operations
│   │   ├── LoginEndPoints.java      # Login endpoint methods
│   │   └── RegisterEndPoints.java   # Registration endpoint methods
│   ├── payloads/
│   │   ├── User.java                # User POJO class
│   │   └── Register.java            # Register POJO class
│   ├── test/
│   │   ├── BaseTest.java            # Base test setup with Faker
│   │   ├── UserTest.java            # User CRUD test cases
│   │   ├── DDTests.java             # Data-driven test cases
│   │   └── GorestTest.java          # GoRest API tests
│   └── utilities/
│       ├── ExtentReportManager.java # Extent report generation
│       ├── CustomListener.java      # TestNG custom listener
│       ├── DataProviders.java       # Excel data providers
│       └── XLUtility.java           # Excel utility helper
├── src/test/resources/
│   ├── Userdata.xlsx                # Test data for DDT
│   ├── GorestAllUserResponse.json   # Saved API response
│   ├── GorestAllUserSchema.json     # JSON Schema for validation
│   └── config.properties            # Configuration file
├── reports/                         # Generated Extent Reports
├── testng.xml                       # TestNG suite configuration
└── pom.xml                          # Maven dependencies
```

---

## ⚙️ Prerequisites

- Java JDK 11+
- Maven 3.6+
- Internet connection (for API calls)

---

## ▶️ How to Run

**Clone the repository:**
```bash
git clone https://github.com/HammadAsif-997/RestAssuredApiTesting.git
cd RestAssuredApiTesting
```

**Run all tests:**
```bash
mvn test
```

---

## 📊 Test Scenarios

### UserTest.java — ReqRes API
| # | Method | Description |
|---|---|---|
| 1 | POST | Create user with Faker data, verify status 201 and response contains ID |
| 2 | GET | Read single user by ID, verify status 200 |
| 3 | GET | Read all users, verify total=12 and total_pages=2 |
| 4 | PUT | Update user full data, verify all fields match |
| 5 | PATCH | Update user last name only, verify fields match |
| 6 | DELETE | Delete user, verify status 204 |

### DDTests.java — Data Driven Testing
| # | Method | Description |
|---|---|---|
| 1 | POST | Create users from Excel file, verify status 201 and all fields |
| 2 | GET | Read each user from Excel by ID |
| 3 | DELETE | Delete each user from Excel |
| 4 | DELETE | Conditionally delete only user with ID=3 |

### GorestTest.java — GoRest API
| # | Method | Description |
|---|---|---|
| 1 | GET | Verify all users have status "active" or "inactive" |
| 2 | GET | Compare live response with saved JSON file, validate schema |

---

## 🔑 Key Highlights

- **Data-Driven Testing** — Test data loaded from Excel (Userdata.xlsx) using Apache POI
- **Faker Integration** — Random realistic user data generated for each test run
- **Extent Reports** — Auto-generated dark-themed HTML reports after every run
- **JSON Schema Validation** — API responses validated against predefined schemas
- **JSON File Comparison** — Live API response compared with saved baseline JSON
- **Page Object Model** — Clean separation of endpoints, payloads and utilities
- **Custom TestNG Listener** — Automatic pass/fail/skip logging to Extent Reports
- **Multi-API Testing** — ReqRes and GoRest APIs tested in same framework

---

## 📈 Results

- **13 automated test cases** covering full API lifecycle
- Data-driven tests run across multiple users from Excel
- Automated Extent HTML reports generated after every run
- JSON Schema validation ensuring API contract compliance

---

## 👤 Author

**Hammad Asif**
- 📧 hmmd97@gmail.com
- 🔗 [LinkedIn](https://linkedin.com/in/hammad-asif-26466a91)
- 💻 [GitHub](https://github.com/HammadAsif-997)
