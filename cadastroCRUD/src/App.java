
import javax.swing.JOptionPane;

import Dao.ClienteMapDao;
import Dao.ClienteSetDao;
import Dao.IClienteDao;
import Dao.domain.Cliente;

public class App {
    private static IClienteDao iClienteDao;

    public static void main(String[] args) {
        iClienteDao = new ClienteMapDao();
        boolean op = true;

        while (op) {

            String valor = mostrarMsm();
            if (valor.equals("1")) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do Cliente separado por virgula, conforme exemplo: Nome,CPF, Telefone, Endereco, numero, cidade, estado",
                        "Área de Cadastro", JOptionPane.INFORMATION_MESSAGE);

                cadastrar(dados);
            } else if (valor.equals("2")) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF.", "Consultar",
                        JOptionPane.INFORMATION_MESSAGE);

                consultar(dados);
            } else if (valor.equals("3")) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF.", "Exluir",
                        JOptionPane.INFORMATION_MESSAGE);

                excluir(dados);
            } else if (valor.equals("4")) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do Cliente separado por virgula, conforme exemplo: Nome,"
                                + "CPF, Telefone, Endereco, numero, cidade, estado",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);

                alterar(dados);
            } else {
                sair();
            }
        }
    }

    private static String mostrarMsm() {
        String valor;
        do {
            valor = JOptionPane.showInputDialog(null,
                    "1-Cadastrar\n2-Consultar\n3-Exclusão\n4-Alteração\n5-Sair/Fechar",
                    "Bem-Vindo", JOptionPane.INFORMATION_MESSAGE);
            if (valor == null) {
                sair();
            }
        } while (!valor.equals("1") && !valor.equals("2") && !valor.equals("3") && !valor.equals("4")
                && !valor.equals("5"));

        return valor;
    }

    private static void cadastrar(String dados) {
        String dadosSplit[];
        dadosSplit = dados.split(",");
        Cliente cliente;

        // Precisa das virgulas para funcionar
        for (int i = 0; i < dadosSplit.length; i++) {
            if (dadosSplit[i].isEmpty()) {
                dadosSplit[i] = null;
            }
        }

        cliente = new Cliente(dadosSplit[0], dadosSplit[1], dadosSplit[2], dadosSplit[3], dadosSplit[4],
                dadosSplit[5], dadosSplit[6]);

        boolean isCadstrar = iClienteDao.cadastrar(cliente);
        if (isCadstrar) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso! ", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado! ", "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDao.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Cliente não encontrado: ", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void excluir(String dados) {
        iClienteDao.excluir(Long.parseLong(dados));
    }

    private static void alterar(String dados) {
        String atualizar[] = dados.split(",");

        // Precisa das virgulas para funcionar
        for (int i = 0; i < atualizar.length; i++) {
            if (atualizar[i].isEmpty()) {
                atualizar[i] = null;
            }
        }
        Cliente cliente = new Cliente(atualizar[0], atualizar[1], atualizar[2], atualizar[3], atualizar[4],
                atualizar[5], atualizar[6]);

        iClienteDao.alterar(cliente);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até", "Finalizado", 0);
        System.exit(0);
    }
}
