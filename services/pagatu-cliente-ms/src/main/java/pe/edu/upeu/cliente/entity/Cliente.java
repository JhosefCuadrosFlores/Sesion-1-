package pe.edu.upeu.cliente.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_persona", nullable = false, length = 10)
    private TipoPersona tipoPersona;

    @Column(length = 8, unique = true)
    private String dni;

    @Column(length = 11, unique = true)
    private String ruc;

    @Column(name = "nombre_completo", length = 150)
    private String nombreCompleto;

    @Column(name = "razon_social", length = 150)
    private String razonSocial;

    @Column(length = 255)
    private String direccion;

    @Column(length = 150)
    private String email;

    @Column(length = 20)
    private String whatsapp;
}
