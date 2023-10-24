package Models.Pessoa;

public class Juridica extends Pessoa {
    private String cnpj;
    private String tipoEmpresa;

    public Juridica(String cnpj, String tipoEmpresa) {
        this.cnpj = cnpj;
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }
}