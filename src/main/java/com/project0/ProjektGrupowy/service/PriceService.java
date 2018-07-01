package com.project0.ProjektGrupowy.service;

import com.project0.ProjektGrupowy.Entities.Car;
import com.project0.ProjektGrupowy.Entities.Price;
import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.dto.PriceDto;
import com.project0.ProjektGrupowy.repository.PriceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PriceDto> getAllPrices(){
        Iterable<Price> prices = priceRepository.findAll();
        return StreamSupport.stream(prices.spliterator(), false)
                .map(price -> modelMapper.map(price, PriceDto.class))
                .collect(Collectors.toList());
    }
}
