package HANSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    Employee(String n, int a) {
        name = n;
        age = a;}
    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + "}";}}

public class SerializeDemo {
    // Method untuk menyimpan (serialize) list objek
    public static void serialize(List<Employee> list, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list);
            System.out.println("Serialized " + list.size() + " objek berhasil.");
        } catch (IOException ex) {
            System.out.println("Error serialize: " + ex.getMessage());}}

    // Method untuk membaca kembali (deserialize) list objek
    @SuppressWarnings("unchecked")
    public static List<Employee> deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserialize: " + ex.getMessage());
            return new ArrayList<>();}}

    public static void main(String[] args) {
        String file = "emp_list.ser";
        List<Employee> employees = List.of(
            new Employee("John", 30),
            new Employee("Sarah", 27),
            new Employee("Budi", 35));

        serialize(employees, file);

        List<Employee> restoredList = deserialize(file);
        System.out.println("Hasil Deserialization:");
        for (Employee emp : restoredList) {
            System.out.println("- " + emp);}}}