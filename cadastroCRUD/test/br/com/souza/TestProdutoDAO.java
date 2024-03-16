package br.com.souza;

import br.com.souza.Dao.ProdutoDAO;
import br.com.souza.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

public class TestProdutoDAO {

    @Test
    public void testAlterarDados(){
        ProdutoDAO pd = new ProdutoDAO();

        Produto p = new Produto();
        p.setNome("Camisza");
        p.setCod(414L);

        Produto p2 = new Produto();
        p2.setNome("Camisa");
        p.setCod(414L);

        pd.alterarDados(p2, p);

        Assert.assertEquals(p.getNome(), p2.getNome());

    }
}
