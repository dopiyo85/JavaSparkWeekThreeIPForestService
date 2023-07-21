package org.javasparkips.wildlifetracker.dao;

import org.javasparkips.wildlifetracker.models.Animal;
import java.util.List;

public interface AnimalDao {
    Animal findById(int id);
    List<Animal> findAll();
    void save(Animal animal);
    void update(Animal animal);
    void delete(int id);
}
