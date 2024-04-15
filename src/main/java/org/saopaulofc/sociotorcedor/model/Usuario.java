package org.saopaulofc.sociotorcedor.model;
import jakarta.persistence.*;
import org.saopaulofc.sociotorcedor.model.constantes.Assinatura;
@Entity(name = "tb_users")
public class Usuario {
    @Column(nullable = false)
    String nome;
    @Id
    @Column(nullable = false)
    String cpf;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    int senha;
    @OneToOne(fetch = FetchType.EAGER)
    Endereco endereco;
    Assinatura assinatura;

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Usuario setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getSenha() {
        return senha;
    }

    public Usuario setSenha(int senha) {
        this.senha = senha;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Usuario setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public Usuario setAssinatura(Assinatura assinatura) {
        this.assinatura = assinatura;
        return this;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                ", assinatura=" + assinatura +
                '}';
    }
}
