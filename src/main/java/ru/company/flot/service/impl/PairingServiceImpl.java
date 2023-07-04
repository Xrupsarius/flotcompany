package ru.company.flot.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.company.flot.dto.PairingDto;
import ru.company.flot.dto.RootJsonRosterDto;
import ru.company.flot.entity.Pairing;
import ru.company.flot.repository.PairingRepository;
import ru.company.flot.service.PairingService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PairingServiceImpl implements PairingService {

    private final PairingRepository repository;

    @Override
    @Transactional
    public List<Pairing> downloadPairings(RootJsonRosterDto rosterDto) {
        List<Pairing> pairings = rosterDto.getPairings().stream()
                .map(roster -> Pairing.builder()
                        .id(roster.getId())
                        .fleet(roster.getFleet())
                        .startTime(roster.getDateTimeStart())
                        .endTime(roster.getDateTimeEnd())
                        .build()).toList();
        repository.saveAll(pairings);
        log.info("Saved to pairing table datas - {}", pairings);
        return pairings;
    }
}
