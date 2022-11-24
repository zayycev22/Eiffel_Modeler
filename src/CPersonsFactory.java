import java.util.Random;

public class CPersonsFactory
{
    private int studentsNum;
    private CStudent[] students;
    CStudent    createStudent(CTeacher teacher, int age, String name)
    {
        return new CStudent(teacher, age, name);
    }

    CTeacher    createTeacher(int age, String name)
    {
        return new CTeacher(age, name);
    }

    /** num always positive
     * @pre num > 0
     */
    public void setStudentsNum(int num)
    {
        this.studentsNum = num;
    }

    /** names not empty, teacher is not null
     * @pre names.lenght > 0 && teacher != null
     */
    public void createStudents(String[] names, CTeacher teacher)
    {
        this.students = new CStudent[studentsNum];
        for (int i = 0; i < studentsNum; i++)
        {

            this.students[i] = this.createStudent(teacher, 23, names[i]);
        }
    }

    /** students not empty
     * @post return != null
     */
    public CStudent[]   getStudents()
    {
        return this.students;
    }

    public boolean equals(Object obj){
        return this == obj;
    }

}
