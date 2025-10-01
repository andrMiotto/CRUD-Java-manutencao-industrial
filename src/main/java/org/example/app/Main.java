package org.example.app;


import org.example.dao.FornecedorDao;
import org.example.dao.MaterialDao;
import org.example.model.Fornecedor;
import org.example.model.Material;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {


        inicio();
    }


    public static void inicio() throws SQLException {
        boolean sair = false;

        System.out.println("=== SISTEMA DE MANUTENÇÃO INDUSTRIAL ===");
        System.out.println("1 - Cadastrar Fornecedor");
        System.out.println("2 - Cadastrar Material");
        System.out.println("3 - Registrar Nota de Entrada");
        System.out.println("4 - Criar Requisição de Material");
        System.out.println("5 - Atender Requisição");
        System.out.println("6 - Cancelar Requisição");
        System.out.println("0 - Sair");

        System.out.print("> ");

        int opcao = sc.nextInt();
        sc.nextLine();
        switch (opcao) {
            case 1: {
                cadastrarFornecedor();
                break;
            }
            case 2: {
                cadastrarMaterial();
                break;
            }

            case 3: {
                registrarNotaEntrada();
                break;
            }
            case 4: {
                criarRequisicaoMaterial();
                break;

            }
            case 5: {
                atenderRequisicao();
                break;
            }

            case 6: {
                cancelarRequisicao();
                break;
            }
        }

    }

    public static void cadastrarFornecedor() throws SQLException {
        System.out.println("=== CADASTRAR FORNECEDOR ===");

        var fornecedorDao = new FornecedorDao();

        System.out.println("Digite o nome do fornecedor: ");
        String nome = sc.nextLine();


        System.out.println("Digite o CNPJ do fornecedor: ");
        String cnpj = sc.nextLine();

        if (!nome.isEmpty() && !cnpj.isEmpty()) {
            var fornecedor = new Fornecedor(nome, cnpj);

            try {
                if (fornecedorDao.verificarDuplicidadeFornecedor(fornecedor)) {
                    fornecedorDao.cadastrarFornecedor(fornecedor);
                    System.out.println("Fornecedor cadastrado com sucesso!!!");

                } else {
                    System.out.println("Fornecedor já cadastrado!!!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("Nome do fornecdor ou cnpj não podem ser nulos!!!");

        }


    }

    public static void cadastrarMaterial() throws SQLException {
        System.out.println("=== CADASTRAR MATERIAL ===");

        var daoMaterial = new MaterialDao();

        System.out.println("Digite o nome do material: ");
        String nome = sc.nextLine();

        System.out.println("Digite a unidade de medida: ");
        String unidade = sc.nextLine();

        System.out.println("Digite o estoque do material: ");
        Double estoque = sc.nextDouble();

        if (!nome.isEmpty() && !unidade.isEmpty() && estoque > 0) {
            var material = new Material(nome, unidade, estoque);

            try {
                if (daoMaterial.verificarDuplicidadeMaterial(material)) {
                    daoMaterial.cadastrarMateriais(material);
                    System.out.println("Material cadastrado com sucesso!!!");

                } else {
                    System.out.println("Material já cadastrado");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else {
            System.out.println("Material já cadastrado");
        }


    }

    public static void registrarNotaEntrada() throws SQLException {
        System.out.println("REGISTRAR NOTA DE ENTRADA");

        var fornecedorDao = new FornecedorDao();
        List<Fornecedor> listaFornecedores = fornecedorDao.listarFornecedores();

        for(Fornecedor f: listaFornecedores){
            System.out.println("ID: "+f.getId() + "\n Nome: " + f.getNome() + "\n CNPJ: " + f.getCnpj());

        }

    }


    public static void criarRequisicaoMaterial() throws SQLException {
    }

    public static void atenderRequisicao() throws SQLException {
    }

    public static void cancelarRequisicao() throws SQLException {
    }


}