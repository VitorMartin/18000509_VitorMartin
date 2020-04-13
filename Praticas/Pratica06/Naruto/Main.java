package Naruto;

public class Main {
    public static void main(String[] args) {
        Ninja ninja = new Ninja("Naruto", "Uzumaki");
        ninja.train();
        
        AcademicStudent academicStudent = new AcademicStudent("Sasuke", "Ushiha");
        academicStudent.train();
        academicStudent.play();
        
        Chuunin chuunin = new Chuunin("Iruka", "Umino", "Treinar Justsu de transformacao");
        chuunin.train();
        chuunin.gotoMission();

        Jounin jounin = new Jounin("kakashi", "Hatake", "Train Sasuke");
        jounin.train();
    }
}