import java.util.ArrayList;

abstract class HospitalStaff {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected double salary;

    public HospitalStaff(String firstName, String lastName, int age, double salary) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive number.");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be a positive number!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public abstract void info();
}

class Doctor extends HospitalStaff {
    private String specialization;
    private int patientsTreated;

    public Doctor(String firstName, String lastName, int age, double salary,
                  String specialization, int patientsTreated) {
        super(firstName, lastName, age, salary);
        this.specialization = specialization;
        this.patientsTreated = patientsTreated;
    }

    public int getPatientsTreated() {
        return patientsTreated;
    }

    @Override
    public void info() {
        System.out.println("Doctor: " + firstName + " " + lastName + " - " + specialization);
        System.out.println("Salary: " + salary + " Lv.");
        System.out.println("Age: " + age);
        System.out.println("Patients treated: " + patientsTreated);
    }
}

class Nurse extends HospitalStaff {
    private String department;
    private int shiftsWorked;

    public Nurse(String firstName, String lastName, int age, double salary,
                 String department, int shiftsWorked) {
        super(firstName, lastName, age, salary);
        this.department = department;
        this.shiftsWorked = shiftsWorked;
    }

    public int getShiftsWorked() {
        return shiftsWorked;
    }

    @Override
    public void info() {
        System.out.println("Nurse: " + firstName + " " + lastName + " - " + department);
        System.out.println("Salary: " + salary + " Lv.");
        System.out.println("Age: " + age);
        System.out.println("Shifts worked: " + shiftsWorked);
    }
}

class Janitor extends HospitalStaff {
    private int areaCovered;

    public Janitor(String firstName, String lastName, int age, double salary,
                   int areaCovered) {
        super(firstName, lastName, age, salary);
        this.areaCovered = areaCovered;
    }

    public int getAreaCovered() {
        return areaCovered;
    }

    @Override
    public void info() {
        System.out.println("Janitor: " + firstName + " " + lastName);
        System.out.println("Salary: " + salary + " Lv.");
        System.out.println("Age: " + age);
        System.out.println("Area covered: " + areaCovered + " sqm");
    }
}

public class DZI_ZAD28 {
    public static void main(String[] args) {
        Doctor doc1 = new Doctor("Ivan", "Petrov", 45, 5000.00, "Cardiologist", 120);
        Doctor doc2 = new Doctor("Maria", "Stoyanova", 38, 4800.00, "Neurologist", 95);

        Nurse nurse1 = new Nurse("Elena", "Dimitrova", 29, 2200.00, "Emergency", 150);
        Nurse nurse2 = new Nurse("Petya", "Georgieva", 34, 2400.00, "Pediatrics", 180);

        Janitor janitor1 = new Janitor("Georgi", "Ivanov", 50, 1500.00, 300);
        Janitor janitor2 = new Janitor("Stanko", "Kolev", 60, 1600.00, 450);

        ArrayList<HospitalStaff> staffList = new ArrayList<>();
        staffList.add(doc1);
        staffList.add(doc2);
        staffList.add(nurse1);
        staffList.add(nurse2);
        staffList.add(janitor1);
        staffList.add(janitor2);

        for(HospitalStaff staff:staffList) {
            staff.info();
            System.out.println("----------------------------");
        }
    }
}
