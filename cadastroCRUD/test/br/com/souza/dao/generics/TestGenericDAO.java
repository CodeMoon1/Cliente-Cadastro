package br.com.souza.dao.generics;

import br.com.souza.Dao.ClienteDAO;
import br.com.souza.Dao.IClienteDAO;

import br.com.souza.Dao.IProdutoDAO;
import br.com.souza.Dao.ProdutoDAO;
import br.com.souza.domain.Cliente;
import br.com.souza.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

public class TestGenericDAO {

    @Test
    public void testCadastrar(){
        Cliente c2 = new Cliente();
        c2.setNome("Homer Simpson");
        c2.setCpf(12345678L);
        c2.setTel("44353453462");
        c2.setNumero("17");
        c2.setCidade("Springfield");
        c2.setEstado("LA");

        IClienteDAO cd = new ClienteDAO();
        Boolean t = cd.cadastrar(c2);
        Assert.assertTrue(t);

        Cliente c = new Cliente();
        c.setNome("Sonic");
        c.setCpf(12345678L);
        c.setTel("89123789");
        c.setNumero("17");
        c.setCidade("mobotropolis");
        c.setEstado("seiNão");
        boolean v = cd.cadastrar(c);
        Assert.assertTrue(!v);

        IProdutoDAO pd = new ProdutoDAO();
        Produto p = new Produto();
        p.setNome("Camisa Verde");
        p.setCod(777L);
        Boolean pValue = pd.cadastrar(p);
        Assert.assertTrue(pValue);

        Produto p2 = new Produto();
        p2.setNome("Camisa Azul");
        p2.setCod(777L);
        Boolean p2Value = pd.cadastrar(p2);
        Assert.assertTrue(!p2Value);
    }

    @Test(expected = NullPointerException.class)
    public void testExcluir(){
        ClienteDAO cd = new ClienteDAO();

        Cliente c = new Cliente();
        c.setNome("Sonic");
        c.setCpf(12345678L);
        c.setTel("89123789");
        c.setNumero("17");
        c.setCidade("mobotropolis");
        c.setEstado("seiNão");
        //cadastra um Cliente
        cd.cadastrar(c);
        //Busca o Cliente Cadastrado
        Cliente consultado = cd.consultar(c.getCodigo());

        //Exclusão do Cliente Cadastrado
        cd.excluir(consultado.getCodigo());

        //consulta do cliente deletado
        Cliente consultadoDepoisExclusao = cd.consultar(consultado.getCodigo());

        //exception NullPointerException
        Assert.assertNull(consultadoDepoisExclusao.getCodigo());
    }


    @Test
    public void testConsultar(){
        IClienteDAO cd = new ClienteDAO();

        Cliente c2 = new Cliente();
        c2.setNome("Homer Simpson");
        c2.setCpf(12345678L);
        c2.setTel("44353453462");
        c2.setNumero("17");
        c2.setCidade("Springfield");
        c2.setEstado("LA");

        Boolean t = cd.cadastrar(c2);
        Assert.assertTrue(t);

        Cliente consultado = cd.consultar(c2.getCodigo());
        Assert.assertEquals(consultado, c2);

        IProdutoDAO pd = new ProdutoDAO();
        Produto p = new Produto();
        p.setNome("Camisa Verde");
        p.setCod(777L);
        Boolean pValue = pd.cadastrar(p);
        Assert.assertTrue(pValue);

        Produto pConsultado = pd.consultar(p.getCodigo());
        Assert.assertEquals(pConsultado, p);
    }

    @Test
    public void testBuscarTodos(){
        IClienteDAO cd = new ClienteDAO();

        Cliente c = new Cliente();
        c.setNome("Sonic");
        c.setCpf(3123123L);
        c.setTel("89123789");
        c.setNumero("17");
        c.setCidade("mobotropolis");
        c.setEstado("Zone1");
        cd.cadastrar(c);

        Cliente c2 = new Cliente();
        c2.setNome("Homer Simpson");
        c2.setCpf(12345678L);
        c2.setTel("44353453462");
        c2.setNumero("12");
        c2.setCidade("Springfield");
        c2.setEstado("LA");
        cd.cadastrar(c2);

        Cliente c3 = new Cliente();
        c3.setNome("Tails");
        c3.setCpf(114551324L);
        c3.setTel("23131241231");
        c3.setNumero("13");
        c3.setCidade("Station Square");
        c3.setEstado("Zone");
        cd.cadastrar(c3);

        int qtd = cd.buscarTodos().size();
        Assert.assertNotNull(qtd);
        Assert.assertTrue(qtd == 3);
    }

}
