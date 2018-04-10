package VendingMcahine;

public class VendingMcahine {
	int price=99;
	int balance;
	int total;
	void showPrompt()
	{
		System.out.println("Hi");
	}
    void insertMoney(int amount)
    {
    	balance=balance+amount;
    }
    void showBalance()
    {
    	System.out.println(balance);
    }
    void showTotal()
    {
    	System.out.println(total);
    }
    void getFood()
    {
    	if(balance>price)
    	{
    		System.out.println("ohye");
    		balance=balance-price;
    		total=total+price;
    		
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMcahine vm=new VendingMcahine();
		vm.showPrompt();
		vm.showBalance();
		vm.insertMoney(100);
		vm.getFood();
		vm.showBalance();
		vm.showTotal();
		VendingMcahine vm1=new VendingMcahine();
		vm1.insertMoney(200);
		vm1.showBalance();
		
	}

}
