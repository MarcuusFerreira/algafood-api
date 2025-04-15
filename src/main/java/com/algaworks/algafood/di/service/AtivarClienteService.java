//package com.algaworks.algafood.di.service;
//
//import com.algaworks.algafood.di.modelo.Cliente;
//import com.algaworks.algafood.di.notificacao.NivelUrgencia;
//import com.algaworks.algafood.di.notificacao.Notificador;
//import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//
//@Component
//public class AtivarClienteService implements InitializingBean, DisposableBean { // Bean inicializacoa, Bean destruicao
//
//    @Autowired
//    private ApplicationEventPublisher eventPublisher;
//
//    public void ativarCliente(Cliente cliente) {
//        cliente.ativar();
//        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
//    }
//
//    @PostConstruct // Cria obj
//    public void init() {
//        System.out.println("INIT");
//    }
//
////    @PreDestroy - Destroy
//    public void destroy() {
//        System.out.println("DESTROY");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet");
//    }
//}
