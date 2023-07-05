package ru.company.flot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.company.flot.entity.Pairing;

import java.util.List;
import java.util.UUID;

public interface PairingRepository extends CrudRepository<Pairing, UUID> {

    List<Pairing> findAllByIdIn(List<Integer> pairingId);

}
