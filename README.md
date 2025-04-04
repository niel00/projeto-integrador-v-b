# 📡 Monitoramento de Sensores com Arduino e Java

Este projeto realiza a leitura de sensores conectados a um **Arduino Uno** e transmite os dados via **porta serial** para um programa em **Java**, que processa as informações e exibe mensagens personalizadas.

## 📌 Funcionalidades

✅ Conecta-se automaticamente à porta serial do Arduino  
✅ Lê os valores dos sensores em tempo real  
✅ Processa as leituras e exibe mensagens personalizadas  
✅ Simula ações como ativação de ar-condicionado, irrigação e luzes  

---

## 🛠 Tecnologias Utilizadas

- **Arduino Uno**
- **Java 8+**
- **Biblioteca jSerialComm** para comunicação serial
- **Sensores utilizados:**
  - **Sensor de Temperatura (A0)**
  - **Sensor de Umidade do Solo (A1)**
  - **Sensor de Movimento PIR (A2)**
  - **LEDs indicativos (Pinos 2, 3 e 4)**

---

## 🔌 Esquema de Conexão

1. **Sensor de Temperatura** → Entrada analógica **A0**  
2. **Sensor de Umidade do Solo** → Entrada analógica **A1**  
3. **Sensor de Movimento PIR** → Entrada analógica **A2**  
4. **LEDs indicativos** → Pinos digitais **2, 3 e 4**  

