package com.tuyo.tuyofood.jpa;

import com.tuyo.tuyofood.TuyoFoodRestApplication;
import com.tuyo.tuyofood.domain.entity.Permission;
import com.tuyo.tuyofood.domain.repository.PermissionRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class PermissionQueryMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(TuyoFoodRestApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        PermissionRepository permissionRepository = applicationContext.getBean(PermissionRepository.class);

        List<Permission> allPermissions = permissionRepository.listar();

        for (Permission permission : allPermissions) {
            System.out.printf("%s - %s\n", permission.getNome(), permission.getDescricao());
        }
    }
}
