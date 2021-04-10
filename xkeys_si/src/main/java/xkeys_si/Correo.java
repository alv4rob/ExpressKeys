package xkeys_si;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

public class Correo {

	private final Properties properties;
	private final Session session;
	
	private final String direccionFuente = "expresskeysweb@gmail.com";
	private final String passwordFuente = "dadaprobada";
	
	
	public Correo() {
		properties = new Properties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");
		
		session = Session.getDefaultInstance(properties);
	}
	
	
	public void enviarCorreo(String direccionDestino,String asunto,String mensaje) throws MessagingException {
		
		MimeMessage correo = new MimeMessage(session);
		correo.setFrom(new InternetAddress(direccionFuente));
		correo.addRecipient(Message.RecipientType.TO, new InternetAddress(direccionDestino));
		correo.setSubject(asunto);
		correo.setText(mensaje);
		Transport t = session.getTransport("smtp");
		t.connect(direccionFuente,passwordFuente);
		t.sendMessage(correo, correo.getRecipients(Message.RecipientType.TO));
		t.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
