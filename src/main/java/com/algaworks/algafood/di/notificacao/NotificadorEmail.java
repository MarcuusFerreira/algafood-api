//package com.algaworks.algafood.di.notificacao;
//
//import com.algaworks.algafood.di.modelo.Cliente;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//
////@Profile("prod")
//@Component
//@TipoDoNotificador(NivelUrgencia.URGENTE)
//public class NotificadorEmail implements Notificador {
//
////    @Value("${notificador.email.host-servidor}")
////    private String host;
////
////    @Value("${notificador.email.porta-servidor}")
////    private Integer port;
//
//    @Autowired
//    private NotificadorProperties notificadorProperties;
//
//    public void notificar(Cliente cliente, String mensagem) {
//        System.out.printf("Host: %s\n", notificadorProperties.getHostServidor());
//        System.out.printf("Port: %s\n", notificadorProperties.getPortaServidor());
//        System.out.printf("Notificando %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
//    }
//
//}
