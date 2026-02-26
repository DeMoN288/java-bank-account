public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice");
        BankAccount acc2 = new BankAccount("Bob");

        System.out.println("Accounts created:");
        System.out.println(acc1);
        System.out.println(acc2);

        System.out.println("\nTesting deposit:");
        boolean dep1 = acc1.deposit(1000);
        System.out.println("Deposit 1000 to Alice: " + dep1 + ", Balance: " + acc1.getBalance());

        System.out.println("\nTesting withdraw (valid):");
        boolean with1 = acc1.withdraw(200);
        System.out.println("Withdraw 200 from Alice: " + with1 + ", Balance: " + acc1.getBalance());

        System.out.println("\nTesting withdraw (invalid - insufficient balance):");
        boolean with2 = acc1.withdraw(2000);
        System.out.println("Withdraw 2000 from Alice: " + with2 + ", Balance: " + acc1.getBalance());

        System.out.println("\nTesting transfer (valid):");
        boolean trans1 = acc1.transfer(acc2, 300);
        System.out.println("Transfer 300 from Alice to Bob: " + trans1);
        System.out.println("Alice Balance: " + acc1.getBalance());
        System.out.println("Bob Balance: " + acc2.getBalance());

        System.out.println("\nTesting transfer (invalid - insufficient balance):");
        boolean trans2 = acc1.transfer(acc2, 1000);
        System.out.println("Transfer 1000 from Alice to Bob: " + trans2);

        System.out.println("\nTesting blocked account scenario:");
        acc2.setBlocked(true);
        boolean trans3 = acc1.transfer(acc2, 100);
        System.out.println("Transfer 100 from Alice to blocked Bob: " + trans3);
        
        System.out.println("\nFinal comparison using equals (acc1 == acc1): " + acc1.equals(acc1));
        System.out.println("Final comparison using equals (acc1 == acc2): " + acc1.equals(acc2));
    }
}
