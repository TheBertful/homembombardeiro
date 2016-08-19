
package Conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Servidor {

    static int porta;

    public static void main(String[] args) {
        
        porta = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a porta em que"
                + " o servidor vai escutar", "7000"));        
        ServerSocket serv = null;        
        Socket s = null;        
        BufferedReader entrada = null;
        try {            
            serv = new ServerSocket(porta);
            System.out.println("Servidor escutando na porta " + porta + "...");
            s = serv.accept();            
            entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            aguarda por algum dado e imprime a linha recebida
            String dados = entrada.readLine();
            while (dados.indexOf("sair") == -1) {
                if (dados != null) {
                    System.out.println(">> Mensagem: " + dados);
                    //  exibe a mensagem recebida pelo client
                    JOptionPane.showMessageDialog(null, dados, "Servidor - Mensagem recebida", JOptionPane.WARNING_MESSAGE);
                }                
                s.close();                
                s = serv.accept();
                //BufferedReader para o canal da stream de entrada de dados do socket s
                entrada = new BufferedReader(new InputStreamReader(s.getInputStream()));
                //Aguarda por algum dado e imprime a linha recebida
                dados = entrada.readLine();
            }
        } catch (IOException e) {
            //Imprime uma notificação na saída padrão caso haja algo errado.
            e.printStackTrace();
        } finally {
            try {
                //Encerra o socket de comunicação
                s.close();
                //Encerra o ServerSocket
                serv.close();
            } catch (IOException e) {
                //Imprime uma notificação na saída padrão caso haja algo errado.
                e.printStackTrace();
            }
        }
    }
}
