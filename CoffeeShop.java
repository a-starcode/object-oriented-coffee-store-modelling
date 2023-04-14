package project;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

abstract class Person {
  private String name;
  private Integer age;

  public Person() {}
  
  public Person(String name, Integer age) {
    this.setName(name);
    this.setAge(age);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    try {
      if (name.length() < 2)
        this.name = null;
  
      String regex = "^[\\p{L} .'-]+$"; // any name from any language
  
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(name);
  
      if (matcher.matches())
        this.name = name; 
      else 
        System.out.println("\nInvalid name passed! Parameters passed: [name=" + name + "]");
    } catch (NullPointerException e) {
      System.out.println("\nName of Employee cannot be null");
    }
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    try {
      if (age > 0 && age < 110)
        this.age = age;
      else 
        System.out.println("\nAge of Person must be between 0 and 110");
    } catch (NullPointerException e) {
      System.out.println("\nInvalid (null) age passed!");
    }
  }

  public abstract void sayHello();

  public String toString() {
    return "Person[name=" + this.getName() + ", age=" + this.getAge() + "]"; 
  }
}

interface CanPlaceOrderInterface {
  public void placeOrder(List<Item> order);
}

class Customer extends Person implements CanPlaceOrderInterface {
  private String phoneNo;
  private List<Item> order;

  public Customer() {}

  public Customer(String name, Integer age, String phoneNo) {
    super(name, age);
    this.setPhoneNumber(phoneNo);
  }

  public String getPhoneNumber() {
    return this.phoneNo;
  }

  public void setPhoneNumber(String phoneNo) {
    try {
      phoneNo = phoneNo.replaceAll("[\\D]", ""); // remove everything but digits from the String

      if (phoneNo.length() == 10)
        this.phoneNo = phoneNo;
      else
        System.out.println("\nPhone number must be 10 digits and only consist of numbers. Parameters passed: [phoneNo=" + phoneNo + "]");
    } catch (NullPointerException e) {
       System.out.println("\nPhone number of Employee cannot be null");
    }
  }

  public List<Item> getOrder() {
    return this.order;
  }

  public void placeOrder(List<Item> order) {
    try {
      this.order = order;
    } catch (NullPointerException e) {
      System.out.println("\nNull order cannot be placed!");
    }
  }

  public void sayHello() {
    System.out.println("Customer says Hello");
  }

  public String toString() {
    return "Customer[" + super.toString() + ", phoneNo=" + this.getPhoneNumber() + ", order=" + this.getOrder().toString() + "]";
  }
}

class Employee extends Person {
  private String id;
  private String managerId;
  private String role;
  private Double salary;
  private Integer noOfVacationDaysTaken;
  private Boolean isIntern;

  // Constructors
  public Employee() {}

  public Employee(String name, Integer age, String id, String role, Double salary, Integer noOfVacationDaysTaken, Boolean isIntern) {
    super(name, age);
    this.setId(id);
    this.setRole(role);
    this.setSalary(salary);
    this.setNumberOfVacationDaysTaken(noOfVacationDaysTaken);
    this.setIsIntern(isIntern);
  }

