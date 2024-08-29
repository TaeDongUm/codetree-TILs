import java.util.*;

class Student implements Comparable<Student> {
    int height;
    int weight;
    int index;

    public Student(int height, int weight, int index) {
        this.height = height;
        this.weight = weight;
        this.index = index;
    }

    @Override
    public int compareTo(Student other) {
        if (this.height != other.height) {
            return this.height - other.height; // 키가 작은 순서대로
        } else {
            return other.weight - this.weight; // 몸무게가 큰 순서대로
        }
    }

    @Override
    public String toString() {
        return height + " " + weight + " " + index;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            students.add(new Student(height, weight, i));
        }

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}