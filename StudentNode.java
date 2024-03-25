public class StudentNode {
    private Student student;
    private StudentNode next;

    //constructor, one parameter Student
    public StudentNode(Student student){
        this.student = student;
        this.next = null;
    }

    //getters and setters
    public Student getStudent() {
        return student;
    }
    public StudentNode getNext() {
        return next;
    }
    public void setNext(StudentNode next) {
        this.next = next;
    }
}
