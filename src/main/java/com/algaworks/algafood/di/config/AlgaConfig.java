//package com.algaworks.algafood;
//
//import com.algaworks.algafood.di.notificacao.NotificadorEmail;
//import com.algaworks.algafood.di.service.AtivarClienteService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AlgaConfig {
//
//    @Bean
//    public NotificadorEmail notificadorEmail() {
//        NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.algamail.com.br");
//        notificadorEmail.setCaixaAlta(true);
//        return notificadorEmail;
//    }
//
//    @Bean
//    public AtivarClienteService ativarClienteService() {
//        return new AtivarClienteService(notificadorEmail());
//    }
//
//}
