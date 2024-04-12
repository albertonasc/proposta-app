package com.alberto.propostaapp.service;

import com.alberto.propostaapp.dto.PropostaRequestDto;
import com.alberto.propostaapp.dto.PropostaResponseDto;
import com.alberto.propostaapp.entity.Proposta;
import com.alberto.propostaapp.mapper.PropostaMapper;
import com.alberto.propostaapp.repository.PropostaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {
    private PropostaRepository propostaRepository;

    public PropostaService(PropostaRepository propostaRepository) {
        this.propostaRepository = propostaRepository;
    }

    public PropostaResponseDto criar(PropostaRequestDto requestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.converteDtoParaProposta(requestDto);
        propostaRepository.save(proposta);

        return PropostaMapper.INSTANCE.converteEntidadeParaDto(proposta);
    }

    public List<PropostaResponseDto> obterProposta() {
        Iterable<Proposta> propostas = propostaRepository.findAll();

        return PropostaMapper.INSTANCE.converteListaEntidadeParaListaDto(propostas);
    }
}
