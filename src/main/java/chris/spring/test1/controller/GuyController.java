package chris.spring.test1.controller;

import chris.spring.test1.model.Guy;
import chris.spring.test1.service.GuyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guys")
public class GuyController {
    private GuyService guyService;

    @Autowired
    public GuyController(GuyService guyService) {
        this.guyService = guyService;
    }

    @GetMapping()
    public List<Guy> list() {
        return guyService.getAll();
    }

    @GetMapping("/{name}")
    public Guy get(@PathVariable String name) {
        return guyService.get(name);
    }

    @GetMapping("/exact")
    public Guy get(@RequestBody Guy guy) {
        return guyService.getExact(guy);
    }

    @PostMapping
    public Guy add(@RequestBody Guy guy) {
        return guyService.upsert(guy);
    }

    @PutMapping
    public Guy update(@RequestBody Guy guy) {
        return guyService.upsert(guy);
    }

    @DeleteMapping("/{name}")
    public List<Guy> delete(@PathVariable String name) {
        return guyService.remove(name);
    }

}
