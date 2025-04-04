package projeto.vb;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ArduinoSerialReader {
    public static void main(String[] args) {
        // Definir a porta onde o Arduino está conectado (ajuste conforme necessário)
        SerialPort arduinoPort = SerialPort.getCommPort("COM3"); // Altere para a porta correta no seu sistema

        // Configurar a comunicação serial
        arduinoPort.setBaudRate(9600); // Mesmo baud rate do código Arduino
        arduinoPort.setNumDataBits(8); // 8 bits de dados
        arduinoPort.setNumStopBits(1); // 1 bit de parada
        arduinoPort.setParity(SerialPort.NO_PARITY); // Sem paridade

        // Tentar abrir a porta serial
        if (!arduinoPort.openPort()) {
            System.out.println("Erro ao abrir a porta serial.");
            return;
        }

        System.out.println("✅ Conectado ao Arduino!");

        // Criar um scanner para ler os dados recebidos pela porta serial
        Scanner scanner = new Scanner(arduinoPort.getInputStream());

        // Loop infinito para ler os dados continuamente
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine(); // Ler uma linha de dados da serial
            processarMensagem(data); // Chamar a função para analisar os dados recebidos
        }

        // Nunca será atingido, pois o loop é infinito, mas deixamos por boas práticas
        scanner.close();
        arduinoPort.closePort();
    }

    /**
     * Método responsável por processar os dados recebidos do Arduino e exibir
     * mensagens personalizadas de acordo com os valores dos sensores.
     */
    private static void processarMensagem(String data) {
        // Verifica se a mensagem contém informações sobre umidade do solo
        if (data.contains("Umidade do Solo")) {
            if (data.contains("Solo Seco")) {
                System.out.println("⚠️ O solo está muito seco, ligar sistema de irrigação por 10 minutos!");
            } else if (data.contains("Solo Úmido")) {
                System.out.println("✅ O solo está em boas condições.");
            } else {
                System.out.println("🚨 O solo está encharcado, verificar sistema de drenagem.");
            }
        }
        // Verifica se a mensagem contém informações sobre temperatura
        else if (data.contains("Temperatura")) {
            if (data.contains("Temperatura Alta")) {
                System.out.println("🔥 Está calor, ligar ar-condicionado por 5 minutos.");
            } else if (data.contains("Temperatura Baixa")) {
                System.out.println("❄️ Está frio, considerar ligar aquecimento.");
            } else {
                System.out.println("🌡️ Temperatura estável.");
            }
        }
        // Verifica se a mensagem contém informações sobre movimento
        else if (data.contains("Movimento")) {
            if (data.contains("Movimento Detectado")) {
                System.out.println("🚶 Movimento detectado, ligar luzes por 10 segundos.");
            } else {
                System.out.println("🌙 Sem movimento, luzes desligadas.");
            }
        }
    }
}
