package com.tuyo.tuyofood.jpa;

import com.tuyo.tuyofood.TuyoFoodRestApplication;
import com.tuyo.tuyofood.domain.entity.Kitchen;
import com.tuyo.tuyofood.domain.repository.KitchenRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

/* 1. Esta classe representa uma Main apenas para testar sem uma Controller.
*  2. Serve também para testar a inicialização não-web
*  3. ApplicationContext: é uma interface que gerencia o contexto da aplicação.
*  4. NONE = determina que aqui não é uma aplicação WEB. */

public class KitchenQueryMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(TuyoFoodRestApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        KitchenRepository kitchenRepository = applicationContext.getBean(KitchenRepository.class);

        List<Kitchen> kitchens = kitchenRepository.listar();

        for (Kitchen kitchen : kitchens) {
            System.out.println(kitchen.getNome());
        }
    }
}
