package ru.company.flot.service;

import ru.company.flot.dto.RootJsonRosterDto;
import ru.company.flot.entity.Pairing;

import java.util.List;

public interface PairingService {

    List<Pairing> uploadPairings(RootJsonRosterDto rosterDto);

    List<Pairing> getAllPairingsByEmployeeId(Integer employeeId);
}
