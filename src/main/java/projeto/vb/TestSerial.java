package projeto.vb;

import com.fazecast.jSerialComm.SerialPort;

public class TestSerial {
    public static void main(String[] args) {
        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("🔌 Portas seriais disponíveis:");
        for (SerialPort port : ports) {
            System.out.println("👉 " + port.getSystemPortName());
        }
    }
}
