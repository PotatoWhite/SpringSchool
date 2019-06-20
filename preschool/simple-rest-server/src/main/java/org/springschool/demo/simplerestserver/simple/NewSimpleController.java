package org.springschool.demo.simplerestserver.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v2/simples")
public class NewSimpleController {
    @Autowired
    private SimpleRepository simpleRepository;

    @GetMapping("")
    public Page<Simple> getAllSimples(Pageable pageable) {
        return simpleRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity getSimple(@PathVariable Long id) {
        Optional<Simple> byId = simpleRepository.findById(id);

        if (byId.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(byId.get());
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("")
    public ResponseEntity createSimple(@RequestBody Simple aSimple) {
        boolean isExist = simpleRepository.existsById(aSimple.getId());
        if (isExist)
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(simpleRepository.save(aSimple));
    }

    @PutMapping("")
    public ResponseEntity updateSimple(@RequestBody Simple aSimple) {
        boolean isExist = simpleRepository.existsById(aSimple.getId());
        if (!isExist)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.status(HttpStatus.OK).body(simpleRepository.save(aSimple));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSimple(@PathVariable Long id) {
        simpleRepository.deleteById(id);

        boolean isExist = simpleRepository.existsById(id);
        if (!isExist)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
