package com.example.app2.service;

import com.example.app2.entity.Name;
import com.example.app2.repo.NameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {

    @Autowired
    private NameRepo nameRepo;
    public void insertName(Map<String,String > name) {
        nameRepo.save(new Name(name.get("s1Key")));

    }

    public List<Name> getAllNames() {
       return nameRepo.findAll();
    }
}
