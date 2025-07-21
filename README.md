# 📊 TrackNTrade – Finance Tracker Backend

TrackNTrade is a personal finance tracking system built with **Java + Spring Boot** and **PostgreSQL**. It helps users manage monthly income, fixed liabilities, savings, and track spendable balance with alerts when funds run low.

---

## 🚀 Features

- ✅ User registration & profile
- ✅ Monthly income entry
- ✅ Configurable fixed expenses (EMIs, subscriptions, etc.)
- ✅ Auto-calculated savings & spendable balance
- ✅ Expense tracking with categories
- ✅ Warnings when spendable balance drops below 10%
- 📅 Per-month financial breakdown

---

## 🏗️ Tech Stack

- **Backend:** Java 17+, Spring Boot
- **Database:** PostgreSQL
- **ORM:** Spring Data JPA (Hibernate)
- **Build Tool:** Maven

---

## ⚙️ Project Structure

src/
├── controller/ # REST APIs
├── model/ # JPA entities
├── repository/ # Spring Data JPA Repos
├── service/ # Business logic
└── TrackntradeApplication.java

## 📦 Requirements

- Java 17+
- Maven
- PostgreSQL

```angular2html
# Clone the repo
git clone https://github.com/your-username/trackntrade-backend.git
cd trackntrade-backend

# Run with Maven
./mvnw spring-boot:run
```