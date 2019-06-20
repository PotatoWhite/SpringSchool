package org.springschool.demo.simplerestserver.simple;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/simples")
public class SimpleController {
    @Autowired
    private SimpleRepository simpleRepository;

    @GetMapping("/{id}")
    public Simple getSimple(@PathVariable Long id){
        return simpleRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public Simple createSimple(@RequestBody Simple aSimple){
        return simpleRepository.save(aSimple);
    }

    @PutMapping("")
    public Simple updateSimple(@RequestBody Simple aSimple){
        return simpleRepository.save(aSimple);
    }

    @DeleteMapping("/{id}")
    public void deleteSimple(@PathVariable Long id){
        simpleRepository.deleteById(id);
    }
}
