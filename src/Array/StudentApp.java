package Array;

public class StudentApp {
    public static void main(String[] args) {
        var studentA = new Student("A", 100);
        var studentB = new Student("B", 90);
        var studentC = new Student("C", 80);
        var arrayGenerics = new ArrayGenerics<Student>();
        arrayGenerics.addLast(studentA);
        arrayGenerics.addLast(studentB);
        arrayGenerics.addLast(studentC);
        System.out.println(arrayGenerics);
    }
}
