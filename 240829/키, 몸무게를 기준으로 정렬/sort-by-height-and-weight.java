import java.util.*;

class Person implements Comparable<Person> {
    String name;
    int height;
    int weight;

    public Person(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Person other) {
        if (this.height != other.height) {
            return this.height - other.height; // 키를 오름차순으로 정렬
        } else {
            return other.weight - this.weight; // 몸무게를 내림차순으로 정렬
        }
    }

    @Override
    public String toString() {
        return name + " " + height + " " + weight;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            persons.add(new Person(name, height, weight));
        }

        Collections.sort(persons);

        for (Person person : persons) {
            System.out.println(person);
        }

        scanner.close();
    }
}