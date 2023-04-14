package project;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployee {
  @Test
  public void testGetNumberOfVacationDaysLeft() {
    Employee testEmployee = new Employee("Jack", 24, "I001", "Barista", 400.0, 0, false);

    testEmployee.setNumberOfVacationDaysTaken(0);
    assertEquals(30, testEmployee.getNumberOfVacationDaysLeft());

    testEmployee.setNumberOfVacationDaysTaken(5);
    assertEquals(25, testEmployee.getNumberOfVacationDaysLeft());

    testEmployee.setNumberOfVacationDaysTaken(30);
    assertEquals(0, testEmployee.getNumberOfVacationDaysLeft());
  }
}
