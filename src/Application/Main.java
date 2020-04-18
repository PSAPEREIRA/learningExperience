package Application;

import Entities.*;
import Utils.CurrencyConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        //Definir o local para PT
        Locale ptPortugal = new Locale("pt", "PT");
        Locale.setDefault(ptPortugal);

        Scanner sc = new Scanner(System.in);
        int opt;

        do {

            System.out.println("\nPick an option:\n1-Rectangle Calculus\n2-Employee Salary\n3-Student Grades");
            System.out.println("4-Currency Converter\n5-Product\n6-BankAccount\n7-RoomRentVector\n8-ListEmployee");
            System.out.println("9-ArrayOfArray\n0-QUIT\n");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    Rectangle rectangle = new Rectangle();

                    System.out.println("Define the width of the rectangle:");
                    rectangle.width = sc.nextDouble();

                    System.out.println("Define the height of the rectangle:");
                    rectangle.height = sc.nextDouble();

                    System.out.printf("The area of the rectangle is: %.2f%n", rectangle.area());
                    System.out.printf("The perimeter of the rectangle is: %.2f%n", rectangle.perimeter());
                    System.out.printf("The diagonal of the rectangle is: %.2f%n", rectangle.diagonal());
                    break;

                case 2:
                    Employee employee = new Employee();
                    double percentage;

                    System.out.println("Name of the employee:");
                    employee.name = sc.nextLine();

                    System.out.println("Employee Gross Salary:");
                    employee.grossSalary = sc.nextDouble();

                    System.out.println("Employee tax:");
                    employee.tax = sc.nextDouble();

                    //System.out.printf("Employee:"+employee.name+", "+employee.netSalary()+"€");

                    System.out.println();
                    System.out.println("Employee: " + employee);
                    System.out.println();

                    System.out.println("Which percentage to increase salary?");
                    percentage = sc.nextDouble();
                    employee.increaseSalary(percentage);

                    System.out.println();
                    System.out.println("Updated data: " + employee);
                    break;

                case 3:

                    Student student = new Student();

                    double finalGrade, missingPoints;

                    System.out.println("Student Name:");
                    student.name = sc.next();

                    System.out.println("1st trimester grade:");
                    student.grade1 = sc.nextDouble();

                    System.out.println("2nd trimester grade:");
                    student.grade2 = sc.nextDouble();

                    System.out.println("3rd trimester grade:");
                    student.grade3 = sc.nextDouble();

                    finalGrade = student.finalGradeCalc();

                    System.out.printf("Student: " + student.name + "\nFinal grade:%.2f%n", finalGrade);

                    if (finalGrade >= 60.00) {
                        System.out.println("PASS");
                    } else {
                        missingPoints = student.missingPointsCalc();
                        System.out.printf("FAILED\nMISSING %.2f%n POINTS", missingPoints);
                    }

                    break;

                case 4:

                    double dollarPrice, amountDollar, amountConverted;

                    System.out.println("What is the current dollar price?");
                    dollarPrice = sc.nextDouble();

                    System.out.println("What is the total amount to be bought?");
                    amountDollar = sc.nextDouble();

                    amountConverted = CurrencyConverter.converter(amountDollar, dollarPrice);

                    amountConverted += amountConverted * CurrencyConverter.IOF;

                    System.out.printf("The amount to be paid in Euros with tax= %.2f€\n", amountConverted);

                    break;

                case 5:

                    String name;
                    double price;
                    int quantity;

                    System.out.println("Enter product data: ");

                    System.out.print("Product Name:");
                    name = sc.nextLine();

                    System.out.print("Product Price:");
                    price = sc.nextDouble();

                    Product product = new Product(name, price);

                    System.out.println();
                    System.out.print("Product data: " + product);

                    System.out.println();
                    System.out.print("Enter the number of products to be added in stock: ");
                    quantity = sc.nextInt();
                    product.addProducts(quantity);

                    System.out.println();
                    System.out.print("Product updated data: " + product);

                    System.out.println();
                    System.out.print("Enter the number of products to be removed in stock: ");
                    quantity = sc.nextInt();
                    product.removeProducts(quantity);

                    System.out.println();
                    System.out.print("Product updated data: " + product);

                    System.out.println();//using get and set for product name attribute
                    System.out.print("Change product name: ");
                    String editName = sc.nextLine();
                    product.setName(editName);
                    System.out.println("Product Name changed to :" + product.getName());
                    System.out.print("Product updated data: " + product);

                case 6:

                    int accountNumber;
                    String nameAccountHolder;
                    double initialDeposit, depositValue;
                    char initialDepositVerify;
                    BankAccount account;

                    System.out.println("Enter account number:");
                    accountNumber = sc.nextInt();

                    System.out.println("Enter name of the holder:");
                    sc.nextLine();
                    nameAccountHolder = sc.nextLine();

                    System.out.println("Is there an Initial deposit (y/n)?");
                    initialDepositVerify = sc.next().charAt(0);

                    if (initialDepositVerify == 'y') {
                        System.out.print("Enter initial deposit value: ");
                        initialDeposit = sc.nextDouble();
                        account = new BankAccount(accountNumber, nameAccountHolder, initialDeposit);
                    } else {
                        account = new BankAccount(accountNumber, nameAccountHolder);
                    }

                    System.out.println();
                    System.out.println("Account Info:");
                    System.out.println(account);

                    System.out.println();
                    System.out.print("Enter a deposit value:");
                    depositValue = sc.nextDouble();
                    account.deposit(depositValue);
                    System.out.println("Updated account data:");
                    System.out.println(account);

                    System.out.println();
                    System.out.print("Enter a withdraw value:");
                    depositValue = sc.nextDouble();
                    account.withdraw(depositValue);
                    System.out.println("Updated account data:");
                    System.out.println(account);

                case 7:

                    int rentNumber, roomNumber;
                    String nameStudent, email;

                    System.out.println("How many rooms will be rented?");
                    rentNumber = sc.nextInt();

                    RoomRent[] roomRents = new RoomRent[10];

                    for (int i = 0; i < rentNumber; i++) {
                        System.out.println("\nRENT#" + (i + 1) + ":");

                        System.out.print("Name: ");
                        sc.nextLine();
                        nameStudent = sc.nextLine();

                        System.out.print("Email: ");
                        email = sc.nextLine();

                        System.out.print("Room Number: ");
                        roomNumber = sc.nextInt();

                        roomRents[roomNumber] = new RoomRent(nameStudent, email, roomNumber);
                    }

                    System.out.println("\nRented Rooms:");

                    for (int i = 0; i < roomRents.length; i++) {
                        if (roomRents[i] != null) {
                            System.out.println(roomRents[i]);
                        }
                    }
                    break;

                case 8:
                    int id, numberEmployees, argId;
                    String nameEmployee;
                    double salary, percentValue;
                    ListedEmployee listedEmployee;
                    List<ListedEmployee> listedEmployeeList = new ArrayList<>();

                    System.out.println("How many employees will be registered?");
                    numberEmployees = sc.nextInt();

                    for (int i = 0; i < numberEmployees; i++) {
                        System.out.println("\nEmployee#" + (i + 1) + ":");

                        System.out.print("Id: ");
                        sc.nextLine();
                        id = sc.nextInt();

                        System.out.print("Name: ");
                        sc.nextLine();
                        nameEmployee = sc.nextLine();

                        System.out.print("Salary: ");
                        salary = sc.nextDouble();

                        ListedEmployee listedEmployeeP = new ListedEmployee(nameEmployee, id, salary);

                        //listedEmployee.addToList(listedEmployee);
                        listedEmployeeList.add(listedEmployeeP);
                    }

                    System.out.println();
                    System.out.println("Enter the employee id that will have salary increase:");
                    argId = sc.nextInt();

                    ListedEmployee listedEmployeeU = listedEmployeeList.stream().filter(listedEmployee1 -> listedEmployee1.getId() == argId).findFirst().orElse(null);

                    if (listedEmployeeU == null) {

                        System.out.println("The id isn't valid");
                    } else {

                        System.out.println("Enter the percentage");
                        percentValue = sc.nextDouble();

                        listedEmployeeU.salaryIncrease(percentValue);

                        //double percentIncrease = listedEmployee.getSalary() * (percentValue / 100);
                        //return listedEmployee.salary = listedEmployee.getSalary() + percentIncrease;
                    }


                    for (ListedEmployee listedEmployees : listedEmployeeList) {
                        System.out.println(listedEmployees);
                    }

                case 9:
                    int rows, columns, columnsCounter, rowsCounter, numberValues, numberChosen;

                    System.out.println("Insert rows number:");
                    rows = sc.nextInt();

                    System.out.println("Insert columns number:");
                    columns = sc.nextInt();

                    int[][] matrix = new int[rows][columns];

                    for (rowsCounter = 0; rowsCounter < matrix.length; rowsCounter++) {
                        for (columnsCounter = 0; columnsCounter < matrix[rowsCounter].length; columnsCounter++) {
                            System.out.println("Insert integer number:");
                            numberValues = sc.nextInt();
                        }
                    }


                    System.out.println("Which number should be analyzed within the matrix:");
                    numberChosen = sc.nextInt();

                    for (rowsCounter = 0; rowsCounter < matrix.length; rowsCounter++) {
                        for (columnsCounter = 0; columnsCounter < matrix[rowsCounter].length; columnsCounter++) {
                            if (matrix[rowsCounter][columnsCounter] == numberChosen) {
                                System.out.println("Position " + rowsCounter + "," + columnsCounter + ":\n");
                                if (rowsCounter > 0) {
                                    System.out.println("Up: " + matrix[rowsCounter - 1][columnsCounter] + "\n");
                                }
                                if (rowsCounter < matrix.length) {
                                    System.out.println("Down: " + matrix[rowsCounter + 1][columnsCounter] + "\n");
                                }
                                if (columnsCounter < matrix[rowsCounter].length) {
                                    System.out.println("Right: " + matrix[rowsCounter][columnsCounter + 1] + "\n");
                                }
                                if (columnsCounter > 0) {
                                    System.out.println("Left: " + matrix[rowsCounter][columnsCounter - 1] + "\n");
                                }
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Please choose an existing option");
                    break;
            }

        } while (opt != 0);
        sc.close();
    }
}
