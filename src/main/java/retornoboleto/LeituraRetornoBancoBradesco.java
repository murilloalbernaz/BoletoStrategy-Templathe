/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author murillo
 */
public class LeituraRetornoBancoBradesco implements LeituraRetorno {

    /*@Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    @Override
    public Boleto processarLinhaArquivo(String[] vetorLinhaArq) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        boleto.setAgencia(vetorLinhaArq[2]);
        boleto.setContaBancaria(vetorLinhaArq[3]);

        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[4], FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.parse(vetorLinhaArq[5], FORMATO_DATA_HORA));

        boleto.setCpfCliente(vetorLinhaArq[6].replaceAll("-", ""));
        boleto.setValor(Double.parseDouble(vetorLinhaArq[7]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[8]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[9]));
        return boleto;
    }
;

}
