package ie.atu;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public interface InventoryClient {
        @PostMapping("/confirm")
        String someDetails(@RequestBody Inventory inventory);
    }

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory getInventory(Long bookId) {
        return InventoryRepository.findByBookId(bookId);
    }

    public void saveInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }
@Transactional
    public boolean updateInventory(Long book_Id, int quantity, String title, String author, String genre) {
        try {
            Inventory existingInventory = InventoryRepository.findByBookId(book_Id);
            System.out.println("bookId: " + book_Id);
            System.out.println("quantity: " + quantity);
            System.out.println("title: " + title);
            System.out.println("author: " + author);
            System.out.println("genre: " + genre);


            if (existingInventory != null) {
                existingInventory.setQuantity(quantity);
                existingInventory.setTitle(title);
                existingInventory.setAuthor(author);
                existingInventory.setGenre(genre);
                inventoryRepository.save(existingInventory);
                return true;
            } else {
                System.out.println("Failed");
                return false;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
