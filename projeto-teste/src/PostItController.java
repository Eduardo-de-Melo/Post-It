import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PostItController {

    @FXML
    private Button cancelar;

    @FXML
    private DatePicker data_fim;

    @FXML
    private DatePicker data_inicio;

    @FXML
    private TextArea descricao;

    @FXML
    private Button enviar;

    @FXML
    private Label status;

    @FXML
    private TextField titulo_tarefa;

    private ConexãoBD con;
    private validarDados vDados;

    public PostItController() {
        this.con = new ConexãoBD();
        this.vDados = new validarDados();
    }

    @FXML
    void enviarAtividade(ActionEvent event) {

        if (vDados.dadosValidos(titulo_tarefa.getText(), data_inicio.getValue(), data_fim.getValue(),
                descricao.getText(), status)) {
            Atividade atividade = new Atividade(titulo_tarefa.getText(), data_inicio.getValue(), data_fim.getValue(),
                    descricao.getText());
            con.inserirAtividadeBD(atividade, status);
        }

    }

    @FXML
    void cancelarEnvio(ActionEvent event) {
        titulo_tarefa.setText(null);
        descricao.setText(null);
        data_inicio.setValue(null);
        data_fim.setValue(null);
        descricao.setText(null);
    }

    public void setStatus(String atualStatus) {
        status.setText(atualStatus);
    }

}
