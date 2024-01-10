package ie.atu;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;

    }

    @CrossOrigin
    @GetMapping("/{bookId}")
    public ResponseEntity<Inventory> getInventory(@PathVariable String bookId) {
        Inventory inventory = inventoryService.getInventory(Long.valueOf(bookId));

        if (inventory == null) {
            System.out.println("Book ID:"+bookId);
            return ResponseEntity.ok(inventory);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateInventory(@Valid @RequestBody InventoryUpdateRequest request) {
        try{
            System.out.println("Entering updateInventory method");

        Long bookId = request.getBookId();
        int quantity = request.getQuantity();
        String author = String.valueOf(request.getAuthor());
        String genre = String.valueOf(request.getGenre());
        String title = String.valueOf(request.getTitle());




        boolean updated = inventoryService.updateInventory(bookId, quantity, title, author, genre);
            System.out.println("Exiting updateInventory method successfully");
        if (updated) {
            return ResponseEntity.ok("Inventory updated");
        } else {
            return ResponseEntity.status(500).body("Failed to update");
        }
    }
     catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body("Failed to update - Exception: " + e.getMessage());
    }
    }

}
