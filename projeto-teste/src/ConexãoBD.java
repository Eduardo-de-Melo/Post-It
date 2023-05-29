import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Label;

public class ConexãoBD {
    private String url;
    private String usuario;
    private String senha;
    private Connection con;
    private Label status;

    public ConexãoBD(Label status) {
        this.url = "jdbc:postgresql://localhost:5432/Post-It";
        usuario = "postgres";
        senha = "1234";
        this.status = status;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão Realizada com sucesso");
        } catch (Exception e) {
            System.out.println("Problema na conexão com banco de dados!");
            //status.setText("Problema na conexão com banco de dados");
        }
    }

    private int executaSQL(String sql) {
        try {
            Statement stm = con.createStatement();
            int res = stm.executeUpdate(sql);
            con.close();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            //status.setText("Problema na conexão com banco de dados");
            return 0;
        }
    }

    public void inserirAtividadeBD(Atividade atividade) {
        String sql = "INSERT INTO atividades (titulo, descricao, data_inicio, data_fim)" + " values ('"
                + atividade.getTitulo() + "','" + atividade.getDescricao() + "','"+atividade.getDataInicio()+"','"+atividade.getDataFim()+"');";

                System.out.println(sql);
                int res = executaSQL(sql);
                if(res>0){
                    System.out.println("Atividade inserida com sucesso!");
                    //status.setText(Atividade inserida com sucesso!);
                }
    }

}
