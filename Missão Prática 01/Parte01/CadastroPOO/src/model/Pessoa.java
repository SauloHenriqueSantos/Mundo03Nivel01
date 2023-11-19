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

public class Pessoa implements Serializable {
   private static final long serialVersionUID = 1L;
   private int id;
   private String nome;

   public Pessoa(int id, String nome) {
      this.id = id;
      this.nome = nome;
   }

   public int getId() {
      return this.id;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void exibir() {
      System.out.println("ID: " + this.id);
      System.out.println("Nome: " + this.nome);
   }
}
