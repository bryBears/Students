package cn.bear;

public class Student {
    private String name;
    private double score;

    Student(){

    }

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getScore() {
        return score;
    }

    void setScore(double score) {
        this.score = score;
    }
}
