//package com.algaworks.algafood.di.notificacao;
//
//import com.algaworks.algafood.di.modelo.Cliente;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Component;
//
//@Profile("dev")
//@Component
//@TipoDoNotificador(NivelUrgencia.URGENTE)
//public class NotificadorEmailMock implements Notificador {
//
//
//    public void notificar(Cliente cliente, String mensagem) {
//
//        System.out.printf("MOCK: Notificacao seria enviada para %s através do e-mail %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
//    }
//
//}
