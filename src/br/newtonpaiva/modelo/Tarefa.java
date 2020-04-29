/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva.modelo;

//Ctrl + Shift + i

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta classe é responsável por mapear uma tarefa do sistema.
 * Essa tarefa pode ser gravada na base de dados, .......
 * 
 * @author Tarley Lana
 */
public class Tarefa {
    /* Atributos */
    private Integer id; // 10
    private String nome;
    private Integer prioridade;
    private Calendar dataLimite;
    private String situacao;
    private Integer percentual;
    private String descricao;

    public Tarefa() {
    }

    /**
     * Construtor de tarefa basica.
     * @param nome Este é o nome da tarefa.
     * @param prioridade Esta é a prioridade da tarefa
     */
    public Tarefa(String nome, Integer prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public Tarefa(Integer id, String nome, Integer prioridade, Calendar dataLimite, String situacao, Integer percentual, String descricao) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.dataLimite = dataLimite;
        this.situacao = situacao;
        this.percentual = percentual;
        this.descricao = descricao;
    }

    
    
    /**
     * Esse método grava na base de dados na tabela chamada tb_tarefa
     * um registro de tarefa.
     *
     */
    public void salvar() {
        // gravar no banco de dados
        System.out.println("Executou o salvar()");
        
        Path arquivo = Paths.get("c:/temp/tarefa.csv");
        String conteudo = this.nome + ";" + this.prioridade +
                ";" + this.situacao + ";" + this.percentual + 
                ";" + this.descricao + "\n";
        
        try { 
            Files.write(arquivo, conteudo.getBytes(),
                    StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            Logger.getLogger(Tarefa.class.getName()).log(Level.SEVERE, null, ex);
        }

   
    }
    
    public void excluir() {
        // excluir no banco de dados
        System.out.println("Executou o excluir");
    }
    
    public Tarefa[] listar() {
        // Buscar do banco de dados as tarefas
        System.out.println("Executou o listar");
        
        return null;
    }
    
    public Tarefa[] listar(String filtro) {
        // Buscar do banco de dados as tarefas
        System.out.println("Executou o listar");
        
        return null;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the prioridade
     */
    public Integer getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the dataLimite
     */
    public Calendar getDataLimite() {
        return dataLimite;
    }

    /**
     * @param dataLimite the dataLimite to set
     */
    public void setDataLimite(Calendar dataLimite) {
        this.dataLimite = dataLimite;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the percentual
     */
    public Integer getPercentual() {
        return percentual;
    }

    /**
     * @param percentual the percentual to set
     */
    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "id=" + id + ", nome=" + nome + ", prioridade=" + prioridade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarefa other = (Tarefa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
 
        return true;
    }
}
