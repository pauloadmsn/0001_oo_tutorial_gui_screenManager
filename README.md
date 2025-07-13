Com certeza! Gerenciar múltiplas telas é uma parte essencial do desenvolvimento de aplicações JavaFX. Neste tutorial, vamos criar um gerenciador de telas simples com três telas diferentes, e cada tela terá botões para navegar entre elas.
 
Pré-requisitos
Certifique-se de ter o seguinte instalado e configurado, assim como no tutorial anterior:
•	IntelliJ IDEA
•	Java Development Kit (JDK 11+)
•	Scene Builder
 
1. Configurando o Projeto no IntelliJ IDEA
Vamos criar um novo projeto JavaFX, similar ao que fizemos para a calculadora.
1.	Abra o IntelliJ IDEA.
2.	Na tela de boas-vindas, selecione "New Project".
3.	No painel esquerdo, escolha "JavaFX".
4.	Configure o "Project SDK" para o seu JDK.
5.	Dê um nome ao projeto, por exemplo, "GerenciadorDeTelas".
6.	Clique em "Next" e, em seguida, "Finish".
O IntelliJ vai gerar a estrutura básica com HelloApplication.java e hello-view.fxml.
 
2. Criando os Arquivos FXML para Cada Tela
Precisaremos de três arquivos FXML, um para cada tela.
1.	No painel "Project" do IntelliJ, navegue até src/main/resources/com/example/gerenciadordetelas (ou o nome do seu pacote de recursos).
2.	Renomeie hello-view.fxml: Clique com o botão direito em hello-view.fxml e selecione "Refactor" > "Rename...". Renomeie para tela1.fxml.
3.	Crie tela2.fxml: Clique com o botão direito no mesmo diretório (com/example/gerenciadordetelas), selecione "New" > "FXML File". Digite tela2.fxml e pressione Enter.
4.	Crie tela3.fxml: Repita o passo anterior para criar tela3.fxml.
Agora você terá tela1.fxml, tela2.fxml e tela3.fxml na sua pasta de recursos.
 
3. Desenhando as Telas no Scene Builder
Vamos abrir cada arquivo FXML no Scene Builder e adicionar um rótulo de título e botões de navegação.
Configurações Comuns para Todas as Telas:
Para cada tela (tela1.fxml, tela2.fxml, tela3.fxml), siga estes passos:
1.	Abra o arquivo FXML no Scene Builder (botão direito no .fxml > Open in Scene Builder).
2.	Remova o conteúdo existente: No painel "Hierarchy", selecione o VBox e o Button e delete-os.
3.	Adicione um AnchorPane: No painel "Library", procure por "AnchorPane". Arraste-o para a área de design. Este será o layout raiz.
o	No painel "Properties", em "Layout", defina Pref Width e Pref Height para 600 e 400 respectivamente (ou o tamanho que preferir).
4.	Adicione um Label para o Título:
o	No painel "Library", procure por "Label". Arraste-o para o AnchorPane.
o	No painel "Properties", em "Text", mude o texto para, por exemplo, "Tela 1" (para tela1.fxml), "Tela 2"(para tela2.fxml) e "Tela 3" (para tela3.fxml).
o	Centralize o rótulo: No painel "Layout", defina as âncoras (AnchorPane.leftAnchor, AnchorPane.rightAnchor, AnchorPane.topAnchor) para centralizar o texto. Você pode colocar leftAnchor="0", rightAnchor="0" e topAnchor="20", e depois, em "Alignment", selecione "Center".
o	Aumente a fonte: No painel "Properties", em "Font", aumente o tamanho da fonte para algo como 24.
5.	Adicione um HBox para os Botões:
o	No painel "Library", procure por "HBox". Arraste-o para o AnchorPane.
o	No painel "Properties", em "Layout", defina as âncoras para posicionar o HBox na parte inferior e centralizá-lo: leftAnchor="0", rightAnchor="0", bottomAnchor="20".
o	Em "Alignment", selecione "Center".
o	Em "Spacing", defina para 10 para espaçar os botões.
6.	Adicione os Buttons:
o	Arraste três "Button" para dentro do HBox.
o	Para cada botão, no painel "Properties", em "Text", defina o texto para "Ir para Tela 1", "Ir para Tela 2" e "Ir para Tela 3" (dependendo da tela atual, você vai desabilitar o botão da tela atual ou não o adicionar).
o	Defina um fx:id para cada botão. Use btnTela1, btnTela2, btnTela3.
Configuração Específica para Cada Tela:
tela1.fxml:
•	Título do Label: "Tela 1"
•	Botões:
o	"Ir para Tela 2" (fx:id="btnTela2")
o	"Ir para Tela 3" (fx:id="btnTela3")
tela2.fxml:
•	Título do Label: "Tela 2"
•	Botões:
o	"Ir para Tela 1" (fx:id="btnTela1")
o	"Ir para Tela 3" (fx:id="btnTela3")
tela3.fxml:
•	Título do Label: "Tela 3"
•	Botões:
o	"Ir para Tela 1" (fx:id="btnTela1")
o	"Ir para Tela 2" (fx:id="btnTela2")
7.	Salve cada arquivo FXML após editá-lo no Scene Builder.
 
