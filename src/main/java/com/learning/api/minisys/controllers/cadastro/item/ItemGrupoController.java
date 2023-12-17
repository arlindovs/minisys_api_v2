package com.learning.api.minisys.controllers.cadastro.item;

import com.learning.api.minisys.repositories.cadastro.item.ItemGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/item_grupos")
public class ItemGrupoController {

    @Autowired
    private ItemGrupoRepository itemGrupoRepository;
}
