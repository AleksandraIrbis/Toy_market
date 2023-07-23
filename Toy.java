import java.io.*;
import java.util.*;

class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", weight=" + weight +
                '}';
    }
}

class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;
    private String filePath;

    public ToyStore(String filePath) {
        this.filePath = filePath;
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addNewToy(int id, String name, int quantity, double weight) {
        Toy newToy = new Toy(id, name, quantity, weight);
        toys.add(newToy);
    }

    public void updateToyWeight(int id, double weight) {
        Toy toyToUpdate = findToyById(id);
        if (toyToUpdate != null) {
            toyToUpdate.setWeight(weight);
        }
    }

    public void drawPrizeToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        Random random = new Random();
        double randomValue = random.nextDouble() * totalWeight;

        for (Toy toy : toys) {
            randomValue -= toy.getWeight();
            if (randomValue <= 0) {
                toy.setQuantity(toy.getQuantity() - 1);
                prizeToys.add(toy);
                break;
            }
        }
    }

    public void savePrizeToysToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Toy toy : prizeToys) {
                writer.println(toy.getId() + "," + toy.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Toy findToyById(int id) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }
}