  // Getters and Setters
  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    try {
      if (id.matches("^[a-zA-Z0-9]+$")) { // if 'id' is alphanumeric
        if (id.length() == 4 && Character.isLetter(id.charAt(0))) { // if first character is letter
          Character.toUpperCase(id.charAt(0)); // for data consistency
          this.id = id;
        }
        else
          System.out.println("\nLength of Id must be 4 characters (alphanumeric) and first character must be a letter. Parameters passed: [id=" + id + "]"); // ex: A001, AbcD
      }
    } catch (NullPointerException e) {
      System.out.println("\nId of Employee cannot be null");
    }
  }

  public String getManagerId() {
    return this.managerId;
  }

  public void setManagerId(String managerId) {
    try {
      if (managerId.matches("^[a-zA-Z0-9]+$")) { // if 'managerId' is alphanumeric
        if (managerId.length() == 4 && Character.isLetter(managerId.charAt(0))) { // if first character is letter
          Character.toUpperCase(managerId.charAt(0)); // for data consistency
          this.managerId = managerId;
        }
        else
          System.out.println("\nLength of managerId must be 4 characters (alphanumeric) and first character must be a letter. Parameters passed: [managerId=" + managerId); // ex: A001, Ab + "]"cD
      }
    } catch (NullPointerException e) {
      System.out.println("\nmanagerId of Employee cannot be null");
    }
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    try {
      if (role.length() < 2)
      this.role = null;

      String regex = "^[\\p{L} .'-]+$";

      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(role);

      if (matcher.matches())
        this.role = role; 
      else 
        System.out.println("\nInvalid role passed! Parameters passed: [role=" + role + "]");
    } catch (NullPointerException e) {
      System.out.println("\nRole of Employee cannot be null");
    }
  }

  public Double getSalary() {
    return this.salary;
  }

  public void setSalary(Double salary) {
    try {
      if (salary > 0.0 && salary < 100000.0)
        this.salary = salary;
      else
        System.out.println("\nSalary has to be between $0 and $100000. Parameters passed: [salary=" + salary + "]");
    } catch (NullPointerException e) {
       System.out.println("\nSalary of Employee cannot be null");
    }
  }

  public Integer getNumberOfVacationDaysTaken() {
    return this.noOfVacationDaysTaken;
  }

  public void setNumberOfVacationDaysTaken(Integer noOfVacationDaysTaken) {
    try {
      if (noOfVacationDaysTaken > -1 && noOfVacationDaysTaken < 31)
        this.noOfVacationDaysTaken = noOfVacationDaysTaken;
      else
        System.out.println("\nNumber of vacation days taken must be between 0 and 30. Parameters passed: [noOfVacationDaysTaken=" + noOfVacationDaysTaken + "]");
    } catch (NullPointerException e) {
      System.out.println("\nNumber of vacation days taken by Employee cannot be null");
    }
  }

  public Integer getNumberOfVacationDaysLeft() { // extra feature
    return (30 - this.noOfVacationDaysTaken);
  }

  public Boolean getIsIntern() {
    return this.isIntern;
  }

  public void setIsIntern(Boolean isIntern) {
    try {
      this.isIntern = isIntern;
    } catch (NullPointerException e) {
      System.out.println("\nisIntern cannot be null");
    }
  }

  public Double calculateBillOfCustomer(Customer customer) {
    Double billTotal = 0.0;

    for (Item menuItem: customer.getOrder()) {
      billTotal += menuItem.getItemPrice();
    }

    return billTotal;
  }

  public Double calculateBillOfCustomer(Customer customer, boolean hasCoupon) {
    Double billTotal = 0.0;

    for (Item menuItem: customer.getOrder()) {
      billTotal += menuItem.getItemPrice();
    }
    if(hasCoupon) 
      return billTotal - (0.25 * billTotal);

    return billTotal;
  }

  public void sayHello() {
    System.out.println("Employee says Hello");
  }

  public String toString() {
    return "Employee[" + super.toString() + ", id=" + this.getId() + ", managerId=" + this.getManagerId() + ", role=" + this.getRole() + ", salary=" + this.getSalary() + ", noOfVacationDaysTaken=" + this.getNumberOfVacationDaysTaken() + ", isIntern=" + this.getIsIntern() + "]";
  }
}

class Manager extends Employee {
  private String email;
  private List<Employee> subordinates;

  // Constructors
  public Manager() {
    subordinates = new ArrayList<Employee>();
  }

  public Manager(String name, Integer age, String id, String role, Double salary, Integer noOfVacationDaysTaken, Boolean isIntern, String email, List<Employee> subordinates) {
    super(name, age, id, role.concat(" Manager"), salary, noOfVacationDaysTaken, isIntern);
    this.setEmail(email);
    this.setSubordinates(subordinates);
  }

