# 🧠 Java Advance Concepts

This project is a hands-on exploration of advanced Java concepts aimed at deepening your understanding of the Java Virtual Machine (JVM), memory handling, concurrency, low-level operations, and secure coding practices.  
Ideal for intermediate to advanced developers who want to go beyond syntax.

## ✅ Covered Topics

- **Memory Management**
- **Java Object Model**
- **Multithreading & Concurrency**
- **JVM Internals**
- **I/O & NIO**
- **Serialization & Deserialization**
- **Reflection & Annotations**
- **Unsafe & Low-Level APIs**
- **Security Essentials**

## 📁 Project Structure

java-advance-concepts/
├── memory/ # Memory leaks, GC, finalize
├── objectmodel/ # Object layout, hashCode, identity
├── concurrency/ # Threads, synchronization, volatile, deadlocks
├── jvm/ # Bytecode, classloaders, JVM runtime options
├── io/ # Traditional IO, NIO, memory-mapped files
├── serialization/ # Custom serialization & deserialization
├── reflection/ # Annotations, private access, proxies
├── unsafe/ # Unsafe memory access, direct ByteBuffer
├── security/ # Cryptography, hashing, secure random
└── README.md # Project documentation


## 🔬 Module Overview

### 🧹 Memory Management
- Demonstrates memory leaks and how to detect them.
- Explores Java Garbage Collection and `WeakReference`.
- Shows how to use `finalize()` (legacy) and why it should be avoided in modern code.

### 📦 Java Object Model
- Understands how object memory layout works (field alignment, padding).
- Shows how `hashCode()` works and how object identity is preserved.

### ⛓️ Multithreading & Concurrency
- Race conditions and how to prevent them with synchronization.
- `volatile` keyword explained.
- Demonstrates deadlocks and thread coordination using `ExecutorService` and `ReentrantLock`.

### 🔍 JVM Internals
- Bytecode inspection tips with `javap`.
- ClassLoader hierarchy.
- JVM runtime details like memory usage and processor count.

### 📂 I/O & NIO
- Traditional file I/O vs. NIO with `FileChannel`.
- Using `MappedByteBuffer` for memory-mapped files.
- Modern file handling using `Path` and `Files`.

### 🧾 Serialization & Deserialization
- Demonstrates how Java's `Serializable` interface works.
- Encrypts password before serialization and decrypts during deserialization.
- Uses `transient` keyword to protect sensitive data.

### 🪞 Reflection & Annotations
- Accesses private fields/methods using `Reflection`.
- Parses custom annotations.
- Builds dynamic proxies to intercept method calls.

### 💣 Unsafe & Low-Level APIs
- Uses `sun.misc.Unsafe` to allocate memory manually.
- Demonstrates `DirectByteBuffer` for high-performance I/O.

### 🔐 Security Essentials
- Generates cryptographically secure random numbers.
- Implements password hashing using `SHA-256`.
- Encrypts/decrypts data using AES and PBKDF2 key derivation.

## 🚀 How to Run

### Requirements
- Java 8 or above
- Maven or any Java-compatible IDE (e.g. IntelliJ, Eclipse)

### Run Tests
```bash
mvn test
```

## 📘 Educational Purpose
This project is built for learning purposes only and covers both theoretical and practical aspects of the Java platform’s internal behavior. It is especially useful for those preparing for interviews or diving into low-level Java.
---

## ✍️ Author

**Ridho Suhaebi Arrowi**  
Feel free to contribute or fork!
