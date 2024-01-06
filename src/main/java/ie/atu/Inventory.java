package ie.atu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String title;

    @NotBlank
    private long bookId;

    @NotBlank
    private String author;

    @NotBlank
    private String genre;

    public void setQuantity(int quantity) {

    }
}
