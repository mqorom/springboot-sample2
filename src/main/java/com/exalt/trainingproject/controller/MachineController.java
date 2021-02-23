package com.exalt.trainingproject.controller;

import com.exalt.trainingproject.model.Machine;
import com.exalt.trainingproject.serviceimpl.MachineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MachineController {
    public static final String URL = "/tenant/{userId}/machine/device";

    @Autowired
    private MachineServiceImpl service;

    @PostMapping(URL)
    public Machine add(@RequestBody Machine machine, @PathVariable int userId) {
        return service.saveMachine(machine, userId);
    }

    @GetMapping(URL)
    public List<Machine> getAll(@PathVariable int userId) {
        return service.getAllByUserId(userId);
    }

    @GetMapping(URL + "/{id}")
    public Machine findById(@PathVariable String id) {
        return service.getById(id);
    }

    @DeleteMapping(URL)
    public void deleteAll(@PathVariable int userId) {
        service.deleteAll(userId);
    }
}

