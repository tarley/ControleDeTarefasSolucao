/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva.modelo;

//Ctrl + Shift + i

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Tarley
 */
public class Tarefa {
    /* Atributos */
    private Integer id; // 10
    private String nome;
    private Integer prioridade;
    private Calendar dataLimite;
    private Date data;
    private String situacao;
    private Integer percentual;
    private String descricao;
    
     /* Métodos */
    void salvar() {
        // gravar no banco de dados
        System.out.println("Executou o salvar()");
    }
    
    void excluir() {
        // excluir no banco de dados
        System.out.println("Executou o excluir");
    }
    
    Tarefa[] listar() {
        // Buscar do banco de dados as tarefas
        System.out.println("Executou o listar");
        
        return null;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Integer id)  {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return this.nome;
    }
 
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
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
}
