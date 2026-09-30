package pe.edu.upeu.orden.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.upeu.orden.client.ProductoClient;
import pe.edu.upeu.orden.dto.ProductoDto;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogoConsultaService {

    private final ProductoClient productoClient;

    @CircuitBreaker(name = "catalogo", fallbackMethod = "fallbackProducto")
    public ProductoDto consultarProducto(Long idProducto) {
        log.info("Feign: consultando producto {} en pagatu-catalogo-ms", idProducto);
        return productoClient.findById(idProducto);
    }

    public ProductoDto fallbackProducto(Long idProducto, Throwable ex) {
        log.warn("Fallback del circuit breaker catalogo para producto {}: {}", idProducto, ex.toString());
        return null;
    }
}