4. Criando o Controlador Principal (MainController)
Vamos criar um controlador que será responsável por gerenciar a navegação entre as telas.
1.	No IntelliJ, no painel "Project", vá para src/main/java/com/example/gerenciadordetelas (ou o nome do seu pacote).
2.	Clique com o botão direito no pacote e selecione New > Java Class.
3.	Dê o nome MainController e pressione Enter.
 
5. Escrevendo o Código do Controlador Principal
Este controlador terá métodos para cada botão e um método para carregar as telas.
Java
package com.example.gerenciadordetelas; // Verifique se o nome do pacote está correto

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects; // Necessário para Objects.requireNonNull

public class MainController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // Método para definir o Stage principal da aplicação
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void irParaTela1(ActionEvent event) throws IOException {
        loadScene("tela1.fxml", "Tela 1");
    }

    @FXML
    void irParaTela2(ActionEvent event) throws IOException {
        loadScene("tela2.fxml", "Tela 2");
    }

    @FXML
    void irParaTela3(ActionEvent event) throws IOException {
        loadScene("tela3.fxml", "Tela 3");
    }

    private void loadScene(String fxmlFileName, String title) throws IOException {
        // Carrega o arquivo FXML
        // Usamos Objects.requireNonNull para garantir que o recurso seja encontrado,
        // lançando uma NullPointerException se não for, o que é útil para depuração.
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(fxmlFileName)));
        root = loader.load();
	
	MainController newController = loader.getController();
	if (newController != null){
		newController.setStage(this.stage);
	}

        scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
 
6. Conectando o FXML ao Controlador
Agora precisamos dizer a cada arquivo FXML qual é o seu controlador e vincular os botões aos métodos.
1.	Volte para o IntelliJ IDEA.
2.	Abra tela1.fxml.
3.	No topo do arquivo FXML, adicione a propriedade fx:controller ao elemento raiz (<AnchorPane>):
XML
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.layout.HBox?>
<?import javafx.scene.text.Font?>

<AnchorPane prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/21" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.gerenciadordetelas.MainController">
    <children>
        <Label alignment="CENTER" layoutX="14.0" layoutY="20.0" text="Tela 1" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0" AnchorPane.topAnchor="20.0">
            <font>
                <Font size="24.0" />
            </font>
        </Label>
        <HBox alignment="CENTER" layoutX="175.0" layoutY="350.0" spacing="10.0" AnchorPane.bottomAnchor="20.0" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0">
            <children>
                <Button mnemonicParsing="false" onAction="#irParaTela2" text="Ir para Tela 2" />
                <Button mnemonicParsing="false" onAction="#irParaTela3" text="Ir para Tela 3" />
            </children>
        </HBox>
    </children>
