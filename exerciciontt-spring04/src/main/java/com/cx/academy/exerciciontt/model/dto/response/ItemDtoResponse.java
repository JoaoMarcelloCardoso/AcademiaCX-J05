package com.cx.academy.exerciciontt.model.dto.response;

import com.cx.academy.exerciciontt.model.ProductModel;


//não consegui implementar por algum item e cart mesmo ao repetir os mesmos passos das outras Dtos, não consegui encontrar o problema
// que retornava erro 500
// pelo que entendi precisaria utilizar uma anotação @Jsonserialize e criar outra classe, mas não conseguirei fazer isso a tempo
public class ItemDtoResponse {
    private Long id;

    private int quantity;

    private Double total;

}
