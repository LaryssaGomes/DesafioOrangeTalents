package com.orangetalents.api.feign;

import java.util.List;

public class VehicleModel {

	private List<Model> modelos;

    public VehicleModel() {
    }

    public VehicleModel(List<Model> modelos) {
        this.modelos = modelos;
    }

    public List<Model> getModelos() {
        return modelos;
    }

    public void setModelos(List<Model> modelos) {
        this.modelos = modelos;
    }

     public static class Model {
        private String nome;
        private Integer codigo;

        public Model() {
        }

        public Model(String nome, Integer codigo) {
            this.nome = nome;
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }


    }

}
