enum AccountType {
    SAVINGS("SA", 2.5),
    CREDIT("CR", 12.0),
    DEPOSIT("DP", 5.0);

    private String code;
    private double interestRate;

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;}

    public String getCode() {
        return code;}

    public double getInterestRate() {
        return interestRate;}}

public class EnumConstructorDemo {
    public static void main(String[] args) {
        for (AccountType act : AccountType.values()) {
            System.out.println("Nama: " + act.name() +
                               " | Kode: " + act.getCode() +
                               " | Suku Bunga: " + act.getInterestRate() + "%");}}}