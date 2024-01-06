package ie.atu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InventoryService {
    @Autowired
    private final InventoryRepository inventoryRepository;
    @FeignClient(name = "Inventory-service", url = "http://localhost:8080")
    public interface InventoryClient{
        @PostMapping("/confirm")
        String someDetails (@RequestBody Inventory inventory);
    }
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory getInventory(Long bookId) {
        return inventoryRepository.findByBookId(bookId);
    }
    public void saveInventory(Inventory inventory) {
        inventoryRepository.save(inventory);

    }

    public boolean updateInventory(Long bookId, int quantity, String title, String authur, String genre) {

        return false;
    }
}