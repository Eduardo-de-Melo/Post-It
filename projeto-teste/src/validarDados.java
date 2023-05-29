import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.Label;

public class validarDados {

    public validarDados() {
    }

    public boolean dadosValidos(String titulo, LocalDate dataInicio, LocalDate dataFim, String descricao,
            Label status) {

        if ((!verificarLocalDateVazio(dataFim, status) && !verificarLocalDateVazio(dataInicio, status)) ) {
            if (dataInicioAntesDataFim(dataInicio, dataFim, status) && !verificarCampoStringVazio(titulo, status) && stringTamanho(titulo, 250, status)){
                return true;
            }
        }

        return false;
    }

    private boolean verificarCampoStringVazio(String str, Label status) {
        if (str == null || str.equals("")) {
            status.setText("Insira um titulo");
            return true;
        } else
            return false;
    }

    private boolean verificarLocalDateVazio(LocalDate date, Label status) {
        if (date == null) {
            status.setText("Insira todos os campos corretamente");
            return true;
        } else
            return false;
    }

    private boolean dataInicioAntesDataFim(LocalDate dataInicio, LocalDate dataFim, Label status) {
        if (dataInicio.isBefore(dataFim)) {
            return true;
        } else {
            status.setText("A data de início é posterior à data de fim.");
            return false;
        }
    }

    private boolean stringTamanho(String str, int length, Label status) {
        if (str.length() < length) {
            return true;
        } else {
            status.setText("Os campos extrapolam o limite de caracteres");
            return false;
        }
    }
}
