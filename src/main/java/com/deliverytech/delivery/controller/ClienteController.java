package com.deliverytech.delivery.controller;

import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    /**
     * Cadastrar novos clientes
     */

    @PostMapping
    public ResponseEntity<?> cadastrar(@Validated @RequestBody Cliente cliente) {
        try {
            Cliente clienteSalvo = clienteService.cadastrar(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno do servidor");
        }
    }

    /**
     * Listar todos os clientes ativos
     */
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = clienteService.listarAtivos();
        return ResponseEntity.ok(clientes);
    }

    /**
     * Buscar clientes por ID
     */
@GetMapping("/{id}")
public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
    Optional<Cliente> cliente = clienteService.buscarPorId(id);

    if (cliente.isPresent()) {
        return ResponseEntity.ok(cliente.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}

/**
 * Atualizar os clientes
 */
@PutMapping("/{id}")
    public ResponseEntity<?> atualizar (@PathVariable Long id,
                                        @Validated @RequestBody Cliente cliente) {
    try {
        Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(clienteAtualizado);
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno do servidor");
    }
}


/**
 * Inativar cliente (soft delete)
 */
@DeleteMapping("/{id}")
    public ResponseEntity<?> inativar(@PathVariable Long id) {
    try {
        clienteService.inativar(id);
        return ResponseEntity.ok().body("Cliente inativado com sucesso");
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro interno do servidor");
    }
}

/**
 * Buscar clientes pelo nome
 */
@GetMapping("/buscar")
    public ResponseEntity<List<Cliente>> buscarPorNome(@RequestParam String nome) {
    List<Cliente> clientes = clienteService.buscarPorNome(nome);
    return ResponseEntity.ok(clientes);
}

/**
 * Buscar clientes pelo email
 */
@GetMapping("/email/{email}")
public ResponseEntity<?> buscarPorEmail(@PathVariable String email) {
    Optional<Cliente> cliente = clienteService.buscarPorEmail(email);

    if (cliente.isPresent()) {
        return ResponseEntity.ok(cliente.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}}