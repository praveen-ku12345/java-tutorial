class Account
{
 int acc_id;
String name;
int amount;
void insert(int n,int n1,String n2)
{
acc_id=n;
amount=n1;
name=n2;
}
void deposite(int n)
{
 amount =amount+n;
System.out.println(amount+"deposited");
}
void withdraw(int amt)
{
 if(amount<amt)
{
System.out.println("Insufficient balance:");
}
else 
{
amount=amount-amt;
}
}
void display()
{
System.out.println(acc_id+" "+name+" "+amount);
}
void checkBalance()
{
System.out.println("amount="+amount);
}

public static void main(String args[])
{
  Account obj=new Account();
  obj.insert(123456,800,"Praveen");
obj.display();
obj.checkBalance();
obj.deposite(100);
obj.withdraw(1000);

}
}