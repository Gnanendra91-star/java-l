import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> pq = new PriorityQueue<>(
            (a, b) -> {
                if (Double.compare(a.getCGPA(), b.getCGPA()) != 0)
                    return Double.compare(b.getCGPA(), a.getCGPA());
                if (!a.getName().equals(b.getName()))
                    return a.getName().compareTo(b.getName());
                return Integer.compare(a.getID(), b.getID());
            });

        for (String event : events) {
            String[] s = event.split(" ");

            if (s[0].equals("ENTER")) {
                pq.offer(new Student(
                        Integer.parseInt(s[3]),
                        s[1],
                        Double.parseDouble(s[2])));
            } else if (!pq.isEmpty()) {
                pq.poll();
            }
        }

        List<Student> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());

        List<String> events = new ArrayList<>();

        while (totalEvents-- > 0) {
            events.add(in.nextLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
        in.close();
    }
}
