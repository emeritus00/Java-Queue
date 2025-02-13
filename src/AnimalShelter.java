import java.util.LinkedList;
import java.util.Queue;

class AnimalShelter {

    // Queues to hold dogs and cats
    private Queue<String> dogs = new LinkedList<>();
    private Queue<String> cats = new LinkedList<>();

    // Method to enqueue an animal
    public void enqueue(String type) {
        if (type.equalsIgnoreCase("dog")) {
            dogs.add(type);
        } else if (type.equalsIgnoreCase("cat")) {
            cats.add(type);
        } else {
            throw new IllegalArgumentException("Invalid animal type. Only 'dog' or 'cat' are allowed.");
        }
    }

    // Method to dequeue the oldest animal (either dog or cat)
    public String dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            throw new IllegalStateException("No animals available in the shelter.");
        }

        // Return the oldest animal (dog if available, otherwise cat)
        if (dogs.isEmpty()) {
            return cats.poll();
        } else if (cats.isEmpty()) {
            return dogs.poll();
        } else {
            // Assume dogs have priority if both are available
            return dogs.poll();
        }
    }
    // Method to dequeue the oldest dog
    public String dequeueDog() {
        if (dogs.isEmpty()) {
            throw new IllegalStateException("No dogs available in the shelter.");
        }
        return dogs.poll();
    }

    // Method to dequeue the oldest cat
    public String dequeueCat() {
        if (cats.isEmpty()) {
            throw new IllegalStateException("No cats available in the shelter.");
        }
        return cats.poll();
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        // Enqueue some animals
        shelter.enqueue("dog");
        shelter.enqueue("cat");
        shelter.enqueue("dog");
        shelter.enqueue("cat");

        // Dequeue operations
        System.out.println("Adopted: " + shelter.dequeueAny());
        System.out.println("Adopted: " + shelter.dequeueCat());
        System.out.println("Adopted: " + shelter.dequeueDog());
        System.out.println("Adopted: " + shelter.dequeueAny());
    }
}
