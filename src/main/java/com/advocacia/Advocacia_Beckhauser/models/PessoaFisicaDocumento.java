package com.advocacia.Advocacia_Beckhauser.models;


/*
* Autor: Lucas Ronchi
* Última alteração: 19/11/2023 às 18:20
*
*
* Classe inacabada.
* Lança "AnnotationException: @OneToOne or @ManyToOne on com.advocacia.Advocacia_Beckhauser.models.PessoaFisicaDocumento.pessoaFisica references an unknown entity: com.advocacia.Advocacia_Beckhauser.models.PessoaFisica"
*
* Para usar esta classe, precisamos entender como modificar as MappedSuperClass Pessoa & PessoaFisica.
* A princípio, usaríamos uma lista de documentos na classe Pessoa, entretanto, para fazer isso, precisamos usar estratégias de Herança ou relacionar diretamente a classe Advogado & Cliente com Documento.
*
* Tentei criar uma classe que intermedia esta relação, mas acabei caindo no mesmo erro e retornei à estaca zero.
* */


/*@Entity
@Table(name = "pessoa_documento")*/
public class PessoaFisicaDocumento extends EntityID {
    /*@OneToOne
    @JoinColumn(name = "pessoa_fisica_id", referencedColumnName = "id")
    private PessoaFisica pessoaFisica;

    @ManyToOne
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private Documento documento;



    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }*/
}