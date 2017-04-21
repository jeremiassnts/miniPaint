package view;
import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.getAreaDesenho().setToolTipText("<html>\r\n\t<b>\u00C1rea de Desenho</b> <br/>\r\n\tAqui \u00E9 seu canvas, escolha uma cor na ferramenta RGB ao lado, <br/>\r\n\tescolha uma forma. Voc\u00EA ver\u00E1 o nome da forma escolhida com <br/>\r\n\ta cor selecionada. Ap\u00F3s, somente clique no canvas e desenhe.\r\n</html>");
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
