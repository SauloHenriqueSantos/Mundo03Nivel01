/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Saulo Henrique
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PessoaFisicaRepo {
   private final List<PessoaFisica> listaPessoasFisicas = new ArrayList();

   public PessoaFisicaRepo() {
   }

   public void inserir(PessoaFisica pessoaFisica) {
      this.listaPessoasFisicas.add(pessoaFisica);
   }

   public void alterar(PessoaFisica pessoaFisica) {
      for(int i = 0; i < this.listaPessoasFisicas.size(); ++i) {
         if (pessoaFisica.getId() == ((PessoaFisica)this.listaPessoasFisicas.get(i)).getId()) {
            this.listaPessoasFisicas.set(i, pessoaFisica);
            return;
         }
      }

   }

   public void excluir(int id) {
      for(int i = 0; i < this.listaPessoasFisicas.size(); ++i) {
         if (((PessoaFisica)this.listaPessoasFisicas.get(i)).getId() == id) {
            this.listaPessoasFisicas.remove(i);
            return;
         }
      }

   }

   public PessoaFisica obter(int id) {
      Iterator var2 = this.listaPessoasFisicas.iterator();

      PessoaFisica pessoaFisica;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         pessoaFisica = (PessoaFisica)var2.next();
      } while(pessoaFisica.getId() != id);

      return pessoaFisica;
   }

   public List<PessoaFisica> obterTodos() {
      return this.listaPessoasFisicas;
   }

   public void persistir(String nomeArquivo) throws IOException {
      try {
         ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo));

         try {
            outputStream.writeObject(this.listaPessoasFisicas);
         } catch (Throwable var6) {
            try {
               outputStream.close();
            } catch (Throwable var5) {
               var6.addSuppressed(var5);
            }

            throw var6;
         }

         outputStream.close();
      } catch (IOException var7) {
         throw var7;
      }
   }

   public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
      try {
         ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo));

         try {
            this.listaPessoasFisicas.clear();
            List<PessoaFisica> listaRecuperada = (List)inputStream.readObject();
            this.listaPessoasFisicas.addAll(listaRecuperada);
         } catch (Throwable var6) {
            try {
               inputStream.close();
            } catch (Throwable var5) {
               var6.addSuppressed(var5);
            }

            throw var6;
         }

         inputStream.close();
      } catch (ClassNotFoundException | IOException var7) {
         throw var7;
      }
   }
}
