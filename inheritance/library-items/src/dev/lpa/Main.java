package dev.lpa;

public class Main {

    public static void main(String[] args) {
        LibraryItem[] itemList = {  new Book("El Extranjero", 1952, "Albert Camus"),
                                    new Magazine("Vogue", 2025, 100698)};

        for (var item : itemList) {
            System.out.println(item.getDescription());
            System.out.println(item.canBeBorrowed());

        }
    }


}
