import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Atividade {
    private String titulo;
    private String dataInicio;
    private String dataFim;
    private String descricao;

    public Atividade(String titulo, LocalDate dataInicio, LocalDate dataFim, String descricao) {
        this.titulo = titulo;
        this.dataInicio = transformDateInString(dataInicio);
        this.dataFim = transformDateInString(dataFim);
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    private String transformDateInString(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = data.format(formatter);

        return dateString;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    
}
