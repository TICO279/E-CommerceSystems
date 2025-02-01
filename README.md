# E-Commerce Systems
# System for Book Sales and Distribution

This project is an **e-commerce system** designed for selling and distributing books with **real-time inventory management, payment validation, and order fulfillment**. It follows a **service-oriented architecture (SOA)** and integrates **GlassFish** and **OpenESB** for web service orchestration.

## Features

- **Order Processing**: Manages purchases, inventory validation, and order tracking.
- **Payment Validation**: Ensures secure transaction processing with real-time credit checks.
- **Inventory Management**: Tracks stock levels and prevents out-of-stock sales.
- **Shipping Integration**: Handles delivery logistics and status tracking.
- **Scalability & Stress Testing**: Includes **individual and system-wide stress tests** to validate performance.
- **Business Orchestration**: Integrates the business logic across multiple services using **OpenESB**.

## Architecture Overview

The system consists of **three core Web Services (WS)** and an **orchestration layer**:

1. **WS_Pedidos (Order Service)**: Handles order creation, stock verification, and order confirmation.
2. **WS_Crédito (Credit Service)**: Processes customer payments, including credit validation.
3. **WS_Envios (Shipping Service)**: Manages delivery logistics and tracking.
4. **BPEL Orchestration (Business Logic)**: Integrates the services into a coordinated workflow using **OpenESB**.
5. **CA Orchestration (Single application integration)**: Integrates all the services using **OpenESB**.

Each service is independent and connects to its own **database**, ensuring modularity and scalability.

## Folder Structure

The repository contains the following key directories:

- **`BusinessLogic/`** → Contains the **BPEL and CA processes** orchestrating the services.
- **`Estresamiento/`** → Includes system-wide **stress testing** modules.
- **`EstresamientoIndividual/`** → Provides **individual stress testing** for specific services.
- **`PojosServiciosDeApoyo/`** → Contains **POJO-based test clients** for direct service interactions.
- **`ServiciosDeApoyo/`** → Includes additional support services and utilities.


## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/YourUsername/E-Commerce-System.git
   cd E-Commerce-System

2. **Set Up the Database**:
   Initialize the databases for orders, payments, and shipping using the provided SQL scripts.

   - **Orders Database** (`bd_proyecto_pedidos`)
   - **Credit Database** (`bd_proyecto_credito`)
   - **Shipping Database** (`bd_proyecto_envios`)

   Run the initialization scripts or setup the databases as needed:
   ```bash
   psql -U user -d bd_proyecto_pedidos -f derby_bd_proyecto_pedidos_v01.sql
   psql -U user -d bd_proyecto_credito -f derby_bd_proyecto_credito_v01.sql
   psql -U user -d bd_proyecto_envios -f derby_bd_proyecto_envios_v01.sql

   

3. **Deploy Web Services**:
   The system consists of three core web services that must be deployed on **GlassFish**.

   Deploy the services using the following commands or directly into the IDE interface:
   ```bash
   glassfish/bin/asadmin deploy WS_Pedidos.war
   glassfish/bin/asadmin deploy WS_Credito.war
   glassfish/bin/asadmin deploy WS_Envios.war

4. **Configure the Orchestration (BPEL, CA) in OpenESB**:
   The business logic is implemented using **BPEL processes**, which handle service coordination and execution.  
   Deploy the BPEL processes to **OpenESB Standalone** with the following command or directly using IDE:
   ```bash
   glassfish/bin/asadmin deploy BPEL_Proyecto.zip
   ```
   Deploy the **CA process** that incorporates the BPEL and test it out before moving to POJO testing.

5. **Run the System**:
   Once all services are deployed, you can interact with the system using the **POJO-based test clients**. These clients allow direct interaction with the web services. These have to be clients to the existing web services. Note:Names might not be exact but all files are included in the folders.

   - **Placing an order**:
     ```bash
     java -jar Pojo_Pedidos.jar
     ```
   - **Processing credit validation**:
     ```bash
     java -jar Pojo_Credito.jar
     ```
   - **Handling shipping requests**:
     ```bash
     java -jar Pojo_Envios.jar
     ```
   - **Handling system-wide requests**:
     ```bash
     java -jar Pojo_Proyecto.jar
     ```

6. **Perform Stress Testing** *(Optional)*:  
   The system includes **automated batch scripts** for performing **stress tests** on the RMI-based services. These tests follow a predefined execution sequence to validate **performance under load**.

   - **Run the stress test in sequence**:
     1. Navigate to the `SimpleRMIAutonomo_Desacoplado_Proyecto` folder.
     2. Make sure you have the correct jar files you want to stress in the folders and bats.
     3. Execute the batch files in the correct order, use the GEN in batsdeinicio to open up the needed bats or:
        ```bash
        ./0_unaSolaVez.bat  # Initialize dependencies
        ./1_ejes.bat         # Execute test 1
        ./1_ejesd.bat        # Execute subtest for 1
        ./2_ejem.bat         # Execute test 2
        ./2_ejesd.bat        # Execute subtest for 2
        ./4_estresa.bat      # Perform primary stress test
        ./4_estresaDes.bat   # Execute decoupled RMI stress test
        ./5_ejer.bat         # Final execution trial
        ```
   
   - **Log and Execution Artifacts**:
     - `estresador.exe`: Generates stress loads and evaluates performance.
     - `hs_err_pidXXXXX.log`: Stores execution logs for debugging.
     - JARs like `tstRMI_desacoplado_Proyecto.jar` and `ISolicitaServicio.jar` execute the **RMI services under stress conditions**.

   These tests help analyze **system stability**, **response times**, and **fault tolerance** under heavy workloads.


7. **Refer to the User Manual** *(Optional)*:
   - Check the generated logs and reports for:
     - Successfully processed orders and shipping records.
     - Credit transactions and validation results.
   - For a **detailed guide** on system usage, troubleshooting, and configuration, refer to the **DocumentoRequerimientos** included in the repository.

## Notes and Limitations
- The system is built using **GlassFish** and **OpenESB**, ensuring modularity and service orchestration. Make sure both are correctly installed and configured before deploying the services.
- **Web Service Dependencies**: Each service (Pedidos, Credito, Envio) operates independently but interacts within the **CA_Proyecto** composite service which incorporates the BPEL. All services must be deployed for full functionality.
- **Database Requirements**: The system uses **Derby databases** for each service (`pedidos`, `credito`, `envios`). Ensure the SQL scripts (`.sql` files) are executed correctly before running the system.
- **Stress Testing Considerations**:
  - The **individual stress tests** focus on specific services to measure their performance under load.
  - The **system-wide stress test** evaluates the full **CA_Proyecto** service, which may require additional memory and processing power.
- **BPEL Process Complexity**: The **business logic layer** implements BPEL processes to manage service interactions. Modifying the BPEL logic requires redeployment of the **BusinessLogic** module.
- **Error Handling**: The current implementation assumes valid inputs for requests. Invalid or unexpected inputs may not always be gracefully handled.
- **Performance Considerations**:
  - OpenESB’s message queue system introduces some latency. Optimization may be required for large-scale deployments.
  - Response times vary depending on database load and service request volume.
- **POJO Client Limitations**: The provided POJO clients are designed for testing purposes and do not include advanced error handling or retry mechanisms.

For more details on configuration and troubleshooting, refer to the **DocumentoRequerimientos** included in the repository.

