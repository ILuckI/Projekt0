package com.project0.ProjektGrupowy.service;

import com.project0.ProjektGrupowy.Entities.Accessory;
import com.project0.ProjektGrupowy.dto.AccessoryDto;
import com.project0.ProjektGrupowy.dto.PriceDto;
import com.project0.ProjektGrupowy.repository.AccessoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<AccessoryDto> getAllAccessories(){
        Iterable<Accessory> accessories = accessoryRepository.findAll();
        return StreamSupport.stream(accessories.spliterator(), false)
                .map(accessory -> modelMapper.map(accessory, AccessoryDto.class))
                .collect(Collectors.toList());
    }

    public int findPriceByAccessoryName(String name){
        return accessoryRepository.findByName(name).getPrice();
    }


}
