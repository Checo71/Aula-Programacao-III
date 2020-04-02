package com.github.mayconmoraesdm.main;

import com.github.mayconmoraesdm.entidades.Contato;
import com.github.mayconmoraesdm.entidades.Entidade;

import java.sql.SQLException;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        try {
           insere();
//            altera();
//            exclui();

            listaTodos();
            lista(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listaTodos() throws SQLException {
        System.out.println("Lista Todos");
        Contato contato = new Contato();
        List<Contato> contatos = contato.busca();
        if (contatos.size() == 0) {
            System.out.printf("Nenhum contato na agenda!");
        } else {
            contatos.forEach(c -> System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s\nE-mail: %s\n" ,
                    c.getId(), c.getNome(), c.getTelefone(), c.getTelefone2(),c.getCelular(), c.getCelular2(), c.getEmail())));
        }
    }

    public static void lista(Integer id) {
        System.out.println("Lista um contato");
        Contato c = new Contato(id);
        System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s\nE-mail: %s\n",
                c.getId(), c.getNome(), c.getTelefone(), c.getCelular(), c.getEmail()));
    }

    public static void insere() {
        System.out.println("Inserindo contato");
        try {
            Contato contato = new Contato();
            contato.setNome("Maycon de Moraes");
            contato.setTelefone("32657845");
            contato.setTelefone2("32657847");
            contato.setCelular("98651278");
            contato.setCelular2("98651499");
            contato.insere();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void altera() {
        try {
            System.out.println("Alterando contato");
            Contato contato = new Contato(2);
            contato.setEmail("maycon@emailteste.com");
            contato.altera();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exclui() {
        try {
            System.out.println("Excluindo contato");
            Contato contato = new Contato(2);
            contato.exclui();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
