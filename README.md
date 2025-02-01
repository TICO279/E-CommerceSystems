# E-Commerce System for Book Sales and Distribution

This project is an **e-commerce system** designed for selling and distributing books with **real-time inventory management, payment validation, and order fulfillment**. It follows a **service-oriented architecture (SOA)** and integrates **GlassFish** and **OpenESB** for web service orchestration.

## Features

- **Order Processing**: Manages purchases, inventory validation, and order tracking.
- **Payment Validation**: Ensures secure transaction processing with real-time credit checks.
- **Inventory Management**: Tracks stock levels and prevents out-of-stock sales.
- **Shipping Integration**: Handles delivery logistics and status tracking.
- **Scalability & Stress Testing**: Includes **individual and system-wide stress tests** to validate performance.
- **BPEL Orchestration**: Integrates the business logic across multiple services using **OpenESB**.

## Architecture Overview

The system consists of **three core Web Services (WS)** and an **orchestration layer**:

1. **WS_Pedidos (Order Service)**: Handles order creation, stock verification, and order confirmation.
2. **WS_Crédito (Credit Service)**: Processes customer payments, including credit validation.
3. **WS_Envios (Shipping Service)**: Manages delivery logistics and tracking.
4. **BPEL Orchestration (Business Logic)**: Integrates the services into a coordinated workflow using **OpenESB**.

Each service is independent and connects to its own **database**, ensuring modularity and scalability.

## Folder Structure

The repository contains the following key directories:

- **`BusinessLogic/`** → Contains the **BPEL processes** orchestrating the services.
- **`Estresamiento/`** → Includes system-wide **stress testing** modules.
- **`EstresamientoIndividual/`** → Provides **individual stress testing** for specific services.
- **`PojosServiciosDeApoyo/`** → Contains **POJO-based test clients** for direct service interactions.
- **`ServiciosDeApoyo/`** → Includes additional support services and utilities.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/YourUsername/E-Commerce-System.git
   cd E-Commerce-System
