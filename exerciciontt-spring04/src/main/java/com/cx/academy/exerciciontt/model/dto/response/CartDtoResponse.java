package com.cx.academy.exerciciontt.model.dto.response;

import com.cx.academy.exerciciontt.model.ClientModel;
import com.cx.academy.exerciciontt.model.ItemModel;
import com.cx.academy.exerciciontt.model.ProductModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

//não consegui implementar por algum item e cart mesmo ao repetir os mesmos passos das outras Dtos, não consegui encontrar o problema
// que retornava erro 500
// pelo que entendi precisaria utilizar uma anotação @Jsonserialize e criar outra classe, mas não conseguirei fazer isso a tempo
public class CartDtoResponse {
    private Long id;

    private Double total;

    private List<ItemModel> items;

    private ClientModel clientModel;

}
