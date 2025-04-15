//package com.algaworks.algafood.di.controller;
//
//import com.algaworks.algafood.di.modelo.Cliente;
//import com.algaworks.algafood.di.service.AtivarClienteService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class MeuPrimeiroController {
//
//    private AtivarClienteService ativarClienteService;
//
//    public MeuPrimeiroController(AtivarClienteService ativarClienteService) {
//        this.ativarClienteService = ativarClienteService;
//    }
//
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        Cliente cliente = new Cliente("Marcus", "marcus@xyz.com", "48996849722");
//        this.ativarClienteService.ativarCliente(cliente);
//        return "Olá!";
//    }
//
//}
