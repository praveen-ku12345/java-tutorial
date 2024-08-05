import java.util.Scanner;
class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class LinkedList
{
    Node head;
    public LinkedList()
    {
        this.head=null;
    }

void append(int data)
{
    Node newNode=new Node(data);
    if(head==null)
    {
        head=newNode;
    }
    Node current=head;
    while(current.next!=null)
    {
        current=current.next;
    }
    current.next=newNode;
}
public void insertBegin(int data)
{
    Node newNode=new Node(data);
    head=newNode;
}
public void lastInsert(int data)
{
    Node newNode=new  Node(data);
    if(head==null)
    {
        head=newNode;
    }
    append(data);
}
public void insertMid(int data,int index)
{
    Node newNode=new Node(data);
    if(index<0)
    {
        System.out.print("Invalid index");
        return;
    }
    if(index==0)
    {
        insertBegin(data);
    }
    Node current=head;
    int count=0;
    while(current!=null && count<index-1)
    {
        current=current.next;
        count++;
    }
    if(current==null)
    {
        System.out.print("Index out of bounds");
        return;
    }
    newNode.next=current.next;
    current.next=newNode;
}
public void deleteBegin()
{
    if(head!=null)
    {
        head=head.next;
    }
}
public void deleteLast()
{
    if( head==null || head.next==null )
    {
        head=null;
        return;
    }
    Node current=head;
    while(current.next.next!=null)
    {
        current=current.next;
    }
    current.next=null;
}
public void deleteMid(int index)
{
    if(index<0 || head==null)
    {
        System.out.print("INvalid operation");
        return;
    }
    if(index==0)
    {
        deleteBegin();
        return;
    }
    Node current=head;
    int count=0;
    while(current!=null && count<index-1)
    {
        current=current.next;
        count++;
    }
    if(current==null|| current.next==null)
    {
        System.out.print("Index out of bounds");
        return;
    }
    current.next=current.next.next;
}
public void display()
{
    Node current=head;
    while(current!=null)
    {
        System.out.print(current.data+"->");
        current=current.next;
    }
    System.out.println();
}
}
public class Main8
{
    public static void main(String args[])
    {
      LinkedList list=new LinkedList();
      Scanner s=new Scanner(System.in);
      while(true)
      {
          System.out.println("1.Insert at begin:");
          System.out.println("2.Insert at last:");
          System.out.println("3.Insert at Specific:");
          System.out.println("5.delete at begin:");
          System.out.println("6.delete at last:");
          System.out.println("7.delete at Specific:");
          System.out.println("8.Display:");
          System.out.println("9.Quit:");
          System.out.println("enter ur choice:");
          int choice=s.nextInt();
          switch(choice)
          {
              case 1:
                  System.out.println("enter the elemnt Insert at begin:");
                  int beginValue=s.nextInt();
                  list.insertBegin(beginValue);
                  break;
             case 2:
                 System.out.println("enter the elemnt Insert at last:");
                  int lastValue=s.nextInt();
                  list.lastInsert(lastValue);
                  break;
             case 3:
                  System.out.println("enter the elemnt Insert atmid:");
                  int specificValue=s.nextInt();
                  System.out.print("enter the index");
                  int index=s.nextInt();
                  list.insertMid(specificValue,index);
                  break;
            case 4:
                list.deleteBegin();
                break;
            case 5:
                list.deleteLast();
                break;
            case 6:
                    System.out.print("enter the index:");
                    int index1=s.nextInt();
                    list.deleteMid(index1);
                    break;
            case 7:
                        list.display();
                        break;
            case 8:
                System.exit(0);
                break;
            
                default:
                System.out.print("Invalid choice:");
                break;
                    
          }
      }
    }
}
