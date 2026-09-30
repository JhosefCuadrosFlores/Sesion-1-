package pe.edu.upeu.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upeu.cliente.entity.TipoPersona;

@Getter
@Setter
public class ClienteRequest {

    @NotNull
    private TipoPersona tipoPersona;

    @Size(min = 8, max = 8)
    private String dni;

    @Size(min = 11, max = 11)
    private String ruc;

    @Size(max = 150)
    private String nombreCompleto;

    @Size(max = 150)
    private String razonSocial;

    @Size(max = 255)
    private String direccion;

    @Email
    @Size(max = 150)
    private String email;

    @Size(max = 20)
    private String whatsapp;
}
