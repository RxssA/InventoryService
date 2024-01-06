package ie.atu;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/inventory")
@RestController
public class InventoryController {
    private final InventoryService InventoryService;
    @Autowired
    public InventoryController(InventoryService InventoryService) {
        this.InventoryService = InventoryService;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Inventory> getInventory(@PathVariable String bookId) {
        Inventory inventory = InventoryService.getInventory(Long.valueOf(bookId));

        if (inventory == null) {
            return ResponseEntity.ok(inventory);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateInventory(@Valid @RequestBody InventoryUpdateRequest request) {
        Long bookId = request.getBookId();
        int quantity = request.getQuantity();
        String authur = String.valueOf(request.getAuthur());
        String genre = String.valueOf(request.getGenre());
        String title = String.valueOf(request.getTitle());


        boolean updated = InventoryService.updateInventory(bookId, quantity, title, authur, genre);
        if (updated){
            return ResponseEntity.ok("Inventory updated");
        } else {
            return ResponseEntity.status(500).body("Failed to update");
        }

    }
}