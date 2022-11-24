import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {;
        Scanner sc          = new Scanner(System.in);
        int students_num    = sc.nextInt();
        String[] names =
                {
                        "Вася",
                        "Саша",
                        "Маша",
                        "Петя",
                        "Артем",
                        "Акакий",
                        "Евкакий",
                        "Евклид",
                        "Нафаня"
                };


        CPersonsFactory factory = new CPersonsFactory();
        Thread[] threads        = new Thread[students_num];

        factory.setStudentsNum(students_num);

        CTeacher teacher = factory.createTeacher(27, "Евгений Александрович");

        factory.createStudents(names, teacher);
        CStudent[] students = factory.getStudents();

        Thread teacherThread = new Thread(teacher);
        teacherThread.start();

        for (int i = 0; i < students_num; i++)
        {
            threads[i] = new Thread(students[i]);
            threads[i].start();
        }

        for (int i = 0; i < students_num; i++)
        {
            try
            {
                threads[i].join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        };
        teacherThread.interrupt();
    }
}