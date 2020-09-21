package sn.gs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.gs.demo.dao.RoleRepository;
import sn.gs.demo.service.ICrudService;

import java.util.List;


//Toutes les controlleurs qui doivent avoir un crud vont herité de celui la
//(On la fé de maniere générique pr eviter de repeter le code du crud). T represente la classe et ID le type de la
//cle primaire de cette classe

public class CrudController<T, ID> {



    @Autowired
    private ICrudService<T, ID> service;

    @GetMapping
    public List<T> getAll()
    {
        return this.service.getAll();
    }

    @PostMapping
    public void add(@RequestBody T entity)
    {
        this.service.add(entity);
    }

    @PutMapping
    public void update(@RequestBody T entity)
    {
        this.service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id)
    {
        this.service.delete(id);
    }
}
