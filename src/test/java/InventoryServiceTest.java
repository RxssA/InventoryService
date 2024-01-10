import ie.atu.Inventory;
import ie.atu.InventoryRepository;
import ie.atu.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = {InventoryService.class})
public class InventoryServiceTest {
    @Autowired
    private InventoryService inventoryService;

    @MockBean
    private InventoryRepository inventoryRepository;  // Fix: Corrected the name here

    @Test
    public void testUpdateInventory() {
        long bookId = 123L;
        int quantity = 5;
        String title = "Sample Title";
        String author = "Sample Author";
        String genre = "Sample Genre";

        // Issue here: when(inventoryRepository.findByBookId(bookId)).thenReturn(new Inventory());
        when(InventoryRepository.findByBookId(bookId)).thenReturn(new Inventory());

        boolean result = inventoryService.updateInventory(bookId, quantity, title, author, genre);

        // Add your assertions or verifications based on the test scenario
    }

}
