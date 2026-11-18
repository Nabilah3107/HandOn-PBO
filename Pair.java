public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;}

    public void showTypes() {
        System.out.println(first.getClass().getSimpleName() + " (" + first + ") & " +
                           second.getClass().getSimpleName() + " (" + second + ")");}

    // Method swap() mengembalikan objek Pair baru dengan tipe dan posisi nilai yang ditukar
    public Pair<T2, T1> swap() {
        return new Pair<>(second, first);}

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "Andi");
        p1.showTypes();
        Pair<String, Integer> p1Swapped = p1.swap();
        p1Swapped.showTypes();

        Pair<Double, Boolean> p2 = new Pair<>(99.5, true);
        p2.showTypes();
        Pair<Boolean, Double> p2Swapped = p2.swap();
        p2Swapped.showTypes();}}