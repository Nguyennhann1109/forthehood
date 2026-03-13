package com.forthehood.forthehood.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forthehood.forthehood.entity.Size;
import com.forthehood.forthehood.repository.SizeRepository;
import com.forthehood.forthehood.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService {

    private final SizeRepository sizeRepository;

    public SizeServiceImpl(SizeRepository sizeRepository){
        this.sizeRepository = sizeRepository;
    }

    @Override
    public List<Size> getAllSizes(){
        return sizeRepository.findAll();
    }

    @Override
    public Size getSizeById(Long id){
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public Size createSize(Size size){
        return sizeRepository.save(size);
    }

    @Override
    public Size updateSize(Long id, Size size){
        size.setId(id);
        return sizeRepository.save(size);
    }

    @Override
    public void deleteSize(Long id){
        sizeRepository.deleteById(id);
    }

}