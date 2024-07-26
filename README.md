# paieT

## Context
The church *** *** *** has undertaken to acquire the property it currently rents by taking out a loan from a microfinance institution. This loan will allow the church to become the owner of the land, for which it currently pays a monthly rent.

The microfinance institution has approved the loan request and established a monthly repayment plan. The church commits to paying a fixed amount each month to repay the loan.

To facilitate the repayment process, the church has implemented a system to encourage the active participation of members who wish to contribute financially, ensuring transparent and efficient fund management.

## Objectives

### General Objective
Enable a digital and automated management system for the church's loan repayment process.

### Specific Objectives
- Automate Record Keeping: Establish a computerized system to record pledges and monthly contributions from members, their personal information, and payments made.

- Communicate Effectively with Members: Provide automated communication to inform members of upcoming payment deadlines, payment reminders, and payment confirmations.

- Allow Members to Track Payments: Provide members with an overview of the loan repayments made.

This project aims to ensure transparent and efficient resource management while promoting financial engagement and solidarity within the church community.

## Analysis and Design
- Class Diagram: https://drive.google.com/file/d/1cpIfbfe6AnzsuD2QBkst9UwtQalsLOoU/view?usp=sharing

- Requirements Document: Link to Document
  https://docs.google.com/document/d/1OqdOueNHKPIMTMiStkIc2vH638FM_pntFMQx6MfmpbM/edit?usp=sharing

## Installations and Configurations
The project is developed using Jakarta EE 10.

1- Maven, version 3
2- JDK, version 17 required
3- Payara, version 6 required
4- PostgreSQL Database

To configure the database connection, go to the '/src/main/resources/filters' directory and modify the snapshot.properties file with the correct PostgreSQL username and password values.