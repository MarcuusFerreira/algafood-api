//package com.algaworks.algafood.di.jpa.cozinha;
//
//import com.algaworks.algafood.AlgafoodApiApplication;
//import com.algaworks.algafood.domain.model.Cozinha;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ApplicationContext;
//
//import java.util.List;
//
//public class ExclusaoCozinhaMain {
//
//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
//
//        Cozinha cozinha = new Cozinha();
//        cozinha.setId(1L);
//        cozinha.setNome("Brasileira");
//        cadastroCozinha.remover(cozinha);
//
//        List<Cozinha> cozinhas = cadastroCozinha.listar();
//        cozinhas.forEach(c -> System.out.printf("%d - %s\n", c.getId(), c.getNome()));
//    }
//}
