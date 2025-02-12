package com.examen_final.p65.examen.controller;

import org.springframework.web.bind.annotation.*;
import com.examen_final.p65.examen.repository.UniversidadRepository;
import com.examen_final.p65.examen.modelo.Universidad;
import java.util.List;

@RestController
@RequestMapping("/api/universidades")
public class UniversidadController {
    private final UniversidadRepository repository;

    public UniversidadController(UniversidadRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Universidad> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Universidad create(@RequestBody Universidad universidad) {
        return repository.save(universidad);
    }

    @PutMapping("/{id}")
    public Universidad update(@PathVariable Long id, @RequestBody Universidad universidad) {
        return repository.findById(id)
                .map(u -> {
                    u.setNombre(universidad.getNombre());
                    u.setCiudad(universidad.getCiudad());
                    return repository.save(u);
                })
                .orElseThrow(() -> new RuntimeException("No encontrada"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
