package ie.atu;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class inventory {

    @NotBlank
    private String title;

    @NotBlank
    private String bookId;

    @NotBlank
    private String author;

    @NotBlank
    private String genre;

}