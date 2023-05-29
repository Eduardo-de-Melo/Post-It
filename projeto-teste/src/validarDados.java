import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class validarDados {

    public boolean dadosValidos() {

        // if(!campoVazio(string), compararDatas(), stringTamanho()){}

        return true;

        // else false
    }

    private boolean campoVazio(String str) {
        if(str == null)
        return true;
        else return false;
    }

    private boolean compararDatas(String dataInicioStr, String dataFimStr) {

        LocalDate dataInicio = LocalDate.parse(dataInicioStr, DateTimeFormatter.ISO_DATE);
        LocalDate dataFim = LocalDate.parse(dataFimStr, DateTimeFormatter.ISO_DATE);

        if (dataInicio.isBefore(dataFim)) {
            System.out.println("A data de início é anterior à data de fim.");
            return true;
        } else {
            System.out.println("A data de início é posterior à data de fim.");
            return false;
        }

    }

    private boolean stringTamanho(String str, int length){
        if (str.length() < length) {
            return true;
        } else {
            return false;
        }
    }

}
