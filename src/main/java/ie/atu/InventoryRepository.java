package ie.atu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.JpaRepository;

@EnableFeignClients
@SpringBootApplication
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByBookId(Long bookId);

    void setQuantity(int quantity);
}
