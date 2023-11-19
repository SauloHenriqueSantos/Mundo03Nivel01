/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;


import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main {
    public static void main(String[] args) throws Exception {

        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

        PessoaFisica pessoa1 = new PessoaFisica(1, "theodoro henrique", "361.178.888-05", 03);
        PessoaFisica pessoa2 = new PessoaFisica(2, "Lais farias", "154.255.111-05", 31);
        repo1.inserir(pessoa1);
        repo1.inserir(pessoa2);

        repo1.persistir("arquivo-pf1");

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

        repo2.recuperar("arquivo-pf1");

        for (PessoaFisica pessoa : repo2.obterTodos()) {
            System.out.println("ID: " + pessoa.getId());
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("CPF: " + pessoa.getCpf());
            System.out.println("Idade: " + pessoa.getIdade());
            System.out.println();
        }

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(1, "LL Motos", "6698371900001-10");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(2, "caçamba lTDA", "628957550001-20");
        repo3.inserir(pessoaJuridica1);
        repo3.inserir(pessoaJuridica2);

        repo3.persistir("arquivo-pj1");

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

        repo4.recuperar("arquivo-pj1");

        for (PessoaJuridica pessoaJuridica : repo4.obterTodos()) {
            System.out.println("Nome: " + pessoaJuridica.getNome());
            System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
            System.out.println();
        }
    }
}
