# Payroll System

Access the complete project specification [here](https://github.com/audreyemmely/folha-de-pagamento/blob/main/especificacao_projeto.pdf).

## :dart: Project's goal 
The aim of the project is to build a payroll system. The system consists of managing the payments of a company's employees. In addition, the system must
manage the data of these employees, such as the scorecards. Employees must receive their salary at the correct time, using the method they prefer, obeying various fees and taxes deducted from the salary.

## Design patterns
### [Template Method](https://refactoring.guru/pt-br/design-patterns/template-method) and [Extract Method](https://refactoring.guru/pt-br/extract-method)
Description: The abstract class Employees has the variable liquidSalary and the concrete class Hourly has the variable salaryDay which refer to the net salary and the salary for the day respectively. This was simplified by removing salaryDay and creating grossSalary, avoiding the redundancy caused by using salaryDay and allowing extensibility if more employee types are created. The use of this extensibility was also applied to the concrete class Salaried, in which this new variable was used.

### [Singleton](https://refactoring.guru/pt-br/design-patterns/singleton)
Description: The Main class called all the functionalities. This not only exposes a lot of code, but also causes a lot of coupling. So the Singleton pattern was used, and this provided decoupling. So if new functionalities are implemented, the new Menu class will only be concerned with providing the new Menu options.

## 🛠️ Technologies
- Java JDK 16.0.1

- Eclipse IDE for Enterprise Java and Web Developers 2021-06