  // Getters and Setters
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    try {
      // manager.example.com is invalid; manager..bob@example.com is invalid; manager@.example.me.org is invalid
      final String emailValidationRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; 

      Pattern pattern = Pattern.compile(emailValidationRegex);
      Matcher matcher = pattern.matcher(email);

      if (matcher.matches())
        this.email = email;
      else
        System.out.println("\nInvalid email entered!");
    } catch (NullPointerException e) {
      System.out.println("\nInvalid (null) email passed!");
    }
  }

  public List<Employee> getSubordinates() {
    return this.subordinates;
  }

  public void setSubordinates(List<Employee> subordinates) {
    try {
      this.subordinates = subordinates;
    } catch (NullPointerException e) {
      System.out.println("\nInvalid (null) subordinates passed!");
    }
  }

  public String toString() {
    return "Manager[" + super.toString() + ", email=" + this.getEmail() + ", subordinates=" + this.getSubordinates().toString() + "]";
  }
}

class Item {
  private String itemName;
  private Double itemPrice;

  // Constructors
  public Item() {}
  
  public Item(String itemName, Double itemPrice) {
    this.setItemName(itemName);
    this.setItemPrice(itemPrice);
  }

  // Getters and Setters
  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    try {
      if (itemName.length() < 2)
        this.itemName = null;
  
      String regex = "^[\\p{L} .'-]+$";
  
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(itemName);
  
      if (matcher.matches())
        this.itemName = itemName; 
      else 
        System.out.println("\nInvalid Item Name passed! Parameters passed: [itemName=" + itemName + "]");
    } catch (NullPointerException e) {
      System.out.println("\nName of Employee cannot be null");
    }
  }

  public Double getItemPrice() {
    return this.itemPrice;
  }

  public void setItemPrice(Double itemPrice) {
    try {
      if (itemPrice > 0.0 && itemPrice < 50000.0)
        this.itemPrice = itemPrice;
      else
        System.out.println("\nItem price has to be between $0 and $50000. Parameters passed: [itemPrice=" + itemPrice + "]");
    } catch (NullPointerException e) {
       System.out.println("\nSalary of Employee cannot be null");
    }
  }

  // Helper functions
  public String toString() {
    return "Item[name=" + this.getItemName() + ", price=$" + this.getItemPrice() + "]";
  }
}

class Menu {
  private List<Item> items;

  // Constructors
  public Menu() {
    items = new ArrayList<Item>();
  }

  public Menu(List<Item> items) {
    this.setItems(items);
  }

   // Getters and Setters
   public List<Item> getItems() {
    return this.items;
  }

  public void setItems(List<Item> items) {
    try {
      this.items = items;
    } catch (NullPointerException e) {
      System.out.println("\nInvalid (null) items passed!");
    }
  }

  public String toString() {
    return "Menu[items=" + this.getItems().toString() + "]";
  }
}

class PizzaShop {
  private List<Employee> employees;
  private List<Manager> managers;
  private String branchLocation;
  private String brandName;
  private Integer startingHour;
  private Integer closingHour;
  private Double profit;
  private Double rent;
  private Menu menu;

  PizzaShop() {
    employees = new ArrayList<Employee>();
    managers = new ArrayList<Manager>();
    menu = new Menu();
  }

  PizzaShop(List<Employee> employees, List<Manager> managers, String brandName, String branchLocation, Integer startingHour, Integer closingHour, Double profit, Double rent, Menu menu) {
    this.setEmployees(employees);
    this.setManagers(managers);
    this.setBrandName(brandName);
    this.setBranchLocation(branchLocation);
    this.setStartingHour(startingHour);
    this.setClosingHour(closingHour);
    this.setProfit(profit);
    this.setRent(rent);
    this.setMenu(menu);
  }

  // Getters and Setters
  public String getBranchLocation() {
    return this.branchLocation;
  }

  public void setBranchLocation(String branchLocation) {
    if (branchLocation.trim().length() > 3)
      this.branchLocation = branchLocation;
    else 
      this.branchLocation = null;
  }

  public String getBrandName() {
    return this.brandName;
  }

  public void setBrandName(String brandName) {
    if (brandName.length() < 2)
      this.brandName = null;

    String regex = "^[\\p{L} .'-]+$";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(brandName);

    if (matcher.matches())
      this.brandName = brandName; 
    else 
      this.brandName = null;
  }

