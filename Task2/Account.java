class Account {
    private String username;
    private String password;
    private int balance;

    public Account(String username, String password, int initialBalance) {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}