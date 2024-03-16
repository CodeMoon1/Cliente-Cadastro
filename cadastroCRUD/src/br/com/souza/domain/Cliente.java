package br.com.souza.domain;
public class Cliente implements Persistente{

    private String nome;
    private Long cpf;
    private Long tel;
    private String endereco;
    private Integer numero;
    private String cidade;
    private String estado;
    public Cliente(){
        super();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setCpf(Long cpf){
        this.cpf = cpf;
    }

    public String getTel() {
        return String.valueOf(this.tel);
    }

    public void setTel(String tel) {
        this.tel = Long.valueOf(tel.trim());
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return String.valueOf(this.numero);
    }

    public void setNumero(String numero) {
        this.numero = Integer.valueOf(numero.trim());
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Nome Cliente: " + this.nome + " CPF: " + this.cpf + " Endereço: "+this.endereco;
    }

    @Override
    public Long getCodigo() {
        return this.getCpf();
    }
}
