import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String department;
    int semester;

    Student(int id, String name, String department, int semester) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.semester = semester;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Dept: " + department + ", Sem: " + semester);
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. Remove Student\n3. Search Student\n4. Display All Students\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.print("Enter Department: ");
                String dept = sc.next();
                System.out.print("Enter Semester: ");
                int sem = sc.nextInt();
                list.add(new Student(id, name, dept, sem));
                System.out.println("Student record added successfully.");

            } else if (choice == 2) {
                System.out.print("Enter Student ID to remove: ");
                int id = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).id == id) {
                        list.remove(i);
                        System.out.println("Student record removed successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Student record not found.");

            } else if (choice == 3) {
                System.out.print("Enter Student ID to search: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Student s : list) {
                    if (s.id == id) {
                        s.display();
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Student record not found.");

            } else if (choice == 4) {
                if (list.isEmpty()) {
                    System.out.println("No student records available.");
                } else {
                    for (Student s : list) {
                        s.display();
                    }
                }

            } else if (choice == 5) {
                System.out.println("Exiting Student Record Management System.");
                break;

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}
