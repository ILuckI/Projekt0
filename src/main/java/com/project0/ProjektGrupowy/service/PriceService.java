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

    public int get3DaysPriceByCarClassId(long carClassId){
        int Days3Price = priceRepository.findByCarClassId(carClassId).getDay3();
        return Days3Price;
    }

    public int get7DaysPriceByCarClassId(long carClassId){
        int Days7Price = priceRepository.findByCarClassId(carClassId).getDay7();
        return Days7Price;
    }

    public int get7DaysMorePriceByCarClassId(long carClassId){
        int Days7MorePrice = priceRepository.findByCarClassId(carClassId).getDay7more();
        return Days7MorePrice;
    }

    public int getDepositByCarClassId(long carClassId){
        int deposit = priceRepository.findByCarClassId(carClassId).getDeposit();
        return deposit;
    }
}