  public Integer getStartingHour() {
    return this.startingHour;
  }

  public void setStartingHour(Integer startingHour) {
    if (startingHour > -1 && startingHour < 24)
      this.startingHour = startingHour;
    else
      this.startingHour = null;
  }

  public Integer getClosingHour() {
    return this.closingHour;
  }

  public void setClosingHour(Integer closingHour) {
    if (startingHour > -1 && startingHour < 24)
      this.closingHour = closingHour;
    else
      this.closingHour = null;
  }

  public Double getCash() {
    try {
      Double cash = 3000.0 + this.profit - this.rent;
      if (cash > 0.0)
        return cash;
      else {
        System.out.println("\nRent cannot be higher than 3000.");
        return null;
      }
    } catch (NullPointerException e) {
      System.out.println("\nInvalid (null) values detected while calculating cash. Parameters passed: [profit=" + this.profit + ", rent=" + this.rent + "]");
      return null;
    }
  }

  public Double getProfit() {
    return this.profit;
  }

  public void setProfit(Double profit) {
    if (profit >= 0.0 && profit < 1000000.0)
      this.profit = profit;
    else
      this.profit = null;
  }

  public Double getRent() {
    return this.rent;
  }

  public void setRent(Double rent) {
    if (rent > 50.0 && rent < 1000000.0)
      this.rent = rent;
    else
      this.rent = null;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees; 
  }

  public List<Manager> getManagers() {
    return managers;
  }

  public void setManagers(List<Manager> managers) {
    this.managers = managers; 
  }

  public Menu getMenu() {
    return this.menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }
  
  public void addEmployee(Employee employee) {
    try {
      this.employees.add(employee);
    } catch (NullPointerException e) {
      System.out.println("\nInvalid employee (null) passed,\n");
    }
  }

  public void addManager(Manager manager) {
    try {
      this.managers.add(manager);
    } catch (NullPointerException e) {
      System.out.println("\nInvalid manager (null) passed,\n");
    }
  }

  public String toString() {
    return "PizzaShop[employees=" + this.getEmployees().toString() + ", managers=" + this.getManagers().toString() + ", branchLocation=" + this.getBranchLocation() + ", brandName=" + this.getBrandName() + "startingHour=" + this.getStartingHour() + ", closingHour=" + this.getClosingHour() + ", profit=" + this.getProfit() + ", rent=" + this.getRent() + ", menu=" + this.getMenu() + "]";
  }
}

