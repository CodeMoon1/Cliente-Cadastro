package br.com.souza.Dao;

import br.com.souza.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class TestClienteDAO {

    @Test
    public void testAlterarDadosCliente(){
        ClienteDAO cd = new ClienteDAO();

        Cliente c = new Cliente();
        c.setNome("Sonic");
        c.setCpf(12345678L);
        c.setTel("89123789");
        c.setNumero("17");
        c.setCidade("mobotropolis");
        c.setEstado("seiNão");

        Cliente c2 = new Cliente();
        c2.setNome("Homer Simpson");
        c2.setCpf(12345678L);
        c2.setTel("44353453462");
        c2.setNumero("17");
        c2.setCidade("Springfield");
        c2.setEstado("LA");

       cd.alterarDados(c,c2);
       Assert.assertEquals(c2.getNome(),c.getNome());
       Assert.assertEquals(c2.getCpf(),c.getCpf());
       Assert.assertEquals(c2.getCidade(), "mobotropolis");
       Assert.assertEquals(c2.getEstado(), "seiNão");
    }

}
