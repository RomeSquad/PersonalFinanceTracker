# 💰 Personal Finance Tracker (CLI) - Rome

Welcome to the **Personal Finance Tracker**, a collaborative, console-based application developed to help users manage their personal finances effectively. This project is designed with a strong emphasis on **Object-Oriented Programming (OOP)** and adherence to **SOLID principles**, following the **Git Flow** branching strategy throughout the development lifecycle.

---

## 🎯 Project Mission

As a squad, our mission is to collaboratively design and implement a **single-user CLI-based Personal Finance Tracker**, focusing on clean architecture, proper OOP structure, and robust Git practices to ensure maintainable, scalable, and testable code.

---

## 🛠️ Features

- ✅ Add transactions (Income or Expense)
- ✅ View all transactions
- ✅ Edit existing transactions
- ✅ Delete transactions
- ✅ Categorize each transaction (e.g., Food, Rent, Salary)
- ✅ View **Monthly Summary** and **Balance Report**

---

## 🧱 Architecture & Design Principles

This application is built with:

- 🧩 **Object-Oriented Programming (OOP)**
- 📐 **SOLID Design Principles**
- 🔌 **Dependency Inversion**: All modules depend on abstractions, not concrete implementations.
- 📦 **In-memory Storage**: Easily swappable due to proper abstraction of the storage layer.
🗃️ JSON File as a Database: Data is serialized/deserialized from a transactions.json file,



---

# Project Structure

## Main Application
- `Main.kt` - Application entry point

## Transaction Management
- `transactions/`
  - `TransactionsInMemory.kt` - Stores transactions in memory during runtime
  - `TransactionsManager.kt` - Acts as the interface to switch between storages

## Data Models
- `entity/`
  - `Categories.kt` - Defines available transaction categories
  - `Transaction.kt` - Core transaction data class
  - `TransactionsType.kt` - Enum representing Income or Expense

## Reporting
- `feature.report/`
  - `BalanceReport.kt` - Generates balance feature.report
  - `MonthlySummaryReport.kt` - Generates monthly summaries
  - `Report.kt` - Common feature.report interface

## Testing
- `test/`
  - `transactioncrud/` - Tests for CRUD operations
  - `TestInMemory.kt` -  Tests for in-memory logic
  - `TransactionTest.kt` - Tests for transactions

## User Interface
- `ui/`
  - `UserActionsMenu.kt` - CLI menu for interacting with the user
