package br.com.souza.Dao;


import br.com.souza.Dao.generics.TestGenericDAO;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestClienteDAO.class, TestProdutoDAO.class, TestGenericDAO.class})
public class AllTest {
}
