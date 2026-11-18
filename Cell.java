public class Cell<T> {
    private T data;

    public void setValue(T data) {
        this.data = data;}

    public T getValue() {
        return data;}

    public void displayType() {
        if (data != null) {
            System.out.println("Tipe data: " + data.getClass().getName());} 
        else {
            System.out.println("Data masih kosong (null)");}}

    public static void main(String[] args) {
        Cell<Integer> intCell = new Cell<>();
        intCell.setValue(100);
        System.out.println("Nilai: " + intCell.getValue());
        intCell.displayType();

        Cell<String> strCell = new Cell<>();
        strCell.setValue("Belajar Generics");
        System.out.println("Nilai: " + strCell.getValue());
        strCell.displayType();}}