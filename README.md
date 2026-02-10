#  Bank Transaction Processor (Java Concurrency Mini Project)

This project is a **simple Java mini-project** designed to demonstrate **core concurrency concepts** in Java using a real-world inspired example of a bank account system.

---

##  Project Goals

- Understand how **threads** work in Java
- Learn the difference between **Thread** and **Runnable**
- Use **ExecutorService** to manage threads
- Apply **synchronization** to protect shared resources
- Prevent **race conditions** in concurrent environments
- Relate concepts to **real backend systems** and **interview questions**

---

##  Concepts Covered

- Thread vs Runnable
- ExecutorService & Thread Pool
- Shared Resources
- Synchronization using `synchronized`
- Race Conditions
- Basic concurrency best practices

---

##  Project Structure

``bash
src/
└── org.example
└── BankApp.java
``


---

##  How It Works

- A single `BankAccount` represents a shared resource.
- Multiple threads perform **deposit** and **withdraw** operations.
- All critical operations are synchronized to ensure **thread safety**.
- Threads are managed using a **fixed thread pool** via `ExecutorService`.

---

##  Example Scenario

- Initial balance: `1000`
- Multiple threads attempt to deposit and withdraw simultaneously.
- Synchronization ensures:
  - No invalid balance
  - No data corruption
  - Consistent results

---

##  How to Run

1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   
2. Open the project in IntelliJ / Eclipse
3. Run BankApp.java
