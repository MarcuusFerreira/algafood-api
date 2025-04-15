//package com.algaworks.algafood.di.jpa.restaurante;
//
//import com.algaworks.algafood.AlgafoodApiApplication;
//import com.algaworks.algafood.domain.model.Restaurante;
//import com.algaworks.algafood.domain.repository.RestauranteRepository;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ApplicationContext;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class RestaurantesMain {
//
//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
//
//        Restaurante restaurante1 = new Restaurante();
//        Restaurante restaurante2 = new Restaurante();
//        restaurante1.setNome("Mequi");
//        restaurante1.setTaxaFrete(BigDecimal.valueOf(5.99));
//        restaurante1.setAtivo(true);
//        restaurante1.setAberto(true);
//        restaurante1.setDataCadastro(LocalDateTime.now());
//
//        restaurante2.setNome("Subway");
//        restaurante2.setTaxaFrete(BigDecimal.valueOf(5.99));
//        restaurante2.setAtivo(true);
//        restaurante2.setAberto(true);
//        restaurante2.setDataCadastro(LocalDateTime.now());
//
//        restaurante1 = restauranteRepository.salvar(restaurante1);
//        restaurante2 = restauranteRepository.salvar(restaurante2);
//
//        System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
//        System.out.printf("%d - %s\n", restaurante2.getId(), restaurante2.getNome());
//
//        List<Restaurante> restaurantes = restauranteRepository.listar();
//        restaurantes.forEach(r -> System.out.printf("%d - %s\n", r.getId(), r.getNome()));
//
//        restaurante1.setNome("Mc Donalds - Campinas");
//        restaurante1 = restauranteRepository.salvar(restaurante1);
//
//        System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
//
//        Restaurante restauranteBuscado = restauranteRepository.buscar(1L);
//
//        System.out.printf("%d - %s\n", restaurante1.getId(), restauranteBuscado.getNome());
//
//        restauranteRepository.remover(restauranteBuscado);
//
//        restaurantes = restauranteRepository.listar();
//        restaurantes.forEach(r -> System.out.printf("%d - %s\n", r.getId(), r.getNome()));
//
//    }
//}
