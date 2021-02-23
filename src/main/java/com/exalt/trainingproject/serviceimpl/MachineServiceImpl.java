package com.exalt.trainingproject.serviceimpl;

import com.exalt.trainingproject.exceptions.ElementNotFoundException;
import com.exalt.trainingproject.model.Machine;
import com.exalt.trainingproject.model.User;
import com.exalt.trainingproject.repository.MachineRepository;
import com.exalt.trainingproject.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public Machine saveMachine(Machine machine, int userId) {
        User user = userServiceImpl.getById(userId);
        machine.setUser(user);
        return machineRepository.save(machine);
    }

    @Override
    public List<Machine> getAllByUserId(int userId) {
        User user = userServiceImpl.getById(userId);
        return machineRepository.findAllByUser(user);
    }

    @Override
    public Machine getById(String id) {
        return machineRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("Could not find machine with provided ID"));
    }

    @Override
    public void deleteAll(int userId) {
        User user = userServiceImpl.getById(userId);
        machineRepository.deleteByUser(user);
    }
}


