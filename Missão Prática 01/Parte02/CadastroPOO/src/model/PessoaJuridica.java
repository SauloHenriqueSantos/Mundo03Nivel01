/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Saulo Henrique
 */
import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
   private static final long serialVersionUID = 1L;
   private String cnpj;

   public PessoaJuridica(int id, String nome, String cnpj) {
      super(id, nome);
      this.cnpj = cnpj;
   }

   public String getCnpj() {
      return this.cnpj;
   }

   public void setCnpj(String cnpj) {
      this.cnpj = cnpj;
   }

   public void exibir() {
      System.out.println("CNPJ: " + this.cnpj);
   }
}
