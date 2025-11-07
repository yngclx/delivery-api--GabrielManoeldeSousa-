package com.deliverytech.delivery.controller;
import java.time.LocalDateTime;
import java.util.List;

import com.deliverytech.delivery.dto.PedidoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.enums.StatusPedido;
import com.deliverytech.delivery.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {
    @Autowired
    private PedidoService PedidoService;

    /**
     * Criar novo pedido
     */
    @PostMapping
    public ResponseEntity<?> criarPedido(@RequestBody PedidoRequestDTO dto) {
        try {
            Pedido pedido = PedidoService.criarPedido(dto);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno do servidor");
        }
    }
    /**
     * Listar pedidos por cliente
     */
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable Long clienteId) {
        List<Pedido> pedidos = PedidoService.listarPorCliente(clienteId);
        return ResponseEntity.ok(pedidos);
    }

    /**
     * Atualizar status do pedido
     */
    @PutMapping("/{pedidoId}/{status}")
    public ResponseEntity<?> atualizarStatus(@PathVariable Long pedidoId,
                                             @PathVariable StatusPedido status) {
        try {
            Pedido pedido = PedidoService.atualizarStatus(pedidoId, status);
            return ResponseEntity.ok(pedido);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno do servidor");
        }
    }
    // Pedidos por cliente
    @GetMapping("/cliente/{clienteId}/todos")
    public ResponseEntity<List<Pedido>> buscarPedidosPorCliente(@PathVariable Long clienteId) {
        List<Pedido> pedidos = PedidoService.buscarPedidosPorCliente(clienteId);
        return ResponseEntity.ok(pedidos);
    }
    /**
     * Listar pedidos por status
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Pedido>> listarPorStatus(@PathVariable StatusPedido status) {
        List<Pedido> pedidos = PedidoService.listarPorStatus(status);
        return ResponseEntity.ok(pedidos);
    }
    /**
     * Listar os 10 pedidos mais recentes
     */
    @GetMapping("/recentes")
    public ResponseEntity<List<Pedido>> listarRecentes() {
        List<Pedido> pedidos = PedidoService.listarRecentes();
        return ResponseEntity.ok(pedidos);
    }
    // Pedidos por período
    @GetMapping("/periodo")
    public ResponseEntity<List<Pedido>> listarPorPeriodo(@RequestParam String inicio, @RequestParam String fim) {
        List<Pedido> pedidos = PedidoService.listarPorPeriodo(LocalDateTime.parse(inicio), LocalDateTime.parse(fim));
        return ResponseEntity.ok(pedidos);
    }

}

