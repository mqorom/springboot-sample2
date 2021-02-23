package com.exalt.trainingproject.service;

import com.exalt.trainingproject.model.Machine;

import java.util.List;

public interface MachineService {

    Machine saveMachine(Machine machine, int userId);

    List<Machine> getAllByUserId(int userId);

    Machine getById(String id);

    void deleteAll(int userId);
}
