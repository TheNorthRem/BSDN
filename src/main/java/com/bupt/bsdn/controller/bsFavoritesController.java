package com.bupt.bsdn.controller;

import com.bupt.bsdn.service.bsFavoritesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bsFavorites")
@Slf4j
@Tag(name = "收藏")
public class bsFavoritesController {
    private final bsFavoritesService bsFavoritesService;

    @Autowired
    public bsFavoritesController(bsFavoritesService bsFavoritesService) {
        this.bsFavoritesService = bsFavoritesService;
    }
}
