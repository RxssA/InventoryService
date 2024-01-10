package ie.atu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "confirmation-service", url = "http//localhost:8080")
public interface InventoryClient {
    @PostMapping("/confirm")
    String someDetails(@RequestBody Inventory inventory);
}
