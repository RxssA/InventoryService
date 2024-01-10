package ie.atu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    static Inventory findByBookId(Long bookId) {

        return null;
    }
}
