🥘 Masaaledaar Tiffin Service

A digital platform built for local home kitchen tiffin service providers to manage customer meals, subscriptions, order flow and delivery efficiently.
This project brings small home-based tiffin vendors online without needing complex POS software.

🚀 Problem & Why This Project?

Small local tiffin providers usually manage orders manually through WhatsApp / calls / notebooks.
This leads to:

Manual customer tracking

Errors in daily order count

No proper subscription management

Time wasted in repeated communication

Masaaledaar Tiffin Service solves this by making the entire system digital — order booking, subscription plans, and customer records are structured and automated.

✅ Core Features

Customer registration and meal subscription system

Daily meal order management

Backend built using Java + JDBC

React frontend interface

Simple UI for smooth customer experience

Faster and organized records management

Designed for small tiffin business owners to go “Digital-first”

🧩 Tech Stack
Layer	Technology
Frontend	React (Plain React)
Backend	Java
Database	MySQL
Connectivity	JDBC
Build	Maven
Version Control	Git + GitHub
🏗️ System Architecture (High-Level)
React UI  ➝  Java Backend (JDBC)  ➝  MySQL Database


React handles UI for customers

Java handles order logic, subscription logic, server socket communication

MySQL stores customer data & tiffin subscription info

⚙️ How to Run
Backend
cd MasaledaarTiffinJDBC
javac *.java
java MasaledarServer

Frontend
cd masaledar-tiffin-frontend
npm install
npm start


Make sure MySQL is running and your DB credentials match inside code.

📂 Folder Structure
Masaaledaar-Tiffin-Service/
 ├── masaledar-tiffin-frontend/   # React UI
 ├── MasaledarServer.java         # Backend Server
 ├── MasaledarTiffinService.java  # Core App Logic
 ├── mysql-connector.jar          # JDBC Driver
 └── ...

🔮 Future Enhancements

Online payment integration (UPI / Razorpay)

Role-based Admin Dashboard

Multi-provider directory (many vendors on same platform)

Meal plan analytics (statistics for vendor)

Mobile App (React Native)

📸 Screenshots (To be added after UI ready)

Add screenshots here to show UI views later.

📌 Repository Link

https://github.com/phobiccvaishu/Masaaledaar-Tiffin-Service

This project is part of my Full Stack learning journey focused on building real products that solve real world problems.