</AnchorPane>
o	Importante: Substitua com.example.gerenciadordetelas pelo nome real do seu pacote.
o	Observe os atributos onAction nos botões, apontando para os métodos do MainController.
4.	Repita este processo para tela2.fxml e tela3.fxml, alterando os botões onAction para corresponder à navegação desejada.
Exemplo para tela2.fxml:
XML
<AnchorPane prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/21" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.gerenciadordetelas.MainController">
    <children>
        <Label alignment="CENTER" layoutX="14.0" layoutY="20.0" text="Tela 2" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0" AnchorPane.topAnchor="20.0">
            <font>
                <Font size="24.0" />
            </font>
        </Label>
        <HBox alignment="CENTER" layoutX="175.0" layoutY="350.0" spacing="10.0" AnchorPane.bottomAnchor="20.0" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0">
            <children>
                <Button mnemonicParsing="false" onAction="#irParaTela1" text="Ir para Tela 1" />
                <Button mnemonicParsing="false" onAction="#irParaTela3" text="Ir para Tela 3" />
            </children>
        </HBox>
    </children>
</AnchorPane>
Exemplo para tela3.fxml:
XML
<AnchorPane prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/21" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.gerenciadordetelas.MainController">
    <children>
        <Label alignment="CENTER" layoutX="14.0" layoutY="20.0" text="Tela 3" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0" AnchorPane.topAnchor="20.0">
            <font>
                <Font size="24.0" />
            </font>
        </Label>
        <HBox alignment="CENTER" layoutX="175.0" layoutY="350.0" spacing="10.0" AnchorPane.bottomAnchor="20.0" AnchorPane.leftAnchor="0.0" AnchorPane.rightAnchor="0.0">
            <children>
                <Button mnemonicParsing="false" onAction="#irParaTela1" text="Ir para Tela 1" />
                <Button mnemonicParsing="false" onAction="#irParaTela2" text="Ir para Tela 2" />
            </children>
        </HBox>
    </children>
</AnchorPane>
5.	Salve todos os arquivos FXML.
 
7. Atualizando a Classe Principal (HelloApplication.java)
A classe principal da sua aplicação precisa carregar a primeira tela e passar o Stage para o MainController.
Java
package com.example.gerenciadordetelas; // Verifique se o nome do pacote está correto

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects; // Necessário para Objects.requireNonNull

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Carrega a primeira tela (tela1.fxml)
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(HelloApplication.class.getResource("tela1.fxml")));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400); // Defina o tamanho da janela

        // Obtém o controlador e passa o Stage para ele
        MainController controller = fxmlLoader.getController();
        if (controller != null) {
            controller.setStage(stage);
        }

        stage.setTitle("Gerenciador de Telas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
 
8. Executando o Gerenciador de Telas
Agora é hora de testar sua aplicação com múltiplas telas!
1.	No IntelliJ IDEA, clique com o botão direito no arquivo HelloApplication.java.
2.	Selecione "Run 'HelloApplication.main()'" ou clique no botão de "Play" verde.
Você verá a "Tela 1" aparecer. Clique nos botões para navegar para "Tela 2" e "Tela 3", e vice-versa.
 
Considerações e Próximos Passos
Este gerenciador de telas é simples e direto. Para aplicações mais complexas, você pode considerar:
•	Gerenciador de Cenas Dedicado: Para um controle mais robusto, você pode criar uma classe SceneManager que centralize o carregamento de cenas, o cache de controladores e a transição entre telas.
•	Passagem de Dados: Como passar dados de uma tela para outra (por exemplo, um objeto de usuário, configurações). Isso geralmente envolve o acesso ao controlador da nova cena.
•	Animações de Transição: Adicionar efeitos visuais ao mudar de uma tela para outra para uma experiência mais fluida.
•	Padrões de Projeto: Explorar padrões como MVC (Model-View-Controller) ou MVVM (Model-View-ViewModel) para organizar melhor seu código à medida que a aplicação cresce.
Este tutorial te deu uma base sólida para começar a criar aplicações JavaFX com múltiplas telas. Sinta-se à vontade para experimentar e personalizar!

<img width="468" height="648" alt="image" src="https://github.com/user-attachments/assets/2011dcd3-adf8-4685-ac21-2ae0fda41748" />
