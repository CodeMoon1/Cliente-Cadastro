package br.com.souza.domain;

import java.util.Objects;

public class Produto implements Persistente {
    private String nome;
    private Long cod;

    public Produto(){
        super();
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    @Override
    public Long getCodigo() {
        return this.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return Objects.equals(getCod(), produto.getCod());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod());
    }
}
