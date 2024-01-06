package ie.atu;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class InventoryUpdateRequest {
    private String title;
    private Long bookId;
    private int quantity;
    private String authur;
    private String genre;

}
