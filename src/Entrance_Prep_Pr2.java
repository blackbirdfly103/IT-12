import java.io.*;
import java.util.*;

abstract class ClubMember {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected double salary;

    public ClubMember(String firstName, String lastName, int age, double salary) {
        if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("The name can’t be an empty string!");
        }
        if (age <= 17) {
            throw new IllegalArgumentException("Age must be greater than 17 years!");
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

class Director extends ClubMember {
    private String directorType;

    public Director(String firstName, String lastName, int age, double salary, String directorType) {
        super(firstName, lastName, age, salary);
        this.directorType = directorType;
    }

    @Override
    public void info() {
        System.out.println(directorType + " director: " + firstName + " " + lastName);
        System.out.println("Salary: " + String.format("%.2f", salary) + " lv");
        System.out.println("Age: " + age + " years");
    }
}

class Coach extends ClubMember {
    private String coachType;
    private int contractLength;

    public Coach(String firstName, String lastName, int age, double salary, String coachType, int contractLength) {
        super(firstName, lastName, age, salary);
        this.coachType = coachType;
        this.contractLength = contractLength;
    }

    @Override
    public void info() {
        System.out.println(coachType + " coach: " + firstName + " " + lastName);
        System.out.println("Salary: " + String.format("%.2f", salary) + " lv");
        System.out.println("Age: " + age + " years");
    }
}

class FootballPlayer extends ClubMember {
    private String position;
    private int contractLength;
    private int matches;
    private int goals;
    private int assists;

    public FootballPlayer(String firstName, String lastName, int age, double salary,
                          String position, int contractLength, int matches, int goals, int assists) {
        super(firstName, lastName, age, salary);
        this.position = position;
        this.contractLength = contractLength;
        this.matches = matches;
        this.goals = goals;
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    @Override
    public void info() {
        System.out.println(firstName + " " + lastName + " - " + position);
        System.out.println("Salary: " + String.format("%.2f", salary) + " lv");
        System.out.println("Age: " + age + " years");
        System.out.println(goals + " goals and " + assists + " assists in " + matches + " matches");
    }
}

class FootballClubManager {
    private List<ClubMember> members = new ArrayList<>();

    public void loadMembers(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    ClubMember member = createMemberFromLine(line);
                    if (member != null) {
                        members.add(member);
                    }
                } catch (Exception e) {
                    System.out.println("Error processing line: " + line);
                    System.out.println("Reason: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
        }
    }

    private ClubMember createMemberFromLine(String line) {
        String[] tokens = line.split(",");
        String type = tokens[0].trim().toLowerCase();

        return switch (type) {
            case "director" -> new Director(
                    tokens[2].trim(), tokens[3].trim(),
                    Integer.parseInt(tokens[4].trim()),
                    Double.parseDouble(tokens[5].trim()),
                    tokens[1].trim()
            );
            case "coach" -> new Coach(
                    tokens[2].trim(), tokens[3].trim(),
                    Integer.parseInt(tokens[4].trim()),
                    Double.parseDouble(tokens[5].trim()),
                    tokens[1].trim(),
                    Integer.parseInt(tokens[6].trim())
            );
            case "player" -> new FootballPlayer(
                    tokens[2].trim(), tokens[3].trim(),
                    Integer.parseInt(tokens[4].trim()),
                    Double.parseDouble(tokens[5].trim()),
                    tokens[1].trim(),
                    Integer.parseInt(tokens[6].trim()),
                    Integer.parseInt(tokens[7].trim()),
                    Integer.parseInt(tokens[8].trim()),
                    Integer.parseInt(tokens[9].trim())
            );
            default -> null;
        };
    }

    public void printClubInfo() {
        members.sort(Comparator.comparingInt(ClubMember::getAge));

        for (ClubMember member : members) {
            member.info();
            System.out.println("*".repeat(20));
        }

        ClubMember highestSalary = members.stream().max(Comparator.comparingDouble(ClubMember::getSalary)).orElse(null);
        FootballPlayer topScorer = members.stream()
                .filter(m -> m instanceof FootballPlayer)
                .map(m -> (FootballPlayer) m)
                .max(Comparator.comparingInt(FootballPlayer::getGoals))
                .orElse(null);

        if (highestSalary != null)
            System.out.printf("The person with the highest salary in the club is %s with %.2f lv salary.%n",
                    highestSalary.getFullName(), highestSalary.getSalary());

        if (topScorer != null)
            System.out.printf("The team's top scorer is %s with %d goals.%n",
                    topScorer.getFullName(), topScorer.getGoals());
    }
}

public class Entrance_Prep_Pr2 {
    public static void main(String[] args) {
        FootballClubManager manager = new FootballClubManager();
        manager.loadMembers("input.txt");
        manager.printClubInfo();
    }
}
