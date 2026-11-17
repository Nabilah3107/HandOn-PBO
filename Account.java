enum AccountType {
    SAVINGS("Tabungan"), 
    CREDIT("Kredit"), 
    DEPOSIT("Deposito"); // Tambahan DEPOSIT

    private String description;

    AccountType(String description) {
        this.description = description;}

    public String toString() {
        return description;}
}

public class Account {
    private AccountType type;

    public Account(AccountType type) {
        this.type = type;}

    public AccountType getType() { 
        return type; }

    public static void main(String[] args) {
        // Menguji di main() mencetak semua tipe enum
        for (AccountType acc : AccountType.values()) {
            System.out.println(acc + " (" + acc.name() + ")");}}}
