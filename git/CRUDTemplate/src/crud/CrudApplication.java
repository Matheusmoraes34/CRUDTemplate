package crud;

import java.util.ArrayList;
import java.util.List;

public class CrudApplication {
    private static List<Item> items = new ArrayList<>();
    private static int currentId = 1;

    public static void main(String[] args) {
        System.out.println("Criando itens...");
        create("Primeiro item");
        create("Segundo item");
        list();

        System.out.println("\nAtualizando o primeiro item...");
        update(1, "Primeiro item atualizado");
        list();

        System.out.println("\nDeletando o segundo item...");
        delete(2);
        list();
    }

    // CREATE
    public static void create(String name) {
        items.add(new Item(currentId++, name));
        System.out.println("Item criado: " + name);
    }

    // READ
    public static void list() {
        System.out.println("Lista de itens:");
        for (Item item : items) {
            System.out.println("ID: " + item.getId() + ", Nome: " + item.getName());
        }
    }

    // UPDATE
    public static void update(int id, String newName) {
        for (Item item : items) {
            if (item.getId() == id) {
                item.setName(newName);
                System.out.println("Item ID " + id + " atualizado.");
                return;
            }
        }
        System.out.println("Item com ID " + id + " não encontrado.");
    }

    // DELETE
    public static void delete(int id) {
        if (items.removeIf(item -> item.getId() == id)) {
            System.out.println("Item ID " + id + " deletado.");
        } else {
            System.out.println("Item com ID " + id + " não encontrado.");
        }
    }
}

// Classe auxiliar para representar os itens
class Item {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
