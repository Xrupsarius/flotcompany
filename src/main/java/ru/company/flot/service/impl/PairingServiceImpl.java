package ru.company.flot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.company.flot.dto.RootJsonRosterDto;
import ru.company.flot.entity.Assignment;
import ru.company.flot.entity.Pairing;
import ru.company.flot.repository.AssignmentRepository;
import ru.company.flot.repository.PairingRepository;
import ru.company.flot.service.PairingService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PairingServiceImpl implements PairingService {

    private final PairingRepository repository;
    private final AssignmentRepository assignmentRepository;

    @Override
    @Transactional
    public List<Pairing> uploadPairings(RootJsonRosterDto rosterDto) {
        if (rosterDto.getPairings().isEmpty()) return Collections.emptyList();
        if (rosterDto.getAssignments().isEmpty()) return Collections.emptyList();

        List<Pairing> pairings = rosterDto.getPairings().stream()
                .map(roster -> Pairing.builder()
                        .id(roster.getId())
                        .fleet(roster.getFleet())
                        .startTime(roster.getDateTimeStart())
                        .endTime(roster.getDateTimeEnd())
                        .build()).toList();
        repository.saveAll(pairings);
        log.info("Uploaded pairings to table - {}", pairings);
        log.info("Started saving assignments");

        List<Assignment> assignments = rosterDto.getAssignments().stream()
                .map(assignmentDto -> Assignment.builder()
                        .id(UUID.randomUUID())
                        .employeeId(assignmentDto.getEmployeeId())
                        .pairingId(assignmentDto.getPairingId())
                        .rank(assignmentDto.getRank())
                        .build()
                )
                .toList();
        assignmentRepository.saveAll(assignments);
        log.info("Saved assignments to db - {}", assignments);
        return pairings;
    }

    @Override
    @Transactional
    public List<Pairing> getAllPairingsByEmployeeId(Integer employeeId) {
        List<Integer> pairingIds = assignmentRepository.findByEmployeeId(employeeId)
                .stream()
                .map(Assignment::getPairingId)
                .toList();
        log.info("Get the all pairing ids from assignments - {}", pairingIds);
        List<Pairing> allByIdsIn = repository.findAllByIdIn(pairingIds);
        log.info("Find for employee with id - {} - all pairings - {}", employeeId, pairingIds);
        return allByIdsIn;
    }
}
