package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    private final PapelMoeda[] papeisMoeda;
    private final int[] notas = {100, 50, 20, 10, 5, 2};

    public Troco(int valor) {

        papeisMoeda = new PapelMoeda[6];
        papeisMoeda[5] = new PapelMoeda(2, 0);
        papeisMoeda[4] = new PapelMoeda(5, 0);
        papeisMoeda[3] = new PapelMoeda(10, 0);
        papeisMoeda[2] = new PapelMoeda(20, 0);
        papeisMoeda[1] = new PapelMoeda(50, 0);
        papeisMoeda[0] = new PapelMoeda(100, 0);

        int count = 0;
        int i = 0;
        int qtd = 0;

        while (valor != 0) {
            if (valor >= notas[i]) {
                valor = valor - notas[i];
                papeisMoeda[i] = new PapelMoeda(notas[i], ++qtd);
            } else if (i < 5) {
                i++;
                qtd = 0;
            }
        }
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    public class TrocoIterator implements Iterator<PapelMoeda> {

        int posicao = 0;
        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            return !(posicao >= troco.papeisMoeda.length || troco.papeisMoeda[posicao] == null);
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda papelMoeda = papeisMoeda[posicao];
            posicao++;
            return papelMoeda;
        }

        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Não é possível remover!");
        }
    }
}