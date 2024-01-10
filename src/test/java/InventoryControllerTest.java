import ie.atu.Inventory;
import ie.atu.InventoryController;
import ie.atu.InventoryService;
import ie.atu.InventoryUpdateRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InventoryControllerTest {

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;

    @Test
    public void testGetInventory() {
        // Mocking
        long bookId = 123L;
        Inventory mockInventory = new Inventory();
        when(inventoryService.getInventory(bookId)).thenReturn(mockInventory);

        // Test
        ResponseEntity<Inventory> response = inventoryController.getInventory(String.valueOf(bookId));

        // Assertions
        assertEquals(ResponseEntity.ok(mockInventory), response);
        verify(inventoryService, times(1)).getInventory(bookId);
    }

    @Test
    public void testGetInventoryNotFound() {
        // Mocking
        long bookId = 456L;
        when(inventoryService.getInventory(bookId)).thenReturn(null);

        // Test
        ResponseEntity<Inventory> response = inventoryController.getInventory(String.valueOf(bookId));

        // Assertions
        assertEquals(ResponseEntity.notFound().build(), response);
        verify(inventoryService, times(1)).getInventory(bookId);
    }

    @Test
    public void testUpdateInventory() {
        // Mocking
        InventoryUpdateRequest mockRequest = new InventoryUpdateRequest();
        mockRequest.setBookId(123L);
        mockRequest.setQuantity(5);
        mockRequest.setAuthor("Sample Author");
        mockRequest.setGenre("Sample Genre");
        mockRequest.setTitle("Sample Title");

        when(inventoryService.updateInventory(
                mockRequest.getBookId(),
                mockRequest.getQuantity(),
                mockRequest.getTitle(),
                mockRequest.getAuthor(),
                mockRequest.getGenre()
        )).thenReturn(true);

        // Test
        ResponseEntity<String> response = inventoryController.updateInventory(mockRequest);

        // Assertions
        assertEquals(ResponseEntity.ok("Inventory updated"), response);
        verify(inventoryService, times(1)).updateInventory(
                mockRequest.getBookId(),
                mockRequest.getQuantity(),
                mockRequest.getTitle(),
                mockRequest.getAuthor(),
                mockRequest.getGenre()
        );
    }

    @Test
    public void testUpdateInventoryFailure() {
        // Mocking
        InventoryUpdateRequest mockRequest = new InventoryUpdateRequest();
        mockRequest.setBookId(123L);
        mockRequest.setQuantity(5);
        mockRequest.setAuthor("Sample Author");
        mockRequest.setGenre("Sample Genre");
        mockRequest.setTitle("Sample Title");

        when(inventoryService.updateInventory(
                mockRequest.getBookId(),
                mockRequest.getQuantity(),
                mockRequest.getTitle(),
                mockRequest.getAuthor(),
                mockRequest.getGenre()
        )).thenReturn(false);

        // Test
        ResponseEntity<String> response = inventoryController.updateInventory(mockRequest);

        // Assertions
        assertEquals(ResponseEntity.status(500).body("Failed to update"), response);
        verify(inventoryService, times(1)).updateInventory(
                mockRequest.getBookId(),
                mockRequest.getQuantity(),
                mockRequest.getTitle(),
                mockRequest.getAuthor(),
                mockRequest.getGenre()
        );
    }

    @Test
    public void testUpdateInventoryException() {
        // Mocking
        InventoryUpdateRequest mockRequest = new InventoryUpdateRequest();
        mockRequest.setBookId(123L);
        mockRequest.setQuantity(5);
        mockRequest.setAuthor("Sample Author");
        mockRequest.setGenre("Sample Genre");
        mockRequest.setTitle("Sample Title");

        when(inventoryService.updateInventory(
                mockRequest.getBookId(),
                mockRequest.getQuantity(),
                mockRequest.getTitle(),
                mockRequest.getAuthor(),
                mockRequest.getGenre()
        )).thenThrow(new RuntimeException("Simulated exception"));

        // Test
        ResponseEntity<String> response = inventoryController.updateInventory(mockRequest);

        // Assertions
        assertEquals(ResponseEntity.status(500).body("Failed to update - Exception: Simulated exception"), response);
        verify(inventoryService, times(1)).updateInventory(
                mockRequest.getBookId(),
                mockRequest.getQuantity(),
                mockRequest.getTitle(),
                mockRequest.getAuthor(),
                mockRequest.getGenre()
        );
    }
}

