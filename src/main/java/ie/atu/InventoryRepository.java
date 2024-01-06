package ie.atu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByBookId(Long bookId);
}