class Project {
  public static void main(String[] args) {
    System.out.println();

    Employee jack = new Employee("Jack", 24, "I001", "Barista", 400.0, 6, false);
    Employee lisa = new Employee("Lisa", 25, "I002", "Cashier", 400.0, 7, false);

    List<Employee> employees = new ArrayList<Employee>(List.of(
      jack,
      lisa,
      new Employee("Sean", 23, "I003", "Barista", 400.0, 6, false))
    );

    List<Manager> managers = new ArrayList<Manager>(List.of(
      new Manager("Karen", 29, "M001", "General", 1000.0, 0, false, "Karen.Unoreverse@gmail.com", employees.subList(0, 2)),
      new Manager("Parth", 29, "M002", "Assistant General", 800.0, 20, false, "Parth.Shah@gmail.com", employees.subList(2, 3)))
    );

    jack.setManagerId("M001");
    lisa.setManagerId("M001");
    employees.get(2).setManagerId("M002");

    List<Item> items = new ArrayList<Item>(List.of(
      new Item("Capuccino", 5.75),
      new Item("Espresso Con Panna", 8.50),
      new Item("Dark Mocha", 9.00),
      new Item("AlmondMilk Brew", 5.00),
      new Item("Caffè Latte", 5.50),
      new Item("Green Tea Creme", 5.50),
      new Item("Avocado Toast", 6.00),
      new Item("Roasted Ham-Cheese Sandwich", 20.00),
      new Item("Vegan Breakfast Sandwich", 18.00))
    );

    Menu menu = new Menu(items);

    PizzaShop pizzaShop = new PizzaShop(employees, managers, "Abhinav's Pizzeria",  "134/A, Mumbai",  8, 21, 1400.0, 2400.0, menu);

    System.out.println("\n======================================================\n\n= Brand name: " + pizzaShop.getBrandName());
    System.out.println("= Address: " + pizzaShop.getBranchLocation());
    System.out.println("= Monthly Rent: $" + pizzaShop.getRent());
    System.out.println("= Opening hour: " + pizzaShop.getStartingHour());
    System.out.println("= Closing hour: " + pizzaShop.getClosingHour());
    System.out.println("= Current cash in register: $" + pizzaShop.getCash());
    System.out.println("= Today's income: $" + pizzaShop.getProfit());

    System.out.println("\n= On Today's Menu = {");
    for (Item item : menu.getItems()) {
      System.out.println("\t~ " + item.toString());
    }
    System.out.println("}");

    System.out.println("\n= List of Employees = [");
    for (Employee emp : employees) {
      System.out.println("\n\tId: " + emp.getId());
      System.out.println("\tManager Id: " + emp.getManagerId());
      System.out.println("\tName: " + emp.getName());
      System.out.println("\tAge: " + emp.getAge());
      System.out.println("\tRole: " + emp.getRole());
      System.out.println("\tSalary: $" + emp.getSalary());
      System.out.println("\tNumber of vacation days taken: " + emp.getNumberOfVacationDaysTaken());
      System.out.println("\tNumber of vacation days left: " + emp.getNumberOfVacationDaysLeft() + ",\n");
    }

    System.out.println("\n\t= List of Managers = {");
    for (Manager manager : managers) {
      System.out.println("\n\t\tId: " + manager.getId());
      System.out.println("\t\tManager Id: " + manager.getManagerId());
      System.out.println("\t\tName: " + manager.getName());
      System.out.println("\t\tAge: " + manager.getAge());
      System.out.println("\t\tRole: " + manager.getRole());
      System.out.println("\t\tSalary: $" + manager.getSalary());
      System.out.println("\t\tNumber of vacation days taken: " + manager.getNumberOfVacationDaysTaken());
      System.out.println("\t\tNumber of vacation days left: " + manager.getNumberOfVacationDaysLeft());
      System.out.println("\t\tEmail: " + manager.getEmail());
      System.out.println("\t\tSubordinates: ");
      int i = 1;
      for (Employee emp : managers) {
        System.out.println("\t\t\t" + i++ + ". " + emp.getName() + " (" + emp.getId() + ")");
      }
    }
    System.out.println("\n\t}\n");

    System.out.print("]\n");

    System.out.println("\n======================================================");

    
    Customer toast = new Customer("Jeremy Wang", 29, "6551207325");
    Customer sykkuno = new Customer("Thomas Bimbus", 28, "6123768232");

    List<Item> toastsOrder= new ArrayList<Item>(List.of(
      menu.getItems().get(1),
      menu.getItems().get(6)
    ));
    toast.placeOrder(toastsOrder);
    
    List<Item> sykkunosOrder= new ArrayList<Item>(List.of(
      menu.getItems().get(3),
      menu.getItems().get(7)
      ));
    sykkuno.placeOrder(sykkunosOrder);

    System.out.println("\n\nJeremy placed his order of: [");
    for (Item food: toastsOrder) {
      System.out.println("\t" + food.getItemName() + " ($" + food.getItemPrice() + ")");
    } System.out.println("]\n");
    System.out.println(lisa.getName() + " attended " + toast.getName() + "'s order and the bill total was: $" + lisa.calculateBillOfCustomer(toast));
    
    System.out.println("\nThomas placed his order of: [");
    for (Item food: sykkunosOrder) {
      System.out.println("\t" + food.getItemName() + " ($" + food.getItemPrice() + ")");
    } System.out.println("]\n");
    System.out.println(jack.getName() + " attended " + sykkuno.getName() + "'s order and the bill total (with a discount) was: $" + jack.calculateBillOfCustomer(sykkuno, true));

    System.out.println();
  }
}