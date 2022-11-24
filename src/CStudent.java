import java.sql.Time;
import java.util.Objects;
import java.util.Random;

public class CStudent implements IStudent, Runnable {
    private final int time;
    private final CTeacher teacher;
    private int age;
    private String name;
    private boolean isBusy;

    /**
     * teacher always not null
     *
     * @pre teacher != null
     */
    CStudent(CTeacher teacher, int age, String name) {
        Random rnd = new Random();

        this.time = rnd.nextInt(4) + 1;
        this.setAge(age);
        this.setName(name);
        this.teacher = teacher;
        this.isBusy = false;
    }

    @Override
    public int getAge() {
        assert this.age > 0;
        return this.age;
    }

    @Override
    public String getName() {
        assert !Objects.equals(this.name, "");
        return this.name;
    }

    @Override
    public void setAge(int age) {
        assert age > 0;
        this.age = age;
    }

    @Override
    public void setName(String name) {
        assert !Objects.equals(name, "");
        this.name = name;
    }

    @Override
    public boolean isTeacherFree() {
        return this.teacher.checkState();
    }

    @Override
    public void run() {
        while (true) {

            synchronized (this.teacher) {
                if (!this.teacher.checkState()) {
                    this.teacher.setState(true);
                    this.isBusy = true;
                }
            }

            if (this.isBusy) {
                System.out.println(this.getName() + " сдает зачёт " + Integer.toString(this.time) + " секунд(ы) ");

                try {
                    Thread.sleep(time * 1000L);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                ;

                synchronized (this.teacher) {
                    this.teacher.setState(false);
                    System.out.println(this.getName() + " сдал зачёт ");
                }
                break;
            }

            System.out.println(this.getName() + " ждет очереди");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            ;
        }
    }

    public boolean equals(Object obj) {
        return this == obj;
    }
}
