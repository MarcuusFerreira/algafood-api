//package com.algaworks.algafood.di.listener;
//
//import com.algaworks.algafood.di.notificacao.NivelUrgencia;
//import com.algaworks.algafood.di.notificacao.Notificador;
//import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
//import com.algaworks.algafood.di.service.ClienteAtivadoEvent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class NotificacaoService {
//
//    @Autowired
//    @TipoDoNotificador(NivelUrgencia.URGENTE)
//    private Notificador notificador;
//
//    @EventListener
//    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
//        System.out.println("Cliente ativo: " + event.getCliente().getNome());
//        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo");
//    }
//}
