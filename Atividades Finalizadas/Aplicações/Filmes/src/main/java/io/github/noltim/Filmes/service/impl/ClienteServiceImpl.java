package io.github.noltim.Filmes.service.impl;

import io.github.noltim.Filmes.domain.repository.ClienteRepository;
import io.github.noltim.Filmes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

}
