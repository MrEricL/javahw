/*
Eric Li
APCS pd4
HW#44: In America, the Driver Sits on the Left
2016-12-13
*/

/*
The interface ListInt is created with a set of methods 
that later the SuperArray will implement/define better and use
 */

public interface List{
    void add(int newVal);
    void add(int index, int newVal);
    void remove(int index);

}
