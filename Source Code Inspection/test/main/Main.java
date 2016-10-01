/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.atividade.ticketmachine.main;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre e Victor
 */
public class Main {

    public static void main(String[] args) {
        // Cria uma TicketMachine com o preço de R$ 10,00 para o ticket
        TicketMachine t = new TicketMachine(10);
        try {
            // Insere 35 reais
            t.inserir(5);
            t.inserir(10);
            t.inserir(20);
            // Mostra o saldo
            System.out.println("Saldo antes da compra: R$ " + t.getSaldo() + ",00");
            // Mostra o preço do ticket comprado e o saldo após a compra
            System.out.print(t.imprimir());
            // Obtém o Iterator que percorre o array de papeisMoedas
            Iterator<PapelMoeda> troco = t.getTroco();
            System.out.println("**Troco**");
            boolean hasChange = false;
            while (troco.hasNext()) {
                PapelMoeda papelMoeda = troco.next();
                // Exibe o PapelMoeda cuja quantidade é maior que 0
                if (papelMoeda.getQuantidade() > 0) {
                    hasChange = true;
                    System.out.println("Valor: R$ " + papelMoeda.getValor());
                    System.out.println("Quantidade: " + papelMoeda.getQuantidade());
                }
            }
            if (!hasChange) {
                System.out.println("Não teve troco!");
            }
        } catch (PapelMoedaInvalidaException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        } catch (SaldoInsuficienteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
}
