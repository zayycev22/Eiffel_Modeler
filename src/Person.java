public interface Person
{

    /** age always positive
     * @post return > 0
     */
    public int     getAge();

    /** name always not empty
     * @post return != ""
     */
    public String  getName();

    /** age always positive
     * @pre age > 0
     */
    public void    setAge(int age);

    /** name always not empty
     * @pre return != ""
     */
    public void    setName(String name);

}
