package Client.Api_Restfull_Client.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @NotBlank(message = "The 'name' field cannot be empty or null")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message = "The 'birthDate' must be in the past or present")
    private LocalDate birthDate ;
    private Integer children;
}
