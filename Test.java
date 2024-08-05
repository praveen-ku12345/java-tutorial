public class Person1
{
    void ab()
    {
        System.out.println("this is parent class");
    }
    
}
public class Person extends Person1{
    void ab(){
        System.out.println("this is child class");
    }
}
public class Text
{
    public static void main(String args[])
    {
        Person s=new Person();
        s.ab();
        //s.ab();
    }
}