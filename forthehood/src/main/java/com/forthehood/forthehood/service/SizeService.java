package com.forthehood.forthehood.service;

import java.util.List;
import com.forthehood.forthehood.entity.Size;

public interface SizeService {

    List<Size> getAllSizes();

    Size getSizeById(Long id);

    Size createSize(Size size);

    Size updateSize(Long id, Size size);

    void deleteSize(Long id);

}