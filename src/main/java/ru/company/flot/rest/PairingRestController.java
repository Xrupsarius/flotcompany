package ru.company.flot.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.company.flot.dto.RootJsonRosterDto;
import ru.company.flot.entity.Pairing;
import ru.company.flot.service.PairingService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pairing")
@RequiredArgsConstructor
public class PairingRestController {

    private final PairingService service;

    @PostMapping("/upload")
    public List<Pairing> uploadPairings(@RequestBody RootJsonRosterDto rosterDto) {
        log.info("Started uploading pairings and appointments.");
        return service.uploadPairings(rosterDto);
    }

}
