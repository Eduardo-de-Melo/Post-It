import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Label;

public class ConexãoBD {
    private String url;
    private String usuario;
    private String senha;
    private Connection con;

    public ConexãoBD() {
        this.url = "jdbc:postgresql://localhost:5432/Post-It";
        usuario = "postgres";
        senha = "1234";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão Realizada com sucesso");
        } catch (Exception e) {
            System.out.println("Problema na conexão com banco de dados!");
        }
    }

    private int executaSQL(String sql, Label status) {
        try {
            Statement stm = con.createStatement();
            int res = stm.executeUpdate(sql);
            con.close();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            status.setText("Ocorreu um erro ao inserir os dados!");
            return 0;
        }
    }

    public void inserirAtividadeBD(Atividade atividade, Label status) {
        String sql = "INSERT INTO atividade (titulo, descricao, data_inicio, data_fim)" + " values ('"
                + atividade.getTitulo() + "','" + atividade.getDescricao() + "','" + atividade.getDataInicio() + "','"
                + atividade.getDataFim() + "');";

        System.out.println(sql);
        int res = executaSQL(sql, status);
        if (res > 0) {
            System.out.println("Atividade inserida com sucesso!");
            status.setText("Atividade inserida com sucesso!");
        }
    }

}
