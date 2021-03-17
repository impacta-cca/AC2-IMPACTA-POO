package ac02;

import java.util.Random;

public class BankAccount {
    private static int lastAccountNumber = 1000;
    //Próximo número utilizado da conta

    private String owner;
    private int accountNumber;
    private double balance;
    private String senha;
    private double cpmf;

    //Criar uma conta com saldo igual 0.0
    public BankAccount(String owner) {
        //chama outro construtor dessa classe com 2 parâmetros
        this(owner, 0.0);
    }

    public BankAccount(String owner, double balance) {


        this.owner = checkName(owner);
        this.accountNumber = lastAccountNumber++;
        this.balance = balance;
        this.senha = makePassword();
        this.cpmf = 0;

    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public static int getLastAccountNumber() {
        return lastAccountNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    /**
     * Deposita dinheiro nesta conta
     * (Pós-condição: getBalance() >= 0.0)
     *
     * @param amount: a quantia de dinheiro a depositar
     *                (Pré-condição: amount >=0)
     */
    public void deposit(double amount) {

        //Evitar efeitos colaterais
        double newBalance = balance + amount;
        balance = newBalance;
    }

    void withDraw(double amount) {
        //Evitar efeitos colaterais

        // 6:
        cpmf = 0.0025 * amount;
        double newBalance = balance - amount;
        balance = newBalance;
        balance -= cpmf;
    }

    //2:
    public void transfer(double valor, BankAccount target) {

        double nbalance = this.balance - valor;
        this.balance = nbalance;
        target.balance = target.balance + valor;

    }

    public String toString() {
        return "BankAccount[" + "Owner= " + owner +
                ",\tAccountNumber= " + accountNumber +
                ",\tBalance= " + balance + "R$"+
                ",\tPassword= " + senha +
                ",\tCPMF= " + cpmf + ']';
    }

    //4:
    private static String checkName(String owner) {
    // instruções do método a ser desenvolvido
        if (owner.matches("[A-zÀ-ú]+[\\s]*[A-zÀ-ú]+")) {
            return owner;
        }
        System.exit(0);
        return null;
    }

    //5:
    private static String makePassword() {
        StringBuilder sen = new StringBuilder();
        Random gerador = new Random();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        abc = abc.toLowerCase();

        for (int i = 0; i < 3; i++) {
            char letter = abc.charAt(gerador.nextInt(abc.length()));
            sen.append(letter);
        }
        for (int i = 3; i <= 7; i++) {
            sen.append(String.valueOf(gerador.nextInt(9)));
        }
        return sen.toString();

    }
}















