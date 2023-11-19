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

public class PessoaJuridicaRepo {
   private final List<PessoaJuridica> listaPessoasJuridicas = new ArrayList();

   public PessoaJuridicaRepo() {
   }

   public void inserir(PessoaJuridica pessoaJuridica) {
      this.listaPessoasJuridicas.add(pessoaJuridica);
   }

   public void alterar(PessoaJuridica pessoaJuridica) {
      for(int i = 0; i < this.listaPessoasJuridicas.size(); ++i) {
         if (pessoaJuridica.getId() == ((PessoaJuridica)this.listaPessoasJuridicas.get(i)).getId()) {
            this.listaPessoasJuridicas.set(i, pessoaJuridica);
            return;
         }
      }

   }

   public void excluir(int id) {
      for(int i = 0; i < this.listaPessoasJuridicas.size(); ++i) {
         if (((PessoaJuridica)this.listaPessoasJuridicas.get(i)).getId() == id) {
            this.listaPessoasJuridicas.remove(i);
            return;
         }
      }

   }

   public PessoaJuridica obter(int id) {
      Iterator var2 = this.listaPessoasJuridicas.iterator();

      PessoaJuridica pessoaJuridica;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         pessoaJuridica = (PessoaJuridica)var2.next();
      } while(pessoaJuridica.getId() != id);

      return pessoaJuridica;
   }

   public List<PessoaJuridica> obterTodos() {
      return this.listaPessoasJuridicas;
   }

   public void persistir(String nomeArquivo) throws IOException {
      try {
         ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo));

         try {
            outputStream.writeObject(this.listaPessoasJuridicas);
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
            this.listaPessoasJuridicas.clear();
            List<PessoaJuridica> listaRecuperada = (List)inputStream.readObject();
            this.listaPessoasJuridicas.addAll(listaRecuperada);
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
