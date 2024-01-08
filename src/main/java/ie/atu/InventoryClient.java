package ie.atu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Inventory-service", url = "http://localhost:8080")
public class InventoryClient {
    @PostMapping("/confirm")
    ResponseEntity<String> someDetails(@RequestBody Inventory inventory);
}
