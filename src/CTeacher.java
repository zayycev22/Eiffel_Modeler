public class CTeacher implements ITeacher, Runnable
{
    private int     age;
    private String  name;
    private boolean needToCheck;

    CTeacher(int age, String name)
    {
        this.setAge(age);
        this.setName(name);
        this.needToCheck = false;
    }

    @Override
    public void setState(boolean state)
    {
        this.needToCheck = state;
    }

    @Override
    public boolean  checkState()
    {
        return this.needToCheck;
    }

    @Override
    public int      getAge()
    {
        return this.age;
    }

    @Override
    public String  getName()
    {
        return this.name;
    }

    @Override
    public void     setAge(int age)
    {
        this.age = age;
    }

    @Override
    public void    setName(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try { Thread.sleep(1000); } catch (InterruptedException ex) { break; };

            synchronized (this)
            {
                if (!this.checkState())
                {
                    System.out.println("Преподаватель " + this.getName() + " спит");
                }
            }
        }
    }
    public boolean equals(Object obj){
        return this == obj;
    }
}
